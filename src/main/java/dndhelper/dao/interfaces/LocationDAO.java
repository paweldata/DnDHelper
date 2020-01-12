package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Location;

public interface LocationDAO {

    public List<Location> getLocations();
    public Location getLocationById(int id);
    public void saveLocation(Location location);
    public void deleteLocation(int id);
}
