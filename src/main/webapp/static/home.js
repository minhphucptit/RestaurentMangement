/**
 * Created by Kupletsky Sergey on 05.11.14.
 *
 * Material Design Responsive Table
 * Tested on Win8.1 with browsers: Chrome 37, Firefox 32, Opera 25, IE 11, Safari 5.1.7
 * You can use this table in Bootstrap (v3) projects. Material Design Responsive Table CSS-style will override basic bootstrap style.
 * JS used only for table constructor: you don't need it in your project
 */

$(document).ready(function() {

    let soGhe = sessionStorage.getItem("soGhe");
    let tenKh = sessionStorage.getItem("tenKh");
    let thoiGianDat = sessionStorage.getItem("thoiGianDat");
    let trangThai = sessionStorage.getItem("trangThai");
    // console.log(soGhe,trangThai)

    if(soGhe){
        $('#customerInput').val(soGhe);
    }

    if(tenKh){
        $('#seatInput').val(tenKh);
    }

    if(thoiGianDat){
        $('#date').val(thoiGianDat);
    }

    if(trangThai){
        $('#status').val(trangThai);
    }
    var table = $('#table');

    // Table bordered
    $('#table-bordered').change(function() {
        var value = $( this ).val();
        table.removeClass('table-bordered').addClass(value);
    });

    // Table striped
    $('#table-striped').change(function() {
        var value = $( this ).val();
        table.removeClass('table-striped').addClass(value);
    });

    // Table hover
    $('#table-hover').change(function() {
        var value = $( this ).val();
        table.removeClass('table-hover').addClass(value);
    });

    // Table color
    $('#table-color').change(function() {
        var value = $(this).val();
        table.removeClass(/^table-mc-/).addClass(value);
    });

    $('#customerInput').on('input',function (){
        console.log($('#customerInput').val());
    })

    $('#seatInput').change('input',function (a){
        console.log(a);
    })

    $('#search').on('click',function (e) {
        e.preventDefault();
        let url = new URL('http://localhost:8080/bans');
        let soGhe = $('#customerInput').val();
        let tenKh = $('#seatInput').val();
        let thoiGianDat = $('#date').val();
        let trangThai = $('#status').val();
        console.log(thoiGianDat,trangThai)
        if(soGhe && !isNaN(soGhe) ){
            url.searchParams.set("soGhe",soGhe);
            sessionStorage.setItem("soGhe",soGhe);
        }else {
            sessionStorage.removeItem("soGhe");
        }
        if(tenKh){
            url.searchParams.set("tenKH",tenKh);
            sessionStorage.setItem("tenKh",tenKh);
        }else {
            sessionStorage.removeItem("tenKh");
        }
        if(trangThai){
            url.searchParams.set("trangThai",trangThai);
            sessionStorage.setItem("trangThai",trangThai);
        }else {
            sessionStorage.removeItem("trangThai");
        }
        if(thoiGianDat){
            sessionStorage.setItem("thoiGianDat",thoiGianDat);
            thoiGianDat = thoiGianDat.replace("T"," ");
            url.searchParams.set("thoiGianDat",thoiGianDat);
        }else {
            sessionStorage.removeItem("thoiGianDat");
        }

        window.location.href = url.toString();
    })
});
