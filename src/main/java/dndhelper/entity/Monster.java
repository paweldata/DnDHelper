package dndhelper.entity;

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

@Entity
@Table(name = "monster")
public class Monster {
    
    @Id
    @Column(name = "name") private String name;
    
    @Column(name = "hit_points") private int hitPoitns;
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
    
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,
                    CascadeType.MERGE,})
    @JoinTable(
            name="monster_location",
            joinColumns=@JoinColumn(name="name_monster"),
            inverseJoinColumns=@JoinColumn(name="id_location")
            )
    private List<Location> locations;
    
    public Monster() {}
    
    public Monster(String name, int hitPoitns, byte[] image) {
        super();
        this.name = name;
        this.hitPoitns = hitPoitns;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHitPoitns() {
        return hitPoitns;
    }
    
    public void setHitPoitns(int hitPoitns) {
        this.hitPoitns = hitPoitns;
    }
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
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
}
