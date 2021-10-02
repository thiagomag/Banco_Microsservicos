package br.com.thiago.movimentacaoconta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovimentacaoContaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovimentacaoContaApplication.class, args);
    }

}
