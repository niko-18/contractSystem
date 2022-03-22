package server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import server.helper.ControllerHelper;
import server.repository.ContractRepository;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initStartData(ContractRepository contractRepository) {
        return args -> {
            contractRepository.deleteAll();
            contractRepository.saveAll(ControllerHelper.createRandomContracts());
        };
    }
}
