package com.w.exam.demo4;

/**
 * @ClassName kill
 * @Description [杀死怪物，怪物在x轴上，有HP，玩家每次技能在x位置释放，怎么可以使用最少技能杀死所有怪物]
 * @Author ANGLE0
 * @Date 2020/7/22 18:01
 * @Version V1.0
 **/

import java.util.Random;

/**
     3 5
     1 10
     10 5
     22 3

 怪物数量，技能范围
 怪物位置，血量
 */
public class kill {

    public static void main(String[] args) {
        System.out.println(new Random(15).nextInt());
    }
}
