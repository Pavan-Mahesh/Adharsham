import java.util.ArrayList;
import java.util.Scanner;

public class IntsInDescending {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String given = input.nextLine();
        input.close();
        String[] num = given.split("\\D+");
        String[] non_num = given.split("\\d+");
        if(non_num[0].compareTo(given) == 0) {
            System.out.println("output:");
            System.out.println(given);
            return;
        }
        boolean empty = num[0].compareTo("") == 0;

        ArrayList<Integer> value = new ArrayList<>();
        int start = empty ? 1: 0;
        for(int idx=start; idx<num.length; idx++)
            value.add(Integer.parseInt(num[idx]));
        sort(value);
        for(int idx=0; idx<value.size(); idx++)
            num[idx+start] = Integer.toString(value.get(idx));

        StringBuilder result = getResult(num, non_num, empty);
        System.out.println("output:");
        System.out.println(result);
    }
    private static StringBuilder getResult(String[] num, String[] non_num, boolean empty) {
        StringBuilder result = new StringBuilder();
        for(int idx = 0; idx<Math.max(num.length, non_num.length); idx++) {
            if(empty) {
                result.append(num[idx]);
                try { result.append(non_num[idx]); } catch (Exception ignore) {}
            }else {
                result.append(non_num[idx]);
                try { result.append(num[idx]); } catch (Exception ignore) {}
            }
        }
        return result;
    }
    private static void sort(ArrayList<Integer> value) {
        for(int i=0; i<value.size()-1; i++) {
            int max_value_idx = i;
            for (int j = i; j < value.size(); j++)
                if (value.get(max_value_idx).compareTo(value.get(j)) < 0)
                    max_value_idx = j;
            if (max_value_idx != i) {
                Integer temp = value.get(i);
                value.set(i, value.get(max_value_idx));
                value.set(max_value_idx, temp);
            }
        }
    }
}