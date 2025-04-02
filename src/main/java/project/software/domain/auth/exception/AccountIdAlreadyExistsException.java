package project.software.domain.auth.exception;

import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends GlobalException {

    public static final GlobalException EXCEPTION = new AccountIdAlreadyExistsException();

    public AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
