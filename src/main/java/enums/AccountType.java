package enums;

public enum AccountType {
    CA ("Conta Corrente"),
    SA ("Conta Poupança"),
    CC ("Cartão de Crédito");

    public String name;

    AccountType(String name) {
        this.name = name;
    }
}
