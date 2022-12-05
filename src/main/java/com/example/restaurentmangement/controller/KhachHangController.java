package com.example.restaurentmangement.controller;

import com.example.restaurentmangement.dao.BanDatDao;
import com.example.restaurentmangement.dao.KhachHangDao;
import com.example.restaurentmangement.model.KhachHang;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Controller
public class KhachHangController {
    KhachHangDao khachHangDao  = new KhachHangDao();

    @GetMapping("/khach-hangs/{id}")
    public String getDsBan(@Param("tenKH") String tenKH,
                           @Param("soDienThoai") String sdt,
                           @PathVariable("id") Integer id,
                           Model model, HttpSession session) {
        session.setAttribute("banId",id);
        model.addAttribute("khs", khachHangDao.getDsKH(tenKH,sdt));
        return "/khach-hangs";
    }

    @GetMapping("/khach-hangs/{id}/them-KH")
    public String taoKH(
            @PathVariable("id") Integer id,
            Map<String,Object> model) {
        model.put("khachHang",new KhachHang());
        return "/them-kh";
    }
    @PostMapping("/khach-hangs/{id}/them-KH")
    public String themKH(
            @PathVariable("id") Integer id,
            @ModelAttribute("khachHang")KhachHang kh) {
        khachHangDao.themKH(kh);
        return "redirect:/khach-hangs/"+ id;
    }

}
