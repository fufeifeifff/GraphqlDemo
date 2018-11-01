package com.igu.developer.demo.service;

import com.igu.developer.demo.UserRepository;
import com.igu.developer.demo.entity.MUserAddress;
import com.igu.developer.demo.entity.User;
import com.igu.developer.demo.vo.UserVo;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GraphQLQuery(name = "getUser")
    public List<User> getUser() {
        return userRepository.findAll();
    }

//    @GraphQLQuery(name = "getUserId")
    public Optional<User> getUserById(@GraphQLArgument(name = "id") Long id) {
        return userRepository.findById(id);
    }

//    @GraphQLQuery(name = "getAddress")
    public Optional<User> getAddressById(@GraphQLArgument(name = "id") Long id) {
        return userRepository.findById(id);
    }

//    @GraphQLMutation(name = "saveUsers")
    public User saveUser(@GraphQLArgument(name = "user") User user) {
        return userRepository.save(user);
    }

//    @GraphQLMutation(name = "deleteUsers")
    public void deleteUser(@GraphQLArgument(name = "id") Long id) {
        userRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isFrees")
    public boolean isCool(@GraphQLContext User user) {
        return !user.getFlgDeleted().equals(1) &&
                !user.getFlgDeleted().equals(0) &&
                !user.getFlgDeleted().equals(1) &&
                !user.getFlgDeleted().equals(1);
    }

//    @GraphQLQuery(name = "giphyUrl")
//    public String getGiphyUrl(@GraphQLContext Car car) {
//        return giphyService.getGiphyUrl(car.getName());
//    }
}
