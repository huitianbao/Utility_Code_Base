/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jlxy.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 16221
 */
public class DateUtil_htb {

    public String getTime_String(Date date) {
        // Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        // System.out.println(df.format(date));// new Date()为获取当前系统时间
        return df.format(date);

    }

    public Date getTime_Date(String df_date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = null;
        try {
            date = df.parse(df_date);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil_htb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;

    }

}
