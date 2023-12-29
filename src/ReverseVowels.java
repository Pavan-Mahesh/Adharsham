import java.util.Scanner;

public class ReverseVowels {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String given = input.nextLine();
        String[] non_vowels = given.split("[aeiouAEIOU]+");
        String[] vowels = given.split("[^aeiouAEIOU]+");
        if(non_vowels.length == 0) {
            System.out.println(given);
            return;
        }else if(non_vowels[0].compareTo(given) == 0) {
            System.out.println(given);
            return;
        }
        boolean empty_in_vowels = vowels[0].isEmpty();
        int start = empty_in_vowels ? 1 : 0;

        String[] reversed = new String[vowels.length-start];
        for(int i=0; i<reversed.length; i++) {
            String vowel = vowels[vowels.length-(i+1)];
            reversed[i] = (new StringBuilder(vowel)).reverse().toString();
        }
        for(int i=start; i<vowels.length; i++)
            vowels[i] = reversed[start == 1 ? i-1 : i];
        String output = String.valueOf(final_output(non_vowels, vowels, empty_in_vowels));
        System.out.println(output);
    }
    private static StringBuilder final_output(String[] non_vowels, String[] vowels, boolean empty_in_vowels) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<Math.max(non_vowels.length, vowels.length); i++) {
            if(empty_in_vowels) {
                result.append(vowels[i]);
                if(i<non_vowels.length) result.append(non_vowels[i]);
            } else {
                result.append(non_vowels[i]);
                if(i<vowels.length) result.append(vowels[i]);
            }
        }
        return result;
    }
}