package questions.day10.q13;

import HomeWork.TimeTool.TimeTool;

import java.util.*;


/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-13 20:34
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{
                -12,-1,4,-14,0,10,7,-7,-6,9,6,-2,7,13,9,-1,4,12,9,4,14,0,-4,0,0,10,2,-7,7,-4,-11,10,2,8,4,-12,-4,-12,-4,-3,12,9,11,4,-1,-3,10,-12,-6,-4,-1,-14,3,2,-7,-11,-3,10,-11,-10,13,-15,7,0,0,-4,-5,11,0,-2,-14,-11,-8,12,1,-1,-14,-12,-6,-5,0,9,-4,-12,-4,4,14,9,-9,10,14,-11,10,6,-3,-4,10,-1,14,-13,13,7,-9,12,4,-1,-4,5,3,6,8,10,0,11,13,11,-7,5,-3,-1,0,-4,-4,-4,10,0
        };

        TimeTool.check("test", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(threeSum(ints));

            }
        });


    }
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        int index1 = 0;
        int index2;
        while (index1 < nums.length) {
            index2 = index1+1;
            while (index2 < nums.length) {
                int num3 = 0 - nums[index1] - nums[index2];
                if (contains(nums, num3,index2+1)) {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[index1]);
                    current.add(nums[index2]);
                    current.add(num3);
                    if (!hasList(lists, current)) {
                        lists.add(current);
                    }
                }
                index2++;
            }
            index1++;

        }
        return lists;

    }

    private static boolean hasList(List<List<Integer>> lists, List<Integer> target) {
        boolean flag = false;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> current = lists.get(i);
            if (target.size() == current.size()) {
                Collections.sort(target);
                Collections.sort(current);

                for (int j = 0; j < target.size(); j++) {
                  if (!target.get(j).equals(current.get(j))) break;
                  if (j==target.size()-1&&target.get(j).equals(current.get(j))) return true;
                }


            }
        }
        return false;
    }

    private static boolean contains(int[] nums, int target,int scope) {
        int[] ints = Arrays.copyOfRange(nums, scope, nums.length);
        Arrays.sort(ints);
       return search(ints, target, 0, ints.length - 1);
    }

    private static boolean search(int[] nums, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
            if (target==nums[mid]) return true;
        }
        return false;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]==target)return true;
//        }


    }


}
