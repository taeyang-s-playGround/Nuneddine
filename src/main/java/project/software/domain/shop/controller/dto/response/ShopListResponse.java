package project.software.domain.shop.controller.dto.response;

import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.GlassesType;
import project.software.domain.shop.domain.type.Type;

import java.util.List;

public record ShopListResponse(List<Shop> shopList) {
    public record ShopResponse(Long id, String brandName, String glassesName, String description, Long price, Type type, GlassesType glassesType) {}
}
