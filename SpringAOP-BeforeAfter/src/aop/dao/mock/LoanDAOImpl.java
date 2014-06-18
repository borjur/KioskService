package aop.dao.mock;

import aop.dao.LoanDAO;
import aop.Loan;



public class LoanDAOImpl implements LoanDAO {

    public int addLoan(Loan loan) {
        System.out.println("Loan Added:");
        System.out.println(loan);

        return 9494;
    }
}
