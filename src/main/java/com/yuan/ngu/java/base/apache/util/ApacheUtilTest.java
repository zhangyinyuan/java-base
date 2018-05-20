package com.yuan.ngu.java.base.apache.util;

import com.yuan.ngu.java.base.entity.StudentPO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * apache.common.lang3包下常用的方法
 */
public class ApacheUtilTest {

    @Test
    public void stringUtilsTest() {
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.trimToEmpty(" 1 2 9 "));
        System.out.println(StringUtils.trimToNull(" "));
    }

    @Test
    public void beanUtilsTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        StudentPO po = new StudentPO();
        po.setStudentId(1000);
        po.setStudentName("zhangyinyuan");
        po.setSex('1');
        Map map = BeanUtils.describe(po);
        System.out.println(map);
        po = new StudentPO();
        BeanUtils.populate(po, map);
        System.out.println(po);
    }

    @Test
    public void base64Test() throws UnsupportedEncodingException {
        Base64 base64 = new Base64();
        String encode = base64.encodeToString("zhangting".getBytes("UTF-8"));
        System.out.println(encode);
        System.out.println(base64.decode(encode));
    }

    @Test
    public void collectionTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(5);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(CollectionUtils.isEmpty(list));
    }

    @Test
    public void httpClientTest() throws IOException {
        HttpClient hc = new HttpClient();
        GetMethod gm = new GetMethod("http://www.ibm.com");
        int statusCode = hc.executeMethod(gm);
        System.out.println(new String(gm.getResponseBody()));
        System.out.println(statusCode);
    }

    // TODO: 2018/5/20 还剩余IO和array
}
