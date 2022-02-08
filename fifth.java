import javax.swing.plaf.synth.SynthUI;
import java.util.HashMap;

public class Program {

    public static int romanToInt(String s){
        var map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int number = 0;
        for(int i=0; i<s.length(); ++i){
            if(i+1 == s.length() || map.get(s.charAt(i)) >= map.get(s.charAt(i+1))){
                number += map.get(s.charAt(i));
            }else{
                number -= map.get(s.charAt(i));
            }
        }
        return number;
    }

    public static void main(String[] args) {
        String roman = "XXIV";
        System.out.println(romanToInt(roman));
    }
}
