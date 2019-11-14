package life.bs;

import java.io.*;

/**
 * input.txt中有10万个随机整数，每行一个，范围从0-99999，
 * 需要分别统计[0-99]、[100-199]、[200-299]、[300-399]  …… [99900, 99999]，
 * 出现的次数。输出为每个范围及其中数字出现的次数，
 * 范围和数字间空格分隔，每行一个。（20）
 *
 *
 *  前提是，系统一次性能共加载这个文件
 */
public class Two {

    public static void main(String[] args) throws Exception {

            File file=new File("E:\\io\\num.txt");
            try {
                FileInputStream fis=new FileInputStream(file);
                InputStreamReader isr=new InputStreamReader(fis,"utf-8");
                BufferedReader br=new BufferedReader(isr);
                String str="";
                // 100,000 /100 = 1000
                int[] arr=new int[1000];

                while((str=br.readLine())!=null){
                    if (str.length()==1||str.length()==2){ // 0-9 或者 10-99
                        arr[0]++;
                    }else if (str.length()==3){ // 100-999
                        arr[str.charAt(0)]++; // 0-9
                    }else if(str.length()==4){ // 1000 - 9999
                        arr[Integer.parseInt(str.substring(0,2))]++;
                    }else if(str.length()==5){ // 10000 - 99999
                        arr[Integer.parseInt(str.substring(0,3))]++;
                    }
                }
                br.close();

                for (int i=0;i<arr.length;i++){
                    if(arr[i]!=0){
                        int b=i*100+99;
                        System.out.println(i*100+"--"+b+"个数位"+arr[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void sout(File file) throws Exception{

        // 首先将数据从文件中读取出来
        BufferedReader br = new BufferedReader(new FileReader(file));

        // 根据题目所知: 我们需要1000桶来存放数据，所以我们需要定义一个数组
        int[] bucket = new int[1000];

        String line = null;

        while((line = br.readLine()) != null){
           bucket[Integer.parseInt(line)/100]++;
        }

        for (int i=0;i<bucket.length;i++){
            System.out.println("["+i*100+","+i*100+99+"]   "+bucket[i]);
        }

    }
}

