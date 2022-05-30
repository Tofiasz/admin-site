package pl.gorczynski.admin.dto.moderator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gorczynski.admin.model.moderator.AdminUser;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDTO {

    private Integer id;
    private String userName;
    private List<RoleDTO> roleDTOList;
    private Boolean enabled;
    private Boolean accountNonLocked;
    private Integer failedAttempt;
    private Date lockTime;

    public AdminUserDTO(final String userName,
                        final List<RoleDTO> roleDTOList) {
        this.userName = userName;
        this.roleDTOList = roleDTOList;
    }
}
