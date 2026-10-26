package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.PostingFacade;
import it.wasacz.blogapp.shared.web.ResponseBuilder;
import it.wasacz.blogapp.shared.web.SuccessResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostingFacade postingFacade;

    public PostController(PostingFacade postingFacade) {
        this.postingFacade = postingFacade;
    }

    @GetMapping("/api/posts")
    public SuccessResponse<List<PostResponseDto>> getPosts() {
        return ResponseBuilder.success(postingFacade.getPosts());
    }

    @GetMapping("/api/posts/{id}")
    public SuccessResponse<PostResponseDto> getPost(@PathVariable Long id) {
        return ResponseBuilder.success(postingFacade.getPost(id));
    }

    @PostMapping("/api/posts")
    public SuccessResponse<PostCreateDto> createPost(@RequestBody PostCreateDto postCreateDto) {
        return ResponseBuilder.success(postingFacade.createPost(postCreateDto));
    }
}