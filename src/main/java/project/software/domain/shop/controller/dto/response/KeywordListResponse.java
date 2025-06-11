package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class KeywordListResponse {

    private List<String> keywordList;
}
