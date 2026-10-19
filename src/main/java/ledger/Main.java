package ledger;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import ledger.domain.Money;

public class Main {
    public static void main(String[] args) {
        final ArrayList<String> formatteds = new ArrayList<>();

        long sum = 0;

        for (String input : args) {
            try {
                long num = Long.parseLong(input);
                sum = Math.addExact(sum, num);
                formatteds.add(Money.format(num));
            } catch (NumberFormatException e) {
                System.err.println("Error: 숫자가 아닙니다: " + input);
                System.exit(1);
            } catch (ArithmeticException e) {
                System.err.println("Error: 합계 overflow 발생");
                System.exit(1);
            }
        }

        final String formattedSum = "= " + Money.format(sum);
        int totalLength = formattedSum.length();
        for (String formatted : formatteds) {
            System.out.println(StringUtils.leftPad(formatted, totalLength));
        }
        System.out.println(formattedSum);
    }
}
