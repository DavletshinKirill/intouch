package dev.davletshin.chat.config;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.domain.Message;
import dev.davletshin.chat.service.interfaces.ChatService;
import dev.davletshin.chat.service.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initializer {
    private final ChatService chatService;
    private final MessageService messageService;

    private Chat createChat(Long id, Long senderId, Long recipientId,
    String senderUsername, String recipientUsername, String senderPhoto, String recipientPhoto) {
        Chat chat = new Chat(id, senderId, recipientId, senderUsername, recipientUsername, senderPhoto, recipientPhoto);
        return chatService.createChat(chat);
    }


    private Message createMessage(Long id ,String message, Long userId, Chat chat) {
        Message createdMessage = new Message(id, message, userId, chat);
        return messageService.createMessage(createdMessage);
    }

    public void initialize() {
        Chat chat1 = createChat(1L, 1L, 2L, "kirill", "dima", "photoKirill", "photoDima");
        Chat chat2 = createChat(2L, 2L, 1L, "dima", "kirill", "photoDima", "photoKirill");
        Message message1 = createMessage(1L, "hello!", 1L, chat1);
        Message message2 = createMessage(2L, "hi!", 2L, chat1);
    }
}
