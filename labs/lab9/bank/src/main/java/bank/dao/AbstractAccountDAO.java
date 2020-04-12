package bank.dao;

public abstract class AbstractAccountDAO implements IAccountDAO {
    IAccountDAO accountDAO;

    public AbstractAccountDAO(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
