import java.util.Scanner;
import java.util.regex.*;
public class HighestSalary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern salary_pattern = Pattern.compile("\\b\\d+\\b$");
        Pattern name_pattern = Pattern.compile(".+(?=\\b\\d+\\b$)");

        int iteration = input.nextInt(); input.nextLine();
        String[] names = new String[iteration];
        long[] salaries = new long[iteration];
        String given, current_name; long current_salary; int idx;
        for(int i=0; i<iteration; i++) {
            given = input.nextLine();
            Matcher name_matcher = name_pattern.matcher(given);
            current_name = name_matcher.find() ? name_matcher.group() : "other";
            Matcher salary_matcher = salary_pattern.matcher(given);
            current_salary = salary_matcher.find() ? Long.parseLong(salary_matcher.group()) : 0;
            idx = checkDuplicates(names, current_name);
            if(idx != -1)
                salaries[idx] += current_salary;
            else {
                salaries[i] = current_salary;
                names[i] = current_name;
            }
        }
        idx = getIndexOfHigh(names, salaries);
        System.out.println(names[idx] + " " + idx);
    }
    static int checkDuplicates(String[] names, String name) {
        name = name.replaceAll(" ", "");
        for(int i=0; i<names.length; i++) {
            if(names[i] == null)
                return -1;
            if((names[i].replaceAll(" ", "")).equals(name))
                return i;
        }
        return -1;
    }
    static int getIndexOfHigh(String[] names, long[] salaries) {
        int idx = 0;
        long high = salaries[idx];
        for(int i=1; i<salaries.length; i++) {
            if(high > salaries[i])
                continue;
            boolean update = true;
            if(high == salaries[i]) {
                String previous = names[idx].replaceAll(" ", "");
                String current = names[i].replaceAll(" ", "");
                update = previous.compareTo(current) > 0;
            }
            if(update) {
                high = Math.max(high, salaries[i]);
                idx = i;
            }
        }
        return idx;
    }
}