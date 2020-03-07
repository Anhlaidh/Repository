package Chapter03;

import Chapter03.TimeTool.TimeTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 01bag
 * @author: Anhlaidh
 * @date: 2020/3/7 0007 0:03
 */
public class bagQuestion {
    class item{
        int weight;
        int value;

        public item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public item() {
        }

        @Override
        public String toString() {
            return "item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }
    public List<item> items(int size,int Max_value,int Max_weight){
        List<item> items = new ArrayList<>();
        for (int i =0;i<size;i++){
            items.add(new item((int)(Math.random()*Max_weight)+1,(int)(Math.random()*Max_value)+1));
        }
        return items;
    }
    public List<item> solution(int dp,List<List<item>> lists){
        int h_value=0;
        List<item> h_list=new ArrayList<>();
        for (List<item> list:lists){
            int value = 0;
            int weight =0;
            for (item item:list){
                weight+=item.weight;
                value+=item.value;
                if (weight>dp) break;

            }
            if (value>h_value&&weight<dp){
                h_value=value;
                h_list=list;
            }
        }
        return h_list;

    }
    public List<List<item>> getList(List<item> items){
        List<List<item>> lists=new ArrayList<>();
        List<item> list=new ArrayList<>();
        if (items==null||items.size()==0){
            return lists;
        }
        backtrack(items,list,lists);
//        for (int i=0;i<items.size();i++){
//
//        }
        return lists;
    }

    public void backtrack(List<item> items, List<item> currentList, List<List<item>> lists){
        if (currentList.size()==items.size()){

            return;
        }
      else {
            for (item item:items){
              if (currentList.contains(item)) continue;
              currentList.add(item);
              backtrack(items,currentList,lists);
//                System.out.println(currentList);
                lists.add(new ArrayList<>(currentList));
              currentList.remove(currentList.size()-1);
          }
      }
    }

    public static void main(String[] args) {
        bagQuestion bagQuestion = new bagQuestion();
        List<item> items = bagQuestion.items(5, 10, 3);
        List<List<item>> lists = bagQuestion.getList(items);
//for (List<item> list:lists){
//    System.out.println(list);
//}
        System.out.println(items);
        TimeTool.check("01bag", new TimeTool.Task() {
            @Override
            public void execute() {
                List<item> solution = bagQuestion.solution(5, lists);
                System.out.println(solution);
            }
        });

        //        System.out.println(bagQuestion.solution(10,lists));

    }
}
