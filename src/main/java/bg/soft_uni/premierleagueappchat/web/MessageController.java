package bg.soft_uni.premierleagueappchat.web;

import bg.soft_uni.premierleagueappchat.models.dtos.AddMessageDto;
import bg.soft_uni.premierleagueappchat.models.dtos.ExportMessageDto;
import bg.soft_uni.premierleagueappchat.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<ExportMessageDto>> getMessages(){
        List<ExportMessageDto> allMessagesSortedByCreated = this.messageService.getAllMessagesSortedByCreated();
        return ResponseEntity.ok(allMessagesSortedByCreated);
    }
    @PostMapping
    public ResponseEntity<Void> addMessage(@RequestBody AddMessageDto addMessageDto){
        this.messageService.addMessage(addMessageDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ExportMessageDto> deleteById(@PathVariable("id") Long id) {
        this.messageService.removeMessage(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
