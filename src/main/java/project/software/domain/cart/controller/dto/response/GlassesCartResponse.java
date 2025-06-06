package project.software.domain.cart.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.cart.domain.Cart;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.type.glasses.FrameShape;

import java.util.List;
import org.hibernate.Hibernate;

@Getter
@AllArgsConstructor
public class GlassesCartResponse {

    private final Long cartsCount;
    private final List<CartResponse> cartList;
    private final Long totalPrice;

    public static GlassesCartResponse from(List<Cart> carts, Long totalPrice) {
        return new GlassesCartResponse((long) carts.size(),
            carts.stream()
                .map(cart -> {
                    Glasses glasses = (Glasses) Hibernate.unproxy(cart.getShop());

                    return CartResponse.builder()
                        .cartId(cart.getId())
                        .shopId(glasses.getId())
                        .brandName(glasses.getBrandName())
                        .imageUrls(glasses.getImageUrls())
                        .frameShape(glasses.getFrameShape())
                        .glassName(glasses.getGlassesName())
                        .lensPower(cart.getLensPower())
                        .price(glasses.getPrice())
                        .count(cart.getCount())
                        .build();
                }).toList(),
            totalPrice
        );
    }

    @Getter
    @Builder
    public static class CartResponse {
        private final Long cartId;
        private final Long shopId;
        private final String brandName;
        private final List<String> imageUrls;
        private final FrameShape frameShape;
        private final String glassName;
        private final Float lensPower;
        private final Long price;
        private final Long count;
    }
}
