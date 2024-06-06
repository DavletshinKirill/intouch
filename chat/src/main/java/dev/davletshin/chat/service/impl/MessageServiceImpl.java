package dev.davletshin.chat.service.impl;

import dev.davletshin.chat.domain.Message;
import dev.davletshin.chat.repository.MessageRepository;
import dev.davletshin.chat.service.interfaces.MessageService;
import dev.davletshin.common.domain.exception.ResourceNotFoundException;
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
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public Set<Message> getMessagesByChatId(Long postId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Message> messages = messageRepository.findAllMessagesByChatId(postId, pageable);
        return messages.hasContent() ? new HashSet<>(messages.getContent()) : Collections.emptySet();
    }
}
