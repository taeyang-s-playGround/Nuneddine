package project.software.domain.alarm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.user.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity(name = "tbl_alarm")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    private LensDateType dateType;

    @Column(nullable = true)
    private LocalDateTime startTime;

    @Column(nullable = true)
    private LocalDateTime endTime;

    private Boolean isRepurchased;

    public void updateAlarm(String name, LensDateType dateType, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.dateType = dateType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void toggleRepurchase() {
        this.isRepurchased = !this.isRepurchased;
    }
}
