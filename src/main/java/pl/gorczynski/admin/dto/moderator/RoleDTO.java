package pl.gorczynski.admin.dto.moderator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Integer id;
    private ERoleDTO roleNameDTO;
}
