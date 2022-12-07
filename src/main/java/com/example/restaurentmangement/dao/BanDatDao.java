package com.example.restaurentmangement.dao;

import com.example.restaurentmangement.dto.BanDatDto;
import com.example.restaurentmangement.model.Ban;
import com.example.restaurentmangement.model.BanDat;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BanDatDao extends Dao {
    public final Integer DEFAULT_DATE_RANGE = 180;

    public BanDatDao() {
        super();
    }

    BanDao banDao = new BanDao();

    public List<BanDatDto> getDSBan(Integer soGhe, String khName, Date date, Integer trangThai) {
        List<BanDatDto> banList = new ArrayList<>();
        List<Ban> bans = banDao.getDSBan();
        String sql = "{call getDSBan(?,?,?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setObject(1, soGhe);
            cs.setString(2, khName);
            cs.setDate(3, new java.sql.Date(date.getTime()));
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                BanDatDto ban = new BanDatDto();
                ban.setBanId(rs.getInt("ban_id"));
                ban.setSoGhe(rs.getInt("so_ghe"));
                ban.setTenBan(rs.getString("ten_ban"));
                ban.setTenKH(rs.getString("ten_khach_hang"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

                ban.setThoiGianDat(rs.getTimestamp("thoi_gian_dat"));
                ban.setTrangThai(1);

                banList.add(ban);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (trangThai == 1)
            return banList;
        else {
            List<BanDatDto> banDatDtos = new ArrayList<>();
            /*Kiểm tra từng bàn 1 xem có bàn nào đã có lịch đặt không */
            bans.forEach(ban -> {
                var lst = banList.stream().filter(banDatDto -> banDatDto.getBanId() == ban.getId())
                        .sorted(Comparator.comparing(BanDatDto::getThoiGianDat)).collect(Collectors.toList());

                //Nếu đã có lịch kiểm tra thời gian đặt có hợp lệ không
                if (!Objects.isNull(lst) && lst.size() > 0) {
                    for (int i = 0; i < lst.size(); i++) {
                        if (checkValidDate(date, i, lst)) {
                            BanDatDto banDatDto = new BanDatDto();
                            banDatDto.setBanId(ban.getId());
                            banDatDto.setTenBan(ban.getName());
                            banDatDto.setTrangThai(0);
                            banDatDto.setSoGhe(ban.getSoGhe());
                            banDatDtos.add(banDatDto);
                            break;
                        }
                    }

                } else {

                    BanDatDto banDatDto = new BanDatDto();
                    banDatDto.setBanId(ban.getId());
                    banDatDto.setTenBan(ban.getName());
                    banDatDto.setTrangThai(0);
                    banDatDto.setSoGhe(ban.getSoGhe());
                    banDatDtos.add(banDatDto);

                }
            });
            if (trangThai == 0) {
                return banDatDtos;
            } else {
                banList.addAll(banDatDtos);
                return banList;
            }
        }
    }

    private boolean checkValidDate(Date d1, int i, List<BanDatDto> lst) {
        //Thoi gian da dat
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 24);
        calendar1.setTime(d1);

        //Thoi gian dat
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY, 24);
        calendar2.setTime(lst.get(i).getThoiGianDat());
        Integer t1 = calendar1.get(Calendar.HOUR_OF_DAY) * 60 + calendar1.get(Calendar.MINUTE);
        Integer t2 = calendar2.get(Calendar.HOUR_OF_DAY) * 60 + calendar2.get(Calendar.MINUTE);
        if (i > 1 && calendar2.after(calendar1)) {//Nếu thời gian đặt nằm giữa hai khoảng đã đặt
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(Calendar.HOUR_OF_DAY, 24);
            calendar3.setTime(lst.get(i - 1).getThoiGianDat());
            Integer t3 = calendar3.get(Calendar.HOUR_OF_DAY) * 60 + calendar3.get(Calendar.MINUTE);
            if ((t1 - t2) >= DEFAULT_DATE_RANGE && (t2 - t3) >= DEFAULT_DATE_RANGE) {
                return true;
            }
        } else if (calendar2.after(calendar1)) {//Nếu thời gian đặt nhỏ hơn thời gian đã đặt min

            if (Math.abs(t1 - t2) >= DEFAULT_DATE_RANGE) {
                return true;
            }
        } else {// Nếu thời gian đặt lớn hơn thời gian đã đặt max
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(Calendar.HOUR_OF_DAY, 24);
            calendar3.setTime(lst.get(lst.size() - 1).getThoiGianDat());
            Integer t3 = calendar3.get(Calendar.HOUR_OF_DAY) * 60 + calendar3.get(Calendar.MINUTE);
            if (Math.abs(t1 - t3) >= DEFAULT_DATE_RANGE) {
                return true;
            }
        }

        return false;
    }


    public void datBan(Integer banId, Integer khachHangId, Date date) {
        String sql = "insert into ban_dat(ban_id,khach_hang_id,thoi_gian_dat) values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, banId);
            ps.setInt(2, khachHangId);
            ps.setTimestamp(3,new Timestamp(date.getTime()));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
