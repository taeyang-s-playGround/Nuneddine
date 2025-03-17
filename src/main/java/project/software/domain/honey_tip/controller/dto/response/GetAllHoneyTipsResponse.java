package project.software.domain.honey_tip.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.honey_tip.domain.HoneyTip;

@Getter
@AllArgsConstructor
public class GetAllHoneyTipsResponse {

    private Long honeyTipId;
    private String title;
    private String content;

    public GetAllHoneyTipsResponse(HoneyTip honeyTip) {
        honeyTipId = honeyTip.getId();
        title = honeyTip.getTitle();
        content = honeyTip.getContent();
    }
}

