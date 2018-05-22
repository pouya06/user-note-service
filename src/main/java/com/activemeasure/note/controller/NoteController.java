package com.activemeasure.note.controller;

import com.activemeasure.note.dto.NoteDTO;
import com.activemeasure.note.dto.UserDTO;
import com.activemeasure.note.entity.User;
import com.activemeasure.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/user/{id}/note", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> addOrUpdateNoteToUser(@PathVariable("id") long id, @RequestBody NoteDTO noteDTO){
        UserDTO userDTO = new UserDTO();
        User user = noteService.addOrUpdateNoteToUser(id, noteDTO);

        if(user == null){
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDTO.setEmail(user.getEmail());

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
