package pl.gorczynski.admin.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private AddressDTO addressDTO;
    private LocalDate registrationDate;
    private Boolean isAccountVerified;
}
