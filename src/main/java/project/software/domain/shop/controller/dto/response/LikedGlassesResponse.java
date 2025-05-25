package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.cart.domain.Cart;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.type.glasses.FrameShape;

import java.util.List;

@Getter
@AllArgsConstructor
public class LikedGlassesResponse {

    private final Long cartsCount;
    private final List<CartResponse> cartList;
    private final Long totalPrice;

    public static LikedGlassesResponse from(List<Cart> carts, Long totalPrice) {
        return new LikedGlassesResponse((long) carts.size(),
            carts.stream()
                .map(cart -> {
                    Glasses glasses = (Glasses) cart.getShop();
                    return CartResponse.builder()
                        .shopId(glasses.getId())
                        .brandName(glasses.getBrandName())
                        .imageUrls(glasses.getImageUrls())
                        .frameShape(glasses.getFrameShape())
                        .glassName(glasses.getGlassesName())
                        .price(glasses.getPrice())
                        .build();
                }).toList(),
            totalPrice
        );
    }

    @Getter
    @Builder
    public static class CartResponse {
        private final Long shopId;
        private final String brandName;
        private final List<String> imageUrls;
        private final FrameShape frameShape;
        private final String glassName;
        private final Long price;
    }
}
