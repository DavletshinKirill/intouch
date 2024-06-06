package dev.davletshin.chat;


import dev.davletshin.chat.config.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {
    private static Initializer initiator;

    @Autowired
    public void setInitialLoader(Initializer initiator) {
        ChatApplication.initiator = initiator;
    }
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
        initiator.initialize();
    }
}
