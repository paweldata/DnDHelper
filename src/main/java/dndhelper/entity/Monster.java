package dndhelper.entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "monster")
public class Monster {
    
    @Id
    @Column(name = "id") private int id;
    
    @Column(name = "name") private String name;
    @Column(name = "hit_points") private int hitPoints;
    @Column(name = "armor_class") private int armorClass;
    @Column(name = "speed") private int speed;
    @Column(name = "challenge") private float challenge;
    
    @Column(name = "strength") private int strength;
    @Column(name = "dexternity") private int dexternity;
    @Column(name = "constitution") private int constitution;
    @Column(name = "intelligence") private int intelligence;
    @Column(name = "wisdom") private int wisdom;
    @Column(name = "charisma") private int charisma;
    
    @Column(name = "image") private byte[] image;
    
    @ManyToMany(mappedBy="monsters")
    private List<Location> locations;
    
    public Monster() {}
    

    
    public Monster(int id, String name, int hitPoints, int armorClass, int speed, float challenge, int strength,
			int dexternity, int constitution, int intelligence, int wisdom, int charisma, byte[] image,
			List<Location> locations) {
		super();
		this.id = id;
		this.name = name;
		this.hitPoints = hitPoints;
		this.armorClass = armorClass;
		this.speed = speed;
		this.challenge = challenge;
		this.strength = strength;
		this.dexternity = dexternity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.image = image;
		this.locations = locations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }
    
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    
    public String getImage() {
    	if(image != null) {
    		byte[] encodeBase64 = Base64.encodeBase64(image);
    		String base64Encoded;
    		try {
    			base64Encoded = new String(encodeBase64, "UTF-8");
    			return base64Encoded;
    		} catch (UnsupportedEncodingException e) {
    			System.out.println("Monster linia ok 75");
    			e.printStackTrace();
    		}
    	}
		return "";
    }
    
    public void setImage(MultipartFile image) {
        try {
			this.image = image.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexternity() {
        return dexternity;
    }

    public void setDexternity(int dexternity) {
        this.dexternity = dexternity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    
    public void addLocation(Location location) {
        if (this.locations == null)
            this.locations = new ArrayList<Location>();
        this.locations.add(location);
    }

	public float getChallenge() {
		return challenge;
	}

	public void setChallenge(float challenge) {
		this.challenge = challenge;
	}
}
