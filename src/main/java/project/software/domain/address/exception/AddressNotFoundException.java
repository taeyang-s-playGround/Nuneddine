
package project.software.domain.address.exception;

import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class AddressNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new AddressNotFoundException();

    private AddressNotFoundException() {
        super(ErrorCode.ADDRESS_NOT_FOUND);
    }
}
