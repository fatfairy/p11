package com.qf.p11.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lj
 * @version 1.0
 */
public class AdminOrderVO {
    private int oId;
    private BigDecimal oCount;
    private Integer oState;
    private Date oTime;
    private String userName;

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public BigDecimal getoCount() {
        return oCount;
    }

    public void setoCount(BigDecimal oCount) {
        this.oCount = oCount;
    }

    public Integer getoState() {
        return oState;
    }

    public void setoState(Integer oState) {
        this.oState = oState;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AdminOrderVO{" +
                "oId=" + oId +
                ", oCount=" + oCount +
                ", oState=" + oState +
                ", oTime=" + oTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
