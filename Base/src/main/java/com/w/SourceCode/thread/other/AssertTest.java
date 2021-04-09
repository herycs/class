package com.w.SourceCode.thread.other;

/**
 * @ClassName assertTest
 * @Description [assert]
 * @Author ANGLE0
 * @Date 2020/6/9 11:05
 * @Version V1.0
 **/
public class AssertTest {

    private static int num = 1;

    public static void main(String[] args) {
        AssertTest assertTest = new AssertTest();
        assertTest.equal();
        assertTest.noEqual();
    }

    public void equal(){
        assert num == 1;
    }

    public void noEqual(){
        assert num == 0;
    }
}
