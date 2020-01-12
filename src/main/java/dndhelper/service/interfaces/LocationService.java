package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Location;

public interface LocationService {

    public List<Location> getLocations();
    public Location getLocationById(int id);
    public void saveLocation(Location location);
    public void deleteLocation(int id);
}
