package project.software.domain.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.service.GetAllShopService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final GetAllShopService getAllShopService;

    @GetMapping
    public ShopListResponse getShopList() {
        return getAllShopService.execute();
    }
}
