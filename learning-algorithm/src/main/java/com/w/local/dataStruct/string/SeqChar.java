package com.w.local.dataStruct.string;

/**
 * @ClassNameSeqString
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 17:12
 * @Version V1.0
 **/
public class SeqChar {

    private char[] chars;
    private int len;
    private int MAX_SIZE;
    private int DEFAULT_SIZE = 50;

    public SeqChar() {
        new SeqChar(DEFAULT_SIZE);
    }

    public SeqChar(int len) {
        this.MAX_SIZE = len;
        this.chars = new char[len + 1];
        this.len = 0;
    }

    public SeqChar(char[] chars) {
        this.chars = new char[chars.length + 1];
        this.setChars(chars);
        this.len = chars.length;
        this.MAX_SIZE = chars.length;

    }

    public SeqChar(char[] chars, int len) {
        this.chars = new char[len + 1];
        this.setChars(chars);
        this.len = chars.length;
        this.MAX_SIZE = len;
    }

    /**
     * @Desc:  [S的pos位开始插入T]
     * @param :  [S, pos, T]
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 22:38
     * @version : v1.0
     */
    public static int insert(SeqChar S, int pos, SeqChar T) throws Exception {
        if (null == S || null == S.chars || null == T.chars || null == T || pos < 0 || pos > S.len + 1)
            throw new Exception("插入位置不合法");
        //S串T串可以全部保留
        if (S.len + T.len < S.MAX_SIZE) {
            //为插入串整理空间
            for (int i = S.len + T.len; i >= pos + T.len; i--) {
                S.chars[i] = S.chars[i - T.len];
            }
            //插入字符串
            for (int i = pos; i < pos + T.len; i++) {
                S.chars[i] = T.chars[i - pos + 1];
            }
            S.len = S.len + T.len;
            return 0;
            //T串可完整插入，S有可能会被截断
        } else if (pos + T.len <= S.MAX_SIZE) {
            //将第pos~pos+T.len位的所有字符后移
            for (int i = S.MAX_SIZE; i >= pos + T.len; i--) {
                S.chars[i] = S.chars[i - T.len];
            }
            for (int i = pos; i < pos + T.len; i++) {
                S.chars[i] = T.chars[i - pos + 1];
            }
            S.len = S.MAX_SIZE;
            return 0;
        } else {
            //插入串T会被截断
            for (int i = pos; i < S.MAX_SIZE; i++) {
                S.chars[i] = T.chars[i - pos + 1];
            }
            S.len = S.MAX_SIZE;
            return 0;
        }
    }

    /**
     * @Desc:  [S的pos位开始删除到pos+len范围的字符]
     * @param :  [S, pos, len]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 22:37
     * @version : v1.0
     */
    public static void delete(SeqChar S, int pos, int len) throws Exception {
        if (null == S || null == S.chars || pos < 0 || pos > S.len + 1)
            throw new Exception("删除参数不合法");
        for (int i = pos; i <= S.len - len; i++) {
            S.chars[i] = S.chars[i + len];
        }
        S.len = S.len - len;
    }

    /**
     * @Desc:  [S后拼接T]
     * @param :  [S, T]
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 22:38
     * @version : v1.0
     */
    public int strCat(SeqChar S, SeqChar T) throws Exception {
        if (null == S || null == T || null == T.chars)
            throw new Exception("参数不合法，拼接失败");
        //可完全拼接
        if (S.len + T.len <= MAX_SIZE) {
            for (int i = S.len + 1; i <= S.len + T.len; i++) {
                S.chars[i] = T.chars[i - S.len];
            }
            S.len = S.len + T.len;
            return 0;
        } else if (S.len < MAX_SIZE) {
            //可拼接部分
            for (int i = S.len + 1; i < MAX_SIZE; i++) {
                S.chars[i] = T.chars[i - S.len];
            }
            S.len = MAX_SIZE;
            return 0;
        }
        return 0;
    }

    /**
     * @param :
     * @return :
     * @Desc: [打印字符]
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 21:21
     * @version : v1.0
     */
    public void display() {
        System.out.print("[");
        if (this.len != 0) {
            for (int i = 0; i < this.len - 1; i++) {
                System.out.print(" '" + this.chars[i + 1] + "',");
            }
            System.out.print(" '" + this.chars[this.len]+"'");
        }
        System.out.println("]\n");
    }

    public void setChars(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            this.chars[i + 1] = chars[i];
            this.len++;
        }
    }

}