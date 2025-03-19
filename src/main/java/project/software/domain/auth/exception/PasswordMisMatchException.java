package project.software.domain.auth.exception;

import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends GlobalException {
    public static final GlobalException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
