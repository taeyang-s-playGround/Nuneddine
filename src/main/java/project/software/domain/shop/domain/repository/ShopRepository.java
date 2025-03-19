package project.software.domain.shop.domain.repository;

import org.springframework.data.repository.CrudRepository;
import project.software.domain.shop.domain.Shop;

import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Long> {

    Shop findShopById(Long shopId);

    //List<Shop> findAllShops();
}
