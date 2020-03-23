package by.epam.jwd.yakovlev.airline.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerator {

    public String getMD5Hash(String password) {

        String hash = DigestUtils.md5Hex(password);

        return hash;
    }
}
