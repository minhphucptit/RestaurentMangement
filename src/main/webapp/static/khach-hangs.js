/**
 * Created by Kupletsky Sergey on 05.11.14.
 *
 * Material Design Responsive Table
 * Tested on Win8.1 with browsers: Chrome 37, Firefox 32, Opera 25, IE 11, Safari 5.1.7
 * You can use this table in Bootstrap (v3) projects. Material Design Responsive Table CSS-style will override basic bootstrap style.
 * JS used only for table constructor: you don't need it in your project
 */

$(document).ready(function() {

    let name = sessionStorage.getItem("tenKH");
    let sdt = sessionStorage.getItem("soDienThoai");


    if(name){
        $('#name').val(name);
    }

    if(sdt){
        $('#sdt').val(sdt);
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



    $('#search').on('click',function (e) {
        e.preventDefault();
        let url = new URL(window.location.href);
        let name = $('#name').val();
        let sdt = $('#sdt').val();


        if(name ){
            url.searchParams.set("tenKH",name);
            sessionStorage.setItem("tenKH",name);
        }else {
            sessionStorage.removeItem("tenKH");
        }
        if(sdt){
            url.searchParams.set("soDienThoai",sdt);
            sessionStorage.setItem("soDienThoai",sdt);
        }else {
            sessionStorage.removeItem("soDienThoai");
        }


        window.location.href = url.toString();
    })
});
