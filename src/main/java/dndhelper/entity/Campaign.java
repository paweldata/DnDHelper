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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id") private int id;
    @Column(name = "name") private String name;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy = "campaign")
    private List<Npc> npcs;
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "campaign")
    private List<Location> locations;
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "campaign")
    private List<Note> notes;
    
    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,})
    @JoinColumn(name="dungeon_master_nick")
    private DungeonMaster dungeonMaster;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,
                    CascadeType.MERGE,})
    @JoinTable(
            name="character_campaign",
            joinColumns=@JoinColumn(name="id_campaign"),
            inverseJoinColumns=@JoinColumn(name="id_character")
            )
    private List<Character> characters;
    
    public Campaign() {}
    
    public Campaign(int id, String name, DungeonMaster dungeonMaster) {
        super();
        this.id = id;
        this.name = name;
        this.dungeonMaster = dungeonMaster;
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

    public DungeonMaster getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(DungeonMaster dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }
    
    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
    
    public void addCharacter(Character character) {
        if (this.characters == null)
            this.characters = new ArrayList<Character>();
        this.characters.add(character);
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }
    
    public void addNpc(Npc npc) {
        if (this.npcs == null)
            this.npcs = new ArrayList<Npc>();
        this.npcs.add(npc);
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

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
    public void addNote(Note note) {
        if (this.notes == null)
            this.notes = new ArrayList<Note>();
        this.notes.add(note);
    }
}
