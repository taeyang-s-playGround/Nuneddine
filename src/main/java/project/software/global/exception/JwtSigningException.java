package project.software.global.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class JwtSigningException extends CustomException {

    public static final CustomException EXCEPTION = new JwtSigningException();

    public JwtSigningException() {
        super(ErrorCode.JwtSigningException);
    }

}
