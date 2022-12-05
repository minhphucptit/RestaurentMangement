package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "ban_dat_combo")
@Data
public class BanDatCombo {
    private int id;
    private int banDatId;
    private int comboId;
}
