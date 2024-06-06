package dev.davletshin.user.domain.post;

import dev.davletshin.user.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
            (
                    name = "comment",
                    nullable = false,
                    columnDefinition = "TEXT"
            )
    private String comment;

    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id", updatable = true)
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "post_id", updatable = true)
    private Post post;

    public Comment(String comment, UserEntity user, Post post) {
        this.comment = comment;
        this.user = user;
        this.post = post;
    }
}

