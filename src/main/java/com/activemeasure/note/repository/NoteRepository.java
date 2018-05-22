package com.activemeasure.note.repository;

import com.activemeasure.note.entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
    
}
