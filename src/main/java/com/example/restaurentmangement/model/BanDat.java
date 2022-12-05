package com.example.restaurentmangement.model;


import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Table(name = "ban")
@Data
public class BanDat {
    @Id
    private int id;
    private Date thoiGianDat;
    private int khachHangId;
    private int banId;
}
