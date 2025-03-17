package project.software.global.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomException {
    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
