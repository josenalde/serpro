import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Palindrome {   
  public static void main(String [] args) { 
	
  Scanner sc = new Scanner(System.in, "utf-8");
  String s = ""; //armazena entrada
  String r = ""; //armazena entrada invertida

  s = sc.nextLine();

  sc.close();

  s = deAccent(s);

  System.out.println(s);
  //inverte a entrada
  for(int i = s.length()-1; i >= 0; --i)
  {
    r += s.charAt(i);
  }
	
   //compara a entrada normal e invertida, ignorando letras maiúsculas ou minúsculas 	
  if (s.equalsIgnoreCase(r)) System.out.println("S");
  else System.out.println("N");	
 }     

 public static String deAccent(String str) {
    String nfdS = Normalizer.normalize(str, Normalizer.Form.NFKD); 
    System.out.println(nfdS); //normalize está substituindo por ?
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); //, Pattern.CASE_INSENSITIVE
    return pattern.matcher(nfdS).replaceAll("");
    //return nfdS;
}

}