package pl.gorczynski.admin.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.repository.moderator.AdminUserRepository;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {

    final private AdminUserRepository adminUsersRepository;

    @Autowired
    public AppUserDetailsServiceImpl(final AdminUserRepository adminUsersRepository) {
        this.adminUsersRepository = adminUsersRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        AdminUser user = adminUsersRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new UserPrincipal(user);
    }
}
