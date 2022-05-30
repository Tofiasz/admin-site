package pl.gorczynski.admin.model.moderator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gorczynski.admin.model.moderator.ERole;

import javax.persistence.*;

@Entity(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private ERole roleName;

    public Role(final ERole roleName) {
        this.roleName = roleName;
    }
}
