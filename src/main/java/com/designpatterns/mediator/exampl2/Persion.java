package com.designpatterns.mediator.exampl2;

public abstract class Persion {

    private Mediator mediator;
    private String name;
    private String condition;

    public Persion(String name, String condition,Mediator mediator) {
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public abstract void getParter(Persion persion);


}
