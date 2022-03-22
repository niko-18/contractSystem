package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, String> {

}
