package com.template.simple;

import com.template.simple.BigDataSourse;
import com.template.simple.JavaSourse;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:04
 */
public class TemplateTest {
    public static void main(String[] args) {
        System.out.println("---java---");
        JavaSourse javaSourse = new JavaSourse();
        javaSourse.createCourse();


        System.out.println("---大数据---");
        BigDataSourse bigDataSourse = new BigDataSourse(true);
        bigDataSourse.createCourse();
    }
}
