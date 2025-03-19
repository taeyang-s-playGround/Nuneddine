package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.shop.domain.Shop;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetShopListResponse {
    List<Shop> shopList;
}
