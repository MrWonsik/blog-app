package it.wasacz.blogapp.posting;

import it.wasacz.blogapp.posting.exception.PostNotFoundException;
import it.wasacz.blogapp.posting.infrastructure.persistence.PostRepository;
import it.wasacz.blogapp.posting.web.PostCreateDto;
import it.wasacz.blogapp.posting.web.PostResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostingFacade {

    private final PostRepository postRepository;

    public PostingFacade(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(
                    post.getId(),
                    post.getTitle(),
                    post.getContent()
                )).toList();
    }

    public PostCreateDto createPost(PostCreateDto postCreateDto) {
        Post newPost = postRepository.save(Post.create(null, postCreateDto.title(), postCreateDto.content()));
        return new PostCreateDto(
                newPost.getTitle(),
                newPost.getContent()
        );
    }

    public PostResponseDto getPost(Long id) {
        return postRepository.findById(id).map(post -> new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent()
        )).orElseThrow(PostNotFoundException::new);
    }
}
