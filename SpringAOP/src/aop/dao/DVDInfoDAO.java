package aop.dao;

import aop.DVDInfo;

import java.util.List;



public interface DVDInfoDAO {
    public List<DVDInfo> getDVDsByLocationID(String locationID);

    public DVDInfo getDVDByID(String id);

    public List<DVDInfo> searchDVDs(String title, String locationID);
}
