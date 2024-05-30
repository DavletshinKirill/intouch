package dev.davletshin.intouch.web.DTO;

import dev.davletshin.intouch.web.validation.OnCreate;
import dev.davletshin.intouch.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
@Data
@AllArgsConstructor
@Schema($schema = "Post DTO")
public class PostDTO {

    @Schema(description = "id", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;

    @Schema(description = "title", example = "title example")
    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Schema(description = "photo", example = "photo example")
    @NotNull(message = "Photo must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Photo length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String photo;
}


