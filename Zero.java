import java.io.*;
import java.util.*;

/**
 * @ClassName: zero.Zero
 * @Description: TODO
 * @Author: LFool
 * @Date: 2019/9/25 9:25
 * @Version: 1.0
 */
public class Zero {

    public static void main(String[] args) throws IOException {
        File file = new File(args[1]);
        Zero.letterCount(file);
    }

    /*
     * 统计字母
     */
    public static void letterCount(File file) throws IOException {
        try {
            FileReader fr = new FileReader(file);
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(fr);

            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            String line = null;
            Integer count = 0;
            Integer total = 0;
            while ((line = br.readLine()) != null) {
                char[] ch = line.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    ch[i] = Character.toLowerCase(ch[i]);
                    if (ch[i] < 'a' || ch[i] > 'z') {
                        continue;
                    }
                    count = hm.get(ch[i] + "");
                    if (count == null) {
                        count = 1;
                    } else {
                        count++;
                    }
                    hm.put(ch[i] + "", count);
                    total++;
                }
            }
            for (String str : hm.keySet()) {
                System.out.println(str + "的数量：" + hm.get(str) + "个----出现频率：" + hm.get(str) * 100.0 / total + "%");
            }
            System.out.println("总字母个数:" + total);

            List<Map.Entry<String, Integer>> list_Data = new ArrayList<>(hm.entrySet());
            Collections.sort(list_Data, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            System.out.println("递增输出：");
            System.out.println(list_Data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
