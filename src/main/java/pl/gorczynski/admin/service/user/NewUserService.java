package pl.gorczynski.admin.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.repository.moderator.AdminUserRepository;

@Service
public class NewUserService {

    private final AdminUserRepository adminUsersRepository;

    @Autowired
    public NewUserService(final AdminUserRepository adminUsersRepository) {
        this.adminUsersRepository = adminUsersRepository;
    }

    public void saveNewUser(final AdminUser adminUser) {
        adminUsersRepository.save(adminUser);
    }
}
