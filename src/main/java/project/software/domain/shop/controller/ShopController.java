package project.software.domain.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.shop.controller.dto.response.GlassesListResponse;
import project.software.domain.shop.controller.dto.response.LensListResponse;
import project.software.domain.shop.controller.dto.response.LikedGlassesResponse;
import project.software.domain.shop.controller.dto.response.LikedLensResponse;
import project.software.domain.shop.controller.dto.response.detail.ShopDetailResponse;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.shop.service.BuyProductService;
import project.software.domain.shop.service.GetLikedGlassesService;
import project.software.domain.shop.service.GetLikedLensService;
import project.software.domain.shop.service.GetShopDetailService;
import project.software.domain.shop.service.GetGlassesListByCategoryService;
import project.software.domain.shop.service.GetLensListByCategoryService;
import project.software.domain.shop.service.SearchShopListByCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final GetShopDetailService getShopDetailService;
    private final BuyProductService buyProductService;
    private final GetLikedLensService getLikedLensService;
    private final GetLikedGlassesService getLikedGlassesService;
    private final GetLensListByCategoryService getLensListByCategoryService;
    private final GetGlassesListByCategoryService getGlassesListByCategoryService;
    private final SearchShopListByCategoryService searchShopListByCategoryService;

    @GetMapping("/{shop-id}")
    public ShopDetailResponse getShopList(@PathVariable("shop-id") Long shopId) {
        return getShopDetailService.execute(shopId);
    }

    @GetMapping("/liked/glasses")
    public LikedGlassesResponse getLikedGlassesList() {
        return getLikedGlassesService.execute();
    }

    @GetMapping("/liked/lens")
    public LikedLensResponse getLikedLensList() {
        return getLikedLensService.execute();
    }

    @PostMapping
    public void buyProduct() {
        buyProductService.execute();
    }

    //검색 API
    @GetMapping("/search")
    public ShopListResponse searchShopListByCategory(
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "lens_color", required = false) List<LensColor> lensColors,
        @RequestParam(value = "lens_date_type", required = false) List<LensDateType> lensDateTypes,
        @RequestParam(value = "frame_shape", required = false) List<FrameShape> frameShapes,
        @RequestParam(value = "frame_material", required = false) List<FrameMaterial> frameMaterials
    ) {
        return searchShopListByCategoryService.execute(keyword, lensColors, lensDateTypes, frameShapes, frameMaterials);
    }

    //메인페이지
    @GetMapping("/lens")
    public LensListResponse getLensListByCategory() {
        return getLensListByCategoryService.execute();
    }

    //메인페이지
    @GetMapping("/glasses")
    public GlassesListResponse getGlassesListByCategory() {
        return getGlassesListByCategoryService.execute();
    }
}
