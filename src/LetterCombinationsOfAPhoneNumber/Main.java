package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);

    }

    private List<String> letterCombinations(String digits, int currentPos){
        if(digits.length()==currentPos){
            return new ArrayList<>();
        }
        int currentElement = Integer.parseInt(digits.charAt(currentPos)+"");
        List<String> currentChar  = getAllPossibility(currentElement);
        List<String> elementsAfter = letterCombinations(digits, currentPos+1);
        if(elementsAfter.size()==0){
            return currentChar;
        }
        else{
            return combine(currentChar, elementsAfter);
        }
    }

    List<String> combine(List<String> currentChar, List<String> elementsAfter){
        List<String> result = new ArrayList<>();
        for(int i =0; i< currentChar.size(); ++i){
            String cC = currentChar.get(i);
            for(int j = 0; j<elementsAfter.size(); ++j){
                String eA = elementsAfter.get(j);
                result.add(cC+eA);
            }
        }
        return result;
    }

    private List<String> getAllPossibility(int x){
        List<String> list = new ArrayList<>();
        switch(x){
            case 2 : list.add("a"); list.add("b");list.add("c"); break;
            case 3 : list.add("d"); list.add("e");list.add("f"); break;
            case 4 : list.add("g"); list.add("h");list.add("i"); break;
            case 5 : list.add("j"); list.add("k");list.add("l"); break;
            case 6 : list.add("m"); list.add("n");list.add("o"); break;
            case 7 : list.add("p"); list.add("q");list.add("r"); list.add("s");break;
            case 8 : list.add("t"); list.add("u");list.add("v"); break;
            case 9 : list.add("w"); list.add("x");list.add("y"); list.add("z"); break;
        }
        return list;
    }
}
