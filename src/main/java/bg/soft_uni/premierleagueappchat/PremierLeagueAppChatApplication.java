package bg.soft_uni.premierleagueappchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PremierLeagueAppChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(PremierLeagueAppChatApplication.class, args);
    }

}
