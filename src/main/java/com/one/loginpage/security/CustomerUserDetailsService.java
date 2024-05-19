package com.one.loginpage.security;

import com.one.loginpage.model.Roles;
import com.one.loginpage.model.UserRegisterPage;
import com.one.loginpage.repository.UserRegisterRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRegisterRepository registerRepository;

    public CustomerUserDetailsService(UserRegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        UserRegisterPage user= registerRepository.findByUserNameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(()->
                        new UsernameNotFoundException("user not found with username or email"+ userNameOrEmail));
        return new User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
        }
        private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Roles> roles) {
            return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        }
}

