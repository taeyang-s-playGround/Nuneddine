package project.software.domain.purchase_history.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.purchase_history.controller.dto.response.PurchaseHistoryListResponse;
import project.software.domain.purchase_history.service.GetAllPurchaseHistoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase_histories")
public class PurchaseHistoryController {

    private final GetAllPurchaseHistoryService getAllPurchaseHistoryService;

    @GetMapping
    public PurchaseHistoryListResponse getAllPurchaseHistory() {
        return getAllPurchaseHistoryService.execute();
    }

}
