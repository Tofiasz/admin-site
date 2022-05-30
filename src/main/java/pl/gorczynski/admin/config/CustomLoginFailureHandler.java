package pl.gorczynski.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.service.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final AuthenticationService authenticationService;

    @Autowired
    public CustomLoginFailureHandler(@Lazy final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String userName = request.getParameter("login");
        AdminUser user = authenticationService.getByUserName(userName);

        Integer leftAttempts = 4;
        if (user.getId() == null) {
            response.sendRedirect("/auth/login-error");
        }
        else  {
            Long lockTimeDuration;
            if (user.getEnabled() && user.getAccountNonLocked()) {
                if (user.getFailedAttempt() < AuthenticationService.MAX_FAILED_ATTEMPTS - 1) {
                    authenticationService.increaseFailedAttempts(user);

                    leftAttempts -= user.getFailedAttempt();
                    response.sendRedirect("/home?left-attempts=" + leftAttempts);
                }
                else {
                    authenticationService.lock(user);
                    lockTimeDuration = authenticationService.getLockTimeDurationInSeconds(user.getLockTime());
                    response.sendRedirect("/home?account-blocked=true&time-left=" + lockTimeDuration);
                }
            }
            else if (!user.getAccountNonLocked()) {
                lockTimeDuration = authenticationService.getLockTimeDurationInSeconds(user.getLockTime());
                response.sendRedirect("/home?account-blocked=true&time-left=" + lockTimeDuration);            }
        }
    }
}

