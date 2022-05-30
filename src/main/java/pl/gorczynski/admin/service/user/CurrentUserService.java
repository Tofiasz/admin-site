package pl.gorczynski.admin.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.model.moderator.ERole;
import pl.gorczynski.admin.model.moderator.Role;
import pl.gorczynski.admin.repository.moderator.AdminUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentUserService {

    private final AdminUserRepository adminUsersRepository;

    @Autowired
    public CurrentUserService(final AdminUserRepository adminUsersRepository) {
        this.adminUsersRepository = adminUsersRepository;
    }

    public Boolean isCurrentUserIsAdmin() {
        List<Role> roles = getCurrentUserRoles();

        return roles.stream()
                .anyMatch((role) -> role.getRoleName().equals(ERole.ROLE_ADMIN));
    }

    private List<Role> getCurrentUserRoles() {
        AdminUser adminUser = getCurrentLoggedUser();

        return adminUser != null ? adminUser.getRoles() : new ArrayList<>();
    }

    private AdminUser getCurrentLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        return adminUsersRepository.findByUserName(currentUserName).orElse(null);
    }
}
