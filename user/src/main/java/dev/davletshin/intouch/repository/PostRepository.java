package dev.davletshin.intouch.repository;

import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = """
                    SELECT * FROM posts p
                    WHERE p.user_id = :user_id
            """, nativeQuery = true)
    Page<Post> findAllByUserId(Long user_id, Pageable pageable);
}
