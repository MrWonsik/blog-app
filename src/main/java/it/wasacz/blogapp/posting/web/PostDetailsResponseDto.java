package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.PostDetails;

public record PostDetailsResponseDto(Long id, String title, String content) {
    public static PostDetailsResponseDto from(PostDetails post) {
        return new PostDetailsResponseDto(
                post.id(),
                post.title(),
                post.content()
        );
    }
}