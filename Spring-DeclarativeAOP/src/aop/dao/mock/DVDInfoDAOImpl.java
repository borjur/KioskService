package aop.dao.mock;

import aop.dao.DVDInfoDAO;
import aop.DVDInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p/>
 * CREATE TABLE DVD(
 * DVDCODE VARCHAR(10) NOT NULL PRIMARY KEY,
 * DVD_TITLE_ID VARCHAR(10) NOT NULL,
 * LOCATION_ID VARCHAR(10),
 * ON_HOLD CHAR(1) DEFAULT 'F',
 * CONSTRAINT FK_DVD_DVDTITLE FOREIGN KEY(DVD_TITLE_ID)
 * REFERENCES DVDTITLE(DVD_TITLE_ID))
 * </p>
 * This component and its source code representation are copyright protected
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

public class DVDInfoDAOImpl implements DVDInfoDAO {
    private static final List<DVDInfo> titles;

    static {
        titles = new ArrayList<DVDInfo>();
        titles.add(new DVDInfo("B00005JLT5", "Roman Polanski", "Region-2", "Widescreen, Dolby, DTS Surround Sound", "R (Restricted)", "Universal Studios", "200301", "The Pianist (Widescreen Edition)", "Adrien Brody - Thomas Kretschmann - Frank Finlay", "BUR-2"));
        titles.add(new DVDInfo("B00005JLZN", "Alan Parker", "Region-0", "Color, Closed-captioned, Widescreen, Dolby", "R (Restricted)", "Universal Studios", "200302", "The Life of David Gale (Widescreen Edition)", "Kevin Spacey - Kate Winslet - Laura Linney", "BUR-2"));
        titles.add(new DVDInfo("B00005JM2Y", "Gurinder Chadha", "Region-2", "Color, Closed-captioned, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Twentieth Century Fox Home Video", "200308", "Bend It Like Beckham (Widescreen Edition)", "Parminder Nagra - Keira Knightley - Jonathan Rhys-Meyers", "BUR-2"));
        titles.add(new DVDInfo("B00005JM4Z", "John Singleton", "Region-1", "Widescreen, Color, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Universal Studios", "200306", "2 Fast 2 Furious (Widescreen Edition)", "Paul Walker - Tyrese - Cole Hauser", "BUR-2"));
        titles.add(new DVDInfo("B00005JM5B", "Stephen Norrington", "Region-0", "Color, Closed-captioned, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Twentieth Century Fox Home Video", "200307", "The League of Extraordinary Gentlemen (Widescreen Edition)", "Sean Connery - Peta Wilson - Tony Curran - Stuart Townsend - Shane West - Jason Flemyng", "BUR-2"));

        titles.add(new DVDInfo("B00000F5B5", "\u00c9mile Gaudreault", "Region-1", "Widescreen, Dolby, DTS Surround Sound", "R (Restricted)", "Columbia Tristar Hom", "200301", "Mambo Italiano", "Luke Kirby - Ginette Reno - Paul Sorvino - Peter Miller (XII)", "CDG-1"));
        titles.add(new DVDInfo("B00003CXCZ", "Hayao Miyazaki", "Region-0", "Animated, Color", "G (General Audience)", "Twentieth Century Fox Home Video", "200408", "My Neighbor Totoro", "Hitoshi Takagi - Noriko Hidaka", "CDG-1"));
        titles.add(new DVDInfo("B00005JKC3", "Ang Lee", "Region-0", "Color, Closed-captioned, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Universal Studios", "200306", "Hulk (Widescreen Special Edition)", "Eric Bana - Jennifer Connelly - Sam Elliott", "CDG-1"));
        titles.add(new DVDInfo("B00005JLQN", "Joel Schumacher", "Region-2", "Color, Closed-captioned, Widescreen, Dolby", "R (Restricted)", "Twentieth Century Fox Home Video", "200304", "Phone Booth", "Colin Farrell - Kiefer Sutherland - Forest Whitaker - Radha Mitchell - Katie Holmes", "CDG-1"));
        titles.add(new DVDInfo("B00005JLRQ", "David Dobkin", "Region-0", "Color, Closed-captioned, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Buena Vista Home Vid", "200302", "Shanghai Knights", "Jackie Chan - Owen Wilson - Fann Wong", "CDG-1"));

        titles.add(new DVDInfo("B00005JLI6", "Gary Hardwick", "Region-1", "Color, Closed-captioned, Widescreen, Dolby", "R (Restricted)", "Universal Studios", "200302", "Deliver Us From Eva (Widescreen Edition)", "LL Cool J - Gabrielle Union - Essence Atkins", "AMS-1"));
        titles.add(new DVDInfo("B00005JLQN", "Joel Schumacher", "Region-2", "Color, Closed-captioned, Widescreen, Dolby", "R (Restricted)", "Twentieth Century Fox Home Video", "200304", "Phone Booth", "Colin Farrell - Kiefer Sutherland - Forest Whitaker - Radha Mitchell - Katie Holmes", "AMS-1"));
        titles.add(new DVDInfo("B00005JLZK", "David R. Ellis", "Region-1", "Widescreen, Dolby, DTS Surround Sound", "R (Restricted)", "New Line Home Entertainment", "200301", "Final Destination 2 (Infinifilm Edition)", "A.J. Cook - Ali Larter - Tony Todd", "AMS-1"));
        titles.add(new DVDInfo("B00005JLZW", "Peyton Reed", "Region-1", "Color, Closed-captioned, Widescreen, Dolby", "PG-13 (Parental Guidance Suggested)", "Twentieth Century Fox Home Video", "200305", "Down with Love (Widescreen Edition)", "Ren\u00e9e Zellweger - Ewan McGregor - David Hyde Pierce", "AMS-1"));
        titles.add(new DVDInfo("B00005JM0B", "Jonathan Mostow", "Region-0", "Color, Closed-captioned, Widescreen, Dolby", "R (Restricted)", "Warner Home Video", "200307", "Terminator 3 - Rise of the Machines (Widescreen Edition)", "Arnold Schwarzenegger - Nick Stahl - Kristanna Loken", "AMS-1"));

    }

    public List<DVDInfo> getDVDsByLocationID(String locationID) {
        List<DVDInfo> result = new ArrayList<DVDInfo>();
        if (locationID == null) {
            return result;
        }
        for (DVDInfo current : titles) {
            if (locationID.equals(current.getLocationID())) {
                result.add(current);
            }
        }
        return Collections.unmodifiableList(result);
    }

    public DVDInfo getDVDByID(String id) {
        if (id == null) {
            return null;
        }

        for (DVDInfo title : titles) {
            if (id.equals(title.getId())) {
                return title;
            }
        }
        return null;
    }

    public List<DVDInfo> searchDVDs(String title, String locationID) {
        List<DVDInfo> result = new ArrayList<DVDInfo>();
        for (DVDInfo dvdTitle : titles) {
            String currentTitle = dvdTitle.getTitle();
            if (currentTitle.indexOf(title) >= 0 &&
                    dvdTitle.getLocationID().equals(locationID)) {
                result.add(dvdTitle);
            }
        }
        return Collections.unmodifiableList(result);
    }
}
