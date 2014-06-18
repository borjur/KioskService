package aop.dao.mock;

import aop.dao.DVDLocationDAO;

import java.util.List;
import java.util.ArrayList;

/**
 * <p/>
 * This component and its source code representation are copyright protected
 * and proprietary to The Trivera Group, Inc., Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of the Trivera Group, Inc.
 *
 * Copyright (c) 2010 The Trivera Group, LLC.
 * http://www.triveratech.com   http://www.triveragroup.com
 * </p>
 * @author The Trivera Group Tech Team.
 */

public class DVDLocationDAOImpl implements DVDLocationDAO {

    private static final List<DVDData> dvdIDList;

    static {
        dvdIDList = new ArrayList<DVDData>();

        dvdIDList.add(new DVDData("12475", "B00005JLT5", "BUR-2"));
        dvdIDList.add(new DVDData("12476", "B00005JLZN", "BUR-2"));
        dvdIDList.add(new DVDData("12477", "B00005JM2Y", "BUR-2"));
        dvdIDList.add(new DVDData("12478", "B00005JM4Z", "BUR-2"));
        dvdIDList.add(new DVDData("12479", "B00005JM5B", "BUR-2"));

        dvdIDList.add(new DVDData("7572", "B00000F5B5", "CDG-1"));
        dvdIDList.add(new DVDData("7573", "B00003CXCZ", "CDG-1"));
        dvdIDList.add(new DVDData("7574", "B00005JKC3", "CDG-1"));
        dvdIDList.add(new DVDData("7575", "B00005JLQN", "CDG-1"));
        dvdIDList.add(new DVDData("7576", "B00005JLRQ", "CDG-1"));

        dvdIDList.add(new DVDData("9136", "B00005JLI6", "AMS-1"));
        dvdIDList.add(new DVDData("9136", "B00005JLQN", "AMS-1"));
        dvdIDList.add(new DVDData("9136", "B00005JLZK", "AMS-1"));
        dvdIDList.add(new DVDData("9136", "B00005JLZW", "AMS-1"));
        dvdIDList.add(new DVDData("9136", "B00005JM0B", "AMS-1"));

    }

    static class DVDData {
        String dvdID;
        String dvdTitleID;
        String locationID;

        public DVDData(String dvdID, String dvdTitleID, String locationID) {
            this.dvdID = dvdID;
            this.dvdTitleID = dvdTitleID;
            this.locationID = locationID;
        }
    }

    public String getDVDId(String dvdTitleID, String locationID) {
        for (DVDData data : dvdIDList) {
            if (dvdTitleID.equals(data.dvdTitleID) && locationID.equals(data.locationID)) {
                return data.dvdID;
            }
        }
        return null;
    }


}
