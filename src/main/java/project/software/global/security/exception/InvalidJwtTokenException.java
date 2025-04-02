package project.software.global.security.exception;


import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class InvalidJwtTokenException extends GlobalException {
    public static final GlobalException EXCEPTION = new InvalidJwtTokenException();

    private InvalidJwtTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
