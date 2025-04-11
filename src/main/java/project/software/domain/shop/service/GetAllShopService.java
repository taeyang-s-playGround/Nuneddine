package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllShopService {

    private final ShopRepository shopRepository;

    public ShopListResponse execute() {
        List<Shop> shops = shopRepository.findAll();

        return new ShopListResponse(shops);
    }
}
