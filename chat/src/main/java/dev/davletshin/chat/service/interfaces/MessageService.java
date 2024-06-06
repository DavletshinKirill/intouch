package dev.davletshin.chat.service.interfaces;

import dev.davletshin.chat.domain.Message;

import java.util.Set;

public interface MessageService {

    Message createMessage(Message message);

    Message updateMessage(Message message);

    void deleteMessage(Long messageId);

    Set<Message> getMessagesByChatId(Long postId, int pageNo, int pageSize);

}
