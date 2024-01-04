package com.qf.p11.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName product
 */
public class Product implements Serializable {
    private Integer pId;

    private Integer tId;

    private String pName;

    private String pTime;

    private String pImage;

    private BigDecimal pPrice;

    private Integer pState;

    private String pInfo;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpState() {
        return pState;
    }

    public void setpState(Integer pState) {
        this.pState = pState;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
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
        Product other = (Product) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()))
            && (this.getpTime() == null ? other.getpTime() == null : this.getpTime().equals(other.getpTime()))
            && (this.getpImage() == null ? other.getpImage() == null : this.getpImage().equals(other.getpImage()))
            && (this.getpPrice() == null ? other.getpPrice() == null : this.getpPrice().equals(other.getpPrice()))
            && (this.getpState() == null ? other.getpState() == null : this.getpState().equals(other.getpState()))
            && (this.getpInfo() == null ? other.getpInfo() == null : this.getpInfo().equals(other.getpInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getpTime() == null) ? 0 : getpTime().hashCode());
        result = prime * result + ((getpImage() == null) ? 0 : getpImage().hashCode());
        result = prime * result + ((getpPrice() == null) ? 0 : getpPrice().hashCode());
        result = prime * result + ((getpState() == null) ? 0 : getpState().hashCode());
        result = prime * result + ((getpInfo() == null) ? 0 : getpInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", tId=").append(tId);
        sb.append(", pName=").append(pName);
        sb.append(", pTime=").append(pTime);
        sb.append(", pImage=").append(pImage);
        sb.append(", pPrice=").append(pPrice);
        sb.append(", pState=").append(pState);
        sb.append(", pInfo=").append(pInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}