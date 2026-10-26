package it.wasacz.blogapp.posting;

import it.wasacz.blogapp.posting.exception.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostingFacade {

    private final PostReader postReader;

    public PostingFacade(PostReader postReader) {
        this.postReader = postReader;
    }

    public List<PostListElement> getPosts(FindPostsQuery query) {
        return postReader.getPostsList(query);
    }

    public CreatedPost createPost(CreatePostCommand postCommand) {
        return postReader.save(postCommand);
    }

    public PostDetails getPost(Long id) {
        return postReader.findById(id).orElseThrow(PostNotFoundException::new);
    }
}
