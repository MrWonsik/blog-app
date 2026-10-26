package it.wasacz.blogapp.posting.infrastructure.persistence;

import it.wasacz.blogapp.posting.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
