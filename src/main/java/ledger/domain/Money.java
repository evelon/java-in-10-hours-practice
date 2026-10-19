package ledger.domain;

import java.util.Locale;

public final class Money {
    public static String format(long won) {
        return String.format(Locale.ROOT, "%,d원", won);
    }
}