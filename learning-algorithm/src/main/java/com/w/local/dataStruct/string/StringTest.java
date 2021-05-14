package com.w.local.dataStruct.string;

/**
 * @ClassNameStringTetst
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 20:33
 * @Version V1.0
 **/
public class StringTest{
    public static void main(String[] args) throws Exception {

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        System.out.println(chars.toString());
        String s = "dlalfejlf";

        String a = "";
        int i = 0;
        while (!(a = s.substring(i,i+1)).equals('\0')){
            i++;
            System.out.println(a);
        }
    }

    private static void SeqStringTest() throws Exception {
        SeqChar a = new SeqChar(new char[]{'a', 'b', 'c', 'd', 'e'}, 15);
        SeqChar b = new SeqChar(new char[]{'o', 'x', 'e', 'g', 'u'});

        a.display();
        b.display();
        System.out.println("初始化结束");


        System.out.println("3号位插入S");
        SeqChar.insert(a, 3,b);
        a.display();

        System.out.println("删除第3-5字符");
        SeqChar.delete(a, 3, 5);
        a.display();
    }
}
