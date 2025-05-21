package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.purchase_history.domain.PurchaseHistory;
import project.software.domain.purchase_history.domain.repository.PurchaseHistoryRepository;
import project.software.domain.shop.domain.Lens;
import project.software.domain.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyProductService {

    private final UserFacade userFacade;
    private final CartRepository cartRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final AlarmRepository alarmRepository;

    public void execute() {
        User user = userFacade.GetCurrentUser();

        List<Cart> carts = cartRepository.findAllByUserId(user.getId());

        carts.forEach(cart -> {
            cartRepository.deleteById(cart.getId());

            // 구매 내역 저장
            purchaseHistoryRepository.save(PurchaseHistory.builder()
                .count(cart.getCount())
                .shop(cart.getShop())
                .user(user)
                .build()
            );

            // 알람 저장은 렌즈인 경우에만
            if (cart.getShop() instanceof Lens lens) {
                LocalDateTime startTime = LocalDateTime.now();
                LocalDateTime endTime;

                switch (lens.getDateType()) {
                    case MONTH -> endTime = startTime.plusDays(30);
                    case WEEK -> endTime = startTime.plusDays(7);
                    default -> {
                        return; // 혹시 모를 잘못된 Enum 값 대응
                    }
                }

                alarmRepository.save(Alarm.builder()
                    .name(lens.getBrandName())
                    .user(cart.getUser())
                    .dateType(lens.getDateType())
                    .startTime(startTime)
                    .endTime(endTime)
                    .build()
                );
            }
        });
    }
}
