package project.software.domain.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.shop.service.GetAllShopService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final GetAllShopService getAllShopService;
}
