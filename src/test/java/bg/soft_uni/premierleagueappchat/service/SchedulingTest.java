package bg.soft_uni.premierleagueappchat.service;

import bg.soft_uni.premierleagueappchat.models.entities.Message;
import bg.soft_uni.premierleagueappchat.repositories.MessageRepository;

import bg.soft_uni.premierleagueappchat.services.scheduling.ChatModerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SchedulingTest {
    @Mock
    private MessageRepository messageRepository;
    private ChatModerator moderator;
    private Message message1;
    private Message message2;
    @BeforeEach
    void setUp(){
        this.moderator = new ChatModerator(messageRepository);
        this.message1=new Message();
        message1.setId(1L);
        message1.setMessage("Hello");
        message2=new Message();
        message2.setId(2L);
        message2.setMessage("kill");
    }
    @Test
    void cleanChatTest(){
        moderator.cleanChat();
        verify(messageRepository, times(1)).deleteAll();
    }
    @Test
    void checkForForbiddenWordsTest() {
        when(messageRepository.findAll()).thenReturn(Arrays.asList(message1, message2));
        moderator.checkForForbiddenWords();

        verify(messageRepository, never()).deleteById(1L);
        verify(messageRepository, times(1)).deleteById(2L);
    }
}
