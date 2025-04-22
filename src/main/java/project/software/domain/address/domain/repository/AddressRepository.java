package project.software.domain.address.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.software.domain.address.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
