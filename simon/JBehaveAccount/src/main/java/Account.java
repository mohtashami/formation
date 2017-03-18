public class Account {
    private int amount = 0;
    private String status = "ACTIVE";

    public Account(int amount) {
        this.amount = amount;
    }

    public Account(int amount, String status) {
        this.amount = amount;
        this.status = status;
    }

    public AccountOperationResultType transfertTo(Account accountB, int amount) {
        AccountOperationResultType result = AccountOperationResultType.UNKNOWN;

        if (AccountStatusType.INACTIVE.getValue().equals(accountB.getStatus())) {
            result = AccountOperationResultType.TARGET_ACCOUNT_DISABLED;
        }
        else if (amount >= 1000){
            if (AccountStatusType.GOLD.toString().equals(this.getStatus()) ){
                this.amount -= amount;

                accountB.addAmount(amount);

                result = AccountOperationResultType.SUCCESS;
            }
            else {
                result = AccountOperationResultType.AMOUNT_TOO_HIGH;
            }
        }
        else if (this.amount >= amount) {
            this.amount -= amount;

            accountB.addAmount(amount);

            result = AccountOperationResultType.SUCCESS;

            if (AccountStatusType.LOCKED.getValue().equals(accountB.getStatus())) {
                accountB.setStatus(AccountStatusType.ACTIVE.toString());
            }
        }
        else {
            result = AccountOperationResultType.NOT_ENOUGH_CREDIT;
        }

        return result;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    void addAmount(int amount) {
        this.amount += amount;
    }
}