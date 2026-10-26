package it.wasacz.blogapp.posting.infrastructure.persistence;

import it.wasacz.blogapp.posting.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class PostJpaReader implements PostReader {

    private final PostRepository postRepository;

    PostJpaReader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostListElement> getPostsList(FindPostsQuery query) {
        return postRepository.findAllPostListItems(
                PageRequest.of(query.page(), query.size())
        );
    }

    @Override
    public CreatedPost save(CreatePostCommand post) {
        Post newPost = postRepository.save(Post.create(post.title(), post.content()));
        return new CreatedPost(newPost.getId(), newPost.getTitle());
    }

    @Override
    public Optional<PostDetails> findById(Long id) {
        return postRepository.findById(id)
                .map(post -> new PostDetails(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                ));
    }
}
