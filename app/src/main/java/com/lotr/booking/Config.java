package com.lotr.booking;

public class Config {

    public static final String BOOKING_MAIN_URL = "https://www.booking.com/index.ru.html";

    public static final String jsscript = "function init() {\n" +
            "\t\tvar logo = document.getElementsByClassName(\"js-header-logo site-header--logo svg_icons_on_header-rtl_fix\");\n" +
            "\t\tvar footer = document.getElementsByClassName(\"site-footer js-site-footer css-loading-hidden hide-footer-menu-tab\");\n" +
            "\n" +
            "\t\tlogo[0].style.display = \"none\";\n" +
            "\t\tfooter[0].style.display = \"none\";\n" +
            "\t\t}\n" +
            "return init();\n";
}
