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
            new AllGuidesResponse.TipResponse("렌즈를 잃어버렸을 때 어떻게 해야 하나요?", "우선 눈 안에 남아있는지 먼저 확인해주세요. 렌즈가 접혀 있거나 눈꺼풀 속에 들어가 있을 수 있어요. 없다면 바닥이나 주변을 살펴보되, 떨어진 렌즈는 다시 착용하지 마세요. 이물감이나 불편함이 계속되면 안과를 방문하는 게 안전합니다."),
            new AllGuidesResponse.TipResponse("렌즈를 낀 채로 자면 어떻게 되나요?", "일반 렌즈를 착용한 상태로 잠들면 산소 공급이 줄어들어 눈이 건조해지고 충혈되거나, 각막염 같은 질환이 생길 수 있습니다. 실수로 잠든 경우엔 렌즈를 바로 빼지 말고 인공눈물로 눈을 충분히 적신 후 조심히 제거해주세요. 자주 반복된다면 꼭 안과 상담을 받아보시는 걸 추천드립니다."),
            new AllGuidesResponse.TipResponse("안경 닦을 때 주의해야 할 점은?", "옷자락이나 휴지로 닦으면 렌즈에 미세한 흠집이 생길 수 있어요. 전용 안경 클리너나 안경용 천(극세사)을 사용하고, 먼지가 많은 경우엔 먼저 물로 헹군 후 닦는 것이 좋습니다. 렌즈 코팅이 오래 유지되려면 습관적으로 관리해주는 게 중요해요."),
            new AllGuidesResponse.TipResponse("첫 렌즈 구매인데 도수는 어떻게 확인하죠?", "안경 도수 = 렌즈 도수는 아닙니다.\u2028렌즈는 눈에 직접 닿기 때문에 각막 곡률, 착용 적합성 등을 함께 고려해야 해요. 가까운 안경원이나 안과에서 렌즈용 시력 검사를 받는 것이 가장 정확합니다.\u2028처방 없이 임의로 구매하면 눈 건강에 문제가 생길 수 있으니 주의하세요.")
        );

        return new AllGuidesResponse(guideList, tipList);
    }
}