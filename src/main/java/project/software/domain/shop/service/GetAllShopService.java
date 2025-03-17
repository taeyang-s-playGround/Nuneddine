package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.shop.domain.repository.ShopRepository;

@Service
@RequiredArgsConstructor
public class GetAllShopService {

    private final ShopRepository shopRepository;

    public void execute() {

    }
}
