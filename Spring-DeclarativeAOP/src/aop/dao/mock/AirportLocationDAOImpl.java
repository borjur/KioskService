package aop.dao.mock;

import aop.AirportLocation;
import aop.dao.AirportLocationDAO;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p/>
 * CREATE VIEW AIRPORT_LOCATIONS (
 * LOCATION_ID,
 * AIRPORT_CODE,
 * AIRPORT_NAME,
 * CITY,
 * COUNTRY,
 * TERMINAL,
 * LOCATION_INFORMATION) AS SELECT DISTINCT
 * LOCATION.LOCATION_ID,
 * LOCATION.AIRPORT_CODE,
 * AIRPORT.AIRPORT_NAME,
 * AIRPORT.CITY,
 * AIRPORT.COUNTRY,
 * LOCATION.TERMINAL,
 * LOCATION.LOCATION_INFORMATION
 * FROM LOCATION AS LOCATION INNER JOIN AIRPORT AS AIRPORT
 * ON LOCATION.AIRPORT_CODE = AIRPORT.AIRPORT_CODE
 * </p>
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

public class AirportLocationDAOImpl implements AirportLocationDAO {
    private static final List<AirportLocation> locations;

    static {
        locations = new ArrayList<AirportLocation>();
        locations.add(new AirportLocation("BUR-2", "BUR", "Burbank Glendale Pasadena Airport", "Burbank, CA", "USA", "Terminal-1", "Inside the Business Lounge"));
        locations.add(new AirportLocation("CDG-1", "CDG", "Charles De Gaulle", "Paris", "France", "Terminal-1", "At the airport gift-shop"));
        locations.add(new AirportLocation("AMS-1", "AMS", "Schiphol", "Amsterdam", "Netherlands", "Main Terminal", "Next to Delta check-in"));
    }

    public List<AirportLocation> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    public AirportLocation getLocationByID(String id) {
        for (AirportLocation airportLocation : locations) {
            if (airportLocation.getLocationID().equals(id)) {
                return airportLocation;
            }
        }
        return null;
    }
}
