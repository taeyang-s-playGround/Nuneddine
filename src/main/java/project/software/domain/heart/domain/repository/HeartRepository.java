package project.software.domain.heart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.heart.domain.Heart;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    Boolean existsByUserIdAndShopId(Long userId, Long shopId);

    void deleteByUserIdAndShopId(Long userId, Long shopId);
}
