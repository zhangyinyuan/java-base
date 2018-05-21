package com.yuan.ngu.java.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 学习static的加载顺序
 * 成员变量>代码块>构造函数
 * Java初始化，加载顺序：
 * 父类静态成员变量，父类静态代码块，
 * 子类静态成员变量，子类静态代码块，
 * 父类非静态成员变量，父类非静态代码块，父类构造函数，
 * 子类非静态成员变量，子类非静态代码块，子类构造函数
 *
 * @author zhangyinyuan
 * @create 2018-05-21 19:29
 **/
@Slf4j
public class StaticTest {

    @Test
    public void test() {
        new StaticSonClass();
    }

    static class StaticSonClass extends StaticSuperClass {
        private static String FLAG = "sss";
        private String desc;

        static {
            log.debug("son static block");
        }

        {
            log.debug("son  not static block");
        }

        public StaticSonClass() {
            log.debug("son No Arg Method");
        }
    }

    static class StaticSuperClass {
        public static String FLAG = "sss";
        public String desc;

        static {
            log.debug("Super static block");
        }

        {
            log.debug("Super  not static block");
        }

        public StaticSuperClass() {
            log.debug("Super No Arg Method");
        }
    }
}
