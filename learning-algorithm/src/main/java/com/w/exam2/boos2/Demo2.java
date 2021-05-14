package com.w.exam2.boos2;

/**
 * @ClassName Demo2
 * @Description [Ä£Ê½Æ¥Åä]
 * @Author ANGLE0
 * @Date 2021/4/17 14:43
 * @Version V1.0
 **/
public class Demo2 {

    public  void main(String[] args) {
        String[] qu = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String part = "FoBa";

        camelMatch(qu, part);

    }

    public  boolean[] camelMatch (String[] queries, String pattern) {

        boolean[] resBool = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            resBool[i] = checkStr(queries[i], pattern);
            System.out.println(resBool[i]);
        }

        return resBool;
    }

    private  boolean checkStr(String str, String part) {

        if (str == null || part == null
        || str == "" || part == "") return false;


        char[] griArray = str.toCharArray();
        char[] partArray = part.toCharArray();

        int count =  0;
        for (int i = 0; i < partArray.length; i++) {
            char tempChar = partArray[i];
            for (int j = 0; j < griArray.length; j++) {
                if (griArray[j] == tempChar) {

                    partArray[i] = '#';
                    griArray[j] = '#';
                    count ++;
                    break;
                }
            }
        }


//        print(griArray);
//        print(partArray);




        return count == part.length() && isAllLowerCast(griArray);
    }

    private  void print(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    private  boolean isAllLowerCast(char[] charArray) {
        boolean isAllLowerCast = true;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '#' && Character.isUpperCase(charArray[i])) {
                isAllLowerCast = false;
                break;
            }
        }
        return isAllLowerCast;
    }

}
