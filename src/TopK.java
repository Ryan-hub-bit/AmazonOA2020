import java.sql.SQLOutput;
import java.util.*;

public class TopK {
    public static void main(String[] args) {
        TopK tk = new TopK();
        List<String> keywords = new ArrayList<>(Arrays.asList(new String[]{"anacell", "cetracular", "betacellular"}));
        List<String> keywords1 = new ArrayList<>(Arrays.asList(new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"}));
        List<String> reviews = new ArrayList<>(Arrays.asList(new String[]{
                "Anacell provides the best services in the city",
                "betacellul;;;;ar has awesome services",
                "Best services provided by anacell, everyone should use anacell",}));
        List<String> reviews1 = new ArrayList<>(Arrays.asList(new String[]{
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",}));

        List<String> res = tk.findTopK(2,keywords1,reviews1);
        for(String s : res) {
            System.out.println(s);
        }

    }
    public List<String>  findTopK(int k, List<String> keywords, List<String> reviews) {
        Map<String, Integer> freq = new HashMap<>();
        for(int i = 0; i < reviews.size(); i++) {
            reviews.get(i).replaceAll("\\pP"," ");
        }
        for(String review: reviews) {
            String[] sr = review.split("\\s+");
            Set<String>  cur = new HashSet<>(Arrays.asList(sr));
            for(String s: cur) {
                freq.put(s.toLowerCase(),freq.getOrDefault(s.toLowerCase(),0)+ 1);

            }
        }
        System.out.println(freq.get("betacellular"));
        PriorityQueue<String> heap = new PriorityQueue<>((s1,s2)
                ->freq.get(s1) == freq.get(s2)? s1.compareTo(s2): freq.get(s2) -freq.get(s1));
        for(String ss: freq.keySet()) {
            if(keywords.contains(ss)) {
                heap.offer(ss);
            }
        }
        List<String> ans = new ArrayList<>();
        while(heap.size() > 0 && k > 0) {
            ans.add(heap.poll());
            k--;
        }
        return ans;
    }
}
