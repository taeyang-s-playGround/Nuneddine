package project.software.domain.purchase_history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.purchase_history.controller.dto.response.PurchaseHistoryListResponse;
import project.software.domain.purchase_history.domain.PurchaseHistory;
import project.software.domain.purchase_history.domain.repository.PurchaseHistoryRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class GetAllPurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final UserFacade userFacade;

    public PurchaseHistoryListResponse execute() {
        User user = userFacade.GetCurrentUser();
        List<PurchaseHistory> purchaseHistoryList = purchaseHistoryRepository.findAllByUserId(user.getId());

        return PurchaseHistoryListResponse.from(purchaseHistoryList);
    }
}
