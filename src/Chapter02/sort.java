package Chapter02;


import Chapter02.TimeTool.TimeTool;

/**
 * @Description: sort
 * @author: Anhlaidh
 * @date: 2020/2/28 0028 14:58
 */
public class sort {
    static void BubbleSort(int[] array){
        for (int j = array.length;j>0;j--){
            for (int i =0;i<j-1;i++){
                if (array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }

    }
    static void SelectSort(int[] array){
        for (int i =0;i<array.length;i++){
            int min=i;
            for (int j=i ;j <array.length;j++){

                if (array[j] <array[min]){
                    min = j;
                }
            }
            if (min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }

        }
    }
    public static void main(String[] args) {
    int[] array = new int[10];
    for (int i = 0;i<array.length;i++){
        array[i] = (int)(Math.random()*100);
    }
    int [] SelectSort_T = array.clone();
    TimeTool.check("SelectSort", new TimeTool.Task() {
            @Override
            public void execute() {
                SelectSort(SelectSort_T);
            }
        });
    for (int i =0;i<SelectSort_T.length;i++){
        System.out.print(SelectSort_T[i]+"\t");
    }
        System.out.println();
    int[] BubbleSort_T = array.clone();
    TimeTool.check("BubbleSort", new TimeTool.Task() {
        @Override
        public void execute() {
            BubbleSort(BubbleSort_T);
        }
    });
        for (int i =0;i<SelectSort_T.length;i++){
            System.out.print(BubbleSort_T[i]+"\t");
        }

    }

}
