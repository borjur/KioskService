package config.dao;

import config.MemberException;


public interface MemberDAO {
    public String getMemberID(String userName, String password) throws MemberException;
}
