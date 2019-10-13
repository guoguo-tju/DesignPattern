package com.guoguo.designpatter.producer_consumer;

import javax.xml.crypto.Data;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-10-13 19:13
 */
public class Comsumer implements Runnable{

    private LinkedBlockingQueue<DataItem> queue;

    private TreeMap<String, DataItem> treeMap;

    public Comsumer(LinkedBlockingQueue queue , TreeMap treeMap){
        this.queue = queue;
        this.treeMap = treeMap;
    }


    @Override
    public void run() {
        try {
            while (!queue.isEmpty()){
                DataItem take = queue.take();
                // treeMap以value作为key,treeMap依据key做排序
                treeMap.put(take.getValue(),take);

            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}