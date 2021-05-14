//package algorithm.dataMining.di3;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * @ClassName D3
// * @Description [DI3算法]
// * @Author ANGLE0
// * @Date 2020/6/22 15:46
// * @Version V1.0
// **/
//public class DI3 {
//
//    private int Num_Attrib = 0;
//    private int Num_Record = 0;
//    private int[][] data = null;
//    private ArrayList list = null;
//    private int MaxDifferentValue;
//    private int ClassNO;
//
//    //获取输入
//    public void getInput() {
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("属性集合大小：");
//        Num_Attrib = in.nextInt();
//        System.out.println("样本数：");
//        Num_Record = in.nextInt();
//        System.out.println("样本数据");
//        data = new int[Num_Record][Num_Attrib];
//        for (int i = 0; i < Num_Record; i++) {
//            data[i][i] = in.nextInt();
//        }
//        list = new ArrayList();
//        for (int i = 0; i < Num_Record; i++) {
//            list.add(data[i][i]);
//        }
//    }
//
//
//    private TreeNode Build_ID3() {
//        int Class_Distribute[];
//        int I;
//        if (Num_Record == 0) {
//            return null;
//        }
//        TreeNode N = new TreeNode();
//        //计算data中各类的分布情况存入Class_Distribute
//        int temp_attribute = 0;
//        for (int i = 0; i < Num_Attrib; i++)
//            if (data[0][i] >= 0)
//                temp_attribute++;
//        if (temp_attribute == 0) {
//            N.setClassNo();//最多的类
//            N.setLeaf(true);
//            N.setLeft_Node(null);
//            N.setRight_Node(null);
//            return N;
//        }
//        if (Class_Distribute.length > 0)//中仅一类的分布大于0
//        {
//            N.setClassNo();
//            N.setLeaf(true);
//            N.setLeft_Node(null);
//            N.setRight_Node(null);
//            return N;
//        }
//        int InforGain = 0;
//        int CurrentCol = -1;
//        for (int i = 0; i < Num_Attrib - 1; i++) {
//            int TempGain = Compute_InforGain(data, Num_Record, I, Num_Attrib);
//            if (InforGain < TempGain) {
//                InforGain = TempGain;
//                CurrentCol = I;
//            }
//        }
//        N.setAttrib_Col(CurrentCol);
//        //记录CurrentCol所对应的不同值放入
//        int[] DiferentValue;
//        int[][] Subdata;
//        int i = 0;
//        int Value_No = -1;
//        while (i < Num_Record) {
//            boolean flag = false;
//            for (int k = 0; k < Value_No; k++)
//                if (DiferentValue[k] == data[i][CurrentCol]) flag = true;
//            if (flag == false) {
//                Value_No++;
//                DiferentValue[Value_No] = data[i][CurrentCol];
//            }
//            I++;
//        }
//        for (int i = 0; i < Value_No; i++) {
//            int k = -1;
//            for (int j = 0; j < Num_Record - 1; j++)
//                if (data[j][CurrentCol] == DiferentValue[i]) {
//                    k = k++;
//                    for (int i1 = 0; i1 < Num_Attrib; i1++)
//                        if (i1 < CurrentCol)
//                            Subdata[k][i1] = data[j][i1];
//                    else
//                    Subdata[k][i1] = -1;
//                }
//            N.setAttrib_Col(CurrentCol);
//            N.setValue(DiferentValue[i]);
//            N.setLeaf(false);
//            N.setClassNo(0);
//            N.setLeft_Node(Build_ID3(Subdata, k+1, Num_Attrib));
//            N.setRight_Node(new TreeNode());
//            N = N.getRight_Node();
//        }
//    }
//
//    //计算信息增益
//    public int Compute_InforGain(int Num_Record, int Col_No, int Num_Attrib) {
//        int[] DifferentValue = new int[MaxDifferentValue];
//        int Total_DifferentValue;
//        int[][] S = new int[ClassNo][MaxDifferentValue];
//        int s = 0;// 数组清0;
//        Total_DifferentValue = -1;
//        for (int i = 0; i < Num_Record; i++) {
//            int j = GetPosition(DifferentValue, Total_DifferentValue, data[i][Col_No]);
//            if (j < 0) {
//                Total_DifferentValue++;
//                DifferentValue[Total_DifferentValue] = data[i][Col_No];
//                int J = Total_DifferentValue;
//            }
//            S[data[i][Num_Attrib - 1]][j]++;
//        }
//        int Total_I = 0;
//        for (int i = 0; i < ClassNo; i++) {
//            int sum = 0;
//            for (int j = 0; j < Num_Record; j++)
//                if (data[j][Num_Attrib - 1] == i)
//                    sum++;
//                Total_I = (int) getPI(sum / Num_Record);
//        }
//        int EA = 0;
//        for (int i = 0; i < Total_DifferentValue; i++) ;
//        {
//            int temp = 0;
//            int sj = 0; //sj是数据子集中属于类j的样本个数；
//            for (int j = 0; j < ClassNO; j++)
//                sj += s[j][i];
//            for (int j = 0; j < ClassNO; j++)
//                EA += sj / Num_Record * getPI(s[j][i] / sj);
//        }
//        return total_I - EA;
//    }
//
//    //得到某数字在数组中的位置
//    public int GetPosition(int[] Data, int dataSize, int value) {
//        for (int i = 0; i < dataSize; i++){
//            if (Data[i] == value)
//                return i;
//        }
//        return -1;
//    }
//
//    public float getPI(float pi) {
//        if (pi <= 0) return 0;
//        if (pi >= 1) return 0;
//        return (float) (0 - pi * Math.log(pi));
//    }
//}
