package fr.pops.website2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
	"fr.pops.website2.business.entity",
	"fr.pops.website2.business.service",
	"fr.pops.website2.persistence",
	"fr.pops.website2.presentation"})
@SpringBootApplication
public class Website2Application {

	public static void main(String[] args) {
		SpringApplication.run(Website2Application.class, args);
	}

}
