import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;
public class HighestSalary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern salary_at_end = Pattern.compile("\\b\\d+\\b$");
        Pattern name_at_begin = Pattern.compile(".+(?=\\b\\d+\\b$)");
        Matcher m;

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Long> salary = new ArrayList<>();
        String given, s; long l; int idx;
        int iteration = input.nextInt(); input.nextLine();
        while(iteration > 0) {
            given = input.nextLine();
            m = name_at_begin.matcher(given);
            s = m.find() ? (m.group().isBlank() ? "other" : m.group()) : "other";
            m = salary_at_end.matcher(given);
            l = m.find() ? Long.parseLong(m.group()) : 0;
            if(name.contains(s)) {
                idx = name.indexOf(s);
                l += salary.get(idx);
                salary.set(idx, l);
            } else {
                name.add(s);
                salary.add(l);
            }
            iteration--;
        }
        input.close();

        long high = salary.getFirst();
        for(int i=1; i<salary.size(); i++)
            high = Math.max(high, salary.get(i));
        idx = salary.indexOf(high);
        System.out.format("%s %d", name.get(idx), idx);
    }
}