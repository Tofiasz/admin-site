package pl.gorczynski.admin.controller.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.gorczynski.admin.service.user.CurrentUserService;

@ControllerAdvice
public class AuthorizationController {

    private final CurrentUserService currentUserService;

    @Autowired
    public AuthorizationController(final CurrentUserService currentUserService) {
        this.currentUserService = currentUserService;
    }

    @ModelAttribute("isCurrentUserIsAdmin")
    public Boolean isCurrentUserIsAdmin() {
        return currentUserService.isCurrentUserIsAdmin();
    }
}
