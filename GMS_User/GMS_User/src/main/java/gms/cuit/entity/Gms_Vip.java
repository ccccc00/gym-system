package gms.cuit.entity;

import java.io.Serializable;

public class Gms_Vip implements Serializable {

    /** 姓名 */
    private String vip_Name ;
    /** 年龄 */
    private Integer vip_Age ;
    /** 手机号 */
    private String vip_Phone ;
    /** 身份证号 */
    private String vip_Id ;

    /** 邮箱 */
    private String vip_Email ;
    /** 余额 */
    private String vip_Account ;
    /** 性别 */
    private String vip_Gender ;
    /** 用户名 */
    private String vip_Userid ;

    public String getVip_Name() {
        return vip_Name;
    }

    public void setVip_Name(String vip_Name) {
        this.vip_Name = vip_Name;
    }

    public Integer getVip_Age() {
        return vip_Age;
    }

    public void setVip_Age(Integer vip_Age) {
        this.vip_Age = vip_Age;
    }

    public String getVip_Phone() {
        return vip_Phone;
    }

    public void setVip_Phone(String vip_Phone) {
        this.vip_Phone = vip_Phone;
    }

    public String getVip_Id() {
        return vip_Id;
    }

    public void setVip_Id(String vip_Id) {
        this.vip_Id = vip_Id;
    }



    public String getVip_Email() {
        return vip_Email;
    }

    public void setVip_Email(String vip_Email) {
        this.vip_Email = vip_Email;
    }

    public String getVip_Account() {
        return vip_Account;
    }

    public void setVip_Account(String vip_Account) {
        this.vip_Account = vip_Account;
    }

    public String getVip_Gender() {
        return vip_Gender;
    }

    public void setVip_Gender(String vip_Gender) {
        this.vip_Gender = vip_Gender;
    }

    public String getVip_Userid() {
        return vip_Userid;
    }

    public void setVip_Userid(String vip_Userid) {
        this.vip_Userid = vip_Userid;
    }

    @Override
    public String toString() {
        return "Gms_vip{" +
                "vip_Name='" + vip_Name + '\'' +
                ", vip_Age=" + vip_Age +
                ", vip_Phone='" + vip_Phone + '\'' +
                ", vip_Id='" + vip_Id + '\'' +
                ", vip_Email='" + vip_Email + '\'' +
                ", vip_Account='" + vip_Account + '\'' +
                ", vip_Gender='" + vip_Gender + '\'' +
                ", vip_Userid='" + vip_Userid + '\'' +
                '}';
    }
}
