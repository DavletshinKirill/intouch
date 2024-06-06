package dev.davletshin.chat.service.impl;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.repository.ChatRepository;
import dev.davletshin.chat.service.interfaces.ChatService;
import dev.davletshin.common.service.interfaces.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }


    @Override
    public Set<Chat> getChatsByUserId(Long senderId, Long recipientId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Chat> chatPage = chatRepository.findBySenderIdOrRecipientId(senderId, recipientId, pageable);
        return chatPage.hasContent() ? new HashSet<>(chatPage.getContent()) : Collections.emptySet();
    }

    @Override
    public void deleteChat(Long chatId) {
        chatRepository.deleteById(chatId);
    }
}
