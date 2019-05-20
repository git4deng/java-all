package com.david.web.jdbc;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author david
 * @create 2019-05-15 15:50
 */
public class test {
    public static void main(String[] args) {
        String s="admin";
        String s1 = DigestUtils.shaHex(s);
        System.out.println(s1);
        //d033e22ae348aeb5660fc2140aec35850c4da997

    }
}
