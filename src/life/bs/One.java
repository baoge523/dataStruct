package life.bs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目一. 文件input.txt是一个文本文件，每一行有多列（用空格分隔）。
 * keyword.conf是一个关键词配置文件，每一行是一个词。
 * 请找出文件input.txt中第一列包含keyword.conf中任意一个关键词的文本行并输出
 */
public class One {

    public static void main(String[] args) throws  Exception {
        File f1 = new File("input.txt");
        File f2 = new File("keyword.conf");
        Map<String, String> map = readFile(f1);
        List<String> strings = readWordFile(f2);
        for (String str : strings){
            if(map.containsKey(str)){
                System.out.println(map.get(str));
            }
        }
    }

    public static Map<String,String> readFile(File file) throws Exception{
        FileReader fr =new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        HashMap<String,String> map = new HashMap<>();
        String line = null;
        while((line =br.readLine()) != null){
            int index =line.indexOf(" ");
            map.put(line.substring(0,index),line);
        }
        br.close();
        return map;
    }


    public static List<String> readWordFile(File file) throws Exception{
        FileReader fr =new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> list = new ArrayList<>();
        String line = null;
        while((line=br.readLine())!=null){
            list.add(line);
        }

        br.close();
        return list;
    }
}
