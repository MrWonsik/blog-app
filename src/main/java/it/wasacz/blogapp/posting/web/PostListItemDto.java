package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.PostListElement;

public record PostListItemDto(Long ig, String content) {
    public static PostListItemDto from(PostListElement post) {
        return new PostListItemDto(
                post.id(),
                post.title()
        );
    }
}
