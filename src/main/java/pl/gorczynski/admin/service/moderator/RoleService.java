package pl.gorczynski.admin.service.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.moderator.RoleDTO;
import pl.gorczynski.admin.mapper.moderator.RoleMapper;
import pl.gorczynski.admin.model.moderator.Role;
import pl.gorczynski.admin.repository.moderator.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(final RoleRepository roleRepository,
                       final RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleMapper.toRoleDTOList(roleList);
    }

    public List<Role> getRoleDTOListBasedIdsList(final List<Integer> roleIdsList) {
        List<RoleDTO> roleDTOList = roleIdsList.stream().map(this::getRoleDTOById).collect(Collectors.toList());

        return roleMapper.toRoleList(roleDTOList);
    }

    private RoleDTO getRoleDTOById(final Integer roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow();

        return roleMapper.toRoleDTO(role);
    }
}
