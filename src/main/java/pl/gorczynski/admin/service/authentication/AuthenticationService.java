package pl.gorczynski.admin.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.authentication.LoginDTO;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.repository.moderator.AdminUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final AdminUserRepository adminUserRepository;
    public static final Integer MAX_FAILED_ATTEMPTS = 5;
    private static final Integer LOCK_TIME_DURATION = 30 * 1_000;

    @Autowired
    public AuthenticationService(final AuthenticationManager authenticationManager,
                                 final AdminUserRepository adminUserRepository) {
        this.authenticationManager = authenticationManager;
        this.adminUserRepository = adminUserRepository;
    }

    public String logout(final HttpServletRequest request, final HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "Logout was successful";
    }

    public void resetFailedAttempts(final String userName) {
        adminUserRepository.updateFailedAttempts(0, userName);
    }

    public void lock(final AdminUser adminUser) {
        adminUser.setAccountNonLocked(false);
        Date date = new Date();
        Date unlockExactDate = new Date(date.getTime() + LOCK_TIME_DURATION);
        adminUser.setLockTime(unlockExactDate);
        adminUserRepository.save(adminUser);
        unlockAccountOnExactDate(adminUser, unlockExactDate);
    }

    private void unlockAccountOnExactDate(final AdminUser adminUser,
                                          final Date unlockExactDate) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                unlockAccount(adminUser);
            }
        };
        timer.schedule(timerTask, unlockExactDate);
    }

    public void unlockAccount(final AdminUser adminUser) {
            adminUser.setAccountNonLocked(true);
            adminUser.setLockTime(null);
            adminUser.setFailedAttempt(0);

            adminUserRepository.save(adminUser);
    }

    public AdminUser getByUserName(final String userName) {
        return adminUserRepository.findByUserName(userName).orElse(new AdminUser());
    }

    public void increaseFailedAttempts(final AdminUser adminUser) {
        Integer newFailAttempts = adminUser.getFailedAttempt() + 1;

        adminUserRepository.updateFailedAttempts(newFailAttempts, adminUser.getUserName());
    }

    public Long getLockTimeDurationInSeconds(final Date lockTime) {
        return (lockTime.getTime() - new Date().getTime()) / 1_000;
    }

    public Integer currentModeratorId() {
        String currentUserName = getCurrentUserName();
        return adminUserRepository.findIdByUserName(currentUserName);
    }

    private String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
