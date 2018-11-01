package com.igu.developer.demo.service;

import com.igu.developer.demo.UserRepository;
import com.igu.developer.demo.dao.UserAddressDao;
import com.igu.developer.demo.entity.MUserAddress;
import com.igu.developer.demo.entity.User;
import com.igu.developer.demo.util.SqlUtil;
import com.igu.developer.demo.vo.AddressVo;
import com.igu.developer.demo.vo.UserVo;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class AddressServices {

    private final UserAddressDao userAddressDao;
    private final UserRepository userRepository;

    public AddressServices(UserRepository userRepository,UserAddressDao userAddressDao) {
        this.userRepository = userRepository;
        this.userAddressDao = userAddressDao;
    }

//    @GraphQLQuery(name = "address")
    public List<MUserAddress> getAddress(@GraphQLArgument(name = "pageSize") Integer pageSize,
                                         @GraphQLArgument(name = "pageNum") Integer pageNum) {
        return userAddressDao.findAll();
    }

//    @GraphQLQuery(name = "addressPage")
    public Page<MUserAddress> getAddressPage(@GraphQLArgument(name = "pageSize") Integer pageSize,
                                             @GraphQLArgument(name = "pageNum") Integer pageNum) {
        Pageable pageable = SqlUtil.pageable(pageNum, pageSize);
        return userAddressDao.findAll(pageable);
    }

//    @GraphQLQuery(name = "getAddressById")
    public Optional<MUserAddress> getAddressById(Long id) {
        return userAddressDao.findById(id);
    }

//    @GraphQLQuery(name = "getAddressByUserId")
    public List<MUserAddress> getUserAddressByUserId(Long id) {
        Integer del = 0;
        List<MUserAddress> list = userAddressDao.findByBusinessIdAndFlgDeleted(Integer.valueOf(String.valueOf(id)),del);
        return list;
    }

    public MUserAddress getUserAddressById(Long id) {
        Integer del = 0;
        MUserAddress mUserAddress = userAddressDao.findByIdAndFlgDeleted(id,del);
        return mUserAddress;
    }


//    @GraphQLQuery(name = "getAddressByAddressId")
    public AddressVo addressById() {
        AddressVo vo = userAddressDao.findAddressByHQLResultObj();
        return vo;
    }

//    @GraphQLQuery(name = "getAddressListByUserId")
    public List<AddressVo> getUserAddressByUserIdVo(Long id) {
        Integer del = 0;
        List<AddressVo> list = userAddressDao.findAddressByBusinessIdAndFlgDeleted(Integer.valueOf(String.valueOf(id)),del);
        return list;
    }

//    @GraphQLQuery(name = "getAddressInfoByUserId")
    public UserVo getAddressByUserId(Long id) {
        Integer del = 0;
        UserVo userVo = new UserVo();
        User user = userRepository.findByIdAndFlgDeleted(id,del);
        if (null!= user){
            userVo.setId(user.getId());
            userVo.setBirthday(user.getBirthday());
            userVo.setLoginName(user.getLoginName());
            userVo.setNickName(user.getNickName());
            userVo.setRealName(user.getRealName());
            userVo.setMobile(user.getMobile());
            userVo.setSex(user.getSex());
            userVo.setUserType(user.getUserType());
            List<MUserAddress> addressList = userAddressDao.findByBusinessIdAndFlgDeleted(Integer.valueOf(String.valueOf(id)),del);
            List< UserVo.AddressList> lists = new ArrayList<>();
            for (MUserAddress mUserAddress : addressList){
                UserVo.AddressList userAddress = new UserVo.AddressList();
                userAddress.setAddress(mUserAddress.getAddress());
                userAddress.setAddressType(mUserAddress.getAddressType());
                userAddress.setBusinessId(mUserAddress.getBusinessId());
                userAddress.setCompleteAddress(mUserAddress.getCompleteAddress());
                userAddress.setId(mUserAddress.getId());
                userAddress.setDetailAddress(mUserAddress.getDetailAddress());
                userAddress.setReceiverName(mUserAddress.getReceiverName());
                userAddress.setReceiverPhone(mUserAddress.getReceiverPhone());
                lists.add(userAddress);
            }
            userVo.setAddress(lists);
        }
        return userVo;
    }

//    @GraphQLMutation(name = "saveUserAddress")
    public MUserAddress saveUserAddress(MUserAddress mUserAddress) {
        return userAddressDao.save(mUserAddress);
    }

//    @GraphQLMutation(name = "deleteUserAddress")
    public void deleteUserAddress(Long id) {
        userAddressDao.deleteById(id);
    }

//    @GraphQLQuery(name = "isDeleted")
//    public boolean isCool(@GraphQLContext User user) {
//        return !user.getFlgDeleted().equals(0);
//    }
}
