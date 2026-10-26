package it.wasacz.blogapp.posting;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private Status postStatus;

    protected Post() {}

    private Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
    }

    static public Post create(String title, String content) {
        return new Post(title, content);
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
