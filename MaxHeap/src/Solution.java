//给定一个非空的整数数组，求出其中出现频率前k高的元素
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    // 频率
    private class Freq implements Comparable<Freq>{
        int e;//表示某一元素
        int freq;//表示该元素出现的频率

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq anther) {
            if (this.freq<anther.freq)
                return 1;
            else if (this.freq>anther.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int [] nums,int k) {
        //统计元素出现的频率
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            //已经包含num则对应的value即频率加一
            if (treeMap.containsKey(num))
                treeMap.put(num, treeMap.get(num) + 1);
             else
                 //第一次进入
                treeMap.put(num, 1);
        }
        //利用优先队列求出前k个元素
        PriorityQueue<Freq> freqPriorityQueue = new PriorityQueue<>();
        //遍历key即对应的元素
        for (int key : treeMap.keySet()) {
            //当前队列大小小于k时 继续入队
            if (freqPriorityQueue.getSize() < k) {
                //元素入队，队列中存放的是该元素和元素对应的频率
                freqPriorityQueue.enqueue(new Freq(key, treeMap.get(key)));
            }
            //如果当前元素的频率大于优先队列的第一个元素的频率
            else if (treeMap.get(key) > freqPriorityQueue.getFront().freq) {
                //则队列第一个元素出队
                freqPriorityQueue.dequeue();
                //新 元素入队
                freqPriorityQueue.enqueue(new Freq(key, treeMap.get(key)));

            }
        }
        //将队列中的元素取出放入链表中
        LinkedList<Integer> res = new LinkedList<>();
        while (!freqPriorityQueue.isEmpty()) {
            //取出第一个元素并加入到队列中
            res.add(freqPriorityQueue.dequeue().e);
        }
        return res;
    }
}
