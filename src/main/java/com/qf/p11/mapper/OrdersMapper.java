package com.qf.p11.mapper;

import com.qf.p11.pojo.Orders;
import com.qf.p11.vo.AdminOrderVO;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 12709
* @description 针对表【orders(订单模块的订单实体)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.Orders
*/
public interface OrdersMapper {
    int insertSingleOrder(Orders orders);

    List<Orders> selectAllOrderByUid(int uId);

    List<OrdersVO> selectAllOrderWithAddressByUid(int uId);

    OrderDetailVO selectOrderDetailByOid(int oId);

    int updateOStateByOIdInt(@Param("oId") int oId, @Param("oState") int oState);

    List<AdminOrderVO> selectAllAdminOrderVO();
}




