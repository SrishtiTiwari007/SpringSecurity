package com.secure.notes.service;

import com.secure.notes.entity.Note;
import com.secure.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository repository;

    @Override
    public Note createNote(String userName, String content){
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(userName);
        Note savedNote = repository.save(note);
        return savedNote;
    }

    @Override
    public Note updateNote(Long id, String content, String userName){
        Note note = repository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        note.setContent(content);
        Note updatedNote = repository.save(note);
        return updatedNote;
    }

    @Override
    public void deleteNote(Long id, String userName){
        repository.deleteById(id);
    }

    @Override
    public List<Note> getNotes(String userName){
        List<Note> list = repository.findByOwnerUsername(userName);
        return list;
    }
}
