package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "ban_dat_mon_an")
@Data
public class BanDatMonAn {
    private int id;
    private int banDatId;
    private int monAnId;
}
