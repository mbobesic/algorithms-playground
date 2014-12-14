package spotify;

import java.util.Scanner;

/**
 * Created by mislav on 11/17/14.
 */
public class Reversebinary {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int originalNumber = input.nextInt();

        int numBitLength = 32 - Integer.numberOfLeadingZeros(originalNumber);


        int result = 0;
        for (int i = 0; i < numBitLength; i++) {

            result = result << 1;
            int bit = originalNumber & 1;

            result += bit;
            originalNumber = originalNumber >> 1;
        }

        System.out.println(result);
        input.close();
    }
}
