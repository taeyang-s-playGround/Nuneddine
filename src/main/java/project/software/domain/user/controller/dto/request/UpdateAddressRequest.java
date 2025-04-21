package project.software.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;

@NoArgsConstructor
@Getter
public class UpdateAddressRequest {

    private String address;
}
