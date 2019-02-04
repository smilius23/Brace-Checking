package home.made;

public class Main {

    public static void main(String[] args) {
        BraceChecking bc = new BraceChecking();
        System.out.println("Brace (){}[] is " + (bc.isValid("(){}[]") ? "valid" : "not valid"));
        System.out.println("Brace ({[]}) is " + (bc.isValid("({[]})") ? "valid" : "not valid"));
        System.out.println("Brace [({})](] is " + (bc.isValid("[({})](]") ? "valid" : "not valid"));
    }
}
