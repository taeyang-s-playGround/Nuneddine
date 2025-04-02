package project.software.infra.exception;

import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class WrongImageException extends GlobalException {

    public static final GlobalException EXCEPTION = new WrongImageException();
    private WrongImageException() { super(ErrorCode.WRONG_IMAGE);}
}
