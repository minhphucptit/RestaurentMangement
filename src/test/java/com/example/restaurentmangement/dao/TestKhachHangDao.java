package com.example.restaurentmangement.dao;

import com.example.restaurentmangement.model.KhachHang;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestKhachHangDao {

    KhachHangDao khachHangDao = new KhachHangDao();

    @Test
    public void testGetDsKhachHang(){
        String ten = "Phúc";
        String sdt = "0";
        List<KhachHang> khachHangList = khachHangDao.getDsKH(ten,sdt);
        Assert.assertNotNull(khachHangList);
    }

    @Test
    public void testLuuKhachHang(){
        KhachHang kh = new KhachHang();
        kh.setTen("Phúc 99");
        kh.setEmail("a@123");
        kh.setDiaChi("NĐ");
        kh.setSdt("09xx");

        try {
            Dao.con.setAutoCommit(false);
            khachHangDao.themKH(kh);
            List<KhachHang> khachHangList = khachHangDao.getDsKH(kh.getTen(), kh.getSdt());
            Assert.assertNotNull(khachHangList);
            Assert.assertEquals(1,khachHangList.size());
            Assert.assertEquals(kh.getTen(),khachHangList.get(0).getTen());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                Dao.con.rollback();
                Dao.con.setAutoCommit(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
