package day1;
import Tools.Integers;
import Tools.Times;

/**
 * @Package: day1
 * @Description： 冒泡排序（优化)
 * @Author: earl_Bao
 * @Date: 2020/9/12 20:48
 * @Version: 1.0
 */
public class BubbleSort {
    /*public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 8, 7};
        int ct = 0; //交换次数计数器
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true; //每一次扫描，若发现没有进行交换，则说明数组中的剩余元素有序
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sorted = false;
                    ct++;
                }
            }
            if (sorted) {
                System.out.println("循环次数:"+ ct );
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "<");
        }
    }*/

    public static void main(String[] args) {
        Integer[] array1 = Integers.random(2000,20,200000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
        Times.test("bubbleSort1",()->{
            bubbleSort1(array1);
        });
        Times.test("bubbleSort2",()->{
            bubbleSort2(array2);
        });
        Times.test("bubbleSort2",()->{
            bubbleSort3(array3);
        });
    }

    /**
    * @Description: 未优化的bubbleSort
    * @Param: [array]
    * @returnType: void
    * @Author: earl_Bao
    * @Date: 2020/9/13
    * @Version: 1.0
    */
    static void bubbleSort1(Integer[] array){
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }
    }
    
    /**
    * @Description: 仅优化整体有序后的bubbleSort
    * @Param: [array]
    * @returnType: void
    * @Author: earl_Bao
    * @Date: 2020/9/13
    * @Version: 1.0
    */
    static void bubbleSort2(Integer[] array){
            for (int end = array.length - 1; end > 0; end--) {
                boolean sorted = true;
                for (int begin = 1; begin <= end; begin++) {
                    if (array[begin] < array[begin - 1]) {
                        int tmp = array[begin];
                        array[begin] = array[begin - 1];
                        array[begin - 1] = tmp;
                        sorted = false;
                    }
                }
                if(sorted)break;;
            }
    }

    /**
    * @Description: 优化整体和局部有序后的bubbleSort
    * @Param: [array]
    * @returnType: void
    * @Author: earl_Bao
    * @Date: 2020/9/13
    * @Version: 1.0
    */
    static void bubbleSort3(Integer[] array){
        for (int end = array.length - 1; end > 0; end--) {
            //sortedIndex在数组完全有序的时候有用，当数组完全有序则一轮扫描后退出
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin; //标记最后一个交换的位置
                }
            }
            end = sortedIndex; //将位置交给end，作为下一次扫描的终点
        }
    }

}