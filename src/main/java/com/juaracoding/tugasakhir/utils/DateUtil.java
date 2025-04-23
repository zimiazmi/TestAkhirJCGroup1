package com.juaracoding.tugasakhir.utils;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 22/04/25 21.44
@Last Modified 22/04/25 21.44
Version 1.0
*/


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getTodayDateFolder() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
    }

}
