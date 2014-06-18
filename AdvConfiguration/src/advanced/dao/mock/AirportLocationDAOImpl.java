package advanced.dao.mock;

import advanced.AirportLocation;
import advanced.dao.AirportLocationDAO;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


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
