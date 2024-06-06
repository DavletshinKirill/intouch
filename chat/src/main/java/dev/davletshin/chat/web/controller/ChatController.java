package dev.davletshin.chat.web.controller;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.domain.Message;
import dev.davletshin.chat.service.interfaces.ChatService;
import dev.davletshin.chat.web.DTO.ChatDTO;
import dev.davletshin.chat.web.DTO.MessageDTO;
import dev.davletshin.chat.web.mapper.ChatMapper;
import dev.davletshin.common.domain.exception.ResourceNotFoundException;
import dev.davletshin.common.web.validation.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat")
public class ChatController {
    private final ChatService chatService;
    private final ChatMapper chatMapper;

    @Operation(summary = "Get Messages By Chat Id")
    @GetMapping("/get/posts/{senderId}/{recipientId}")
    public Set<ChatDTO> getMessages(@PathVariable Long user_id,
                                       @RequestParam(defaultValue = "0") int pageNo,
                                       @RequestParam(defaultValue = "1") int pageSize) {
        Set<Chat> chats = chatService.getChatsByUserId(user_id, user_id, pageNo, pageSize);
        if(chats.isEmpty())
            throw new ResourceNotFoundException("Messages by chat id not found exception");
        return chatMapper.toDTO(chats);
    }

    @Operation(summary = "Delete Message")
    @DeleteMapping("/{chat_id}")
    public void deleteById(@PathVariable Long chat_id) {
        chatService.deleteChat(chat_id);
    }

    @Operation(summary = "Create Message")
    @PostMapping("/create/message")
    public ChatDTO createChat(@Validated(OnCreate.class) @RequestBody ChatDTO chatDTO) {
        Chat chat = chatMapper.toEntity(chatDTO);
        Chat createdChat = chatService.createChat(chat);
        return chatMapper.toDTO(createdChat);
    }
}
