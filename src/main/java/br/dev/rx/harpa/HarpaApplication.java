package br.dev.rx.harpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.dev.rx.harpa")
public class HarpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarpaApplication.class, args);
	}

}
