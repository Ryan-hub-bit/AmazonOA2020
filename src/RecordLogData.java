import java.util.*;

public class RecordLogData {
        public String[] reorderLogFiles(String[] logs) {
            int n = logs.length;
            // if(n == 0) {
            //     return new String[];
            // }
            List<String> letter = new ArrayList<>();
            List<String> dig = new ArrayList<>();
            for(String log: logs) {
                if(Character.isDigit(log.charAt(log.indexOf(" ")+1))) {
                    dig.add(log);
                }else {
                    letter.add(log);
                }
            }
            Collections.sort(letter, new Comparator<String>() {
                public int compare(String let1, String let2) {
                    String afterLet1 = let1.substring(let1.indexOf(" ") + 1);
                    String afterLet2 = let2.substring(let2.indexOf(" ") + 1);
                    return afterLet1.equals(afterLet2) ? let1.compareTo(let2):afterLet1.compareTo(afterLet2);
                }
            });
            letter.addAll(dig);
            return letter.toArray(new String[0]);
        }

}
