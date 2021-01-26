package service;

import model.ChartOfAccount;
import repository.ChartOfAccountRepository;

public class ChartOfAccountService {
    public void save(ChartOfAccount chartOfAccount){
        ChartOfAccountRepository repository = new ChartOfAccountRepository();
        repository.save(chartOfAccount);
    }
}
