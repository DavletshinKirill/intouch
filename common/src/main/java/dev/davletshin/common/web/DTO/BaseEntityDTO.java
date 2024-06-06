package dev.davletshin.common.web.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.davletshin.common.web.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDTO {
    @Schema(description = "id", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Long id;

}
