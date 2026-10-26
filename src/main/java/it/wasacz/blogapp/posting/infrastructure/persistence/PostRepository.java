package it.wasacz.blogapp.posting.infrastructure.persistence;

import it.wasacz.blogapp.posting.Post;
import it.wasacz.blogapp.posting.PostListElement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
        select new it.wasacz.blogapp.posting.PostListElement(
            p.id,
            p.title
        )
        from Post p
        order by p.id desc
    """)
    List<PostListElement> findAllPostListItems(Pageable pageable);

}
