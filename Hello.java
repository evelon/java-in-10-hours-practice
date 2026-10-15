public class Hello {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("usage: java -jar hello.jar <원금> <연이율%> <개월>");
            System.exit(1);
            return;
        }

        long balance;
        int ratePercent;
        int months;

        try {
            balance = Long.parseLong(args[0]);
            ratePercent = Integer.parseInt(args[1]);
            months = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("숫자를 입력해 주세요");
            System.exit(1);
            return;
        }

        for (int i = 0; i < months; i++) {
            balance = balance + (long) (balance * ratePercent / 1200);
            System.out.printf("%d %d\n", i + 1, balance);
        }
    }
}
