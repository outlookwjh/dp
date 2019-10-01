package com.designpatterns.mediator.exampl2;

public class Women extends Persion {

    public Women(String name, String conditon,Mediator mediator) {
        super(name,conditon,mediator);
    }

    @Override
    public void getParter(Persion persion) {
        this.getMediator().setWomen(this);
        this.getMediator().getPartner(persion);
    }
}
