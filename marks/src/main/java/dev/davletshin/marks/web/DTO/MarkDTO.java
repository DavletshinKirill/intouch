package dev.davletshin.marks.web.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.davletshin.common.web.DTO.BaseEntityDTO;
import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import dev.davletshin.marks.domain.MarkEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MarkDTO extends BaseEntityDTO {
    @Schema(name = "userId", example = "1")
    @NotNull(message = "UserId must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Long userId;
    private MarkEnum mark;
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime dateTime;
    private SubjectDTO subject;
}
