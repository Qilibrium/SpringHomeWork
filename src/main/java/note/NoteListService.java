package note;

import entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NoteListService {

    List<Note> notesList = new ArrayList<>();

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

    public Note getById(long id) {
        Note note = new Note();
        for (Note note1 : notesList) {
            if (note1.getId() == (id)) {
                return note1;
            }
        }
        return note;
    }

   public void deleteById(long id) {
       Note note = new Note();
       for (Note note1 : notesList) {
           if (note1.getId() == (id)){
               notesList.remove(note1);
           }
       }
       }


    public static long uniId(){
        long a =  ( long ) (Math.random() * Math.abs(900000000L));
        long b = 1;
        return a*b;

    }
}
