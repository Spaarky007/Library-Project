package com.newLibraryProjectt.LibraryProject.convertor;

import com.newLibraryProjectt.LibraryProject.dto.UserDto;
import com.newLibraryProjectt.LibraryProject.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDtoConvertor {

    @Autowired
    private UserDto userDto;

    public UserDto toUserConvertor(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

}
