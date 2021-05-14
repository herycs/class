package com.w.local.dataStruct.string;

/**
 * @ClassNameMyString
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 16:44
 * @Version V1.0
 **/
public interface MyString {
    /**
     * @Desc:  [生成一个串使其值和chars相等]
     * @param :  chars存储目标值
     * @return : S(String), chars(String)
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:46
     * @version : v1.0
     */
    void StrAssign(String S, String chars);

    /**
     * @Desc:  [赋值T--->S]
     * @param :
     * @return :
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:49
     * @version : v1.0
     */
    void StrCopy(String S, String T);

    /**
     * @Desc:  [返回串的长度]
     * @param :  S(String)
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:51
     * @version : v1.0
     */
    int StrLength(String S);

    /**
     * @Desc:  [在S串的第pos个字符前插入T]
     * @param :  [S, pos, T]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:55
     * @version : v1.0
     */
    void StrInsert(String S, int pos, String T);

    /**
     * @Desc:  [删除第pos个字符开始连续len个字符]
     * @param :  [S, pos, len]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:57
     * @version : v1.0
     */
    void StrDelete(String S, int pos, int len);

    /**
     * @Desc:  [比较串大小]
     * @param :  [S, T]
     * @return :
     *          S > T => 1,
     *          S = T => 0,
     *          S < T = -1
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 16:58
     * @version : v1.0
     */
    int StrCompare(String S, String T);

    /**
     * @Desc:  [拼接，将T拼接到S后面]
     * @param :  [S, T]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:00
     * @version : v1.0
     */
    void StrCat(String S, String T);

    /**
     * @Desc:  [截取 S 中从pos开始的len个字符赋值给 T]
     * @param :  [T, S, pos, len]
     * @return : java.lang.String
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:01
     * @version : v1.0
     */
    String SubString(String T, String S, int pos, int len);

    /**
     * @Desc:  [串S是否有从 第pos个字符后 存在与 T相等的子串]
     * @param :  [S, pos, T]
     * @return : int
     *           存在 => pos个字符后首次出现的位置
     *           不存在 => 0
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:03
     * @version : v1.0
     */
    int StrIndex(String S, int pos, String T);

    /**
     * @Desc:  [V替换S中所有与T匹配的串]
     * @param :  [S, T, V]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:08
     * @version : v1.0
     */
    void StrReplace(String S, String T, String V);

    /**
     * @Desc:  [判空]
     * @param :  [S]
     * @return : boolean
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:09
     * @version : v1.0
     */
    boolean StrEmpty(String S);

    /**
     * @Desc:  [S 存在则清空]
     * @param :  [S]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:10
     * @version : v1.0
     */
    void StrClear(String S);

    /**
     * @Desc:  [销毁 S ]
     * @param :  [S]
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 17:10
     * @version : v1.0
     */
    void StrDestory(String S);
}
