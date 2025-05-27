package project.software.domain.shop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT h.shop FROM tbl_heart h WHERE h.user.id = :userId")
    List<Shop> findShopsByUserId(@Param("userId") Long userId);

    @Query("SELECT g FROM Glasses g")
    List<Glasses> findAllGlasses();

    @Query("SELECT l FROM Lens l")
    List<Lens> findAllLens();

    List<Shop> findByGroupIdAndIdNot(String groupId, Long id);
}
