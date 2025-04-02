package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.shop.controller.dto.response.GetShopListResponse;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllShopService {

    private final ShopRepository shopRepository;

    public GetShopListResponse execute() {
        /*
        List<Shop> shopList = shopRepository.findAll();

         */

        return new GetShopListResponse(null);
    }
}
