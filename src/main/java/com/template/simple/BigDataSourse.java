package com.template.simple;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:00
 */
public class BigDataSourse extends NetWorkSourse {

    private boolean temp = false;

    public BigDataSourse(boolean temp) {
        this.temp = temp;
    }

    @Override
    protected boolean needHomeWork() {
        return temp;
    }

    void checkHomeWork() {
        System.out.println("检查大数据作业");
    }
}
