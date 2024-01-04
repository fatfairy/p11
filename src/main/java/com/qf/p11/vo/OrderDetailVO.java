package com.qf.p11.vo;

import com.qf.p11.pojo.Address;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */
public class OrderDetailVO {

    private int oId;

    private Integer uId;

    private Integer aId;

    private BigDecimal oCount;

    private Date oTime;

    private Integer oState;

    private Address address;

    private List<ProductVO> productVOS;

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public BigDecimal getoCount() {
        return oCount;
    }

    public void setoCount(BigDecimal oCount) {
        this.oCount = oCount;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Integer getoState() {
        return oState;
    }

    public void setoState(Integer oState) {
        this.oState = oState;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ProductVO> getProductVOS() {
        return productVOS;
    }

    public void setProductVOS(List<ProductVO> productVOS) {
        this.productVOS = productVOS;
    }

    @Override
    public String toString() {
        return "OrderDetailVO{" +
                "oId=" + oId +
                ", uId=" + uId +
                ", aId=" + aId +
                ", oCount=" + oCount +
                ", oTime=" + oTime +
                ", oState=" + oState +
                ", address=" + address +
                ", productVOS=" + productVOS +
                '}';
    }
}
