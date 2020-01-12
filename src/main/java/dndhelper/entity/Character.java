package dndhelper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_character")
public class Character {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id") private int id;
    
    @Column(name = "level") private int level;
    @Column(name = "exp") private int exp;
    
    @Column(name = "armor_class") private int armorClass;
    @Column(name = "hitpoints") private int hitPoints;
    @Column(name = "speed") private int speed;
    
    @Column(name = "name") private String name;
    @Column(name = "race") private String race; //TODO: enum
    @Column(name = "class") private String charClass; //TODO: enum
    @Column(name = "allignment") private String allignment; //TODO: enum
    @Column(name = "background") private String background;
    
    @Column(name = "strength") private int strength;
    @Column(name = "dexternity") private int dexternity;
    @Column(name = "constitution") private int constitution;
    @Column(name = "intelligence") private int intelligence;
    @Column(name = "wisdom") private int wisdom;
    @Column(name = "charisma") private int charisma;
    
    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,})
    @JoinColumn(name="nick_player")
    private Player player;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,
                    CascadeType.MERGE,})
    @JoinTable(
            name="character_campaign",
            joinColumns=@JoinColumn(name="id_character"),
            inverseJoinColumns=@JoinColumn(name="id_campaign")
            )
    private List<Campaign> campaigns;
    
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,
                    CascadeType.MERGE,})
    @JoinTable(
            name="item_character",
            joinColumns=@JoinColumn(name="id_character"),
            inverseJoinColumns=@JoinColumn(name="id_item")
            )
    private List<Item> items;
    
    public Character() {}

    public Character(int id, int level, int exp, int armorClass, int hitPoints, int speed, String name, String race,
            String charClass, String allignment, String background, int strength, int dexternity, int constitution,
            int intelligence, int wisdom, int charisma, Player player) {
        super();
        this.id = id;
        this.level = level;
        this.exp = exp;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.allignment = allignment;
        this.background = background;
        this.strength = strength;
        this.dexternity = dexternity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getAllignment() {
        return allignment;
    }

    public void setAllignment(String allignment) {
        this.allignment = allignment;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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
    
    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
    
    public void addCampaign(Campaign campaign) {
        if (this.campaigns == null)
            this.campaigns = new ArrayList<Campaign>();
        this.campaigns.add(campaign);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void addItem(Item item) {
        if (this.items == null)
            this.items = new ArrayList<Item>();
        this.items.add(item);
    }
}
