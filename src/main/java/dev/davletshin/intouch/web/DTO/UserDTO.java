package dev.davletshin.intouch.web.DTO;

import dev.davletshin.intouch.domain.user.Role;
import dev.davletshin.intouch.web.validation.OnCreate;
import dev.davletshin.intouch.web.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;
import java.util.UUID;


@Data
@AllArgsConstructor
@Schema($schema = "User DTO")
public class UserDTO {

    @Schema(description = "id", example = "c05ea001-2a3c-4ad7-b68c-41f0e654d269")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private UUID id;

    @Schema(description = "Username", example = "kirichka27@gmail.com")
    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "User password", example = "$2a$10$H0YUJXfiPTmjvQ8hLawbPu87p3rJzTyk6oAkU6Ek9kOK4A9Q356vG")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null",  groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Password length must be smaller that 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<Role> roles;

}
