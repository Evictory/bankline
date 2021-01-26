package service;

import model.Transaction;
import repository.TransactionRepository;

public class TransactionService {
    public void save(Transaction transaction){
        TransactionRepository repository = new TransactionRepository();
        repository.save(transaction);
    }
}
