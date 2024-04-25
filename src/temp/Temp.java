package temp;

import java.util.*;
import java.util.stream.Collectors;

public class Temp {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(3);
        integerList.add(4);
        integerList.add(2);



    String s = "string data to count each character";
        Map<Character, Integer> hashMap = new HashMap<>();
        List<Character> sList = new ArrayList<>();
        for(int i = 0; i< s.length();++i){
            sList.add(s.charAt(i));
        }
//        Map<Character, Integer> h =

        sList.
                stream()
                .collect(Collectors.groupingBy(t->t, Collectors.counting()))
                        .entrySet().stream().forEach(t->System.out.println(t.getKey()+"->"+t.getValue()));


        integerList
                .stream()
                .collect(Collectors.groupingBy(t->t, Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(t->{
                    if(t.getValue()>1){
                        System.out.println("Element "+ t +" is duplicate");
                    }
                });

//        System.out.println(h);
    }
}
