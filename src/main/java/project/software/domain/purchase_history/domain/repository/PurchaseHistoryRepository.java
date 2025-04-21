package project.software.domain.purchase_history.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.software.domain.purchase_history.domain.PurchaseHistory;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    public List<PurchaseHistory> findAllByUserId(Long userId);

}
