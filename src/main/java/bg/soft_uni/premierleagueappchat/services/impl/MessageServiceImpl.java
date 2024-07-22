package bg.soft_uni.premierleagueappchat.services.impl;

import bg.soft_uni.premierleagueappchat.models.dtos.AddMessageDto;
import bg.soft_uni.premierleagueappchat.models.dtos.ExportMessageDto;
import bg.soft_uni.premierleagueappchat.models.entities.Message;
import bg.soft_uni.premierleagueappchat.repositories.MessageRepository;
import bg.soft_uni.premierleagueappchat.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addMessage(AddMessageDto addMessageDto) {
        Message messages = new Message(addMessageDto.getUserMessage(), LocalDateTime.now(), addMessageDto.getUserId());
        this.messageRepository.save(messages);                                                                                                                                                                                                                                         this.messageRepository.save(messages);
    }

    @Override
    public List<ExportMessageDto> getAllMessagesSortedByCreated() {
        return this.messageRepository.findAll().stream().map(message -> {
            return this.modelMapper.map(message, ExportMessageDto.class);
        }).sorted(Comparator.comparing(ExportMessageDto::getCreated)).collect(Collectors.toList());
    }

    @Override
    public void removeMessage(long id) {
        this.messageRepository.deleteById(id);
    }
}
