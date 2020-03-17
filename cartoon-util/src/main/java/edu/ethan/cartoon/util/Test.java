//package edu.ethan.cartoon.util;
//
//import java.util.*;
//
///**
// * @author Administrator
// * @date 2019/12/20
// */
//public class Test {
//
//    public static Boolean compare(String one,String two){//进行比较两个字符串大小one大返回true否则返回false
//
//        char[] ones=one.toCharArray();//将字符串转为字符数组
//        char[] twos=two.toCharArray();
//        int number;
//        if(ones.length>twos.length)
//        {
//            number=twos.length;
//        }else{
//            number=ones.length;
//        }
//        for(int i=0;i<number;i++){
//            int grade_one=getGrade(ones[i]);//对于字符来说根据获取开头设置的优先级，同一优先级进行比较不同优先级直接获得大小
//            int grade_two=getGrade(twos[i]);
//            //System.out.println(grade_one);//输出各自的等级
//            //System.out.println(grade_two);
//            if(grade_one>grade_two)
//            {
//                return true;
//            }
//            else{
//                if(grade_one<grade_two)
//                {
//                    return false;
//                }
//                else{//如果等级相等则在各自的等级内部继续比较
//                    int one_num=ones[i];
//                    int two_num=twos[i];
//                    if(grade_one==5){//当等级都为5时，即都为汉字
//                        one_num=get_First_Pinyin(ones[i]);
//                        two_num=get_First_Pinyin(twos[i]);
//                        if(one_num<two_num)
//                        {
//                            return true;
//                        }else{
//                            if(one_num>two_num)
//                            {
//                                return false;
//                            }
//                            else{
//                                continue;
//                            }
//                        }
//
//                    }else{
//                        if(grade_one==4){//当等级都为4时表示都为字符，但是默认.字符大于别的字符
//                            if(ones[i]=='.')
//                            {
//                                return true;
//                            }
//                            else{
//                                if(twos[i]=='.')
//                                {
//                                    return false;
//                                }else{
//                                    continue;
//                                }
//                            }
//                        }else{//当等级为1,2,3是继续比较，且比较方法相同都是比较编码的大小
//                            if(one_num<two_num)
//                            {
//                                return true;
//                            }else{
//                                if(one_num>two_num)
//                                {
//                                    return false;
//                                }
//                                else{
//                                    continue;
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//        return true;
//
//    }
//    public static int get_First_Pinyin(char c)//获取汉字字符的拼音的首字母
//    {
//        String[] pinyins=PinyinHelper.convertToPinyinArray(c, PinyinFormat.WITHOUT_TONE);
//        char[] result=pinyins[0].toCharArray();
//        //System.out.println(pinyins[0]);//输出整个拼音
//        //System.out.println(result[0]);//输入拼音的首个字母
//        int nums=result[0];
//        return nums;
//
//    }
//
//    public static int getGrade(char c){//获取字符的优先级
//        int i=c;
//        if (i>=19968&&i<=40869)
//        {return 5;}
//        else {
//            if (i >= 48 && i <= 57) {
//                return 1;
//            } else {
//                if (i >= 97 && i <= 122) {
//                    return 2;
//                } else {
//                    if (i >= 65 && i <= 90) {
//                        return 3;
//                    } else {
//                        return 4;
//                    }
//                }}}}}