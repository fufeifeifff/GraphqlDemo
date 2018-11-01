package com.igu.developer.demo.controller;
/**
* @Author:fffu
* @Description:用户地址数据获取
* @Date:2018/10/23 10:34
*/

import com.igu.developer.demo.ApiConstants;
import com.igu.developer.demo.entity.MUserAddress;
import com.igu.developer.demo.service.AddressServices;
import com.igu.developer.demo.service.UserServices;
import com.igu.developer.demo.vo.AddressVo;
import com.igu.developer.demo.vo.ResponseVo;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class MUserController {

    @Autowired
    private UserServices userService;
    @Autowired
    private AddressServices addressServices;

    @GraphQLQuery(name = "addressList")
    public ResponseVo<Page<MUserAddress>> list(@GraphQLArgument(name = "pageSize") Integer pageSize,
                                     @GraphQLArgument(name = "pageNum") Integer pageNum) {
        log.debug("测试封装code msg   addressList");
        try {
            Page<MUserAddress> list = addressServices.getAddressPage(pageSize,pageNum);
            System.out.println(" 查询list " + list);

            return new ResponseVo<Page<MUserAddress>>().ok(list);
        } catch (Exception e) {
            log.error("封装数据失败：{}", e);
            return new ResponseVo().error(null, ApiConstants.EXCEPTION_ERROR_MESSAGE_INDSIDE_ERR, ApiConstants.RESPONSE_CODE_INSIDE_ERR);
        }
    }

    @GraphQLQuery(name = "userAddressList")
    public ResponseVo<List<AddressVo>> addressList(@GraphQLArgument(name = "id") Long id) {
        log.debug("测试封装code msg   userAddressList");
        try {
            List<AddressVo> list = addressServices.getUserAddressByUserIdVo(id);

            return new ResponseVo().ok(list);
        } catch (Exception e) {
            log.error("封装数据失败：{}", e);
            return new ResponseVo().error(null, ApiConstants.EXCEPTION_ERROR_MESSAGE_INDSIDE_ERR, ApiConstants.RESPONSE_CODE_INSIDE_ERR);
        }
    }

    @GraphQLMutation(name = "addAndUptUserAddress")
    public ResponseVo<MUserAddress> add(@GraphQLArgument(name = "userAddress") MUserAddress mUserAddress) {
        log.debug("测试封装code msg  addUserAddress");
        try {
            if (mUserAddress.getId()==null){
                addressServices.saveUserAddress(mUserAddress);
                return new  ResponseVo<MUserAddress>().ok(mUserAddress,"添加成功");
            } else {
                MUserAddress old = addressServices.getUserAddressById(mUserAddress.getId());
                if (null != old){
                    mUserAddress.setAddress(mUserAddress.getAddress()==null?old.getAddress():mUserAddress.getAddress());
                    mUserAddress.setAddressType(mUserAddress.getAddressType()==null?old.getAddressType():mUserAddress.getAddressType());
                    mUserAddress.setAreaCode(mUserAddress.getAreaCode()==null?old.getAreaCode():mUserAddress.getAreaCode());
                    mUserAddress.setBusinessId(mUserAddress.getBusinessId()==null?old.getBusinessId():mUserAddress.getBusinessId());
                    mUserAddress.setCityCode(mUserAddress.getCityCode()==null?old.getCityCode():mUserAddress.getCityCode());
                    mUserAddress.setCompleteAddress(mUserAddress.getCompleteAddress()==null?old.getCompleteAddress():mUserAddress.getCompleteAddress());
                    mUserAddress.setCreateTime(new Date());
                    mUserAddress.setDetailAddress(mUserAddress.getDetailAddress()==null?old.getDetailAddress():mUserAddress.getDetailAddress());
                    mUserAddress.setFlgDeleted(0);
                    mUserAddress.setReceiverName(mUserAddress.getReceiverName()==null?old.getReceiverName():mUserAddress.getReceiverName());
                    mUserAddress.setReceiverPhone(mUserAddress.getReceiverPhone()==null?old.getReceiverPhone():mUserAddress.getReceiverPhone());
                    mUserAddress.setFlgDefault(1);
                    mUserAddress.setProvinceCode(mUserAddress.getProvinceCode()==null?old.getProvinceCode():mUserAddress.getProvinceCode());
                    mUserAddress.setStreetCode(mUserAddress.getStreetCode()==null?old.getStreetCode():mUserAddress.getStreetCode());
                    addressServices.saveUserAddress(mUserAddress);
                    return new  ResponseVo<MUserAddress>().ok(mUserAddress,"修改成功");
                }else {
                    return new  ResponseVo<MUserAddress>().error(null,"该地址不存在，请检查地址信息");
                }

            }
        } catch (Exception e) {
            log.error("添加或者更新地址 封装数据失败：{}", e);
            return new ResponseVo().error(null, ApiConstants.EXCEPTION_ERROR_MESSAGE_INDSIDE_ERR, ApiConstants.RESPONSE_CODE_INSIDE_ERR);
        }
    }

    @GraphQLMutation(name = "delUserAddress")
    public ResponseVo<MUserAddress> del(@GraphQLArgument(name = "id") Long id) {
        log.debug("封装code msg 接口delUserAddress，删除地址");
        try {
            if(id==null){
                return new ResponseVo().error(null,"id不能为空！");
            }
            MUserAddress mUserAddress = addressServices.getUserAddressById(id);
            if (null != mUserAddress){
                addressServices.deleteUserAddress(id);
                return new ResponseVo().ok(null,"删除成功");
            }else {
                return new ResponseVo().error(null,"该地址已删除，请不要重复提交");
            }
        } catch (Exception e) {
            log.error("删除地址 封装数据失败：{}", e);
            return new ResponseVo().error(null, ApiConstants.EXCEPTION_ERROR_MESSAGE_INDSIDE_ERR, ApiConstants.RESPONSE_CODE_INSIDE_ERR);
        }
    }

    @GraphQLQuery(name = "isDeleted")
    public boolean isDefault(@GraphQLContext MUserAddress mUserAddress) {
        return !mUserAddress.getFlgDefault().equals(1);
    }

}
