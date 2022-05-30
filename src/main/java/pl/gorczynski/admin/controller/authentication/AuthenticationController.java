package pl.gorczynski.admin.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.gorczynski.admin.service.authentication.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @Autowired
    public AuthenticationController(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "redirect:/home?login-error=true";
    }

    @GetMapping("/logout")
    public String logout(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final RedirectAttributes redirectAttributes) {
        String logoutResponse = authenticationService.logout(request, response);
        redirectAttributes.addAttribute("logout-response", logoutResponse);

        return "redirect:/home";
    }
}
