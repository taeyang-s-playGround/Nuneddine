package project.software.global.security;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GuestTokenResponse {

    private String guestId;

    public GuestTokenResponse(String customGuestId) {
        guestId = customGuestId;
    }
}
