package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.LocationDAO;
import dndhelper.entity.Location;
import dndhelper.entity.Monster;
import dndhelper.service.interfaces.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;
    
    @Transactional
    public List<Location> getLocations() {
        return this.locationDAO.getLocations();
    }

    @Transactional
    public Location getLocationById(int id) {
        return this.locationDAO.getLocationById(id);
    }

    @Transactional
    public void saveLocation(Location location) {
        this.locationDAO.saveLocation(location);
    }

    @Transactional
    public void deleteLocation(int id) {
        this.locationDAO.deleteLocation(id);
    }

	@Override
	@Transactional
	public List<Monster> getMonstersByLocation(int locationId) {
		Location location = locationDAO.getLocationById(locationId);
		List <Monster> monsters = location.getMonsters();
		for(Monster tempMonster : monsters);
		return monsters;
	}

}
