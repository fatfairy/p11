package com.qf.p11.vo;

import com.qf.p11.pojo.Address;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lj
 * @version 1.0
 */
public class OrdersVO {
    private int oId;

    private Integer uId;

    private Integer aId;

    private BigDecimal oCount;

    private Date oTime;

    private Integer oState;

    private Address address;

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

    @Override
    public String toString() {
        return "OrdersVO{" +
                "oId=" + oId +
                ", uId=" + uId +
                ", aId=" + aId +
                ", oCount=" + oCount +
                ", oTime=" + oTime +
                ", oState=" + oState +
                ", address=" + address +
                '}';
    }
}
