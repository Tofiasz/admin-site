package pl.gorczynski.admin.service.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.moderator.AdminUserDTO;
import pl.gorczynski.admin.dto.moderator.RegistrationDTO;
import pl.gorczynski.admin.mapper.moderator.AdminUserMapper;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.model.moderator.ERole;
import pl.gorczynski.admin.model.moderator.Role;
import pl.gorczynski.admin.repository.moderator.AdminUserRepository;
import pl.gorczynski.admin.service.authentication.AuthenticationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModeratorService {

    private final AdminUserRepository adminUserRepository;
    private final AdminUserMapper adminUserMapper;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    @Autowired
    public ModeratorService(final AdminUserRepository adminUserRepository,
                            final AdminUserMapper adminUserMapper,
                            final RoleService roleService,
                            final AuthenticationService authenticationService) {
        this.adminUserRepository = adminUserRepository;
        this.adminUserMapper = adminUserMapper;
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    public List<AdminUserDTO> getAdminSiteAllUsersList() {
        List<AdminUser> adminUserList = adminUserRepository.findAll();

       return convertToAdminUserDTOList(adminUserList);
    }

    public List<AdminUserDTO> getAdminSiteModeratorsAndAdminsList() {
        List<AdminUser> adminUserList = adminUserRepository.findUserByRoleList(ERole.ROLE_ADMIN.toString(), ERole.ROLE_MODERATOR.toString());

        return convertToAdminUserDTOList(adminUserList);
    }

    public List<AdminUserDTO> getAdminSiteBasicUsersList() {
        List<AdminUser> adminUserList = adminUserRepository.findUserByRoleList(ERole.ROLE_USER.toString());

        return convertToAdminUserDTOList(adminUserList);
    }

    private AdminUserDTO convertToAdminUserDTO(final AdminUser adminUser) {

        return adminUserMapper.toAdminUserDTO(adminUser);
    }

    private List<AdminUserDTO> convertToAdminUserDTOList(final List<AdminUser> adminUserList) {

        return adminUserList.stream()
                .map(this :: convertToAdminUserDTO)
                .collect(Collectors.toList());
    }

    private void save(final AdminUser adminUser) {
        adminUserRepository.save(adminUser);
    }

    public void addNewModerator(final RegistrationDTO registrationDTO,
                                final List<Integer> roleIdsList) {
        List<Role> roleList = roleService.getRoleDTOListBasedIdsList(roleIdsList);
        String encryptedPassword = encryptPassword(registrationDTO.getPassword());
        AdminUser adminUser = new AdminUser(registrationDTO.getUserName(), encryptedPassword);
        adminUser.setRoles(roleList);
        adminUser.setAccountNonLocked(true);
        adminUser.setFailedAttempt(0);
        adminUser.setEnabled(true);
        save(adminUser);
    }

    private String encryptPassword(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public List<AdminUserDTO> getPageWithModerators(final Integer pageNumber) {
        List<AdminUser> adminUserList = adminUserRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return adminUserMapper.toAdminUsersListDTO(adminUserList);
    }

    public Integer getModeratorPagesNumber() {
        return  (Integer) (int) Math.ceil(adminUserRepository.count() / 10.0);
    }

    public void deleteModeratorById(final Integer moderatorId) {
        Integer currentModeratorId = authenticationService.currentModeratorId();
        if (!moderatorId.equals(currentModeratorId)) {
            adminUserRepository.deleteById(moderatorId);
        }
    }
}
