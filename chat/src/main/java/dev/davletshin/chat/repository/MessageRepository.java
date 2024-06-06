package dev.davletshin.chat.repository;

import dev.davletshin.chat.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = """
                    SELECT * FROM message m
                    WHERE m.chat_id = :chat_id
            """, nativeQuery = true)
    Page<Message> findAllMessagesByChatId(Long chat_id, Pageable pageable);
}
