package com.qf.p11.service;

import com.github.pagehelper.PageInfo;
import com.qf.p11.pojo.*;
import com.qf.p11.vo.CartVO;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;

import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */
public interface UserService {
    boolean checkUserName(String username);

    boolean userRegister(User user);

    User login(String uName,String uPassword);

    boolean activate(int uId);

    User getUserById(int uId);

    User getUserByName(String uName);

    void sendVaryEmail(String code,String uName);

    List<Product> queryProductByTypeId(int tId);

    PageInfo<Product> queryPageProductByTypeId(int pageNo, int tId);

    Product queryProductById(int pId);

    void addProductToCart(int uId,int pId);

    int addCartByUid(int uId);

    CartVO queryUserCart(int uId);

    void updateCartCountAndNum(int uId, int pId, int num);

    void removeProductFromCart(int pId,int uId);

    void removeAllProductFromCart(int uId);

    List<Address> queryAllAddressByUid(int uId);

    int addSingleOrder(int aid,int uId);

    List<Orders> queryAllOrderByUid(int uId);

    Address queryAddressByUid(int uId);

    List<OrdersVO> queryAllOrderWithAddressByUid(int uId);

    Address querySingleAddressByOid(int oId);

    OrderDetailVO queryOrderDetailVOByOid(int oId);

    int addAddress(Address address);

    List<Type> queryAllType();

    int modifyOrderStateToPayed(int oId);
}
