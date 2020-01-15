package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.LocationDAO;
import dndhelper.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Location> getLocations() {
      Session session = this.sessionFactory.getCurrentSession();
      List<Location> locationList = session.createQuery("FROM location", Location.class).list();
      
      return locationList;
    }

    public Location getLocationById(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      Location location = session.get(Location.class, id);
      
      return location;
    }

    public void saveLocation(Location location) {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(location);
    }

    public void deleteLocation(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      
      Query deleteQuery = session.createQuery(
          "DELETE FROM location WHERE location.id LIKE :locationID");
      deleteQuery.setParameter("locationId", id);
      deleteQuery.executeUpdate();
    }

}
