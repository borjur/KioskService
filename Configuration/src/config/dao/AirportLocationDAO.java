package config.dao;

import config.AirportLocation;

import java.util.List;


public interface AirportLocationDAO {
    public List<AirportLocation> getLocations();
    public AirportLocation getLocationByID(String id);
}
