package com.template.simple;

/**
 * 模板设计模式
 * author:曲终、人散
 * Date:2019/4/11 21:51
 */
public abstract class NetWorkSourse {

    protected final void createCourse(){
        //制作预习资料
        this.postPreResourse();

        //制作PPT
        this.createPPT();

        //直播课堂
        this.liveVideo();

        //提交课件笔记
        this.postNote();

        //提交源码
        this.postResource();

        //布置作业，有的的课堂有作业、有的没有作业
        //如果有作业的话，就检查作业  没有的话就结束了
        if(needHomeWork()){
            checkHomeWork();
        }

    }

    abstract void checkHomeWork();

    //钩子方法
    protected  boolean needHomeWork(){
        return false;
    }

    final void postResource(){
        System.out.println("提交源码");
    }

    final void postNote(){
        System.out.println("提交笔记");
    }

    final void liveVideo(){
        System.out.println("在线直播");
    }

    final void createPPT(){
        System.out.println("制作PPT");
    }

    final void postPreResourse(){
        System.out.println("制作预习资料");
    }

}
