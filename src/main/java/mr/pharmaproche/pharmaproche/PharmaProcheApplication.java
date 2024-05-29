package mr.pharmaproche.pharmaproche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PharmaProcheApplication {
	public static void main(String[] args) {
		SpringApplication.run(PharmaProcheApplication.class, args);
	}

}
