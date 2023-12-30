package lab;

import datastr.ARI;
import datastr.ArrayStack;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse("12345"));

    }

    private static ArrayStack s = new ArrayStack();

    public static String reverse(String str) {
        String back = "";
        String backR = "";
        ARI ari = new ARI(str, back, backR);
        s.push(ari);
        System.out.println("Call reverse(\"" + str + "\")");
        System.out.println(s.toString());
        if (str.length() != 1) {
            back = str.substring(1);
            ari.setBack(back);
            backR = reverse(back);
            ari.setBackR(backR);
        }
        System.out.println("Return from reverse(\"" + str + "\")");
        System.out.println(s.toString());
        s.pop();
        return backR += str.charAt(0);
    }
}