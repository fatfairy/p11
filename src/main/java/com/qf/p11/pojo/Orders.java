package com.qf.p11.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName orders
 */
public class Orders implements Serializable {
    private int oId;

    private Integer uId;

    private Integer aId;

    private BigDecimal oCount;

    private Date oTime;

    private Integer oState;

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "Orders{" +
                "oId=" + oId +
                ", uId=" + uId +
                ", aId=" + aId +
                ", oCount=" + oCount +
                ", oTime=" + oTime +
                ", oState=" + oState +
                '}';
    }
}