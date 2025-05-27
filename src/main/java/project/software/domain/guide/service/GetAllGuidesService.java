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

        // 질문/답변 형식의 Tip 리스트
        List<AllGuidesResponse.TipResponse> tipList = List.of(
            new AllGuidesResponse.TipResponse("", "렌즈를 끼기 전 반드시 손을 깨끗이 씻고 물기를 제거하세요."),
            new AllGuidesResponse.TipResponse("", "렌즈를 끼기 전 반드시 손을 깨끗이 씻고 물기를 제거하세요."),
            new AllGuidesResponse.TipResponse("", "렌즈를 끼기 전 반드시 손을 깨끗이 씻고 물기를 제거하세요."),
            new AllGuidesResponse.TipResponse("", "가벼운 프레임을 선택하거나 코 받침을 조절해보세요.")
        );

        return new AllGuidesResponse(guideList, tipList);
    }
}