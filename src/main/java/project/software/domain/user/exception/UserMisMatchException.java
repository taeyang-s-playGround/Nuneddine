package project.software.domain.user.exception;

import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class UserMisMatchException extends CustomException {
    public static final CustomException EXCEPTION = new UserMisMatchException();

    private UserMisMatchException() {
        super(ErrorCode.USER_MISMATCH);
    }
}
