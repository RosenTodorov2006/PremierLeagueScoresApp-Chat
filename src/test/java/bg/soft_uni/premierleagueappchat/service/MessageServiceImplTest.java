package bg.soft_uni.premierleagueappchat.service;//package bg.soft_uni.premierlegueapp.service;


import bg.soft_uni.premierleagueappchat.models.dtos.ExportMessageDto;
import bg.soft_uni.premierleagueappchat.models.entities.Message;
import bg.soft_uni.premierleagueappchat.repositories.MessageRepository;
import bg.soft_uni.premierleagueappchat.services.impl.MessageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageServiceImplTest {
    private final static String MESSAGE = "text";
    private final static long USER_ID = 1;
    @Mock
    private MessageRepository messageRepository;
    @Mock
    private ModelMapper modelMapper;

    private List<Message> messages;
    private ExportMessageDto exportMessageDto;
    private MessageServiceImpl messageService;
    @BeforeEach
    void setUp(){
        messages = new ArrayList<>();
        Message message = new Message();
        message.setMessage(MESSAGE);
        messages.add(message);
        exportMessageDto = new ExportMessageDto();
        exportMessageDto.setMessage(message.getMessage());
        exportMessageDto.setUserId(USER_ID);
        messageService = new MessageServiceImpl(messageRepository, modelMapper);
    }
    @Test
    void getAllMessagesSortedByCreatedTest(){
        when(messageRepository.findAll()).thenReturn(messages);
        when(modelMapper.map(messages.get(0), ExportMessageDto.class)).thenReturn(exportMessageDto);
        List<ExportMessageDto> allMessagesSortedByCreated = this.messageService.getAllMessagesSortedByCreated();
        ExportMessageDto exportMessageDto1 = allMessagesSortedByCreated.get(0);
        Assertions.assertEquals(1, allMessagesSortedByCreated.size());
        Assertions.assertEquals(MESSAGE, exportMessageDto1.getMessage());
        Assertions.assertEquals(USER_ID, exportMessageDto1.getUserId());
    }
}
