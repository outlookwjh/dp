package com.designpatterns.facade;

/**
 * 向用户暴露的类，持有三个类的引用，提供简单访问接口
 */
public class FacadeClass {

    private GuozhaiClass guozhaiClass;

    private GuPiaoClass guPiaoClass;

    private WaiHuiClass waiHuiClass;

    public FacadeClass(){
        guozhaiClass = new GuozhaiClass();

        guPiaoClass = new GuPiaoClass();

        waiHuiClass = new WaiHuiClass();
    }
    public void buyJiJin(){

        guPiaoClass.buyGuPiao();
        guozhaiClass.buyGuPiao();
        waiHuiClass.buyGuPiao();
    }
    public void buyGG(){
        guozhaiClass.buyGuPiao();
        guPiaoClass.buyGuPiao();
    }



}
