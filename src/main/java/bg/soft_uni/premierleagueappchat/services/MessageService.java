package bg.soft_uni.premierleagueappchat.services;

import bg.soft_uni.premierleagueappchat.models.dtos.AddMessageDto;
import bg.soft_uni.premierleagueappchat.models.dtos.ExportMessageDto;

import java.util.List;

public interface MessageService {
    void addMessage(AddMessageDto addMessageDto);

    List<ExportMessageDto> getAllMessagesSortedByCreated();

    void removeMessage(long id);
}
