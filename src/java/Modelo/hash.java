/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static java.util.logging.Level.OFF;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Estiven
 */
public class hash {
    
    
    //retorn aun hash a partir de un tipo y un texto
    public static String getHash(String txt, String hashType){
    
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i]  & 0xFF)| 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //retorna un md5
    
    public static String md5(String txt){
    return hash.getHash(txt, "MD5");
    }
    
    //retorna un sha1
    
    public static String sha1(String txt){
    return hash.getHash(txt, "SHA1");
    }
}
