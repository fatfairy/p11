package com.qf.p11.pojo;

import java.io.Serializable;

/**
 * @TableName address
 */
public class Address implements Serializable {
    private Integer aId;

    private Integer uId;

    private String aName;

    private String aPhone;

    private String aDetail;

    private Integer aState;

    private static final long serialVersionUID = 1L;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaDetail() {
        return aDetail;
    }

    public void setaDetail(String aDetail) {
        this.aDetail = aDetail;
    }

    public Integer getaState() {
        return aState;
    }

    public void setaState(Integer aState) {
        this.aState = aState;
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
        Address other = (Address) that;
        return (this.getaId() == null ? other.getaId() == null : this.getaId().equals(other.getaId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getaName() == null ? other.getaName() == null : this.getaName().equals(other.getaName()))
            && (this.getaPhone() == null ? other.getaPhone() == null : this.getaPhone().equals(other.getaPhone()))
            && (this.getaDetail() == null ? other.getaDetail() == null : this.getaDetail().equals(other.getaDetail()))
            && (this.getaState() == null ? other.getaState() == null : this.getaState().equals(other.getaState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getaId() == null) ? 0 : getaId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getaName() == null) ? 0 : getaName().hashCode());
        result = prime * result + ((getaPhone() == null) ? 0 : getaPhone().hashCode());
        result = prime * result + ((getaDetail() == null) ? 0 : getaDetail().hashCode());
        result = prime * result + ((getaState() == null) ? 0 : getaState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aId=").append(aId);
        sb.append(", uId=").append(uId);
        sb.append(", aName=").append(aName);
        sb.append(", aPhone=").append(aPhone);
        sb.append(", aDetail=").append(aDetail);
        sb.append(", aState=").append(aState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}