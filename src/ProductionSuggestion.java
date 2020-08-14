import java.util.*;

public class ProductionSuggestion {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<String> curSuggestion = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            if(products.length == 0 || searchWord.length() == 0) {
                return ans;
            }
            Arrays.sort(products,(p1,p2) -> p1.compareTo(p2));
            for(int i = 1; i <= searchWord.length(); i++) {
                for(String product: products) {
                    if(curSuggestion.size() < 3 && product.length() >= i) {
                        if(product.substring(0,i).equals(searchWord.substring(0,i))) {
                            curSuggestion.add(product);
                        }
                    }
                }
                ans.add(new ArrayList<>(curSuggestion));
                curSuggestion.clear();
            }
            return ans;
        }

}
