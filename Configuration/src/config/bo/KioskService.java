package config.bo;

import config.dao.DVDInfoDAO;
import config.dao.DVDLocationDAO;
import config.dao.LoanDAO;
import config.dao.MemberDAO;
import config.AirportLocation;
import config.DVDInfo;
import config.Loan;
import config.MemberException;

import java.util.List;
import java.util.Date;


public class KioskService {
    private AirportLocation airportLocation;
    private DVDInfoDAO dvdInfoDAO;
    private DVDLocationDAO dvdLocationDAO;
    private LoanDAO loanDAO;
    private MemberDAO memberDAO;

    public KioskService(AirportLocation airportLocation) {
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
