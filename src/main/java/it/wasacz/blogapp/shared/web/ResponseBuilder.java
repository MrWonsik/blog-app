package it.wasacz.blogapp.shared.web;

public class ResponseBuilder {

    public static <T> SuccessResponse<T> success(T object) {
        return new SuccessResponse<>(object);
    }

    public static ErrorResponse error(ErrorMessage errorMessage) {
        return new ErrorResponse(errorMessage);
    }
}
