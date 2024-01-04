package com.qf.p11.vo;

import java.math.BigDecimal;

/**
 * @author Lj
 * @version 1.0
 */
public class ProductVO {
    private Integer pId;

    private Integer tId;

    private String pName;

    private String pTime;

    private String pImage;

    private BigDecimal pPrice;

    private Integer pState;

    private String pInfo;

    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "pId=" + pId +
                ", tId=" + tId +
                ", pName='" + pName + '\'' +
                ", pTime='" + pTime + '\'' +
                ", pImage='" + pImage + '\'' +
                ", pPrice=" + pPrice +
                ", pState=" + pState +
                ", pInfo='" + pInfo + '\'' +
                ", num=" + num +
                '}';
    }
}
