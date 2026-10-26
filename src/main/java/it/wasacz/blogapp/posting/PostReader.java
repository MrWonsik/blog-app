package it.wasacz.blogapp.posting;

import java.util.List;
import java.util.Optional;

public interface PostReader {

    List<PostListElement> getPostsList(FindPostsQuery query);

    CreatedPost save(CreatePostCommand post);

    Optional<PostDetails> findById(Long id);
}
