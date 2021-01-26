package repository;

import model.Transaction;

public class TransactionRepository extends CrudRepository {
    public TransactionRepository(){
        super();
    }

    public void save(Transaction transaction) {
        super.save(transaction);
    }
}
