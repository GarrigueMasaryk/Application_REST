package com.example.application_rest.service;

import com.example.application_rest.api.dto.UserDTO;
import com.example.application_rest.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Petr", 19, "petr@gmail.com");
        User user2 = new User(2, "Markéta", 28, "marketa@gmail.com");
        User user3 = new User(3, "Jirka", 30, "jirka@gmail.com");
        User user4 = new User(4, "Nikola", 23, "nikola@gmail.com");
        User user5 = new User(5, "František", 47, "franta@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public Optional<UserDTO> getUserDTO(Integer id) {
        Optional<UserDTO> optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getAge(), user.getEmail());
                optional = Optional.of(userDTO);
                return optional;
            }
        }
        return optional;
    }
}
