package project.software.domain.purchase_history.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.cart.controller.dto.response.AllCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.purchase_history.domain.PurchaseHistory;
import project.software.domain.shop.domain.type.GlassesType;
import project.software.domain.shop.domain.type.Type;

import java.util.List;

@Getter
@AllArgsConstructor
public class PurchaseHistoryListResponse {

    private final List<PurchaseHistoryResponse> purchaseHistoryList;

    public static PurchaseHistoryListResponse from(List<PurchaseHistory> purchaseHistoryList) {
        return new PurchaseHistoryListResponse(
            purchaseHistoryList.stream()
                .map(cart -> PurchaseHistoryResponse.builder()
                    .shopId(cart.getShop().getId())
                    .brandName(cart.getShop().getBrandName())
                    .glassName(cart.getShop().getGlassesName())
                    .description(cart.getShop().getDescription())
                    .price(cart.getShop().getPrice())
                    .type(cart.getShop().getType())
                    .glassesType(cart.getShop().getGlassesType())
                    .count(cart.getCount())
                    .build()
                ).toList()
        );
    }

    @Getter
    @Builder
    public static class PurchaseHistoryResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassName;
        private final String description;
        private final Long price;
        private final Type type;
        private final GlassesType glassesType;
        private final Long count;
    }
}