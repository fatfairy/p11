package com.qf.p11.mapper;

import com.qf.p11.pojo.Cart;
import com.qf.p11.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
* @author 12709
* @description 针对表【cart(购物车实体)】的数据库操作Mapper
* @createDate 2023-12-27 20:10:04
* @Entity com.qf.p11.pojo.Cart
*/
public interface CartMapper {
    int insertCartByUid(int uId);

    Cart selectSingleCartByUid(int uId);

    int updateCart(Cart cart);

    Cart selectCartInfo(int uId);

    CartVO selectUserCart(int uId);

    int updateCartNum(@Param("cId") int cId,@Param("num") int num,@Param("price") BigDecimal price);

    int updateCartCountAndNum(int uId);

    int selectCartIdByUid(int uId);

    int updateResetCartById(int cId);
}




