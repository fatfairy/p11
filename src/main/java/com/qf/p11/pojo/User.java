package com.qf.p11.pojo;

import java.io.Serializable;

/**
 * @TableName user
 */
public class User implements Serializable {
    private Integer uId;

    private String uName;

    private String uPassword;

    private String uEmail;

    private String uSex;

    private Integer uStatus;

    private String uCode;

    private Integer uRole;

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode;
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
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
        User other = (User) that;
        return (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuPassword() == null ? other.getuPassword() == null : this.getuPassword().equals(other.getuPassword()))
            && (this.getuEmail() == null ? other.getuEmail() == null : this.getuEmail().equals(other.getuEmail()))
            && (this.getuSex() == null ? other.getuSex() == null : this.getuSex().equals(other.getuSex()))
            && (this.getuStatus() == null ? other.getuStatus() == null : this.getuStatus().equals(other.getuStatus()))
            && (this.getuCode() == null ? other.getuCode() == null : this.getuCode().equals(other.getuCode()))
            && (this.getuRole() == null ? other.getuRole() == null : this.getuRole().equals(other.getuRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuPassword() == null) ? 0 : getuPassword().hashCode());
        result = prime * result + ((getuEmail() == null) ? 0 : getuEmail().hashCode());
        result = prime * result + ((getuSex() == null) ? 0 : getuSex().hashCode());
        result = prime * result + ((getuStatus() == null) ? 0 : getuStatus().hashCode());
        result = prime * result + ((getuCode() == null) ? 0 : getuCode().hashCode());
        result = prime * result + ((getuRole() == null) ? 0 : getuRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uName=").append(uName);
        sb.append(", uPassword=").append(uPassword);
        sb.append(", uEmail=").append(uEmail);
        sb.append(", uSex=").append(uSex);
        sb.append(", uStatus=").append(uStatus);
        sb.append(", uCode=").append(uCode);
        sb.append(", uRole=").append(uRole);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}