package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dao;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.UserRequest;
import org.springframework.stereotype.Component;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Exception.UserNotFoundException;

import java.lang.annotation.Retention;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // JPA/Hibernate > Database
// UserDaoService > Static List
    private static List<UserRequest> users = new ArrayList<>();
    private static int countOfUser = 0;
    static {
        users.add(new UserRequest(++countOfUser, "Raju", LocalDate.now().minusYears(30)));
        users.add(new UserRequest(++countOfUser, "Ranu", LocalDate.now().minusYears(28)));
        users.add(new UserRequest(++countOfUser, "Pappu", LocalDate.now().minusYears(35)));
        users.add(new UserRequest(++countOfUser, "Ankita", LocalDate.now().minusYears(31)));

    }

    public List<UserRequest> findAll() {
        return users;
    }

    public UserRequest save(UserRequest user) {
        user.setId(++countOfUser);
        users.add(user);
        return user;
    }

    public UserRequest findOne(int id) {
        Predicate<? super UserRequest> predicate = users -> users.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUsers(int id) {
        Predicate<? super UserRequest> predicate = users -> users.getId().equals(id);
        users.removeIf(predicate);
    }
}
