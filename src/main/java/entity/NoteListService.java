package entity;


import entity.Note;
import entity.note.NoteRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteListService implements NoteRepository {



   public Note add(Note note){
        note.setId(uniId());
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        notesList.add(note);
        return note;
    }

   public List<Note> listAll(){
       return notesList;
    }

    public void update(Note note) {
        for (Note note1 : notesList) {
            if (note1.getId() == note.getId()) {
                note1.setTitle(note.getTitle());
                note1.setContent(note.getContent());
            }
            System.out.println("note1 = " + note1);
        }
    }

    public Note getByIdLambda(long id){
       return notesList.stream().filter(note -> note.getId()==id).findAny().orElseThrow(null);
    }

   public void deleteById(long id) {
       Note delete = notesList.stream().filter(note -> note.getId() == id).findAny().orElseThrow(null);
       notesList.remove(delete);

   }


    public static long uniId(){
        long a =  ( long ) (Math.random() * Math.abs(900000000L));
        long b = 1;
        return a*b;

    }
}
