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
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "name") private String name;
    
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,
                    CascadeType.MERGE,})
    @JoinTable(
            name="item_character",
            joinColumns=@JoinColumn(name="id_item"),
            inverseJoinColumns=@JoinColumn(name="id_character")
            )
    private List<Character> characters;
    
    public Item() {}
    
    public Item(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
