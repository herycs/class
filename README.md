# Base_Know

## algorithm
> 算法
### base
> 基础算法

### leetcode
> 刷题

## dataStruct
> 数据结构
### 线性表
### 队列
### 栈
### 字符串
### 树

## designPattern
> 设计模式

### strategy
> 策略模式
>
> Comparable | Comparator
>
> 复用--->适配
- 理解：封装执行一个任务的不同的执行方式

### factory
> 工厂模式
>
>工厂方法 | 抽象工厂 | 简单工厂 | 抽象工厂
> 
>实际应用：Spring IOC
- 定义：任何可产生对象的方法或类，都可以称之为工厂
- 出现原因：灵活控制生产过程
- 简单实践：形容词--->接口，名词--->抽象类
#### 特点
- 工厂方法--->产品族扩展
- 抽象工厂在产品族的维度扩展
#### 缺点分析
- 扩展实质上是受限制的，在限定产品族中是合适的，但当新加产品族时，可能需要改很多代码

### singleton
> 单例模式
>
- 使用：饿汉式，懒汉式（存在多线程情况下的问题）
    - ###### 加锁：synchronized,但这种方式导致其性能下降

### mediator
> 调停者
>
> 实际应用：消息中间件
- 出现原因：办理简单的事需要各个模块间协调，但若单独交给各自模块处理会十分臃肿，其中的关联关系会十分复杂，另外扩展方面同样不好
- 理解：提供一个公共处理模块处理各自间的联系，作为一个协调者和调度者

### decorator
> 装饰器

### observer
> 观察者
>
> 实际应用：事件处理
- 实际应用：Listener,Callback,Observer,Hook

### Composite
> 组合
>
> 树装结构专用模式

### flyweight
> 享元模式
- 理解：重复利用对象，共享元数据

### proxy
> 代理
>
> 动态代理 | 静态代理
>
> 应用：Spring AOP{动态代理}

### iterator
> 迭代器
>
> 容器 | 容器遍历

### visitor
> 访问者
>
> 容器 | 容器遍历 | 反编译asm(class类文件结构符合要求)
- 理解：不改变结构基础上动态改变对内部类的动作，适用于结构不变的类

### builder
> 构建器
>
- 应用：构建复杂对象
- 理解：同样构建过程，创建不同表示

### adapter | wapper
> 适配器
>
> 应用：java.io | ASM transformer | java.jdbc odbc bridge

### bridge
> 桥接模式
>
- 理解：分离抽象与具体，采用聚合的方式连接抽象与具体

### command | action | transaction
> 命令封装
>
> 应用：宏命令 | 多次undo | transaction回滚

### prototype
> 原型模式
>
>
- 实际操作：实现interface Cloneable
- 应用：一个类属性确定，需要产生很多相同对象

### memento
> 备忘录
>
- 理解：记录状态，便于回滚
- 应用：记录快照，存盘

### template
> 模板方法
>
> 应用：hook(钩子函数) | ASM ClassVisitor

### state
> 状态模式
>
- 理解：依据状态--->决定行为
## JavaBase
> java基础
### 集合类
### IO基础
### 源码

## JVM
> jvm调优测试代码

## com.w.test
> 测试代码


"# class" 
