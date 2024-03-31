import java.util.ArrayList;
import java.util.List;

/**
 * Creates the ArrayList to instantiate the list of transactions.
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */

public class TransactionFactory {
    /**
     * Instantiates the list of transactions.
     * @return list of transactions
     */
    public static List<Transaction> createTransactionList() {
        return new ArrayList<>();
    }
}
