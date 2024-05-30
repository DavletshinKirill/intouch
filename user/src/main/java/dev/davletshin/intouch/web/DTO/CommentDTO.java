package dev.davletshin.intouch.web.DTO;

import dev.davletshin.intouch.domain.post.Post;
import dev.davletshin.intouch.domain.user.UserEntity;
import dev.davletshin.intouch.web.validation.OnCreate;
import dev.davletshin.intouch.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Schema($schema = "Comment DTO")
public class CommentDTO {
    @Schema(description = "id", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;


    @Schema(description = "Comment", example = "Comment Example")
    @NotNull(message = "Comment must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Comment length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String comment;


    private UserEntity user;


    private Post post;

}
