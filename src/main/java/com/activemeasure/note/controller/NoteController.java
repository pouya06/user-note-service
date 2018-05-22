package com.activemeasure.note.controller;

import com.activemeasure.note.entity.Note;
import com.activemeasure.note.entity.User;
import com.activemeasure.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> addOrUpdateNoteToUser(@PathVariable("id") long id, @RequestBody Note note){
        return noteService.addOrUpdateNoteToUser(id, note);
    }
}
