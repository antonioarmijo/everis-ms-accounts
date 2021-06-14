package com.bank.ms.accounts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MsAccountsApplication {

	public static void main(String[] args) {
		log.info("Apicación iniciada 2");
		SpringApplication.run(MsAccountsApplication.class, args);
	}

}
