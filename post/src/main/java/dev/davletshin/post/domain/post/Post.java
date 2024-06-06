package dev.davletshin.post.domain.post;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column
            (
                    name = "photo",
                    nullable = false,
                    columnDefinition = "TEXT"
            )
    private String photo;

    private Long userId;

}
