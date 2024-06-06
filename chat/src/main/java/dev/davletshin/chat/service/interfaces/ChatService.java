package dev.davletshin.chat.service.interfaces;

import dev.davletshin.chat.domain.Chat;

import java.util.Set;

public interface ChatService {

    Chat createChat(Chat chat);


    Set<Chat> getChatsByUserId(Long senderId, Long recipientId, int pageNo, int pageSize);

    void deleteChat(Long chatId);


}
