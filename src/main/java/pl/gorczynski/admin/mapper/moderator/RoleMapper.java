package pl.gorczynski.admin.mapper.moderator;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.moderator.ERoleDTO;
import pl.gorczynski.admin.dto.moderator.RoleDTO;
import pl.gorczynski.admin.model.moderator.ERole;
import pl.gorczynski.admin.model.moderator.Role;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public List<RoleDTO> toRoleDTOList(final List<Role> roleList) {
        return roleList.stream()
                .map(this::toRoleDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO toRoleDTO(final Role role) {
        return new RoleDTO(role.getId(), ERoleDTO.valueOf(role.getRoleName().toString()));
    }

    public Role toRole(final RoleDTO roleDTO) {
        return new Role(ERole.valueOf(roleDTO.getRoleNameDTO().toString()));
    }

    public List<Role> toRoleList(final List<RoleDTO> roleDTOList) {
        return roleDTOList.stream()
                .map(this::toRole)
                .collect(Collectors.toList());
    }
}
