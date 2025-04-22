package project.software.domain.alarm.exception;

import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class AlarmNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new AlarmNotFoundException();

    private AlarmNotFoundException() {
        super(ErrorCode.ALARM_NOT_FOUND);
    }

}
