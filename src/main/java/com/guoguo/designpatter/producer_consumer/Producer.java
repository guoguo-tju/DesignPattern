package com.guoguo.designpatter.producer_consumer;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-10-13 18:56
 */
public class Producer implements Runnable{

    private LinkedBlockingQueue<DataItem> queue;

    private File file;

    public Producer(LinkedBlockingQueue<DataItem> queue, File file){
        this.queue = queue;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                String[] split = line.split(",");
                DataItem dataItem = new DataItem();
                dataItem.setKey(Long.parseLong(split[0]));
                dataItem.setValue(dataItem.getValue());
                queue.add(dataItem);
            }
            // 记得关流
            bufferedReader.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}