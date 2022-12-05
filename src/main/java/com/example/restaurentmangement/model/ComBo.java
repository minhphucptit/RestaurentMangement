package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "combo")
@Data
public class ComBo {
    @Id
    private int id;
    private String ten;
    private int soLuong;
    private float gia;
    private String moTa;
}
