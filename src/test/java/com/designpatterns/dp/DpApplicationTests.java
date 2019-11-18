package com.designpatterns.dp;

import com.designpatterns.abstractFactory.factory.NorthFactory;
import com.designpatterns.abstractFactory.factory.SourthFactory;
import com.designpatterns.abstractFactory.factory.fruitFactory;
import com.designpatterns.abstractFactory.product.Fruit_af;
import com.designpatterns.builder.ClassRoomBuilder;
import com.designpatterns.builder.Director;
import com.designpatterns.builder.House;
import com.designpatterns.builder.HouseBuilder;
import com.designpatterns.decorator.*;
import com.designpatterns.factorymethod.AppleFactory;
import com.designpatterns.factorymethod.peerFactory;
import com.designpatterns.protoType.People;
import com.designpatterns.protoType.People1;
import com.designpatterns.simplefactory.Factory;

import com.designpatterns.simplefactory.Fruit;
import com.designpatterns.singleton.Person1;
import com.designpatterns.singleton.Person2;
import com.designpatterns.strategy.Context;
import com.designpatterns.strategy.strategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
	 * @throws Exception
	 */
	@Test
	void testAbstractFactory() throws Exception {

		//北方水果
		Fruit_af  northApp = new NorthFactory().getApple();
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
	 * @throws Exception
	 */
	@Test
	void testProtoType() throws Exception {

		//浅克隆, pet为引用对象，克隆时只是将栈内存中的引用指针拷贝一份，所以克隆后☞向同一个堆位置
		People  people = new People();
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
	 *
	 * 现实场景类比： 校长准备修建一座教室，但是自己不会修，也不想知道怎么才能修好教室；
	 * 				所以，校长准备通过招标的方式选择一个施工队来给自己修房子----houseBuilder
	 * 			         并与一家工程咨询公司签订了工程咨询合同，该工程咨询公司负责监督施工队建设教室---director
	 * 	扩展性： 校长如果需要建造一个球场，则只需要招标一个建造球场的施工队即可
	 *
	 *
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
	 *
	 *
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
	 * @throws Exception
	 */
	@Test
	void testStrategy(){

		Context context = new Context();

		strategy strategy = context.getStrategy("1");

		strategy.print("1");
	}



}
