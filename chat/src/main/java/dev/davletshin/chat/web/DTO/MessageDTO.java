package dev.davletshin.chat.web.DTO;

import dev.davletshin.chat.domain.Chat;
import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Schema($schema = "Message DTO")
public class MessageDTO {

    @Schema(description = "id", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;


    @Schema(description = "Message", example = "Message Example")
    @NotNull(message = "Message must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Message length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String message;


    @Schema(description = "UserId", example = "1")
    @NotNull(message = "UserId must be not null", groups = {OnUpdate.class})
    private Long userId;

    @Schema(description = "Chat")
    private ChatDTO chat;

}
