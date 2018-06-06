/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jlxy.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 16221
 */
public class SeprateSrc {
    public  String[]  seprate(String src){
        String[] list=src.split("\\/");
        for (int i = 0; i < list.length; i++) {
            String string = list[i];
            System.out.println("list[ "+i+" ] = "+string);
            
        }
        return list;
        
        
    }
    
    
    
    
    
    public  String  polymerize(String[] list){
        String srcString="/"+list[2]+"/"+list[4]+"/"+list[5]+"/"+list[6]+"/"+list[7];
        
        return srcString;
        
    }
    
    /*
    public static void main(String[] args) {
        String[] list=seprate("E:/Netbeanscode/HTB_photo4/web/imagesUpload/1/1/55d19d6d-3d70-4180-acbf-38fc32b4a35c.jpg");
        String result=polymerize(list);
        System.out.println(result);
        
    }
*/
    
}
