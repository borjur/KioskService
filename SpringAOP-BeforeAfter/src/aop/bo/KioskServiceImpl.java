package aop.bo;

import aop.dao.DVDInfoDAO;
import aop.dao.DVDLocationDAO;
import aop.dao.LoanDAO;
import aop.dao.MemberDAO;
import aop.AirportLocation;
import aop.DVDInfo;
import aop.Loan;
import aop.MemberException;

import java.util.List;
import java.util.Date;



public class KioskServiceImpl implements KioskService {
    private AirportLocation airportLocation;
    private DVDInfoDAO dvdInfoDAO;
    private DVDLocationDAO dvdLocationDAO;
    private LoanDAO loanDAO;
    private MemberDAO memberDAO;

    public KioskServiceImpl(AirportLocation airportLocation) {
        this.airportLocation = airportLocation;
    }

    public void setDvdInfoDAO(DVDInfoDAO dvdInfoDAO) {
        this.dvdInfoDAO = dvdInfoDAO;
    }

    public void setDvdLocationDAO(DVDLocationDAO dvdLocationDAO) {
        this.dvdLocationDAO = dvdLocationDAO;
    }

    public void setLoanDAO(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<DVDInfo> searchByTitle(String title) {
        return dvdInfoDAO.searchDVDs(title, airportLocation.getLocationID());
    }

    public int loanDVD(String dvdTitleID, String userName, String password, Date returnDate, String returnLocationID) {
        String dvdCode = dvdLocationDAO.getDVDId(dvdTitleID, airportLocation.getLocationID());
        String memberID = null;
        try {
            memberID = memberDAO.getMemberID(userName, password);
        } catch (MemberException e) {
            return -1;
        }

        Loan loan = new Loan();
        loan.setDvdCode(dvdCode);
        loan.setExpectedReturnDate(returnDate);
        loan.setExpectedReturnLocation(returnLocationID);
        loan.setFromLocation(airportLocation.getLocationID());
        loan.setLoanDate(new Date());
        loan.setMemberID(memberID);

        int loanID = loanDAO.addLoan(loan);
        return loanID;
    }
}
