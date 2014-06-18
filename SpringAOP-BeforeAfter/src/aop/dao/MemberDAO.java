package aop.dao;

import aop.MemberException;



public interface MemberDAO {
    public String getMemberID(String userName, String password) throws MemberException;
}
