package project.software.global.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
