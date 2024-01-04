package com.qf.p11.mapper;

import com.qf.p11.pojo.CartProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 12709
* @description 针对表【cart_product】的数据库操作Mapper
* @createDate 2023-12-27 20:10:04
* @Entity com.qf.p11.pojo.CartProduct
*/
public interface CartProductMapper {
    int insertCartProduct(@Param("cId") int cId,@Param("pId") int pId);

    CartProduct selectSingleByCidAndPid(@Param("cId") int cId,@Param("pId") int pId);

    int updateNumById(CartProduct cartProduct);

    int deleteByCidAndPid(@Param("cId") int cId,@Param("pId") int pId);

    int deleteByCid(int cId);

    List<CartProduct> selectAllByUid(int uid);

}




