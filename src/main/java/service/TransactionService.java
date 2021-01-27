package service;

import model.Transaction;
import repository.TransactionRepository;

public class TransactionService {
    //implementar subtração-adição de balances das contas
    public void save(Transaction transaction){
        TransactionRepository repository = new TransactionRepository();
        repository.save(transaction);
    }
}
