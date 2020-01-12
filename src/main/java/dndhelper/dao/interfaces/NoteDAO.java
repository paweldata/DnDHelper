package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Note;

public interface NoteDAO {

    public List<Note> getNotes();
    public Note getNoteById(int id);
    public void saveNote(Note note);
    public void deleteNote(int id);
}
