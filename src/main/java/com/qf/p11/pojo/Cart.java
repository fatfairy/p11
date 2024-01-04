package com.qf.p11.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName cart
 */
public class Cart implements Serializable {
    private Integer cId;

    private Integer uId;

    private BigDecimal cCount;

    private Integer cNum;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Cart other = (Cart) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getcCount() == null ? other.getcCount() == null : this.getcCount().equals(other.getcCount()))
            && (this.getcNum() == null ? other.getcNum() == null : this.getcNum().equals(other.getcNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getcCount() == null) ? 0 : getcCount().hashCode());
        result = prime * result + ((getcNum() == null) ? 0 : getcNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", uId=").append(uId);
        sb.append(", cCount=").append(cCount);
        sb.append(", cNum=").append(cNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}