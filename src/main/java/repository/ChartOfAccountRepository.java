package repository;

import model.ChartOfAccount;

public class ChartOfAccountRepository extends CrudRepository {
    public ChartOfAccountRepository(){
        super();
    }

    public void save(ChartOfAccount chartOfAccount) {
        super.save(chartOfAccount);
    }
}
