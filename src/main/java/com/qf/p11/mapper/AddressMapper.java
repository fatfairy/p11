package com.qf.p11.mapper;

import com.qf.p11.pojo.Address;

import java.util.List;

/**
* @author 12709
* @description 针对表【address(用户个人中心的地址实体，用于存储地址信息)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.Address
*/
public interface AddressMapper {
    List<Address> selectAllAddressByUid(int uId);

    Address selectAddressFromOrderByUid(int uId);

    Address selectSingleAddressByOid(int oId);

    int insertAddress(Address address);
}




