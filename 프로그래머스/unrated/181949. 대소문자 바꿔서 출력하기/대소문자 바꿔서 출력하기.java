import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        var n = a.length();
        char word;
        
        for(int i=0;i<n;i++){
            word = a.charAt(i);
            if(Character.isUpperCase(word)==true)
                System.out.print(Character.toLowerCase(word));
            else
                System.out.print(Character.toUpperCase(word));
        }
    }
}