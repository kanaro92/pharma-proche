package mr.pharmaproche.pharmaproche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean active;
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
    @OneToOne
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserRequest> userRequests;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+role.getUserRole().name()));
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        roles.forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getUserRole().name())));
//        });
//        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
