package com.w.local.sort;

import com.w.local.sort.init.bubble.BubbleSort;
import com.w.local.sort.init.choise.Selection;
import com.w.local.sort.init.quick.QuickSort;

import static com.w.local.sort.utils.SortUtils.check;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/5/1 20:43
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        check(false, new QuickSort());
    }
}
