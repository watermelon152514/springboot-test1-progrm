package com.guet.cn.springboottest1program.bean;

public class EmployeeMoney {
    private String employee_Id;
    private String type_Name;
    private int add_Money;
    private int bottom_Money;
    private int up_Money;
    private int delete_Money;
    private String remarks;
    private String money_Time;

    public String getMoney_Time() {
        return money_Time;
    }

    public void setMoney_Time(String money_Time) {
        this.money_Time = money_Time;
    }

    @Override
    public String toString() {
        return "EmployeeMoney{" +
                "employee_Id='" + employee_Id + '\'' +
                ", type_Name='" + type_Name + '\'' +
                ", add_Money=" + add_Money +
                ", bottom_Money=" + bottom_Money +
                ", up_Money=" + up_Money +
                ", delete_Money=" + delete_Money +
                ", remarks='" + remarks + '\'' +
                ", money_Time='" + money_Time + '\'' +
                '}';
    }

    public String getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(String employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getType_Name() {
        return type_Name;
    }

    public void setType_Name(String type_Name) {
        this.type_Name = type_Name;
    }

    public int getAdd_Money() {
        return add_Money;
    }

    public void setAdd_Money(int add_Money) {
        this.add_Money = add_Money;
    }

    public int getBottom_Money() {
        return bottom_Money;
    }

    public void setBottom_Money(int bottom_Money) {
        this.bottom_Money = bottom_Money;
    }

    public int getUp_Money() {
        return up_Money;
    }

    public void setUp_Money(int up_Money) {
        this.up_Money = up_Money;
    }

    public int getDelete_Money() {
        return delete_Money;
    }

    public void setDelete_Money(int delete_Money) {
        this.delete_Money = delete_Money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
