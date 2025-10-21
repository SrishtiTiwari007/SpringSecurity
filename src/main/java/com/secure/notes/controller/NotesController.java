package com.secure.notes.controller;

import com.secure.notes.entity.Note;
import com.secure.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService service;

    @PostMapping
    public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String userName = userDetails.getUsername();
        System.out.println("User Details: "+userName);
        return service.createNote(userName,content);
    }

    @GetMapping
    public List<Note> getNotes(@AuthenticationPrincipal UserDetails userDetails){
        String userName = userDetails.getUsername();
        System.out.println("User Details: "+userName);
        return service.getNotes(userName);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String userName = userDetails.getUsername();
        System.out.println("User De0tails: "+userName);
        return service.updateNote(id,content,userName);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        String userName = userDetails.getUsername();
        System.out.println("User Details: "+userName);
        service.deleteNote(id, userName);
    }
}