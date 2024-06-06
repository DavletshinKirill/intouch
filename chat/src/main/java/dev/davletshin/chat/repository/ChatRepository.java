package dev.davletshin.chat.repository;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.chat.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Page<Chat> findBySenderIdOrRecipientId(Long senderId, Long recipientId, Pageable pageable);
}
