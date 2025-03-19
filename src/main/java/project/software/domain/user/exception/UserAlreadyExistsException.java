package project.software.domain.user.exception;

import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends GlobalException {
    public static final GlobalException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
