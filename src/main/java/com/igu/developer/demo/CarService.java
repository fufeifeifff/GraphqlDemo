package com.igu.developer.demo;

import com.igu.developer.demo.entity.User;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final GiphyService giphyService;
    private final UserRepository userRepository;

    public CarService(CarRepository carRepository, GiphyService giphyService,UserRepository userRepository) {
        this.carRepository = carRepository;
        this.giphyService = giphyService;
        this.userRepository = userRepository;
    }

    @GraphQLQuery(name = "cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GraphQLQuery(name = "carVo")
    public CarVo getCarVo(@GraphQLArgument(name = "id")Long id) {
        CarVo carVo = carRepository.findCarVoById(id);
        return carVo;
    }

//    @GraphQLQuery(name = "carVoList")
//    public List<CarVo> getCarVoList(@GraphQLArgument(name = "name")String name) {
//        List<CarVo> carVo = carRepository.findCarListVoByName(name);
//        return carVo;
//    }

    @GraphQLQuery(name = "car")
    public Optional<Car> getCarById(@GraphQLArgument(name = "id") Long id) {
        return carRepository.findById(id);
    }

    @GraphQLMutation(name = "saveCar")
    public Car saveCar(@GraphQLArgument(name = "car") Car car) {
        return carRepository.save(car);
    }

    @GraphQLMutation(name = "deleteCar")
    public void deleteCar(@GraphQLArgument(name = "id") Long id) {
        carRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isCool")
    public boolean isCool(@GraphQLContext Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }

    @GraphQLQuery(name = "giphyUrl")
    public String getGiphyUrl(@GraphQLContext Car car) {
        return giphyService.getGiphyUrl(car.getName());
    }
}
