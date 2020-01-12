package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Note;

public interface NoteService {

    public List<Note> getNotes();
    public Note getNoteById(int id);
    public void saveNote(Note note);
    public void deleteNote(int id);
}
