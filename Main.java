import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner scan =new Scanner(System.in);
        String input=scan.nextLine();
        textModifier(input);
    }

    public static String textModifier(String text) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> nums= new ArrayList<>();
        for (char i : text.toCharArray()) {
            list.add(String.valueOf(i));
        }
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).isBlank()&&list.get(i+1).isBlank()) {
                list.remove(i);
            }
        }
        for (int i = list.size()-1; i >=0; i--) {
            if (list.get(i).equals("-")){
                Collections.swap(list,i-1,i+1);
                list.remove(i);
            }
            if (list.get(i).equals("+")){
                list.remove(i);
                list.add(i,"!");
            }
            if (list.get(i).equals("0")||list.get(i).equals("1")||list.get(i).equals("2")||list.get(i).equals("3")||list.get(i).equals("4")||list.get(i).equals("5")||list.get(i).equals("6")||list.get(i).equals("7")||list.get(i).equals("8")||list.get(i).equals("9")){
                nums.addLast(Integer.valueOf(list.get(i)));
                list.remove(i);
            }
        }
        int result = 0;
        for (int i:nums) {
            result =result+ nums.get(i);
        }
        if (result>0) {
            list.addLast(" " + result);
        }
        String textResult=String.join("",list);
        System.out.println(textResult);
        return text;
    }
}