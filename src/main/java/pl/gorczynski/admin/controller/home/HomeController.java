package pl.gorczynski.admin.controller.home;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gorczynski.admin.dto.authentication.LoginDTO;

import java.security.Principal;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getHome(final Model model,
                          final Principal moderator,
                          @RequestParam(name = "access-denied-error", required = false) final Boolean accessDeniedError,
                          @RequestParam(name = "logout-response", required = false) final String logoutResponse,
                          @RequestParam(name = "left-attempts", required = false) final Integer leftAttempts,
                          @RequestParam(name = "account-blocked", required = false) final Boolean accountBlocked,
                          @RequestParam(name = "session-expired", required = false) final Boolean sessionExpired,
                          @RequestParam(name = "time-left", required = false ) final Integer timeLeft,
                          @RequestParam(name = "login-error", required = false) final Boolean loginError) {
        if (moderator != null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("sign", new LoginDTO());
        model.addAttribute("accessDeniedError", accessDeniedError);
        model.addAttribute("logoutResponse", logoutResponse);
        model.addAttribute("leftAttempts", leftAttempts);
        model.addAttribute("accountBlocked", accountBlocked);
        model.addAttribute("sessionExpired", sessionExpired);
        model.addAttribute("lockedDate", timeLeft);
        model.addAttribute("loginError", loginError);

        return "home/home";
    }
}
