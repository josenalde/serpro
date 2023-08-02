import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sl = s.toLowerCase();
        System.out.println(sl);
        int cv = 0;
        for (int i = 0; i < sl.length(); i++) {
            //System.out.println(sl.charAt(i));
            if (sl.charAt(i) == 'a' || sl.charAt(i) == 'e' || sl.charAt(i) == 'i' || sl.charAt(i) == 'o' || sl.charAt(i) == 'u') {
                cv+=1;
            }
        }
        // opcionalmente
        //long count = someString.chars().filter(ch -> ch == 'e').count();
        //assertEquals(2, count);
        
        sc.close();
        System.out.println(cv);

        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher matcher = pattern.matcher(sl);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.printf("metodo 2 regex: %d", count);
    }
}
