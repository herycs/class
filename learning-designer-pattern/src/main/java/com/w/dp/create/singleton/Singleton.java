package designPattern.create.singleton;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;

/**
 * @ClassName Singleton
 * @Description [单例]
 * @Author ANGLE0
 * @Date 2020/8/28 19:08
 * @Version V1.0
 **/
public class Singleton {

    public Singleton() {

    }

}

// 饿汉模式
class HungerModel {
    private static Singleton singleton = new Singleton();
    private HungerModel() {}
    public static Singleton getSingleton() {
        return singleton;
    }
}


// lazy loading v1.0---非线程安全
class LazyModel1 {
    private static Singleton singleton;
    private LazyModel1(){}
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

// lazy loading v1.1---线程安全,但冗余
class LazyModel2 {
    private static Singleton singleton;
    private LazyModel2(){}
    //lazy loading v1.1---线程安全，但冗余
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

// lazy loading v1.2---双重检查锁,存在线程安全隐患，序列化问题
class LazyModel3 {
    private static Singleton singleton;
    private LazyModel3(){}
    //双重检查锁
    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (LazyModel3.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

// lazy loading v1.3---双重检查锁,线程安全 volatile --- 序列化问题
class LazyModel4 {
    private static volatile Singleton singleton;
    private LazyModel4(){}
    //双重检查锁
    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (LazyModel4.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

// lazy loading v1.4---双重检查锁,线程安全 final --- 序列化问题
class Wapper<T> {
    public final T value;
    public Wapper(T value) {
        this.value = value;
    }
}
class LazyModel5 {
    private Wapper<Singleton> wapper = null;
    public Singleton getInstance() {
        Wapper<Singleton> tWrapper = wapper;
        if (wapper == null) {
            synchronized (this) {
                if (tWrapper == null) {
                    wapper = new Wapper<>(new Singleton());
                }
                tWrapper = wapper;
            }
        }
        return tWrapper.value;
    }
}

// lazy loading v1.5---内部类
class InnerClass {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private InnerClass() {
    }
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


// 枚举，无序列化问题-------->YES
enum EnumModel {
    INSTANCE;
    EnumModel() {}
}

// 双重检查锁，解决序列化问题-------->YES
class DoubleCheck implements Serializable {
    private volatile static Singleton singleton;
    private DoubleCheck() {}
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheck.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    public Object readResolve() {
        return singleton;
    }
}