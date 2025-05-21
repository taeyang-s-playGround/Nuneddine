package project.software.domain.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.shop.controller.dto.response.GlassesListResponse;
import project.software.domain.shop.controller.dto.response.LensListResponse;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.shop.service.BuyProductService;
import project.software.domain.shop.service.GetAllLikedShopService;
import project.software.domain.shop.service.GetAllShopService;
import project.software.domain.shop.service.GetGlassesListByCategoryService;
import project.software.domain.shop.service.GetLensListByCategoryService;
import project.software.domain.shop.service.SearchShopListByCategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final GetAllShopService getAllShopService;
    private final BuyProductService buyProductService;
    private final GetAllLikedShopService getAllLikedShopService;
    private final GetLensListByCategoryService getLensListByCategoryService;
    private final GetGlassesListByCategoryService getGlassesListByCategoryService;
    private final SearchShopListByCategoryService searchShopListByCategoryService;

    @GetMapping
    public ShopListResponse getShopList() {
        return getAllShopService.execute();
    }

    @GetMapping("/liked")
    public ShopListResponse getLikedShopList() {
        return getAllLikedShopService.execute();
    }

    @PostMapping
    public void buyProduct() {
        buyProductService.execute();
    }

    //검색 API
    @GetMapping("/search")
    public ShopListResponse searchShopListByCategory(
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "lens_color", required = false) LensColor lensColor,
        @RequestParam(value = "lens_date_type", required = false) LensDateType lensDateType,
        @RequestParam(value = "frame_shape", required = false) FrameShape frameShape,
        @RequestParam(value = "frame_material", required = false) FrameMaterial frameMaterial
    ) {
        return searchShopListByCategoryService.execute(keyword, lensColor, lensDateType, frameShape, frameMaterial);
    }

    //메인페이지
    @GetMapping("/lens")
    public LensListResponse getLensListByCategory(
        @RequestParam(value = "lens_color", required = false) LensColor lensColor,
        @RequestParam(value = "lens_date_type", required = false) LensDateType lensDateType
    ) {
        return getLensListByCategoryService.execute();
    }

    //메인페이지
    @GetMapping("/glasses")
    public GlassesListResponse getGlassesListByCategory(
    ) {
        return getGlassesListByCategoryService.execute();
    }
}
