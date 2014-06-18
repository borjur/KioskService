package advanced.dao;

import advanced.AirportLocation;

import java.util.List;


public interface AirportLocationDAO {
    public List<AirportLocation> getLocations();
    public AirportLocation getLocationByID(String id);
}
