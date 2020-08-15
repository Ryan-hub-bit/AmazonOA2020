import java.util.*;

public class PartitionLabel {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if(S.length() == 0) {
            return  ans;
        }
        int[] lastCh = new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastCh[S.charAt(i) - 'a'] = i;
        }
        int j = 0,anchor = 0;
        for(int i = 0; i < S.length(); i++) {
            j = Math.max(j,lastCh[S.charAt(i) - 'a']);
            if(j == i) {
                ans.add(j- anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
