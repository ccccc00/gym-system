package gms.cuit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Gms_Inschool implements Serializable {

    /** 工号/学号 */
    private String inschool_Id ;
    /** 姓名 */
    private String inschool_Name ;
    /** 身份证 */
    private String inschool_idcard ;
    /** 性别 */
    private String inschool_Sex ;
    /** 年龄 */
    private Integer inschool_Age ;
    /** 入校日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date inschool_Entertime ;

    private String inschool_Phone;

    public String getInschool_Phone() {
        return inschool_Phone;
    }

    public void setInschool_Phone(String inschool_Phone) {
        this.inschool_Phone = inschool_Phone;
    }

    public Gms_Inschool() {
        super();
    }

    public String getInschool_Id() {
        return inschool_Id;
    }

    public void setInschool_Id(String inschool_Id) {
        this.inschool_Id = inschool_Id;
    }

    public String getInschool_Name() {
        return inschool_Name;
    }

    public void setInschool_Name(String inschool_Name) {
        this.inschool_Name = inschool_Name;
    }

    public String getInschool_idcard() {
        return inschool_idcard;
    }

    public void setInschool_idcard(String inschool_idcard) {
        this.inschool_idcard = inschool_idcard;
    }

    public String getInschool_Sex() {
        return inschool_Sex;
    }

    public void setInschool_Sex(String inschool_Sex) {
        this.inschool_Sex = inschool_Sex;
    }

    public Integer getInschool_Age() {
        return inschool_Age;
    }

    public void setInschool_Age(Integer inschool_Age) {
        this.inschool_Age = inschool_Age;
    }

    public Date getInschool_Entertime() {
        return inschool_Entertime;
    }

    public void setInschool_Entertime(Date inschool_Entertime) {
        this.inschool_Entertime = inschool_Entertime;
    }

    public Gms_Inschool(String inschool_Id, String inschool_Name, String inschool_idcard, String inschool_Sex, Integer inschool_Age, Date inschool_Entertime, String inschool_Phone) {
        this.inschool_Id = inschool_Id;
        this.inschool_Name = inschool_Name;
        this.inschool_idcard = inschool_idcard;
        this.inschool_Sex = inschool_Sex;
        this.inschool_Age = inschool_Age;
        this.inschool_Entertime = inschool_Entertime;
        this.inschool_Phone=inschool_Phone;
    }

    @Override
    public String toString() {
        return "Gms_Inschool{" +
                "inschool_Id='" + inschool_Id + '\'' +
                ", inschool_Name='" + inschool_Name + '\'' +
                ", inschool_idcard='" + inschool_idcard + '\'' +
                ", inschool_Sex='" + inschool_Sex + '\'' +
                ", inschool_Age=" + inschool_Age +
                ", inschool_Entertime=" + inschool_Entertime +
                ", inschool_Phone=" + inschool_Phone +
                '}';
    }


}