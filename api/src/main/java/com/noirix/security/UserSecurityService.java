package com.noirix.security;

import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import com.noirix.entity.User;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.repository.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    public static final String NO_USER_FOUND_WITH_LOGIN_S = "No user found with login '%s'.";
    public static final String USER_WITH_THIS_LOGIN_NOT_FOUND = "User with this login not found";
    private final UserSpringDataRepository userRepository;

    private final RolesSpringDataRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            /*Find user in DB*/
            Optional<User> searchResult = userRepository.findByLogin(username);

            if (searchResult.isPresent()) {
                User user = searchResult.get();

                /*We are creating Spring Security User object*/

                return new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
//                        ["ROLE_USER", "ROLE_ADMIN"]
                        AuthorityUtils.commaSeparatedStringToAuthorityList(
                                roleRepository.findByUserId(user.getId())
                                        .stream()
                                        .map(Roles::getRoleName)
                                        .map(SystemRoles::name)
                                        .collect(Collectors.joining(","))
                        )
                );
            } else {
                throw new UsernameNotFoundException(String.format(NO_USER_FOUND_WITH_LOGIN_S, username));
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(USER_WITH_THIS_LOGIN_NOT_FOUND);
        }
    }
}
