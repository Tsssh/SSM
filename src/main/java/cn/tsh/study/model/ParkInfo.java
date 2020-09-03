package cn.tsh.study.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ParkInfo {
    private  String Name;
    private  String Status;
    private  String LAT;
    private  String Branch_code;
    private  String Address;
    private  String LNG;
    private  String Province;
    private  String City;
    private  String Lot_Tp;



}
