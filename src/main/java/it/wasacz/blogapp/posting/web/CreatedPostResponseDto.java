package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.CreatedPost;

public record CreatedPostResponseDto(
        Long id,
        String title
) {
    public static CreatedPostResponseDto from(CreatedPost post) {
        return new CreatedPostResponseDto(
                post.id(),
                post.title()
        );
    }
}
