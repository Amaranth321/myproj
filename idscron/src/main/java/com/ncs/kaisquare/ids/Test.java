package com.ncs.kaisquare.ids;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Test implements TestInterface{
    public Queue queue = new LinkedList();

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList();
//        List<Integer> list2 = new LinkedList();
//        long time1 = System.currentTimeMillis();
//        for(int i=0;i<2000000;i++){
//            list.add(i);
//        }
//        System.out.println("arraylist add use:"+(System.currentTimeMillis()-time1));
//        long time2 = System.currentTimeMillis();
//        for(int i=0;i<2000000;i++){
//            list2.add(i);
//        }
//        System.out.println("linkedlist add use:"+(System.currentTimeMillis()-time2));
//
//        long time3 = System.currentTimeMillis();
//        long count1 = list.parallelStream().filter(x->x%4==0).count();
//        System.out.println("search arraylist use:"+(System.currentTimeMillis()-time3)+" and count is "+count1);
//
//
//        long time4 = System.currentTimeMillis();
//        long count2 = list2.parallelStream().filter(x->x%4==0).count();
//        System.out.println("search linkedlist use:"+(System.currentTimeMillis()-time4)+" and count is "+count2);




    }
}
