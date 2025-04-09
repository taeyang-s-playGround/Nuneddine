package project.software.domain.guide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.guide.controller.dto.response.AllGuidesResponse;
import project.software.domain.guide.domain.Guide;
import project.software.domain.guide.domain.repository.GuideRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetAllGuidesService {

    private final GuideRepository guideRepository;

    public AllGuidesResponse execute() {

        List<Guide> guides = guideRepository.findAll();
        return new AllGuidesResponse(guides);
    }
}
