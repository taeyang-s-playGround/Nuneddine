package project.software.domain.address.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.Shop;
import project.software.domain.user.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity(name = "tbl_address")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String address;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String detailAddress;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String postCode;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String receiver;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String phoneNumber;

    public void updateAddress(String address, String detailAddress, String postCode, String receiver, String phoneNumber) {
        this.address = address;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
        this.receiver = receiver;
        this.phoneNumber = phoneNumber;
    }
}
