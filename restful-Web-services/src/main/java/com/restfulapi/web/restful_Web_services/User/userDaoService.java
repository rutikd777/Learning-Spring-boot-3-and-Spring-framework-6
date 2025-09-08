package com.restfulapi.web.restful_Web_services.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class userDaoService {

    //JPA/Hibernate - Database
    //UserDaoService - Static List

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusMonths(2)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusMonths(12)));
        users.add(new User(++userCount,"John", LocalDate.now().minusMonths(5)));
        users.add(new User(++userCount,"Robbin", LocalDate.now().minusMonths(8)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
       return  users.stream()
               .filter(user -> user.getId().equals(id))
               .findFirst()
               .orElse(null);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User delete(int id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return user;
            }
        }
        return null; // User not found
    }


}
