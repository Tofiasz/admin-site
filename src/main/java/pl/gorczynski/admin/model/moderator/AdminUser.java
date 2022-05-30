package pl.gorczynski.admin.model.moderator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private List<Role> roles;
    private Boolean enabled;
    private Boolean accountNonLocked;
    private Integer failedAttempt;
    private Date lockTime;

    public AdminUser(final @NotNull String userName,
                     final @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public AdminUser(final @NotNull String userName,
                     final @NotNull String password,
                     final @NotNull List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.enabled = null;
        this.accountNonLocked = null;
        this.failedAttempt = null;
        this.lockTime = null;
    }

    public AdminUser(final Integer id,
                     final @NotNull String userName,
                     final @NotNull List<Role> roles,
                     final Boolean enabled,
                     final Boolean accountNonLocked,
                     final Integer failedAttempt,
                     final Date lockTime) {
        this.id = id;
        this.userName = userName;
        this.roles = roles;
        this.enabled = enabled;
        this.accountNonLocked = accountNonLocked;
        this.failedAttempt = failedAttempt;
        this.lockTime = lockTime;
    }
}
