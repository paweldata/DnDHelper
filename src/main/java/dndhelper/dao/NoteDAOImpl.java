package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.NoteDAO;
import dndhelper.entity.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Note> getNotes() {
        // TODO Auto-generated method stub
        return null;
    }

    public Note getNoteById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveNote(Note note) {
        // TODO Auto-generated method stub

    }

    public void deleteNote(int id) {
        // TODO Auto-generated method stub

    }

}
