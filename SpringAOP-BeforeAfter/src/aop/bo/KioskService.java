package aop.bo;

import aop.DVDInfo;

import java.util.List;
import java.util.Date;



public interface KioskService {
    public List<DVDInfo> searchByTitle(String title);

    public int loanDVD(String dvdTitleID, String userName, String password, Date returnDate, String returnLocationID);

}
