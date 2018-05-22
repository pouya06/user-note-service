package com.activemeasure.note.service;

import com.activemeasure.note.entity.Note;
import com.activemeasure.note.entity.User;
import com.activemeasure.note.repository.NoteRepository;
import com.activemeasure.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class NoteService {

    private UserRepository userRepository;
    private NoteRepository noteRepository;

    @Autowired
    public NoteService(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @Transactional
    public ResponseEntity<User> addOrUpdateNoteToUser(long id, Note note) {
        Optional<User> user = userRepository.findById(id);

        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Note savingNote = new Note();
        savingNote.setTitle(note.getTitle());
        savingNote.setNote(note.getNote());
        savingNote.setUser(user.get());

        noteRepository.save(savingNote);


        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }
}
