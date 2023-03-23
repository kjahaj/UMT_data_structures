import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<String> emailsList = new LinkedList<>();
        addEmail(emailsList, "kleijahaj08@gmail.com");
        addEmail(emailsList, "angjelosgoga32@yahoo.com");
        addEmail(emailsList, "data structure");
        addEmail(emailsList, "axlrose@gmail.com");
        LinkedList<String> newList = domainSearching(emailsList, "gmail.com");
        System.out.println(newList);
    }
    public static void addEmail(LinkedList<String> emailList,String email ){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        try {
            if(email.matches(regex)){
                emailList.add(email);
            }
            else{
                throw new IllegalArgumentException("The email you entered: \""+email+"\" is not correct");
            }
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static LinkedList<String> domainSearching(LinkedList<String> emails,String domain){
        LinkedList<String> newList = new LinkedList<>();
        for (String string : emails) {
            String[] spString = string.split("@");

            if(spString[1].equals(domain)){
                newList.add(string);
            }
        }
        return newList;
    }
    public static int attachment(LinkedList<String> emails){
        int cnt = 0;
        for (String email : emails) {
            if (email.toLowerCase().contains("attachment") ||
                    email.toLowerCase().contains("attached") ||
                    email.toLowerCase().contains("enclosed")) {
                cnt++;
            }
        }
        return cnt;
    }

}
/* THE OUTPUT:
    The email you entered: "data structure" is not correct
        [kleijahaj08@gmail.com, axlrose@gmail.com]
*/
