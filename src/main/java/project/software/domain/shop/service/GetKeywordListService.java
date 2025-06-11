package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.shop.controller.dto.response.KeywordListResponse;
import project.software.domain.shop.domain.Keyword;
import project.software.domain.shop.domain.repository.KeywordRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetKeywordListService {

    private final KeywordRepository keywordRepository;
    private final UserFacade userFacade;

    public KeywordListResponse execute() {

        User user = userFacade.getCurrentUser();
        List<Keyword> keywords = keywordRepository.findAllByUser(user);

        List<String> keywordStrings = keywords.stream()
            .map(Keyword :: getKeyword)
            .toList();

        return new KeywordListResponse(keywordStrings);
    }
}
