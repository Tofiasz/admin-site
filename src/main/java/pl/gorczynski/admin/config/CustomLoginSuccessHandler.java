package pl.gorczynski.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.moderator.AdminUser;
import pl.gorczynski.admin.service.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final AuthenticationService authenticationService;

    @Autowired
    public CustomLoginSuccessHandler(@Lazy final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        final Authentication authentication) throws IOException, ServletException {
        String userName = authentication.getName();
        AdminUser adminUser = authenticationService.getByUserName(userName);

        if (adminUser.getFailedAttempt() > 0) {
            authenticationService.resetFailedAttempts(adminUser.getUserName());
        }
        Integer maxInactiveSessionTimeInSeconds = 60 * 60;

        request.getSession(false).setMaxInactiveInterval(maxInactiveSessionTimeInSeconds);
        response.sendRedirect("/dashboard");
    }

}
