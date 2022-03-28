
import java.util.*;

public class crc {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] data, crc, divisor, div, rem;
        int data_bits, divisor_bits, tot_length;
        System.out.println("enter no of data bits");
        data_bits = sc.nextInt();
        data = new int[data_bits];
        System.out.println("enter data bits");
        for (int i = 0; i < data_bits; i++)
            data[i] = sc.nextInt();
        System.out.println("enter no of divisor bits");
        divisor_bits = sc.nextInt();
        divisor = new int[divisor_bits];
        System.out.println("enter divisor bits");
        for (int i = 0; i < divisor_bits; i++)
            divisor[i] = sc.nextInt();
        tot_length = divisor_bits + data_bits - 1;
        div = new int[tot_length];
        crc = new int[tot_length];
        rem = new int[tot_length];
        for (int i = 0; i < data.length; i++)
            div[i] = data[i];
        System.out.println("dividend after appending zero's is ");
        for (int i = 0; i < div.length; i++)
            System.out.print(div[i]);
        ;
        // crc generation
        for (int i = 0; i < div.length; i++)
            rem[i] = div[i];
        rem = divide(div, divisor, rem);
        for (int i = 0; i < div.length; i++)
            crc[i] = (div[i] ^ rem[i]);
        System.out.println("crc code is: ");
        for (int i = 0; i < crc.length; i++)
            System.out.print(crc[i]);
        // error detection
        System.out.println("enter crc code for error detection");
        for (int i = 0; i < crc.length; i++)
            crc[i] = sc.nextInt();
        for (int i = 0; i < rem.length; i++)
            rem[i] = crc[i];

        rem = divide(crc, divisor, rem);
        for (int i = 0; i < rem.length; i++) {
            if (rem[i] != 0) {
                System.out.println("error");
                break;
            }
            if (i == rem.length - 1)
                System.out.println("no error");
        }

        sc.close();
    }

    static int[] divide(int div[], int divisor[], int rem[]) {
        int cur = 0;
        while (true) {

            for (int i = 0; i < divisor.length; i++) {
                rem[cur + i] = (rem[cur + i] ^ divisor[i]);
            }
            while (rem[cur] == 0 && cur != rem.length - 1)
                cur++;
            if ((rem.length - cur) < divisor.length)
                break;
        }

        return rem;
    }

}
