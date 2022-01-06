package com.pys.shiro.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName:md5}")
    private String algorithmName;
    @Value("${password.hashIterations:2}")
    private int hashIterations;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String encryptPassword(String password,String salt) {

        // 根据项目需要，可以随机生成salt，用于加密
        //String salt = randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(password+salt),
                hashIterations).toHex();

       return newPassword;
    }

}
