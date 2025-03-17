package project.software.global.error;

import lombok.Builder;
import lombok.Getter;
import project.software.global.error.exception.ErrorCode;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String message;

    public static ErrorResponse of(ErrorCode errorCode, String description) {
        return ErrorResponse.builder()
            .message(errorCode.getMessage())
            .status(errorCode.getStatus())
            .build();
    }

    public static ErrorResponse of(int statusCode, String description) {
        return ErrorResponse.builder()
            .message(description)
            .status(statusCode)
            .build();
    }
}