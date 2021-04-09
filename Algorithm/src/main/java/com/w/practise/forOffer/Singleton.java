package com.w.practise.forOffer;

/**
 * @ClassName Singleton
 * @Description [单例实现]
 * @Author ANGLE0
 * @Date 2020/6/18 10:52
 * @Version V1.0
 **/
public class Singleton {

    //推荐解法：1静态常量区创建，2内部类

    //饿汉,线程安全
    private static class Singleton2{

        private final static Singleton2 demo = new Singleton2();

        private Singleton2 getInstance(){
            return demo;
        }
    }
    //懒汉
    private static class Singleton1{

        private static Singleton1 demo = null;

        public Singleton1 getInstance(){
            return new Singleton1();
        }
    }
    //懒汉改进,加锁
    private static class Singleton3{

        private static Singleton3 demo = null;

        public static synchronized Singleton3 getInstance(){
            if (demo == null){
                demo = new Singleton3();
            }
            return demo;
        }
    }
    //懒汉改进,静态区
    private static class Singleton4{

        private static Singleton4 demo = null;

        static {
            demo = new Singleton4();
        }

        public static synchronized Singleton4 getInstance(){
            return demo;
        }
    }

    //静态内部类
    private static class Singleton5{
        private final static class SingletonHolder{
            private final static Singleton5 instance = new Singleton5();
        }
        public static synchronized Singleton5 getInstance(){
            return SingletonHolder.instance;
        }
    }

    //双重检查锁
    private static class Singleton6{

        private static volatile Singleton6 singleton6 = null;

        private static Singleton6 getInstance(){

            if (singleton6 == null){
                synchronized (Singleton6.class){
                    if (singleton6 == null){
                        singleton6 = new Singleton6();
                    }
                }
            }
            return singleton6;
        }
    }
}
