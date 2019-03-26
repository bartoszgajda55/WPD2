package com.gcu.wpd2.services;

import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not Found");
    }

    List<String> authorities = Arrays.asList(new SimpleGrantedAuthority("user").toString());

    return new User(user.getUsername(), user.getPassword(), authorities.toArray(new String[authorities.size()]));
  }
}
