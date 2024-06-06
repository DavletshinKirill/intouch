package dev.davletshin.chat.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "chat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "senderId", nullable = false)
    private Long senderId;
    @Column(name = "recipientId", nullable = false)
    private Long recipientId;
    @Column(name = "senderUsername", nullable = false)
    private String senderUsername;
    @Column(name = "recipientUsername", nullable = false)
    private String recipientUsername;
    @Column(name = "senderPhoto", nullable = false)
    private String senderPhoto;
    @Column(name = "recipientPhoto", nullable = false)
    private String recipientPhoto;

}
