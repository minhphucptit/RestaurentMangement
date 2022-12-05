package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mon_an")
@Data
public class MonAn {
    @Id
    private String id;
    private String soLuong;
    private float gia;
}
