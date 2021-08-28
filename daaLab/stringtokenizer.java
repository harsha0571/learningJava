
// import java.util.Scanner;
// import java.util.StringTokenizer;
import java.util.*;

public class stringtokenizer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String data;
        System.out.println("Enter data in <name,dd/mm/yyyy> format ");
        data = input.next();
        input.close();
        StringTokenizer st = new StringTokenizer(data, ",/");
        int count = st.countTokens();
        for (int i = 1; i <= count && st.hasMoreTokens(); i++) {
            System.out.print(st.nextToken());
            if (i < count)
                System.out.print(",");
        }
    }

}