
# java设计模式

<br>

* [工厂模式](#工厂模式)




<br>


<h2 id="工厂模式">工厂模式</h2>

<br>

   * 就是实例化对象,用工厂方法代替new的操作.
   * 工厂模式包括工厂方法模式和抽象工厂模式.
   * 抽象工厂模式是工厂方法模式得扩展.
   * 意图:
   	定义一个接口来创建对象,但是让子类来决定哪些类需要被实例化.
   	工厂方法把实例化的工作推迟到子类中去实现.
   	在软件系统中经常面临着对象的创建工作,由于需求的变化,这个对象可能也会随之发生变化,但它有比较稳定的接口.为此,我们需要提供一种封装机制来隔离出这个易便对象的的变化,从而保持系统中其他依赖该对象的对象不随需求变化而变化.
    
   ![工厂模式类图](https://raw.githubusercontent.com/guoguo-tju/DesignPattern/master/src/main/resources/picture/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E7%B1%BB%E5%9B%BE.png?t=1 "工厂模式类图")
	
   <h3 id="常见应用">常见应用</h3>
   
   * JDBC
   
   ![工厂模式在JDBC的实现](https://raw.githubusercontent.com/guoguo-tju/DesignPattern/master/src/main/resources/picture/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E5%9C%A8JDBC%E7%9A%84%E5%AE%9E%E7%8E%B0.png?t=1 "工厂模式在JDBC的实现")
   * Spring beanFactory 
   
      BeanFactory,作为Spring基础的Ioc容器,是Spring的一个Bean工厂.它是用来生产Bean,然后提供给客户端.
           Bean的实例化过程如下:
           1)调用Bean的默认构造方法,或指定的构造方法,生成bean实例(instance1).
           2)如果Bean的配置文件中注入了Bean属性值,则在instance1基础上进行属性注入形成instance2,这种注入是覆盖性的.
           3)如果Bean实现了InitializingBean接口,则调用afterPropertiesSet()方法,来改变或操作instance2,得到instance3.
           4)如果Bean的配置文件中指定了init-method="init"属性,则会调用指定的初始化方法,则在instance3的基础上调用初始化方法init(),将对象最终初始化为instance4,这个初始化的名字是任意的.


<br>


<h2 id="代理模式">代理模式</h2>

<br>

   <h3 id="静态代理">静态代理</h3>
   
   
   <h3 id="动态代理">动态代理</h3>
   
   
    能不能通过一个类实现对火车汽车自行车等的动态代理呢？（即实现对不同类，不同方法的代理）

	JDK动态代理：（见图片）
	InvocationHandler接口，实现Invoke方法。
	Proxy,newProxyInstance产生的动态代理类。

	JDK动态代理实现步骤：
	1.创建一个实现接口InvocationHandler的类，它必须实现invoke方法。
	2.创建被代理的类（Car）以及接口（Moveable）
	3.调用Proxy的静态方法，创建一个代理类
	  Proxy.newProxyInstance().
	4.通过代理调用方法。

	cglib动态代理:

	两种代理方式的比较:
	JDK动态代理只能代理实现了接口的类.
	cglib动态代理针对类来实现代理的,对指定的目标类产生一个子类,通过方法拦截技术拦截所有父类方法的调用.
	cglib使用继承的方式实现代理，所以不能对final修饰类进行代理

	cglib实现步骤:
	1.先要引入cglib的jar包.
	2.创建一个类(可以不实现接口)
	3.创建一个类CglibProxy实现MethodInterceptor接口,返回代理类.
	  一个getProxy(),返回代理类,enhancer,帮助生成代理类.
	4.cglibProxy.getProxy()获得代理类并使用.

	
	