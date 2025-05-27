package project.software.domain.guide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.guide.controller.dto.response.AllGuidesResponse;
import project.software.domain.guide.domain.Guide;
import project.software.domain.guide.domain.repository.GuideRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetAllGuidesService {

    private final GuideRepository guideRepository;

    public AllGuidesResponse execute() {
        List<AllGuidesResponse.GuideResponse> guideList = guideRepository.findAll()
            .stream()
            .map(guide -> new AllGuidesResponse.GuideResponse(
                guide.getId(),
                guide.getTitle(),
                guide.getImageUrl()
            ))
            .collect(Collectors.toList());

        // Tip 리스트는 하드코딩
        List<String> tipList = List.of(
            "하루에 한 번 눈의 피로를 풀어주세요.",
            "렌즈 착용 전 손을 깨끗이 씻으세요.",
            "안경은 렌즈 천으로 닦으세요."
        );

        return new AllGuidesResponse(guideList, tipList);
    }
}
