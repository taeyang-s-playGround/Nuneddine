package project.software.domain.guide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.guide.controller.dto.response.GuideDetailResponse;
import project.software.domain.guide.domain.Guide;
import project.software.domain.guide.domain.repository.GuideRepository;
import project.software.domain.shop.exception.ShopNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GuideDetailService {

    private final GuideRepository guideRepository;

    public GuideDetailResponse execute(Long guideId) {

        Guide guide = guideRepository.findById(guideId).orElseThrow(() -> ShopNotFoundException.EXCEPTION);

        return new GuideDetailResponse(guide);
    }
}
