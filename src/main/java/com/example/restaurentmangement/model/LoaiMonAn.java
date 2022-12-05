package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loai_mon_an")
@Data
public class LoaiMonAn {
    @Id
    private int id;
    private String ten;
    private String moTa;
}
