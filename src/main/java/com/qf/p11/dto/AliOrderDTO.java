package com.qf.p11.dto;

/**
 * @author Lj
 * @version 1.0
 */
public class AliOrderDTO {
    private String out_trade_no;
    private String total_amount;
    private String subject;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "AliOrderDTO{" +
                "out_trade_no='" + out_trade_no + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
