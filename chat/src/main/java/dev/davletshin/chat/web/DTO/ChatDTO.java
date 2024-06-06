package dev.davletshin.chat.web.DTO;

import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Schema($schema = "Chat DTO")
public class ChatDTO {

    @Schema(description = "id", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;

    @Schema(description = "SenderId", example = "1")
    @NotNull(message = "SenderId must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Long senderId;

    @Schema(description = "RecipientId", example = "2")
    @NotNull(message = "SenderId must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Long recipientId;

    @Schema(description = "senderUsername", example = "senderUsername Example")
    @NotNull(message = "senderUsername must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "senderUsername length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String senderUsername;

    @Schema(description = "recipientUsername", example = "recipientUsername Example")
    @NotNull(message = "recipientUsername must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "recipientUsername length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String recipientUsername;

    @Schema(description = "senderPhoto", example = "senderPhoto Example")
    @NotNull(message = "senderPhoto must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "senderPhoto length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String senderPhoto;

    @Schema(description = "recipientPhoto", example = "recipientPhoto Example")
    @NotNull(message = "recipientPhoto must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "recipientPhoto length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String recipientPhoto;
}
