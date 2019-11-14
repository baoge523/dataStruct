package life.structure.array;

import java.io.*;

/**
 * 跟着尚硅谷数据结构与算法敲的实例:
 *
 * 稀疏数组(sparse array)
 *
 *   使用场景: 当我们的二维数组中存在大量的重复性的数据，而我们的目标数据很少时，
 *            可以理由稀疏数组来节约空间。
 *   例如:
 *       五子棋的存档和恢复
 *
 *       存档:  数组 --> 稀疏数组  --> 文件
 *       恢复:  文件 --> 稀疏数组  --> 数组
 *
 *
 *  案例: 现在我们有 11 * 11 的棋盘，在棋盘中存在三个点
 *           黑子 (3,2),(5,4)
 *           白子 (7,5)
 *       未使用的位置用0表示，1表示黑子，2表示白子
 *
 *
 *
 *    稀疏数组的格式:***
 *        永远都三列，n行
 *        row  clo  value
 *     0   11   11   3       表示有 11行，11列，3个数据
 *     1   3    2    1       表示 4行，3列的值是1
 *     。。。
 *
 *
 */
public class SparseArray {

    public static void main(String[] args) {

        // 创建好 11 * 11 棋盘，并打印
        int checkerArray[][] =  new int[11][11];

        // 指定位置放不同的棋子
        // 黑子 (3,2),(5,4)
        // 白子 (7,5)
        checkerArray[3][2] = 1;
        checkerArray[5][4] = 1;
        checkerArray[7][5] = 2;

        /**
         * checkerArray 本身表示的就是行
         *
         * checkerArray.length 表示就是行的行数
         *
         * 第一层循环遍历行
         *
         * 第二层循环遍历列
         *
         */
//        for (int[] row:checkerArray){
//            for (int item: row){
//                System.out.printf("\t%d",item);
//            }
//            System.out.println();
//        }

        // 获取有多少个棋子
        int sum = 0;
        for(int i=0;i<checkerArray.length;i++){
            for(int j=0;j<checkerArray.length;j++){
                if(checkerArray[i][j] != 0){
                    sum++;
                }
            }
        }
        // 将数组转换成稀疏数组
        // 稀疏数组永远都是 三列，n行。 行=棋子个数+1
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 存放棋子信息
        int count = 0; // 用来表示存放棋子的位置
        for (int i=0;i<checkerArray.length;i++){
            for (int j=0;j<checkerArray.length;j++){
                if(checkerArray[i][j] !=0){
                    count++; // 0号位置已经被占了，所以要先++一次
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = checkerArray[i][j];
                }
            }
        }

        // 打印稀疏数组
        for (int[] row:sparseArray){
            for (int item : row){
                System.out.printf("\t%d",item);
            }
            System.out.println();
        }

        // 将稀疏数组存放到文件中去
        save2file(sparseArray);

        // 将文件中数据回复成稀疏数组
        sparseArray = read2file();

        // 将稀疏数组回复称普通数组
        recovery(sparseArray);

    }

    /**
     * 从文件中读取操作会损坏文件，将byte数组转换成字符串时，发现最后一个数据少一个反引号，解析时，就失败了
     *
     * 待解决。。。
     *
     * @return
     */
    private static int[][] read2file() {
        FileInputStream fis  = null;
        try{
            fis = new FileInputStream(new File("D:\\data.txt"));
            byte buffer[] = new byte[1024];
            fis.read(buffer);
            String str = new String(buffer,"iso-8859-1");
            String[] split = str.split(",");
            int sparesArray[][] = new int[split.length/3][3];
            int index=-1;
            for (int i=0;i<split.length-1;i++){
                if(i%3==0){
                    index++;
                }
                sparesArray[index][i%3]=Integer.parseInt(split[i]);
            }
            return sparesArray;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new int[0][0];
    }

    /**
     * 将稀疏数组转换成普通数组
     * @param sparesArray
     */
    public static void recovery(int[][] sparesArray){

        int newArray[][] = new int[sparesArray[0][0]][sparesArray[0][1]];
        for(int i=1;i<=sparesArray[0][2];i++){
            newArray[sparesArray[i][0]][sparesArray[i][1]] = sparesArray[i][2];
        }

        for (int[] row:newArray){
            for(int item:row){
                System.out.printf("\t%d",item);
            }
            System.out.println();
        }

    }

    /**
     * 将稀疏数组保存到文件中去
     * @param sparseArray
     */
    public static void save2file(int[][] sparseArray){
        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream(new File("D:\\data.txt"));
             StringBuilder sb = new StringBuilder();
             for (int[] row:sparseArray){
                 for (int item:row){
                     sb.append(item+",");
                 }
             }
             sb.append(-1);
            String s = sb.toString();
            System.out.println(s);
            fos.write(s.getBytes("iso-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }






}
