package note;

import entity.Note;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service

public class NoteService {

    //create unique code
    private final long idCode = ( long ) (Math.random() * Math.abs(900000000L));
    private final Map<Long,Note> notes = new HashMap<Long, Note>();

// create new note
public Map<Long, Note> add(String title, String content){
    Note note = new Note();
    Long id = idCode;
    if (notes.containsKey(id)) {
        throw new IllegalStateException("A value for "+id+" is already present.");
    }
    else  {
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        notes.put(id, note);
    }
    return notes;
}
// get all notes
    public  Map<Long, Note> listAll(){
        return notes;
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
       notes.get(id);
            note.setTitle(title);
            note.setContent(content);
            notes.put(idCode, note);
        }
   else if(!notes.containsKey(id)){
       throw new IllegalStateException("There is no value to update for key '"+id+"'.");
        } else if (notes.values() == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
    }

// get note by id
    public  Note getById(long id) {
        return notes.get(id);
    }


    }












