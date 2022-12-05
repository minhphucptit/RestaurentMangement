package com.example.restaurentmangement.controller;

import com.example.restaurentmangement.dao.BanDao;
import com.example.restaurentmangement.dao.BanDatDao;
import com.example.restaurentmangement.dao.KhachHangDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class BanController {
    BanDatDao banDatDao = new BanDatDao();
    BanDao banDao = new BanDao();
    KhachHangDao  khachHangDao = new KhachHangDao();

    @GetMapping("/bans")
    public String getDsBan(@Param("soGhe") Integer soGhe, @Param("tenKH") String tenKH,
                           @Param("thoiGianDat") String thoiGianDat,
                           @Param("trangThai")Integer trangThai, Model model, HttpSession session) throws ParseException {
        Date date = null;
        if(thoiGianDat!=null){
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(thoiGianDat);
            session.setAttribute("date",date);
        }else {
            date = Date.from(Instant.now());
        }
        if(trangThai==null) trangThai=1;
        model.addAttribute("bans", banDatDao.getDSBan(soGhe, tenKH, date,trangThai));
        return "/bans";
    }

    @GetMapping("/ban-dat/khach-hang/{id}")
    public String getBan(Model model, HttpSession session, @PathVariable("id")Integer id) throws ParseException {
        Integer banId = (Integer) session.getAttribute("banId");
        Date date = (Date) session.getAttribute("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

        if(banId!= null && date != null){
            var ban = banDao.getDSBan().stream().filter(ban1 -> ban1.getId()==banId).findFirst().get();
            var kh = khachHangDao.getDsKH(null,null).stream().filter(khachHang -> khachHang.getId() == id).findFirst().get();
            model.addAttribute("kh",kh);
            model.addAttribute("ban",ban);
            model.addAttribute("date",dateFormat.format(date));
        }
        return "/ban";
    }

    @GetMapping("/bans/{ban_id}/khach-hang/{khach_hang_id}/dat")
    public String datBan(HttpSession session, @PathVariable("ban_id")Integer banId,@PathVariable("khach_hang_id")Integer khachHangId) throws ParseException {
        Date date = (Date) session.getAttribute("date");

        if(date != null){
           banDatDao.datBan(banId,khachHangId,date);
        }
        return "redirect:/bans";
    }

}
