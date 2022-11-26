package com.newLibraryProjectt.LibraryProject.repository;

import com.newLibraryProjectt.LibraryProject.dto.UserDto;
import com.newLibraryProjectt.LibraryProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from Users  where name like %?1% and address like %?2% and phone like %?3%", nativeQuery = true)
    List<User> searchUser(String name, String address, String phone);
}
