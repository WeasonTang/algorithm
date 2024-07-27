package _05greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 1.创建广播电台
        Map<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        // 将各个电台放入到broadcasts
        HashSet<String> b1 = new HashSet<String>();
        b1.add("北京");
        b1.add("上海");
        b1.add("天津");
        HashSet<String> b2 = new HashSet<String>();
        b2.add("广州");
        b2.add("北京");
        b2.add("深圳");
        HashSet<String> b3 = new HashSet<String>();
        b3.add("成都");
        b3.add("上海");
        b3.add("杭州");
        HashSet<String> b4 = new HashSet<String>();
        b4.add("天津");
        b4.add("上海");
        HashSet<String> b5 = new HashSet<String>();
        b5.add("杭州");
        b5.add("大连");
        // 加入到map
        broadcasts.put("k1", b1);
        broadcasts.put("k2", b2);
        broadcasts.put("k3", b3);
        broadcasts.put("k4", b4);
        broadcasts.put("k5", b5);

        // 2.allAreas 存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        broadcasts.values().stream().forEach(t -> allAreas.addAll(t));

        System.out.println(allAreas);
        // 3.创建ArrayList 存放选择的电台集合
        List<String> selects = new ArrayList<>();
        // 存放遍历过程中 电台含有的未覆盖地区
        HashSet<String> tempSet = new HashSet<String>();
        // maxKey 遍历过程中 含有最大的未覆盖地区的电台的key
        String maxKey;
        // tempSet的size
        int size;
        // 含有未覆盖地区最多的电台的电台数
        int maxKeyRetainSize = 0;
        // 开始遍历选择电台
        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 去两个集合的交集
                tempSet.retainAll(allAreas);
                // 选择最优电台(含有未覆盖地区最多的电台)
                if ((size = tempSet.size()) > 0
                        && (maxKey == null || size > maxKeyRetainSize)) {
                    maxKey = key;
                    maxKeyRetainSize = size;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
            System.out.println(allAreas);
        }

        System.out.println(selects);
    }

}
