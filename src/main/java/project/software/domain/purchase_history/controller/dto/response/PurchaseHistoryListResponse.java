package project.software.domain.purchase_history.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.purchase_history.domain.PurchaseHistory;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.ShopType;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class PurchaseHistoryListResponse {

    private final List<HistoryGroupByDate> purchaseHistoryByDate;

    public static PurchaseHistoryListResponse from(List<PurchaseHistory> purchaseHistories) {
        Map<LocalDate, List<PurchaseHistoryResponse>> grouped = purchaseHistories.stream()
            .collect(Collectors.groupingBy(
                PurchaseHistory::getDate,
                LinkedHashMap::new,
                Collectors.mapping(PurchaseHistoryResponse::from, Collectors.toList())
            ));

        List<HistoryGroupByDate> groupedList = grouped.entrySet().stream()
            .map(entry -> new HistoryGroupByDate(entry.getKey(), entry.getValue()))
            .toList();

        return new PurchaseHistoryListResponse(groupedList);
    }

    @Getter
    @AllArgsConstructor
    public static class HistoryGroupByDate {
        private final LocalDate date;
        private final List<PurchaseHistoryResponse> histories;
    }

    @Getter
    @Builder
    public static class PurchaseHistoryResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassName;
        private final List<String> imageUrls;
        private final Long price;
        private final Long count;
        private final Float lensPower;
        private final ShopType type;

        // 안경이면 포함
        private final FrameShape frameShape;

        // 렌즈면 포함
        private final LensDateType lensDateType;

        public static PurchaseHistoryResponse from(PurchaseHistory history) {
            Shop shop = history.getShop();

            PurchaseHistoryResponseBuilder builder = PurchaseHistoryResponse.builder()
                .shopId(shop.getId())
                .brandName(shop.getBrandName())
                .glassName(shop.getGlassesName())
                .imageUrls(shop.getImageUrls())
                .price(shop.getPrice())
                .count(history.getCount())
                .lensPower(history.getLensPower())
                .type(shop.getShopType());

            if (shop instanceof Glasses glasses) {
                builder.frameShape(glasses.getFrameShape());
            } else if (shop instanceof Lens lens) {
                builder.lensDateType(lens.getDateType());
            }

            return builder.build();
        }
    }
}
