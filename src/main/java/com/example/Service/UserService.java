package com.example.Service;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.getById(id);
    }

    public void create (User user){
        if(user.getId() != null){
            IllegalArgumentException exception = new IllegalArgumentException(
                    "User of the specified identifier already exist");
            log.error("Write Failed");
            throw exception;
        }
        userRepository.save(user);
    }
    public void update(User user) {
        if (user.getId() != null) {
            User updatedUser = userRepository.getById(user.getId());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
        }
        userRepository.save(user);
    }

    public void delete(User user) {
        if (user.getId() != null) {
            userRepository.delete(user);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
