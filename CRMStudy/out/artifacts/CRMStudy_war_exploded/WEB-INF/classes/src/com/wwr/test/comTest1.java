package com.wwr.test;

import java.util.*;

/**
 * @author：wwr
 * @date：2018/3/9
 * @since：jdk:1.8
 */
public class comTest1 {
    public static void main(String[] args) {
        int []param = {1,4,2,1,3,2,1,4};
        List<Integer> resultList = getSort(param);
        System.out.println(Arrays.toString(resultList.toArray()));
        getSortAndGetNum(param);
    }

    /**
     * 程序实现对数组排序并按顺序输出结果
     * {1,4,2,1,3,2,1,4}作为参数（参数可变）传入java方法中，控制台输出如下结果{1,2,3,4}
     * 排序方法封装
     * @param param
     * @return
     */
    private static List<Integer> getSort(int[] param) {
        List<Integer> resultList = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(param);
        for (int i = 0; i < param.length; i++) {
            list.add(param[i]);
        }
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            flag = false;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    /**
     * 程序实现对数据排序并按出现次数进行排序
     * {1,4,2,1,3,2,1,4}作为参数（参数可变）传入java方法中，控制台输出如下结果
     * 1 出现了3次
     * 2 出现了2次
     * 4 出现了2次
     * 3 出现了1次
     * 获取出现次数并排序
     * @param param
     * @return
     */
    private static void getSortAndGetNum(int[] param){
        int num = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(param);
        for (int i = 0; i < param.length; i++) {
            list.add(param[i]);
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    num++;
                }
            }
            map.put(list.get(i),num);
            num=0;
        }
        List<Integer> resultList = getSort(param);
        for(int i =0;i<resultList.size();i++){
            System.out.println(resultList.get(i)+" 出现了 "+map.get(resultList.get(i))+"次");
        }
    }

}

