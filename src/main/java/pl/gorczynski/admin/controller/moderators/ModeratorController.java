package pl.gorczynski.admin.controller.moderators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dto.moderator.RegistrationDTO;
import pl.gorczynski.admin.service.authentication.AuthenticationService;
import pl.gorczynski.admin.service.moderator.ModeratorService;
import pl.gorczynski.admin.service.moderator.RoleService;

import java.util.List;

@Controller
@RequestMapping("/moderators")
public class ModeratorController {

    private final ModeratorService moderatorService;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    @Autowired
    public ModeratorController(final ModeratorService moderatorService,
                               final RoleService roleService,
                               final AuthenticationService authenticationService) {
        this.moderatorService = moderatorService;
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String getModerators(final Model model) {
        model.addAttribute("condition", "moderators");

        return "moderators/moderators";
    }

    @GetMapping("/all-moderators")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllModerators(final Model model,
                                   @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                   final Integer pageNumber) {
        model.addAttribute("moderatorsList", moderatorService.getPageWithModerators(pageNumber));
        model.addAttribute("pagesNumber", moderatorService.getModeratorPagesNumber());
        model.addAttribute("searching", false);
        model.addAttribute("currentUserId", authenticationService.currentModeratorId());

        return "moderators/allModerators";
    }

    @GetMapping("/add-new-moderator")
    @PreAuthorize("hasRole('ADMIN')")
    public String addNewModerator(final Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        model.addAttribute("allRolesDTO", roleService.getAllRoles());

        return "moderators/newModerator";
    }

    @PostMapping("/add-new-moderator")
    @PreAuthorize("hasRole('ADMIN')")
    public String addNewModerator(@ModelAttribute(value = "registrationDTO") final RegistrationDTO registrationDTO,
                                  @RequestParam(value = "role" , required = false) List<Integer> roleIdsList) {
        moderatorService.addNewModerator(registrationDTO, roleIdsList);

        return "redirect:/moderators/all-moderators";
    }

    @GetMapping("/delete-moderator-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteModeratorById(@RequestParam(value = "id") final Integer moderatorId) {
        moderatorService.deleteModeratorById(moderatorId);

        return "redirect:/moderators/all-moderators";
    }
}
