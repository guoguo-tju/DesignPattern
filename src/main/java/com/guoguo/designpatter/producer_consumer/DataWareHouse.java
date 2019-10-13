package com.guoguo.designpatter.producer_consumer;

import lombok.Data;

import java.io.File;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 考题：
 * 10G带时间戳的N条kv结构乱序文件存在重复数据，在一台2C4G服务器上去重并保留最新时间戳数据有序输出文件
 * 说明：
 * 1、按照时间戳升序排列
 * 2、时间戳相同，按值的字母序升序排列
 *
 * 案例输入：KV（毫秒时间戳+文本值0-50变长字符串，仅包含字母和数字）
 * 1570593273486,03Ad2k33
 * 1570593273487,03Ad233d988dfd
 * 1570593273488,03Ad2k34
 * 1570593273488,03Ad233d988dfd
 * 1570593273489,03Ad2k33
 * 1570593273487,03Ad233d988dfd
 * 1570593273486,03Ad2k34
 * 1570593273492,03Ad233d988dfd
 * 1570593273493,03Ad2k33
 * 1570593273494,03Ad233d988dfd
 * 1570593273494,03Ad234d988dfd
 *
 * 案例输出：
 * 1570593273488,03Ad2k34
 * 1570593273493,03Ad2k33
 * 1570593273494,03Ad233d988dfd
 * 1570593273494,03Ad234d988dfd
 *
 * 参考思路:
 * https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/06.04.html
 * https://www.jianshu.com/p/dce6a43d4678
 *
 */

/**
 * 描述: 数据仓库
 *
 * @author guozh
 * @create 2019-10-13 19:29
 */
@Data
public class DataWareHouse {

    private static final int THREAD_POOL_SIZE = 10;
    private LinkedBlockingQueue<DataItem> queue;
    private TreeMap<String,DataItem> treeMap;
    private ExecutorService threadPool;

    public DataWareHouse(){
        this.queue = new LinkedBlockingQueue<>();
        this.treeMap = new TreeMap<String, DataItem>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 字符串比较,升序排列
                return o2.compareTo(o1);
            }
        });
        this.threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public static void main(String[] args) {

        String filePath = "sre/main/resources/files";
        File file = new File(filePath);
        // 获取该目录下所有的文件对象
        File[] files = file.listFiles();
        DataWareHouse dataWareHouse = new DataWareHouse();
        for (File file1 : files) {

            Producer producer = new Producer(dataWareHouse.getQueue(), file1);

            dataWareHouse.getThreadPool().execute(producer);
        }

        Comsumer comsumer = new Comsumer(dataWareHouse.getQueue(), dataWareHouse.getTreeMap());
        new Thread(comsumer).start();

        // 消费完所有的对象在treemap里,对treeMap排序
        TreeMap<String, DataItem> treeMap = dataWareHouse.getTreeMap();

    }




}