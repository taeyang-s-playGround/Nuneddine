package project.software.domain.honey_tip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.honey_tip.controller.dto.response.GetAllHoneyTipsResponse;
import project.software.domain.honey_tip.domain.HoneyTip;
import project.software.domain.honey_tip.domain.repository.HoneyTipRepository;
import project.software.domain.user.domain.User;

import java.util.List;
/*
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetAllHoneyTipService {

    private final UserFacade userFacade;
    private final HoneyTipRepository honeyTipRepository;

    public GetAllHoneyTipsResponse execute() {
        User user = userFacade.CurrentUser();

        List<HoneyTip> honeyTips = honeyTipRepository.findAll();
        return new GetAllHoneyTipsResponse(user);



    }
}


 */