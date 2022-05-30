package pl.gorczynski.admin.dto.moderator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RegistrationDTO {

    private String userName;
    private String password;
    private List<RoleDTO> roleDTOList;
}
