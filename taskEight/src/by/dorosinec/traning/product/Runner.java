package by.dorosinec.traning.product;

/**
 * This class is an entry point in the program
 */
public class Runner {
    /**
     * This method call class ReaderAndWrite to set product and
     * ask user, need to add anything product
     * @param args params that take from the command line
     */
    public static void main(String[] args) {
        ReaderAndWrite reader = new ReaderAndWrite();
        // Sets the products
        reader.readConsole();
        Counter counter = new Counter().add(new CountTypes())
                                       .add(new CountAll())
                                       .add(new AveragePrice())
                                       .add(new AveragePriceType());
        counter.execute(reader.getProducts());
    }
}
