package project.software.domain.shop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.software.domain.shop.domain.Shop;
import project.software.domain.user.domain.User;
import project.software.domain.heart.domain.Heart;


import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT h.shop FROM tbl_heart h WHERE h.user.id = :userId")
    List<Shop> findShopsByUserId(@Param("userId") Long userId);

}
