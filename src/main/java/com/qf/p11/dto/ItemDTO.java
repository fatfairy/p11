package com.qf.p11.dto;

import java.math.BigDecimal;

/**
 * @author Lj
 * @version 1.0
 */
public class ItemDTO {
    private Integer num;
    private Integer pId;

    private BigDecimal count;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "num=" + num +
                ", pId=" + pId +
                ", count=" + count +
                '}';
    }
}
