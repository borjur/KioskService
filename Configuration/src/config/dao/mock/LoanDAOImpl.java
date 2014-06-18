package config.dao.mock;

import config.dao.LoanDAO;
import config.Loan;


public class LoanDAOImpl implements LoanDAO {

    public int addLoan(Loan loan){
        System.out.println("Loan Added:");
        System.out.println(loan);

        return 9494;
    }
}
