package dev.davletshin.marks.web.DTO;

import dev.davletshin.common.web.DTO.BaseEntityDTO;
import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SubjectDTO extends BaseEntityDTO {
    @Schema(description = "Title", example = "Title Example")
    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String title;
    private SemesterDTO semester;
}
