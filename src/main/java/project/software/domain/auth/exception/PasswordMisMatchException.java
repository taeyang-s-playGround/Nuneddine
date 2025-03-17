package project.software.domain.auth.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
