package com.w.local.dataMining.apriori;

import java.io.*;
import java.util.*;

/**
 * @ClassName AprioriDemo
 * @Description [数据挖掘算法Apriori算法]
 * @Author ANGLE0
 * @Date 2020/4/29 10:37
 * @Version V1.0
 **/
public class AprioriDemo {

    private final static int SUPPORT_LIMIT = 2; // 支持度阈值
    private final static double RESULT_SPLITFIDENCE = 0.7; // 置信度阈值
    private final static String SPLIT_CHARACTER = ";"; // 项之间的分隔符
    private final static String RESULT_SPLIT = "--->"; // 项之间的分隔符

    /**
     * 算法主程序
     *
     * @param dataList
     * @return
     */
    public Map<String, Integer> apriori(ArrayList<String> dataList) {
        //为提高性能将数据放置在HashMap中
        Map<String, Integer> stepFrequentSetMap = new HashMap();
        stepFrequentSetMap.putAll(getItems(dataList));

        //项集进行备份
        Map<String, Integer> frequentSetMap = new HashMap<String, Integer>();//频繁项集
        frequentSetMap.putAll(stepFrequentSetMap);
        //只要项集未处理完，就继续
        while (stepFrequentSetMap != null && stepFrequentSetMap.size() > 0) {
            Map<String, Integer> dataSet = aprioriGen(stepFrequentSetMap);

            Set<String> candidateKeySet = dataSet.keySet();

            //进行计数
            for (String data : dataList) {
                for (String candidate : candidateKeySet) {
                    boolean flag = true;
                    //由于采用了String处理的模式，故此处需要分割所选项
                    String[] strings = candidate.split(SPLIT_CHARACTER);
                    for (String string : strings) {
                        if (data.indexOf(string + SPLIT_CHARACTER) == -1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        dataSet.put(candidate, dataSet.get(candidate) + 1);
                    }
                }
            }

            //从候选集中找到符合支持度的频繁项集
            stepFrequentSetMap.clear();
            for (String candidate : candidateKeySet) {
                Integer count = dataSet.get(candidate);
                if (count >= SUPPORT_LIMIT)
                    stepFrequentSetMap.put(candidate, count);
            }

            // 合并全部频繁集
            frequentSetMap.putAll(stepFrequentSetMap);
        }
        return frequentSetMap;
    }

    /**
     * 找到集合子元素，对每个子元素进行打分
     */
    private Map<String, Integer> getItems(ArrayList<String> dataList) {
        Map<String, Integer> resultSetMap = new HashMap();

        for (String data : dataList) {
            String[] strings = data.split(SPLIT_CHARACTER);
            for (String string : strings) {
                string += SPLIT_CHARACTER;
                if (resultSetMap.get(string) == null) {
                    resultSetMap.put(string, 1);
                } else {
                    //统计数+1
                    resultSetMap.put(string, resultSetMap.get(string) + 1);
                }
            }
        }
        return resultSetMap;
    }

    /**
     * 依据上一步的频繁项集的集合选出候选集
     *
     * @param setMap
     * @return
     */
    private Map<String, Integer> aprioriGen(Map<String, Integer> setMap) {
        Map<String, Integer> dataSet = new HashMap();

        Set<String> candidateSet = setMap.keySet();
        //遍历频繁项集
        for (String s1 : candidateSet) {
            String[] strings1 = s1.split(SPLIT_CHARACTER);
            String s1String = "";
            for (String temp : strings1) {
                s1String += temp + SPLIT_CHARACTER;
            }
            for (String s2 : candidateSet) {
                String[] strings2 = s2.split(SPLIT_CHARACTER);

                boolean flag = true;
                for (int i = 0; i < strings1.length - 1; i++) {
                    if (strings1[i].compareTo(strings2[i]) != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag && strings1[strings1.length - 1].compareTo(strings2[strings1.length - 1]) < 0) {
                    //连接步：产生候选
                    String c = s1String + strings2[strings2.length - 1] + SPLIT_CHARACTER;
                    if (hasInfrequentSubset(c, setMap)) {
                        //剪枝步：删除非频繁的候选
                    } else {
                        dataSet.put(c, 0);
                    }
                }
            }
        }

        return dataSet;
    }

    /**
     *推断候选集是否是频繁项集
     *
     * @return
     */
    private boolean hasInfrequentSubset(String candidateSet, Map<String, Integer> setMap) {
        String[] strings = candidateSet.split(SPLIT_CHARACTER);

        //找出候选集全部的子集，并推断每一个子集是否属于频繁子集
        for (int i = 0; i < strings.length; i++) {
            String subString = "";
            for (int j = 0; j < strings.length; j++) {
                if (j != i) {
                    subString += strings[j] + SPLIT_CHARACTER;
                }
            }
            if (setMap.get(subString) == null){
                return true;
            }
        }

        return false;
    }

    /**
     * 由频繁项集产生关联规则
     *
     * @param frequentSetMap
     * @return
     */
    public Map<String, Double> getRelation(Map<String, Integer> frequentSetMap) {
        Map<String, Double> relationsMap = new HashMap();
        Set<String> keySet = frequentSetMap.keySet();

        for (String key : keySet) {
            List<String> keys = subset(key);
            for (String keysItem : keys) {
                //子集keysItem也是频繁项
                Integer count = frequentSetMap.get(keysItem);
                if (count != null) {
                    Double RESULT_SPLITfidence = (1.0 * frequentSetMap.get(key)) / (1.0 * frequentSetMap.get(keysItem));
                    if (RESULT_SPLITfidence > RESULT_SPLITFIDENCE)
                        relationsMap.put(keysItem + RESULT_SPLIT + expect(key, keysItem), RESULT_SPLITfidence);
                }
            }
        }
        return relationsMap;
    }

    /**
     * 求一个集合全部的非空真子集
     */
    private List<String> subset(String sourceSet) {
        List<String> result = new ArrayList();

        String[] strings = sourceSet.split(SPLIT_CHARACTER);
        //非空真子集
        for (int i = 1; i < (int) (Math.pow(2, strings.length)) - 1; i++) {
            String item = "";
            String flag = "";
            int t = i;
            do {
                flag += "" + t % 2;
                t = t / 2;
            } while (t > 0);
            for (int j = flag.length() - 1; j >= 0; j--) {
                if (flag.charAt(j) == '1') {
                    item = strings[j] + SPLIT_CHARACTER + item;
                }
            }
            result.add(item);
        }

        return result;
    }

    /**
     * 集合运算 集合[A] / [B]
     *
     * @return
     */
    private String expect(String stringA, String stringB) {
        String result = "";

        String[] stringAs = stringA.split(SPLIT_CHARACTER);
        String[] stringBs = stringB.split(SPLIT_CHARACTER);

        for (int i = 0; i < stringAs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < stringBs.length; j++) {
                if (stringAs[i].compareTo(stringBs[j]) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                result += stringAs[i] + SPLIT_CHARACTER;
        }

        return result;
    }

    /**
     * 从目标文件获取数据
     * */
    public static ArrayList getData(String srcFile) throws FileNotFoundException {
        File file = new File(srcFile);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        ArrayList arrayList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String buffer = " ";
        try {
            while (buffer != null) {
                buffer = reader.readLine();
                arrayList.add(buffer);
            }
            arrayList.remove(arrayList.size() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    
    

    public static void main(String[] args) {

        String filePath = "D:\\oridata.txt";
        ArrayList arrayList = new ArrayList<String>();

        try {
            arrayList = getData(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件读取失败，请检查路径是否正确");
            return;
        }
        aprioriTest(arrayList);

    }


/*
    <data>
        1;2;5;
        2;4;
        2;3;
        1;2;4;
        1;3;
        2;3;
        1;3;
        1;2;3;5;
        1;2;3;
*/

    /**
     * apriori测试程序
     * */
    private static void aprioriTest(ArrayList arraylist) {

        ArrayList<String> dataList = arraylist;

        AprioriDemo apriori = new AprioriDemo();

        System.out.println("频繁项集");
        Map<String, Integer> frequentSetMap = apriori.apriori(dataList);
        Set<String> keySet = frequentSetMap.keySet();
        for (String key : keySet) {
            System.out.printf("%-4s\t:%d\n", key, frequentSetMap.get(key));
        }

        System.out.println("关联规则");
        Map<String, Double> relationMap = apriori.getRelation(frequentSetMap);
        Set<String> rrKeySet = relationMap.keySet();
        for (String rrKey : rrKeySet) {
            System.out.printf("%-5s\t:\t%.2f\n", rrKey, relationMap.get(rrKey));
        }
    }
}
