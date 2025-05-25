package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.controller.dto.response.LensListResponse;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetLensListByCategoryService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;
    private final HeartRepository heartRepository;

    public LensListResponse execute() {

        User user = userFacade.getCurrentUser();

        List<Lens> lenses = shopRepository.findAllLens();

        return LensListResponse.from(lenses, user.getId(), heartRepository);
    }
}
