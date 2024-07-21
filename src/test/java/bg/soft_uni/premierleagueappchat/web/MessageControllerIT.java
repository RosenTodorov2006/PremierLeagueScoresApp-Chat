package bg.soft_uni.premierleagueappchat.web;

import bg.soft_uni.premierleagueappchat.models.dtos.AddMessageDto;
import bg.soft_uni.premierleagueappchat.models.entities.Message;
import bg.soft_uni.premierleagueappchat.repositories.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerIT {
    private final static String USER_ID = "1";
    private final static long EXPECTED_USER_ID = 1;
    private final static long EXPECTED_COUNT = 1;
    private final static long EXPECTED_COUNT_AFTER_REMOVE = 0;
    private final static String USER_MESSAGE_FIELD_VALUE = "message";
    private final LocalDateTime TIME = LocalDateTime.now();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MessageRepository messageRepository;
    private Message message;
    @AfterEach
    void clear(){
        this.messageRepository.deleteAll();
    }
    @BeforeEach
    void setUp(){
        this.message = new Message(USER_MESSAGE_FIELD_VALUE, TIME, EXPECTED_USER_ID);
    }
    @Test
    void fetAllMessagesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/chat"))
                .andExpect(status().isOk());
    }
    @Test
    void addMessageTest() throws Exception {
        Assertions.assertEquals(0, messageRepository.count());

        String jsonRequest = "{ \"userId\": \"" + USER_ID + "\", \"userMessage\": \"" + USER_MESSAGE_FIELD_VALUE + "\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/chat")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());

        Assertions.assertEquals(1, messageRepository.count());
        List<Message> all = messageRepository.findAll();
        Message currentMessage = all.get(0);
        Assertions.assertEquals(USER_MESSAGE_FIELD_VALUE, currentMessage.getMessage());
        Assertions.assertEquals(EXPECTED_USER_ID, currentMessage.getUserId());
    }
    @Test
    void deleteMessageTest() throws Exception {
        this.messageRepository.deleteAll();
        this.messageRepository.save(message);
        Assertions.assertEquals(EXPECTED_COUNT, this.messageRepository.count());
        mockMvc.perform(MockMvcRequestBuilders.delete("/chat/1"))
                .andExpect(status().isNoContent());
        Assertions.assertEquals(EXPECTED_COUNT_AFTER_REMOVE, this.messageRepository.count());
    }
}
