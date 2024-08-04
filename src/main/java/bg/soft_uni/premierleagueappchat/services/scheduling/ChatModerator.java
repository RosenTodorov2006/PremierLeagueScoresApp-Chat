package bg.soft_uni.premierleagueappchat.services.scheduling;

import bg.soft_uni.premierleagueappchat.models.entities.enums.ForbiddenWords;
import bg.soft_uni.premierleagueappchat.repositories.MessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ChatModerator {
    private final MessageRepository messageRepository;

    public ChatModerator(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    @Scheduled(cron = "0 0 0/12 * * ?")
    public void cleanChat() {
        messageRepository.deleteAll();
    }

    @Scheduled(cron = "0 0/15 * * * ?")
    public void checkForForbiddenWords() {
        this.messageRepository.findAll().forEach(message -> {
            List<String> forbiddenWords = Arrays.stream(ForbiddenWords.values()).map(Enum::name).toList();
            if(forbiddenWords.contains(message.getMessage().toUpperCase())){
                this.messageRepository.deleteById(message.getId());
            }
        });
    }
}
