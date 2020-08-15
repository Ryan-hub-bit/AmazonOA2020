import java.util.*;

public class OptimalUtilization {
    public static void main(String[] args) {
        OptimalUtilization ou = new OptimalUtilization();
        int[][] arr1 = new int[][]{{1, 2}, {2, 4}, {3, 6}};
        int[][] arr2 = new int[][]{{1,2}};
        int[][] arr3 = new int[][]{{1, 8}, {2, 7}, {3, 14}};
        int[][] arr4 = new int[][]{{1, 5}, {2, 10}, {3, 14}};
        int[][] arr5 = new int[][]{{1, 8}, {2, 15}, {3, 9}};
        int[][] arr6 = new int[][]{{1, 8}, {2, 11}, {3, 12}};
        List<int[]> list1 =Arrays.asList(arr1);
        List<int[]> list2 =Arrays.asList(arr2);
        List<int[]> list3 =Arrays.asList(arr3);
        List<int[]> list4 =Arrays.asList(arr4);
        List<int[]> list5 =Arrays.asList(arr5);
        List<int[]> list6 =Arrays.asList(arr6);
        List<int[]> ans = ou.optimalU(list5,list6,20);
        for(int[] a: ans) {
            System.out.println("a[0]:" + a[0]);
            System.out.println("a[1]:" + a[1]);
        }

    }
    public List<int[]> optimalU(List<int[]> list1, List<int[]> list2, int target) {
//        Map<int[],Integer> map = new HashMap<>();
//        for(int[] l1: list1) {
//            for(int[] l2: list2) {
//                map.put(new int[]{l1[0],l2[0]},l1[1] + l2[1]);
//            }
//        }
//        int max = 0;
//        for(Map.Entry<int[],Integer> entry: map.entrySet()) {
//            if(target >= entry.getValue()) {
//                max = Math.max(entry.getValue(),max);
//            }
//        }
//        List<int[]> ans = new ArrayList<>();
//        for(Map.Entry<int[],Integer> entry: map.entrySet()) {
//            if(max == entry.getValue()) {
//               ans.add(entry.getKey());
//            }
//        }
//        return ans;
        Collections.sort(list1,(l1,l2) ->l1[1] - l2[1]);
        Collections.sort(list2,(l1,l2) ->l1[1] - l2[1]);
        int max = 0;
        int n = list1.size();
        int m = list2.size();
        int i = 0;
        int j = m -1;
        List<int[]> ans = new ArrayList<>();
        while(i < n && j >= 0) {
            int sum = list1.get(i)[1] + list2.get(j)[1];
            if(sum > target) {
                j--;
            } else {
                if(sum >= max) {
                    if(sum > max) {
                        ans.clear();
                        max = sum;
                    }
                    ans.add(new int[]{list1.get(i)[0],list2.get(j)[0]});
                    int index = j - 1;
                    while(index >= 0 && list2.get(index)[0] == list2.get(index + 1)[0]) {
                        ans.add(new int[]{list1.get(i)[0],list2.get(index)[0]});
                    }
                }
                i++;
            }
        }
        return ans;
    }
}
