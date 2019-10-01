package com.designpatterns.mediator.exampl2;

public class Man extends Persion {

    public Man(String name,String conditon,Mediator mediator) {
        super(name,conditon,mediator);
    }

    @Override
    public void getParter(Persion persion) {
        this.getMediator().setMan(this);
        this.getMediator().getPartner(persion);
    }
}
