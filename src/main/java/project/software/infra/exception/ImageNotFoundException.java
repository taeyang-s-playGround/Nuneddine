package project.software.infra.exception;


import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class ImageNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new ImageNotFoundException();
    public ImageNotFoundException(){
        super(ErrorCode.IMAGE_NOT_FOUND_EXCEPTION);
    }
}
