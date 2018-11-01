package com.igu.developer.demo.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
/**
* @Author:fuff
* @Description:用户地址实体
* @Date: 10:13 2018/10/23
*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "m_user_address")
public class MUserAddress{
    
    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A address's id")
    private Long id;
    @GraphQLQuery(name = "businessId", description = "A address's businessId")
    private Integer businessId;
    @GraphQLQuery(name = "receiverName", description = "A address's receiverName")
    private String receiverName;
    @GraphQLQuery(name = "receiverPhone", description = "A address's receiverPhone")
    private String receiverPhone;
    @GraphQLQuery(name = "provinceCode", description = "A address's provinceCode")
    private Integer provinceCode;
    @GraphQLQuery(name = "cityCode", description = "A address's cityCode")
    private Integer cityCode;
    @GraphQLQuery(name = "areaCode", description = "A address's areaCode")
    private Integer areaCode;
    @GraphQLQuery(name = "streetCode", description = "A address's streetCode")
    private Integer streetCode;
    @GraphQLQuery(name = "address", description = "A address's address")
    private String address;
    @GraphQLQuery(name = "detailAddress", description = "A address's detailAddress")
    private String detailAddress;
    @GraphQLQuery(name = "completeAddress", description = "A address's completeAddress")
    private String completeAddress;
    @GraphQLQuery(name = "addressType", description = "A address's addressType")
    private Integer addressType;
    @GraphQLQuery(name = "longitude", description = "A address's longitude")
    private Double longitude;
    @GraphQLQuery(name = "latitude", description = "A address's latitude")
    private Double latitude;
    @GraphQLQuery(name = "flgDefault", description = "A address's flgDefault")
    private Integer flgDefault;
    @GraphQLQuery(name = "flgDeleted", description = "A address's flgDeleted")
    private Integer flgDeleted;
    @GraphQLQuery(name = "createdBy", description = "A address's createdBy")
    private Integer createdBy;
    @GraphQLQuery(name = "createTime", description = "A address's createTime")
    private Date createTime;
    @GraphQLQuery(name = "lastModifiedBy", description = "A address's lastModifiedBy")
    private Integer lastModifiedBy;
    @GraphQLQuery(name = "lastModifiedTime", description = "A address's lastModifiedTime")
    private Date lastModifiedTime;

}