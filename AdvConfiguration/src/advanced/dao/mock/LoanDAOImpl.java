package advanced.dao.mock;

import advanced.dao.LoanDAO;
import advanced.Loan;


public class LoanDAOImpl implements LoanDAO {

    public int addLoan(Loan loan){
        System.out.println("Loan Added:");
        System.out.println(loan);

        return 9494;
    }
}
