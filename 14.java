import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Program {
    public static boolean isValid(String s,String t){
        var map1 = new HashMap<Character,Integer>();
        var map2 = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); ++i){
            char w1 = s.charAt(i);
            char w2 = t.charAt(i);
            if(!map1.containsKey(w1))
                map1.put(w1,i);
            if(!map2.containsKey(w2))
                map2.put(w2,i);
            if(!Objects.equals(map1.get(w1),map2.get(w2)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "foo";
        String s2 = "bar";
        System.out.print(isValid(s1,s2));
    }
}
