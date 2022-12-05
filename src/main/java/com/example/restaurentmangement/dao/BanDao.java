package com.example.restaurentmangement.dao;

import com.example.restaurentmangement.dto.BanDatDto;
import com.example.restaurentmangement.model.Ban;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BanDao extends Dao {
    public BanDao() {
        super();
    }

    public List<Ban> getDSBan() {
        List<Ban> banList = new ArrayList<>();
        String sql = "select * from ban";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ban ban = new Ban();
                ban.setId(rs.getInt("id"));
                ban.setName(rs.getString("ten"));
                ban.setSoGhe(rs.getInt("so_ghe"));
                banList.add(ban);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return banList;
    }
}
