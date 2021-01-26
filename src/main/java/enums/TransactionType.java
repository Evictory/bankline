package enums;

public enum TransactionType {
    TRANSFER("Transferência"),
    INCOME("Receita"),
    EXPENDITURE("Despesa");

    private String name;

    TransactionType(String name){
        this.name = name;
    }
}
