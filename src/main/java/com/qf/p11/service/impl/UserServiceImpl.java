package com.qf.p11.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.p11.dto.ItemDTO;
import com.qf.p11.mapper.*;
import com.qf.p11.pojo.*;
import com.qf.p11.service.UserService;
import com.qf.p11.vo.CartVO;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */


@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    CartMapper cartMapper;

    @Resource
    CartProductMapper cartProductMapper;

    @Resource
    AddressMapper addressMapper;

    @Resource
    OrdersMapper ordersMapper;

    @Resource
    ItemMapper itemMapper;

    @Resource
    TypeMapper typeMapper;

    @Override
    public boolean activate(int uId) {
        return userMapper.updateUStatusByUId(uId)>0;
    }

    @Override
    public List<Address> queryAllAddressByUid(int uId) {
        return addressMapper.selectAllAddressByUid(uId);
    }

    @Override
    public List<Orders> queryAllOrderByUid(int uId) {
        return ordersMapper.selectAllOrderByUid(uId);
    }

    @Override
    public Address queryAddressByUid(int uId) {
        return null;
    }

    @Override
    public List<OrdersVO> queryAllOrderWithAddressByUid(int uId) {
        return ordersMapper.selectAllOrderWithAddressByUid(uId);
    }

    @Override
    public OrderDetailVO queryOrderDetailVOByOid(int oId) {
        return ordersMapper.selectOrderDetailByOid(oId);
    }

    @Override
    public Address querySingleAddressByOid(int oId) {
        return null;
    }

    /**
     *
     * @param aid
     * @param uId
     * @return 自增的订单号
     */
    @Override
    public int addSingleOrder(int aid, int uId) {
        Cart cart = cartMapper.selectSingleCartByUid(uId);
        Orders orders = new Orders();
        orders.setaId(aid);
        orders.setuId(uId);
        orders.setoCount(cart.getcCount());
        orders.setoTime(new Date());
        orders.setoState(1);
        ordersMapper.insertSingleOrder(orders);
        List<ItemDTO> itemDTOS = itemMapper.selectProductForInsert(uId);
        itemMapper.insertBatch(itemDTOS,orders.getoId());
        removeAllProductFromCart(uId);
        return orders.getoId();
    }

    @Override
    public void removeAllProductFromCart(int uId) {
        int cId = cartMapper.selectCartIdByUid(uId);
        cartProductMapper.deleteByCid(cId);
        cartMapper.updateResetCartById(cId);
    }

    @Override
    public void removeProductFromCart(int pId, int uId) {
        int cId = cartMapper.selectCartIdByUid(uId);
        updateCartCountAndNum(uId,pId,0);
        cartProductMapper.deleteByCidAndPid(cId,pId);
    }

    @Override
    public void updateCartCountAndNum(int uId, int pId, int num) {

        Cart cart = cartMapper.selectSingleCartByUid(uId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setPid(pId);
        cartProduct.setCid(cart.getcId());
        cartProduct.setNum(num);
        cartProductMapper.updateNumById(cartProduct);
        cartMapper.updateCartCountAndNum(uId);

    }

    @Override
    public CartVO queryUserCart(int uId) {
        return cartMapper.selectUserCart(uId);
    }

    @Override
    public int addCartByUid(int uId) {
        return cartMapper.insertCartByUid(uId);
    }

    @Override
    public void addProductToCart(int uId, int pId) {

        Cart cart = cartMapper.selectCartInfo(uId);
        CartProduct cartProduct = cartProductMapper.selectSingleByCidAndPid(cart.getcId(), pId);
        if (cartProduct==null) {
            cartProductMapper.insertCartProduct(cart.getcId(), pId);
        }else {
            cartProduct.setNum(cartProduct.getNum()+1);
            cartProductMapper.updateNumById(cartProduct);
        }
        cartMapper.updateCartCountAndNum(uId);
    }

    @Override
    public Product queryProductById(int pId) {
        return productMapper.selectSingleById(pId);
    }

    @Override
    public List<Product> queryProductByTypeId(int tId) {
        return productMapper.selectProductByType(tId);
    }

    @Override
    public PageInfo<Product> queryPageProductByTypeId(int pageNo,int tId) {

        PageHelper.startPage(pageNo,4);

        List<Product> products = productMapper.selectProductByType(tId);

        return new PageInfo<>(products);
    }

    @Override
    public void sendVaryEmail(String code, String uName) {

        String ip = null;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        String url = "http://"+ip+":8080/p11/activate?c="+code+"&uName="+uName;
        MailAccount mailAccount = new MailAccount();
        mailAccount.setFrom("13480743727@163.com");
        mailAccount.setPass("dsx123456");
        MailUtil.send(mailAccount,
                "519345977@qq.com","active",url,false);
    }

    @Override
    public User getUserByName(String uName) {
        return userMapper.selectUserByName(uName);
    }

    @Override
    public User getUserById(int uId) {
        return userMapper.selectUserById(uId);
    }

    @Override
    public User login(String uName, String uPassword) {
        return userMapper.selectUserByNameAndPwd(uName,uPassword);
    }

    @Override
    public boolean userRegister(User user) {
        return userMapper.insertSingleUser(user)>0;
    }

    @Override
    public boolean checkUserName(String username) {
        User user = userMapper.selectCountByUsername(username);
        return user == null;
    }

    @Override
    public int addAddress(Address address) {
        address.setaState(0);
        return addressMapper.insertAddress(address);
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.selectAllType();
    }

    @Override
    public int modifyOrderStateToPayed(int oId) {
        return ordersMapper.updateOStateByOIdInt(oId,2);
    }
}
