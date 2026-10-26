package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.CreatePostCommand;

public record PostCreateCommandDto(String title, String content) {
    public CreatePostCommand toCommand() {
        return new CreatePostCommand(title, content);
    }
}
