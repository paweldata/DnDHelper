package dndhelper.service.interfaces;

import java.util.Collection;
import java.util.List;

import dndhelper.entity.Location;
import dndhelper.entity.Monster;

public interface LocationService {

    public List<Location> getLocations();
    public Location getLocationById(int id);
    public void saveLocation(Location location);
    public void deleteLocation(int id);
	public List <Monster> getMonstersByLocation(int locationId);
}
