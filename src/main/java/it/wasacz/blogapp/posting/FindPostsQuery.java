package it.wasacz.blogapp.posting;

public record FindPostsQuery(int page, int size) {
    public FindPostsQuery {
        if (page < 0) {
            throw new IllegalArgumentException("Page cannot be negative");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }

        if (size > 100) {
            throw new IllegalArgumentException("Size cannot be greater than 100");
        }
    }
}
