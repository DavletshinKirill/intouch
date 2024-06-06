package dev.davletshin.post.domain.post;

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

    private Long userId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "post_id", updatable = true)
    private Post post;

    public Comment(String comment, Long userId, Post post) {
        this.comment = comment;
        this.userId = userId;
        this.post = post;
    }
}

