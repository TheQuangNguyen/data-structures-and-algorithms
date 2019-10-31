package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LeftJoin {

    public static String[][] leftJoin(HashMap<String, String> synonym, HashMap<String, String> antonym) {
        String[][] leftJoinResult = new String[synonym.size()][3];
        // counter to indicate the index of the outer array
        int i = 0;
        // counter to indicate the index of the inner array
        for (Map.Entry<String, String> entry: synonym.entrySet()) {
            String currentKey = entry.getKey();
            if (antonym.containsKey(currentKey)) {
                leftJoinResult[i][0] = currentKey;
                leftJoinResult[i][1] = entry.getValue();
                leftJoinResult[i][2] = antonym.get(currentKey);
            } else {
                leftJoinResult[i][0] = currentKey;
                leftJoinResult[i][1] = entry.getValue();
                leftJoinResult[i][2] = null;
            }
            i++;
        }
        return leftJoinResult;
    }
}
