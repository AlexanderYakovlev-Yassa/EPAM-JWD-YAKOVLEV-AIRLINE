package by.epam.jwd.yakovlev.airline.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerator {

    public String getMD5Hash(char[] password) {

        String hash = "";

        for (char ch : password) {
            hash = DigestUtils.md5Hex(hash + ch);
        }

        return hash;
    }
}
