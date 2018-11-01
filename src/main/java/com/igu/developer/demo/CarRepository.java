package com.igu.developer.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
interface CarRepository extends JpaRepository<Car, Long> {


    CarVo findCarVoById(Long id);

//    List<CarVo> findCarListVoByName(String name);

//    @Query(value = "select new pers.zpw.domain.CityHohel(t1.name AS cityName,t2.name AS hotelName) from  TCity t1 left  join THotel t2 on t1.id=t2.city where t2.name =:name")
//    List<CityHotel> findCityAndHotelByHQLResultObj(@Param("name") String name);
}