package com.w.exam.demo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [背包问题，采购物资，价格，使用价值]
 * @Author ANGLE0
 * @Date 2020/8/1 15:18
 * @Version V1.0
 **/
public class Main1 {
    /**
     * 预算：T
     * 物资：
     * 价格：P    价值：W
     * <p>
     * {INPUT} =
     * {
     * 总预算： < 200_000
     * 总物资：< 20
     * 价格： < 15_000  价值：< 15_000
     * <p>
     * }
     */

    static class Item {
        public int price = 0;
        public int weight = 0;

        public Item(int p, int w) {
            this.price = p;
            this.weight = w;
        }
    }

    static class Comp implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if (o1.weight == o2.weight) {
                return o1.price - o2.price;
            }
            return o2.weight - o1.weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Item temp = new Item(a, b);
            items[i] = temp;
        }

        Arrays.sort(items, new Comp());

        int res = 0;
        for (int i = 0; i < items.length; i++) {
            res = Math.max(res, getMaxValue(items, money, i));
        }

        System.out.println(res);
    }

    // 分别是：Item[]: 物品数组，money: 预算，index: 当前索引
    public static int getMaxValue(Item[] items, int money, int k) {
        if (items == null || items.length < 1 || money < 0) {
            return -1;
        }

        int maxValue = 0;

        for (int i = k; i < items.length; i++) {
            if (money - items[i].price >= 0) {
                maxValue += items[i].weight;
                money -= items[i].price;
            }
        }

        return maxValue;
    }
}
