package project.software.domain.auth.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class NicknameAlreadyExistsException extends CustomException {
    public static final CustomException EXCEPTION = new NicknameAlreadyExistsException();

    public NicknameAlreadyExistsException() {
        super(ErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
