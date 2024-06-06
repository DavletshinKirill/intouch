package dev.davletshin.user.repository;

import dev.davletshin.user.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = """
                    SELECT * FROM posts p
                    WHERE p.user_id = :user_id
            """, nativeQuery = true)
    Page<Post> findAllByUserId(Long user_id, Pageable pageable);
}
