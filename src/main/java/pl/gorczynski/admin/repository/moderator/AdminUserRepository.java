package pl.gorczynski.admin.repository.moderator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.gorczynski.admin.model.moderator.AdminUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

    Optional<AdminUser> findByUserName(final String userName);
    @Query(value = "UPDATE admin_user SET failed_attempt = ?1 WHERE user_name = ?2",
            nativeQuery = true)
    @Modifying
    @Transactional
    void updateFailedAttempts(final Integer failedAttempts, final String userName);
    List<AdminUser> findAll();
    @Query(value = "SELECT DISTINCT admin_user.* \n" +
            "FROM admin_user\n" +
            "JOIN admin_user_roles ON admin_user.id = admin_user_roles.admin_user_id\n" +
            "JOIN role ON admin_user_roles.roles_id = role.id\n" +
            "WHERE role.role_name = ?1 OR role.role_name = ?2",
    nativeQuery = true)
    List<AdminUser> findUserByRoleList(final String firstRole, final String secondRole);
    @Query(value = "SELECT DISTINCT admin_user.* \n" +
            "FROM admin_user\n" +
            "JOIN admin_user_roles ON admin_user.id = admin_user_roles.admin_user_id\n" +
            "JOIN role ON admin_user_roles.roles_id = role.id\n" +
            "WHERE role.role_name = ?1", nativeQuery = true)
    List<AdminUser> findUserByRoleList(final String role);
    Page<AdminUser> findAll(final Pageable pageable);
    @Query(value = "SELECT admin_user.id\n" +
            "FROM admin_user\n" +
            "WHERE admin_user.user_name = ?1", nativeQuery = true)
    Integer findIdByUserName(final String userName);
}
