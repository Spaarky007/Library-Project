package com.newLibraryProjectt.LibraryProject.service;

import com.newLibraryProjectt.LibraryProject.convertor.UserDtoConvertor;
import com.newLibraryProjectt.LibraryProject.dto.UserDto;
import com.newLibraryProjectt.LibraryProject.entity.User;
import com.newLibraryProjectt.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoConvertor userDtoConvertor;

    public User getUserById(Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new Exception();
         return user.get();
    }

    public UserDto saveUser(User user) {
        User user1 =  userRepository.save(user);
        UserDto userDto = userDtoConvertor.toUserConvertor(user1);
        return userDto;
    }

    public List<UserDto> searchUser(User user) {
        List<User> userList = userRepository.searchUser(user.getName(),
                user.getAddress(), user.getPhone());
        List<UserDto> userDtoList = userList.stream().map(u->userDtoConvertor.toUserConvertor(u)).collect(Collectors.toList());
        return userDtoList;

    }
}
