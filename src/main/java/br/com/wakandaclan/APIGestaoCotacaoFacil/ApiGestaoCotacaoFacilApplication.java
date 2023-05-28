package br.com.wakandaclan.APIGestaoCotacaoFacil;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/")
@SpringBootApplication
public class ApiGestaoCotacaoFacilApplication {

	@GetMapping
	public String getHomeTeste() {
		log.info("Pagina Home");
		return "Gestão Cotação Facil - API";
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiGestaoCotacaoFacilApplication.class, args);
	}

}
