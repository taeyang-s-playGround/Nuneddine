package project.software.domain.alarm.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class AlarmListResponse {

    private final List<AlarmResponse> alarmList;

    public static AlarmListResponse from(List<Alarm> alarms) {
        return new AlarmListResponse(
            alarms.stream()
                .map(alarm -> AlarmResponse.builder()
                    .alarmId(alarm.getId())
                    .name(alarm.getName())
                    .dateType(alarm.getDateType())
                    .startTime(alarm.getStartTime())
                    .endTime(alarm.getEndTime())
                    .isRepurchased(alarm.getIsRepurchased())
                    .build()
                ).toList()
        );
    }

    @Getter
    @Builder
    public static class AlarmResponse {
        private final Long alarmId;
        private final String name;
        private final LensDateType dateType;
        private final LocalDateTime startTime;
        private final LocalDateTime endTime;
        private final Boolean isRepurchased;
    }
}
