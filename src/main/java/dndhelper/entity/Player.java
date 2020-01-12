package dndhelper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
    
    @Id
    @Column(name = "nick") private String nick;
    @Column(name = "mail") private String mail;
    @Column(name = "password") private String password;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy = "player")
    private List<Character> characters;
    
    public Player() {}
    
    public Player (String nick, String mail, String password) {
        super();
        this.nick = nick;
        this.mail = mail;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
