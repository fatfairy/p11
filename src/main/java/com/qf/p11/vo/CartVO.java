package com.qf.p11.vo;

import com.qf.p11.pojo.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */
public class CartVO {
    private Integer cId;

    private BigDecimal cCount;

    private Integer cNum;

    private List<ProductVO> products;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public BigDecimal getcCount() {
        return cCount;
    }

    public void setcCount(BigDecimal cCount) {
        this.cCount = cCount;
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public List<ProductVO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductVO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cId=" + cId +
                ", cCount=" + cCount +
                ", cNum=" + cNum +
                ", products=" + products +
                '}';
    }
}
