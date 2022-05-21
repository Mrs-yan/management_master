package com.management.client.unit;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.security.MessageDigest;

/**
 * MD5
 *
 * @author 严虹钱
 * @since 2022/5/1
 */
public class MD5 {
    /**
     * MD5加密之方法二
     *
     * @param str 待加密字符串
     * @return 16进制加密字符串
     * @explain java实现
     */
    public static String encrypt2ToMD5(String str) {
        // 加密后的16进制字符串
        String hexStr = "";
        try {
            // 此 MessageDigest 类为应用程序提供信息摘要算法的功能
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 转换为MD5码
            byte[] digest = md5.digest(str.getBytes("utf-8"));
            hexStr = ByteUtils.toHexString(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexStr;
    }
}
