package advanced.dao;

import advanced.MemberException;


public interface MemberDAO {
    public String getMemberID(String userName, String password) throws MemberException;
}
