package com.designpatterns.dp;

import com.designpatterns.abstractFactory.factory.NorthFactory;
import com.designpatterns.abstractFactory.factory.SourthFactory;
import com.designpatterns.abstractFactory.factory.fruitFactory;
import com.designpatterns.abstractFactory.product.Fruit_af;
import com.designpatterns.factorymethod.AppleFactory;
import com.designpatterns.factorymethod.peerFactory;
import com.designpatterns.simplefactory.Factory;

import com.designpatterns.simplefactory.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
