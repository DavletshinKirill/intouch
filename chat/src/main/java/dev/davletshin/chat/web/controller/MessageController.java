package dev.davletshin.chat.web.controller;

import dev.davletshin.chat.domain.Message;
import dev.davletshin.chat.service.interfaces.MessageService;
import dev.davletshin.chat.web.DTO.MessageDTO;
import dev.davletshin.chat.web.mapper.MessageMapper;
import dev.davletshin.common.domain.exception.ResourceNotFoundException;
import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;
    @Operation(summary = "Get Messages By Chat Id")
    @GetMapping("/get/posts/{chat_id}")
    public Set<MessageDTO> getMessages(@PathVariable Long chat_id,
                                       @RequestParam(defaultValue = "0") int pageNo,
                                       @RequestParam(defaultValue = "1") int pageSize) {
        Set<Message> messages = messageService.getMessagesByChatId(chat_id, pageNo, pageSize);
        if(messages.isEmpty())
            throw new ResourceNotFoundException("Messages by chat id not found exception");
        return messageMapper.toDTO(messages);
    }

    @Operation(summary = "Delete Message")
    @DeleteMapping("/{message_id}")
    public void deleteById(@PathVariable Long message_id) {
        messageService.deleteMessage(message_id);
    }

    @Operation(summary = "Update Message")
    @PutMapping("/update")
    public MessageDTO updateMessage(@Validated(OnUpdate.class)
                              @RequestBody MessageDTO dto) {
        Message message = messageMapper.toEntity(dto);
        Message updatedMessage = messageService.updateMessage(message);
        return messageMapper.toDTO(updatedMessage);
    }

    @Operation(summary = "Create Message")
    @PostMapping("/create/message")
    public MessageDTO createMessage(@Validated(OnCreate.class) @RequestBody MessageDTO messageDTO) {
        Message message = messageMapper.toEntity(messageDTO);
        Message createdMessage = messageService.createMessage(message);
        return messageMapper.toDTO(createdMessage);
    }
}
