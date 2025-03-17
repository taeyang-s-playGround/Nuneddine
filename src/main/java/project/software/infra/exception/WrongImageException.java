package project.software.infra.exception;

import project.software.global.error.exception.CustomException;
import project.software.global.error.exception.ErrorCode;

public class WrongImageException extends CustomException {

    public static final CustomException EXCEPTION = new WrongImageException();
    private WrongImageException() { super(ErrorCode.WRONG_IMAGE);}
}
