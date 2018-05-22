package com.activemeasure.note.service;

import com.activemeasure.note.dto.NoteDTO;
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
    public User addOrUpdateNoteToUser(long id, NoteDTO noteDTO) {
        Optional<User> user = userRepository.findById(id);

        if (user.get().getEmail() != null) {
            Note savingNote = new Note();
            savingNote.setTitle(noteDTO.getTitle());
            savingNote.setNote(noteDTO.getNote());
            savingNote.setUser(user.get());

            noteRepository.save(savingNote);

            return user.get();
        }

        return null;
    }
}
