package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.NoteDAO;
import dndhelper.entity.Note;
import dndhelper.service.interfaces.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;
    
    @Transactional
    public List<Note> getNotes() {
        return this.noteDAO.getNotes();
    }

    @Transactional
    public Note getNoteById(int id) {
        return this.noteDAO.getNoteById(id);
    }

    @Transactional
    public void saveNote(Note note) {
        this.noteDAO.saveNote(note);
    }

    @Transactional
    public void deleteNote(int id) {
        this.noteDAO.deleteNote(id);
    }

}
