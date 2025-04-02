package project.software.global.security.exception;


import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class ExpiredJwtTokenException extends GlobalException {
    public static final GlobalException EXCEPTION = new ExpiredJwtTokenException();

    private ExpiredJwtTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
