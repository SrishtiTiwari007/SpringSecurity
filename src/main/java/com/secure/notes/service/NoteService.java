package com.secure.notes.service;

import com.secure.notes.entity.Note;

import java.util.List;

public interface NoteService {
    Note createNote(String userName, String content);

    Note updateNote(Long id, String content, String userName);

    void deleteNote(Long id, String userName);

    List<Note> getNotes(String userName);
}
