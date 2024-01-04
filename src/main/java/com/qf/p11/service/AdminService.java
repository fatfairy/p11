package com.qf.p11.service;

import com.qf.p11.pojo.Product;
import com.qf.p11.pojo.Type;
import com.qf.p11.pojo.User;
import com.qf.p11.vo.AdminOrderVO;

import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */
public interface AdminService {
    User login(String username,String password);

    List<User> queryAllUser();

    boolean removeUser(int id);

    List<User> queryUserByNameAndSex(String uName,String uSex);

    List<Type> queryAllType();

    boolean addProduct(Product product);

    List<Product> queryAllProduct();


    User getUserById(int uId);

    List<AdminOrderVO> queryAllAdminOrderVO();

    int modifyOrderStateToSend(int oId);
}
