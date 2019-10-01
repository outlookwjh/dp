package com.designpatterns.dp;

import com.designpatterns.abstractFactory.factory.NorthFactory;
import com.designpatterns.abstractFactory.factory.SourthFactory;
import com.designpatterns.abstractFactory.factory.fruitFactory;
import com.designpatterns.abstractFactory.product.Fruit_af;
import com.designpatterns.adapter.Yaoming;
import com.designpatterns.adapter.YaomingAdapter;
import com.designpatterns.bridge.example1.Bus2000;
import com.designpatterns.bridge.example2.Bus;
import com.designpatterns.bridge.example3.CarInstall;
import com.designpatterns.builder.ClassRoomBuilder;
import com.designpatterns.builder.Director;
import com.designpatterns.builder.House;
import com.designpatterns.builder.HouseBuilder;
import com.designpatterns.chain_of_responsibility.MakeCar;
import com.designpatterns.chain_of_responsibility.MakeCarBody;
import com.designpatterns.chain_of_responsibility.MakeCarHead;
import com.designpatterns.chain_of_responsibility.MakeCarTail;
import com.designpatterns.command.*;
import com.designpatterns.decorator.*;
import com.designpatterns.facade.FacadeClass;
import com.designpatterns.factorymethod.AppleFactory;
import com.designpatterns.factorymethod.peerFactory;
import com.designpatterns.interpreter.DecreInterpreter;
import com.designpatterns.interpreter.Expression;
import com.designpatterns.interpreter.PlusInterpreter;
import com.designpatterns.mediator.exampl1.Man;
import com.designpatterns.mediator.exampl1.Persion;
import com.designpatterns.mediator.exampl1.Women;
import com.designpatterns.mediator.exampl2.Mediator;
import com.designpatterns.memento.CareTaker;
import com.designpatterns.memento.Company;
import com.designpatterns.memento.CompanyMemento;
import com.designpatterns.observer.ClickClass;
import com.designpatterns.observer.StudentClass;
import com.designpatterns.observer.TeacherClass;
import com.designpatterns.protoType.People;
import com.designpatterns.protoType.People1;
import com.designpatterns.proxy.Dog;
import com.designpatterns.proxy.DogInerface;
import com.designpatterns.proxy.DogProxy;
import com.designpatterns.proxy.dynamicProxy.Car;
import com.designpatterns.proxy.dynamicProxy.CarInterface;
import com.designpatterns.proxy.dynamicProxy.Myhandler;
import com.designpatterns.simplefactory.Factory;

import com.designpatterns.simplefactory.Fruit;
import com.designpatterns.singleton.Person1;
import com.designpatterns.singleton.Person2;
import com.designpatterns.strategy.Context;
import com.designpatterns.strategy.strategy;
import com.designpatterns.template.Fight;
import com.designpatterns.template.ManFight;
import com.designpatterns.visitor.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DpApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("helloword");
    }

    /**
     * 简单工厂
     */
    @Test
    void testSimpleFactory() throws Exception {

        Fruit apple = Factory.getinstance("com.designpatterns.simplefactory.Banana");

        apple.get();

    }

    /**
     * 工厂方法
     *
     * @throws Exception
     */
    @Test
    void testFactoryMethod() throws Exception {

        com.designpatterns.factorymethod.Factory af = new AppleFactory();
        com.designpatterns.factorymethod.Fruit fruit = af.createFruit();
        fruit.get();

        //甲方要求增加一个peer的水果，原代码不需要修改，只需要增加一个peer
        //的水果类和peer的工厂类，符合开发--封闭原则
        com.designpatterns.factorymethod.Factory pf = new peerFactory();
        com.designpatterns.factorymethod.Fruit fruit1 = pf.createFruit();

        fruit1.get();

    }

    /**
     * 抽象工厂
     *
     * @throws Exception
     */
    @Test
    void testAbstractFactory() throws Exception {

        //北方水果
        Fruit_af northApp = new NorthFactory().getApple();
        northApp.get();

        Fruit_af northBa = new NorthFactory().getBanana();
        northBa.get();

        //南方水果
        fruitFactory factory = new SourthFactory();
        factory.getApple().get();
        factory.getBanana().get();
    }

    /**
     * singleton
     *
     * @throws Exception
     */
    @Test
    void testSingleton() throws Exception {

        //饿汉式
        Person1 person1 = Person1.getInstance();

        Person1 person12 = Person1.getInstance();

        person1.setName("wjh");

        person12.setName("wlll");
        //打印pe'r'si'o'n1,结果是person12,证明是一个实例；
        System.out.println(person1.getName());

        //懒汉式
        Person2 per = Person2.getInstance();
        Person2 per1 = Person2.getInstance();
        per.setName("xian");
        per.setName("shanxi");
        System.out.println(per.getName());


    }

    /**
     * ProtoType
     *
     * @throws Exception
     */
    @Test
    void testProtoType() throws Exception {

        //浅克隆, pet为引用对象，克隆时只是将栈内存中的引用指针拷贝一份，所以克隆后☞向同一个堆位置
        People people = new People();
        people.setName("wjh");
        people.setSex("male");
        people.setAge(12);
        List pet = new ArrayList();
        pet.add("dog");
        pet.add("rabbit");
        people.setPets(pet);

        People people1 = people.clone();
        people1.setName("liull");

        pet.add("cat");

        System.out.println(people);
        System.out.println(people1);

        //深克隆
        People1 pp = new People1();
        pp.setName("wjh");
        pp.setSex("male");
        pp.setAge(12);
        List petp = new ArrayList();
        petp.add("dog");
        petp.add("rabbit");
        pp.setPets(petp);

        People1 pp2 = pp.clone();
        pp2.setName("liull");

        petp.add("cat");


        System.out.println(pp);
        System.out.println(pp2);
    }

    /**
     * builder
     * <p>
     * 现实场景类比： 校长准备修建一座教室，但是自己不会修，也不想知道怎么才能修好教室；
     * 所以，校长准备通过招标的方式选择一个施工队来给自己修房子----houseBuilder
     * 并与一家工程咨询公司签订了工程咨询合同，该工程咨询公司负责监督施工队建设教室---director
     * 扩展性： 校长如果需要建造一个球场，则只需要招标一个建造球场的施工队即可
     */
    @Test
    void testBuilder() throws Exception {
        HouseBuilder classroomBuilder = new ClassRoomBuilder();
        Director director = new Director();
        director.makeHouse(classroomBuilder);
        House house = classroomBuilder.buildHouse();

        System.out.println(house.getFloor());


    }

    /**
     * decorator 装饰者模式
     */
    @Test
    void testDecorator() throws Exception {

        CarAction car = new RunCar();

        car.show();
        System.out.println("=========================");
        Decorator fly = new FlyDecorator(car);

        fly.show();
        System.out.println("=========================");
        Decorator swim = new SwimDecorator(fly);

        swim.show();

    }

    /**
     * strategy
     *
     * @throws Exception
     */
    @Test
    void testStrategy() {

        Context context = new Context();

        strategy strategy = context.getStrategy("1");

        strategy.print("1");
    }

    /**
     * observer
     *
     * @throws Exception
     */
    @Test
    void testObserver() {

        StudentClass student = new StudentClass();
        ClickClass clickClass = new ClickClass();
        clickClass.addObserver(student);
        clickClass.addObserver(new TeacherClass());
        clickClass.setDinglingling("dinglingling");
    }

    /**
     * Proxy
     */
    @Test
    void testProxy() {

        DogInerface proxy = new DogProxy(new Dog());

        proxy.speak();

    }

    /**
     * dynamicProxy
     */
    @Test
    void testdynamicProxy() {

        CarInterface instance =
                (CarInterface) Proxy.newProxyInstance(Car.class.getClassLoader(),
                        Car.class.getInterfaces(), new Myhandler());

        instance.driver();
    }

    /**
     * facade 外观模式
     */
    @Test
    void testFacade() {

        FacadeClass  facade = new FacadeClass();

        facade.buyGG();

        facade.buyJiJin();
    }

    /**
     * 桥接模式
     */
    @Test
    void testBridge() {
        //example1 扩展性问题：1. 当要增加一个卡车类时，需要增加cart抽象类，并需要增加cart2000和cart2200类
        //扩展性差，增加的类多
        com.designpatterns.bridge.example1.Car car = new Bus2000();
        car.installEngine();

        //example2 扩展性问题：1. bus不需要安装2200cc和2300发动机；2. 需要增加引擎种类时，需要
        //修改car接口，同时要修改bus类
        com.designpatterns.bridge.example2.Car car1 = new Bus();
        car1.install2000Engine();
        //example3  将车和安装引擎动作分开，让车持有安装引擎的接口，并在车的具体实现中获取安装引擎接口对象引用，
        // 利用抽象方法在子类中的不同，实现差异性，解决了example2中的问题1和2

        com.designpatterns.bridge.example3.Bus bus =
                new com.designpatterns.bridge.example3.Bus2000(new CarInstall());
        bus.CarInstall();
    }

    /**
     * adapter适配器
     */
    @Test
    void testAdapter() {

        Yaoming yaoming = new Yaoming();

        yaoming.ymSpeaking();

        YaomingAdapter adapter = new YaomingAdapter(new Yaoming());

        adapter.translate();

    }

    /**
     * interpreter 解释器模式
     */
    @Test
    void testInterpreter() {

        //功能测试
        com.designpatterns.interpreter.Context context = new com.designpatterns.interpreter.Context();
        context.setInput(10);
        Expression expression = new PlusInterpreter();
        expression.interprete(context);
        System.out.println(context.getInput());
        Expression expression1 = new DecreInterpreter();
        expression1.interprete(context);
        System.out.println(context.getInput());

        //日常用法
        List<Expression> exList = new ArrayList<>();
        exList.add(new PlusInterpreter());
        exList.add(new PlusInterpreter());
        exList.add(new DecreInterpreter());
        for (Expression ex : exList) {
            ex.interprete(context);
            System.out.println(context.getInput());
        }
    }

    /**
     * mediator 中介者模式
     */
    @Test
    void testmediator() {

        //example1: 问题：women和man两个类交互时，高度耦合，当其中一个改变时，另外一个也要改变
        Persion man = new Man("wjh","level1");

        Persion women = new Women("liulili" ,"level1");

        Persion wemen = new Women("lixinai","level2");

        /*man.getParter(women);

        women.getParter(man);

        women.getParter(wemen);*/

        //example2 : 利用中介者模式，中介者担任两个类交互的角色，可以控制两个类的交互，当交互需要变化时，两个类不需要改变
        Mediator mediator =  new Mediator();
        com.designpatterns.mediator.exampl2.Persion p1 =
                new com.designpatterns.mediator.exampl2.Man("wjh","xixi",mediator);
        com.designpatterns.mediator.exampl2.Persion p2 =
                new com.designpatterns.mediator.exampl2.Women("liulili","xixi",mediator);
        com.designpatterns.mediator.exampl2.Persion p3 =
                new com.designpatterns.mediator.exampl2.Women("lixinai","haha",mediator);

        p1.getParter(p2);
        p1.getParter(p3);

    }

    /**
     * Chain of responsibility 职责链模式
     */
    @Test
    void testCoR() {

        MakeCar head = new MakeCarHead();
        MakeCar body = new MakeCarBody();
        MakeCar tail = new MakeCarTail();

     /*   //设置职责链顺序
        head.setNextCarHandler(body);
        body.setNextCarHandler(tail);
        //执行职责链
        head.handlerCar();*/

        //设置职责链顺序
        head.setNextCarHandler(body).setNextCarHandler(tail);
        //执行职责链
        head.handlerCar();


    }

    /**
     * 模板方法
     */
    @Test
    void testTemplate() {

        Fight manf = new ManFight();

        manf.warTemplate();

        Fight womenf = new ManFight();

        womenf.warTemplate();


    }

    /**
     * 备忘录模式 memento
     */
    @Test
    void testMemento() {

       /* Company company = new Company("wjh", "liulili", "jiayuanqiang");
        //创建一个备份
        CompanyMemento memento = company.createMemento();
        //修改company
        company.setBoss("boss");

        company.display();
        //回滚company
        company.rollBack(memento);

        company.display();*/

        //利用caretaker,符合单一职责原则
        Company company = new Company("wjh", "liulili", "jiayuanqiang");
        //创建一个备份
        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(company.createMemento());
        //修改company
        company.setBoss("boss");

        company.display();
        //回滚company
        company.rollBack(careTaker.getMemento());

        company.display();

    }

    /**
     * 命令模式 commond
     */
    @Test
    void testCommond() {
        Commond commond1 = new AppleCommond(new Peddler());
        Commond commond2 = new BananaCommond(new Peddler());

        Waiter waiter = new Waiter();

        waiter.addOrder(commond1);
        waiter.addOrder(commond2);

        waiter.excutor();

        waiter.removeOrder(commond1);

        waiter.excutor();


    }

    /**
     * visitor 访问者模式
     */
    @Test
    void testVisitor() {

        ParkConstruct construct = new ParkConstruct();
        Visitor cleanerA = new CleanerAVisitor();
        construct.accept(cleanerA);
        Visitor cleanerB = new CleanerBVisitor();
        construct.accept(cleanerB);
        Visitor manager = new ManagerVisitor();
        construct.accept(manager);


    }

}
