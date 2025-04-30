package com.juaracoding.tugasakhir.utils;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/30/2025 9:39 AM
@Last Modified 4/30/2025 9:39 AM
Version 1.0
*/

public class OSUtils {

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

}
