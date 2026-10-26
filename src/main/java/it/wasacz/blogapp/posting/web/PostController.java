package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.CreatePostCommand;
import it.wasacz.blogapp.posting.CreatedPost;
import it.wasacz.blogapp.posting.FindPostsQuery;
import it.wasacz.blogapp.posting.PostDetails;
import it.wasacz.blogapp.posting.PostListElement;
import it.wasacz.blogapp.posting.PostingFacade;
import it.wasacz.blogapp.shared.web.ResponseBuilder;
import it.wasacz.blogapp.shared.web.SuccessResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostingFacade postingFacade;

    public PostController(PostingFacade postingFacade) {
        this.postingFacade = postingFacade;
    }

    @GetMapping("/api/posts")
    public SuccessResponse<List<PostListItemDto>> getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        FindPostsQuery query = new FindPostsQuery(page, size);

        List<PostListElement> posts = postingFacade.getPosts(query);

        List<PostListItemDto> response = posts.stream()
                .map(PostListItemDto::from)
                .toList();

        return ResponseBuilder.success(response);
    }

    @GetMapping("/api/posts/{id}")
    public SuccessResponse<PostDetailsResponseDto> getPost(@PathVariable Long id) {
        PostDetails post = postingFacade.getPost(id);

        return ResponseBuilder.success(PostDetailsResponseDto.from(post));
    }

    @PostMapping("/api/posts")
    public SuccessResponse<CreatedPostResponseDto> createPost(@RequestBody PostCreateCommandDto requestDto) {
        CreatedPost post = postingFacade.createPost(requestDto.toCommand());

        return ResponseBuilder.success(CreatedPostResponseDto.from(post));
    }
}