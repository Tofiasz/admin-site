package pl.gorczynski.admin.mapper.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.moderator.AdminUserDTO;
import pl.gorczynski.admin.model.moderator.AdminUser;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminUserMapper {

    private final RoleMapper roleMapper;

    @Autowired
    public AdminUserMapper(final RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public AdminUserDTO toAdminUserDTO(final AdminUser adminUser) {
        return new AdminUserDTO(adminUser.getId(),
                adminUser.getUserName(),
                roleMapper.toRoleDTOList(adminUser.getRoles()),
                adminUser.getEnabled(),
                adminUser.getAccountNonLocked(),
                adminUser.getFailedAttempt(),
                adminUser.getLockTime());
    }

    public List<AdminUserDTO> toAdminUsersListDTO(final List<AdminUser> adminUserList) {
        return adminUserList.stream()
                .map(this::toAdminUserDTO)
                .collect(Collectors.toList());
    }

    public AdminUser toAdminUser(final AdminUserDTO adminUserDTO) {
        return new AdminUser(adminUserDTO.getId(),
                adminUserDTO.getUserName(),
                roleMapper.toRoleList(adminUserDTO.getRoleDTOList()),
                adminUserDTO.getEnabled(),
                adminUserDTO.getAccountNonLocked(),
                adminUserDTO.getFailedAttempt(),
                adminUserDTO.getLockTime());
    }

    public List<AdminUser> toAdminUsersList(final List<AdminUserDTO> adminUserDTOList) {
        return adminUserDTOList.stream()
                .map(this::toAdminUser)
                .collect(Collectors.toList());
    }
}
