package com.qf.p11.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName item
 */
public class Item implements Serializable {
    private Integer iId;

    private String oId;

    private Integer pId;

    private BigDecimal iCount;

    private Integer iNum;

    private static final long serialVersionUID = 1L;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public BigDecimal getiCount() {
        return iCount;
    }

    public void setiCount(BigDecimal iCount) {
        this.iCount = iCount;
    }

    public Integer getiNum() {
        return iNum;
    }

    public void setiNum(Integer iNum) {
        this.iNum = iNum;
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
        Item other = (Item) that;
        return (this.getiId() == null ? other.getiId() == null : this.getiId().equals(other.getiId()))
            && (this.getoId() == null ? other.getoId() == null : this.getoId().equals(other.getoId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getiCount() == null ? other.getiCount() == null : this.getiCount().equals(other.getiCount()))
            && (this.getiNum() == null ? other.getiNum() == null : this.getiNum().equals(other.getiNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getiId() == null) ? 0 : getiId().hashCode());
        result = prime * result + ((getoId() == null) ? 0 : getoId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getiCount() == null) ? 0 : getiCount().hashCode());
        result = prime * result + ((getiNum() == null) ? 0 : getiNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iId=").append(iId);
        sb.append(", oId=").append(oId);
        sb.append(", pId=").append(pId);
        sb.append(", iCount=").append(iCount);
        sb.append(", iNum=").append(iNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}