package com.yuan.ngu.java.base.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * DESCRIPTION
 *
 * @author zhangyinyuan
 * @create 2018-05-21 22:43
 **/
@Slf4j
public class StringTest {
    @Test
    public void test() {
        String str = "Hello World !";
        log.debug(str.length() + "");
        log.debug(str.indexOf("H") + "");
        log.debug(str.replace(" ", "-"));
        log.debug(str.replaceAll(" ", "-"));
        log.debug(str.concat("abc"));
        log.debug(str.substring(str.length() - 1));
        log.debug(str.substring(3, 5));
        log.debug(str.split(" ")[0]);
        log.debug(str.contains("W") + "");
        log.debug(str.toCharArray()[0] + "");
        log.debug(str.equals("a") + "");
        log.debug(str.equalsIgnoreCase("B") + "");
        log.debug(str.toLowerCase());
        log.debug(str.toUpperCase());
        log.debug(str.trim());
    }
}
