package com.example.restaurentmangement.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BanDatDto {
    private int banId;
    private String tenKH;
    private String tenBan;
    private int trangThai;
    private Date thoiGianDat;
    private int soGhe;
    private String dieuKienDat;

    public String getThoiGianDat1(){
        if(thoiGianDat == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        return dateFormat.format(thoiGianDat);
    }
}
