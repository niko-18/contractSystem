package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Contract;
import server.repository.ContractRepository;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("")
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }
}
