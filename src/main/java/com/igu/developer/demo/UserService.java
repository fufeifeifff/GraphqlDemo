//package com.igu.developer.demo;
//
//import com.igu.developer.demo.entity.User;
//import io.leangen.graphql.annotations.GraphQLArgument;
//import io.leangen.graphql.annotations.GraphQLContext;
//import io.leangen.graphql.annotations.GraphQLMutation;
//import io.leangen.graphql.annotations.GraphQLQuery;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GraphQLQuery(name = "user")
//    public List<User> getUser() {
//        return userRepository.findAll();
//    }
//
//    @GraphQLQuery(name = "userId")
//    public Optional<User> getUserById(@GraphQLArgument(name = "id") Long id) {
//        return userRepository.findById(id);
//    }
//
//    @GraphQLMutation(name = "saveUser")
//    public User saveUser(@GraphQLArgument(name = "car") User car) {
//        return userRepository.save(car);
//    }
//
//    @GraphQLMutation(name = "deleteUser")
//    public void deleteUser(@GraphQLArgument(name = "id") Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @GraphQLQuery(name = "isFree")
//    public boolean isCool(@GraphQLContext User user) {
//        return !user.getFlgDeleted().equals(1) &&
//                !user.getFlgDeleted().equals(0) &&
//                !user.getFlgDeleted().equals(1) &&
//                !user.getFlgDeleted().equals(1);
//    }
//
////    @GraphQLQuery(name = "giphyUrl")
////    public String getGiphyUrl(@GraphQLContext Car car) {
////        return giphyService.getGiphyUrl(car.getName());
////    }
//}
