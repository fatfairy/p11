package com.qf.p11.mapper;

import com.qf.p11.pojo.Product;
import com.qf.p11.vo.ProductVO;

import java.util.List;

/**
* @author 12709
* @description 针对表【product(商品模块的商品实体)】的数据库操作Mapper
* @createDate 2023-12-26 15:01:02
* @Entity com.qf.p11.pojo.Product
*/
public interface ProductMapper {

    int insertSingleProduct(Product product);

    List<Product> selectAllProduct();

    List<Product> selectProductByType(int tId);


    Product selectSingleById(int pId);

    List<ProductVO> selectByCartId(int cId);

    List<ProductVO> selectAllProductVOFromItemByOid(int oId);
}




