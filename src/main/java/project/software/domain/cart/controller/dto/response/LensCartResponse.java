package project.software.domain.cart.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.Hibernate;
import project.software.domain.cart.domain.Cart;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;

@Getter
@AllArgsConstructor
public class LensCartResponse {

    private final Long cartsCount;
    private final List<CartResponse> cartList;
    private final Long totalPrice;

    public static LensCartResponse from(List<Cart> carts, Long totalPrice) {
        return new LensCartResponse((long) carts.size(),
            carts.stream()
                .map(cart -> {
                    Shop shop = Hibernate.unproxy(cart.getShop(), Shop.class);

                    if (!(shop instanceof Lens lens)) {
                        throw new IllegalStateException("Shop is not a Lens type: id = " + shop.getId());
                    }

                    return CartResponse.builder()
                        .cartId(cart.getId())
                        .shopId(lens.getId())
                        .brandName(lens.getBrandName())
                        .imageUrls(lens.getImageUrls())
                        .dateType(lens.getDateType())
                        .glassName(lens.getGlassesName())
                        .lensPower(cart.getLensPower())
                        .price(lens.getPrice())
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
        private final LensDateType dateType;
        private final String glassName;
        private final Float lensPower;
        private final Long price;
        private final Long count;
    }
}