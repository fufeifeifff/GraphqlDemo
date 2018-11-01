package com.igu.developer.demo.vo;

/**
 * @Author:fuff
 * @Description:用户地址实体映射
 */

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;
import java.util.Date;


@Data
public class AddressVo{

    private @NonNull Long id;

    private @NonNull Integer businessId;

    private @NonNull String receiverName;

    private @NonNull String receiverPhone;

    private @NonNull Integer provinceCode;

    private @NonNull Integer cityCode;

    private @NonNull Integer areaCode;

    @GraphQLQuery(name = "streetCode", description = "A addressVo's streetCode")
    private Integer streetCode;

    private @NonNull String address;

    private @NonNull String detailAddress;

    private @NonNull String completeAddress;

    private @NonNull Integer addressType;

    private Double longitude;

    private Double latitude;

    private @NonNull Integer flgDefault;

    private @NonNull Integer flgDeleted;

    private Integer createdBy;

    private Date createTime;

    private Integer lastModifiedBy;

    private  Date lastModifiedTime;

}