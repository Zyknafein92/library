package com.library.gateway.services;

import com.library.gateway.exceptions.UserCreationException;
import com.library.gateway.exceptions.UserNotFoundException;
import com.library.gateway.model.Role;
import com.library.gateway.model.RoleName;
import com.library.gateway.model.User;
import com.library.gateway.repository.RoleRepository;
import com.library.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User getUser(Long id) {
        User user = userRepository.getOne(id);
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
        return user;
    }

    @Override
    public User createUser(UserDTO userDTO) {

        if( userDTO.getEmail() == null ) {
            throw new UserCreationException("Veuillez à renseigner un Email ");
        }

        if( userDTO.getPassword() == null ) {
            throw new UserCreationException(" Veuillez rajouter un password");
        }

        if( userDTO.getRoles() == null ) {
            Set<Role> roles = new HashSet<>();
            Role roleUser = roleRepository.findByName(RoleName.ROLE_USER);
            roles.add(roleUser);
            userDTO.setRoles(roles);
        }

        User user = userMapper.userDtoToUser(userDTO);
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.getOne(userDTO.getId());
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
        userMapper.updateUserFromUserDTO(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}