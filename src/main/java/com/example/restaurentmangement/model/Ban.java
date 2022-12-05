package com.example.restaurentmangement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ban")
@Data
public class Ban {
    @Id
    private int id;
    private String name;
    private int soGhe;
    private boolean daDat;
    private int banDatId;
}
