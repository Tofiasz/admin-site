package pl.gorczynski.admin.model.shop.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(unique = true)
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String emailAddress;
    @OneToOne
    private Address address;
    @NotNull
    private LocalDate registrationDate;
    @NotNull
    private Boolean isAccountVerified;

    public Customer(final Integer id,
                    @NotNull final String login,
                    @NotNull final String firstName,
                    @NotNull final String lastName,
                    @NotNull final String emailAddress,
                    final Address address,
                    @NotNull final LocalDate registrationDate,
                    @NotNull final Boolean isAccountVerified) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.registrationDate = registrationDate;
        this.isAccountVerified = isAccountVerified;
    }
}
