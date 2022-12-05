package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "khach_hang")
@Data
public class KhachHang {
    @Id
    private int id;
    private String ten;
    private String email;
    private String diaChi;
    private String sdt;
}
