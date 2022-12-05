package com.example.restaurentmangement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loai_ban")
public class LoaiBan {
    @Id
    private int id;
    private String ten;
    private String mota;
}
