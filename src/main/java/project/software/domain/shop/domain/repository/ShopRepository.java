package project.software.domain.shop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.shop.domain.Shop;


public interface ShopRepository extends JpaRepository<Shop, Long> {

    Shop findShopById(Long shopId);
}
