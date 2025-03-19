package project.software.domain.auth.exception;

import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class NicknameAlreadyExistsException extends GlobalException {
    public static final GlobalException EXCEPTION = new NicknameAlreadyExistsException();

    public NicknameAlreadyExistsException() {
        super(ErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
