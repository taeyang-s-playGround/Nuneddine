package project.software.global.error;

import project.software.global.error.exception.ErrorCode;

public record ErrorResponse(
    int status,
    String message
) {
    public ErrorResponse(ErrorCode errorCode) {
        this(
            errorCode.getStatus(),
            errorCode.getMessage()
        );
    }
}