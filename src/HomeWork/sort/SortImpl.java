package HomeWork.sort;

import HomeWork.sort.ISort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 15:36
 */
public class SortImpl implements ISort {
    @Override
    public void QuickSort(int[] array) {

    }

    @Override
    public void MergeSort(int[] array) {
        int mid = array.length/2;
        int[] left = null;
        int[] right=null;
        if (array.length>1){
            //TODO 分成两个数组
            left = Arrays.copyOfRange(array, 0, mid);
             right = Arrays.copyOfRange(array, mid , array.length);
            MergeSort(left);
            MergeSort(right);
        }
        Merge(array,left,right);

    }

    private void Merge(int[] array, int[] left, int[] right) {
        if (left==null||right==null) array=array;
        else {
           int l=0;
           int r=0;
           int i=0;
           while (i<array.length){
               if (left[l]<right[r]){
                   array[i] = left[l];
                   l++;
                   i++;
                   if (l>=left.length){
                       while (r<right.length){
                           array[i] = right[r];
                           r++;
                           i++;
                       }
                   }
               }
               else{
                   array[i] = right[r];
                   r++;
                   i++;
                   if (r>=right.length){
                       while (l<left.length){
                           array[i] = left[l];
                           i++;
                           l++;
                       }

                   }

               }
           }
        }
    }

    @Override
    public void BubbleSort(int[] array) {
        for (int j = array.length; j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    @Override
    public void SelectSort(int[] array) {
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
}
