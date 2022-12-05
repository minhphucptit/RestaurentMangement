package com.example.restaurentmangement.dao;

import com.example.restaurentmangement.model.KhachHang;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDao extends Dao {
    public KhachHangDao() {
        super();
    }

    public List<KhachHang> getDsKH(String ten, String sdt) {
        List<KhachHang> khachHangList = new ArrayList<>();
        String sql = "{call getDSKH(?,?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, ten);
            cs.setString(2, sdt);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setTen(rs.getString("ten"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setDiaChi(rs.getString("dia_chi"));
                khachHangList.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHangList;
    }

    public void themKH(KhachHang kh) {
//        int id = -1;
        String sql = "insert into khach_hang(ten,email,sdt,dia_chi) values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTen());
            ps.setString(2, kh.getEmail());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());

            ps.executeUpdate();

//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        kh.setId(id);
//        return kh;
    }
}
