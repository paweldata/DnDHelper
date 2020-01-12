package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.LocationDAO;
import dndhelper.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Location> getLocations() {
        // TODO Auto-generated method stub
        return null;
    }

    public Location getLocationById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveLocation(Location location) {
        // TODO Auto-generated method stub

    }

    public void deleteLocation(int id) {
        // TODO Auto-generated method stub

    }

}
