package note;
import entity.Note;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    
    private final Map<Long,Note> notes = new HashMap<Long, Note>();

    // create new note
public Note add(Note note) {
    if (notes.containsKey(uniId())) {
        throw new IllegalStateException("A value for "+uniId()+" is already present.");
    }
    else  {
        note.setId(uniId());
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        notes.put(note.getId(), note);
    }
    return note;
}

// get all notes
public List<Note> listAll(){
    Note note = new Note();
    List allList = new ArrayList<>(notes.entrySet());
    return allList;
}


// delete note by id
public void deleteById(long id){
        if(notes.containsKey(id)){
    notes.remove(id);
        }
        else System.out.println("ID not found");
}

// update note
    public void update(long id, String title, String content){
        Note note = new Note();
   if(notes.containsKey(id)) {
       note.setId(id);
       note.setTitle(title);
       note.setContent(content);
       notes.put(id, note);
   }
   else throw new IllegalStateException("There is no value to update for key '" + id + "'.");
}

// get note by id
    public  Note getById(long id) {
        return notes.get(id);
    }

//method create Id
    public static long uniId(){
        long a =  ( long ) (Math.random() * Math.abs(900000000L));
        long b = 1;
        return a*b;

    }


}












