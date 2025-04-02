package project.software.infra.exception;


import project.software.global.error.exception.GlobalException;
import project.software.global.error.exception.ErrorCode;

public class ImageNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new ImageNotFoundException();
    public ImageNotFoundException(){
        super(ErrorCode.IMAGE_NOT_FOUND_EXCEPTION);
    }
}
