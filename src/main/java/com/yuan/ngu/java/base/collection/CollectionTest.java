package com.yuan.ngu.java.base.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author zhangyinyuan
 * @create 2018-05-21 23:12
 **/
@Slf4j
public class CollectionTest {

    @Test
    public void test() {
        Map map = new HashMap<String, Object>();
        map.put("map", null);
        map.put(null, null);
        Map table = new Hashtable<String, Object>();
        table.put(null, "");
        table.put("", null);
        log.debug(map.toString());
        log.debug(table.toString());
    }
}
