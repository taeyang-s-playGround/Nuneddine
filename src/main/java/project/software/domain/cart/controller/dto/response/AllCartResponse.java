package project.software.domain.cart.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.cart.domain.Cart;
import project.software.domain.shop.domain.type.GlassesType;
import project.software.domain.shop.domain.type.Type;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllCartResponse {

    private final List<CartResponse> cartList;

    public static AllCartResponse from(List<Cart> carts) {
        return new AllCartResponse(
            carts.stream()
                .map(cart -> CartResponse.builder()
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
    public static class CartResponse {
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
