package com.qf.p11.service.impl;

import com.qf.p11.mapper.OrdersMapper;
import com.qf.p11.mapper.ProductMapper;
import com.qf.p11.mapper.TypeMapper;
import com.qf.p11.mapper.UserMapper;
import com.qf.p11.pojo.Product;
import com.qf.p11.pojo.Type;
import com.qf.p11.pojo.User;
import com.qf.p11.service.AdminService;
import com.qf.p11.vo.AdminOrderVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    UserMapper userMapper;

    @Resource
    TypeMapper typeMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public User getUserById(int uId) {
        return userMapper.selectUserById(uId);
    }

    @Override
    public List<Product> queryAllProduct() {
        return productMapper.selectAllProduct();
    }

    @Override
    public boolean addProduct(Product product) {
        return productMapper.insertSingleProduct(product)>0;
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.selectAllType();
    }

    @Override
    public List<User> queryUserByNameAndSex(String uName, String uSex) {
        return userMapper.selectUserByNameAndSex(uName,uSex);
    }

    @Override
    public boolean removeUser(int id) {
        return userMapper.deleteByUId(id)>0;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User login(String username, String password) {
        return userMapper.selectUserByNameAndPwd(username,password);
    }

    @Override
    public List<AdminOrderVO> queryAllAdminOrderVO() {
        return ordersMapper.selectAllAdminOrderVO();
    }

    @Override
    public int modifyOrderStateToSend(int oId) {
        return ordersMapper.updateOStateByOIdInt(oId,3);
    }
}
