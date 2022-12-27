package note;
import entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class NoteService {

    //create unique code

    private final Map<Long,Note> notes = new HashMap<Long, Note>();

    // create new note
public Note add(Note note) {

    note.setId(uniId());
    notes.put(note.getId(), new Note( note.getTitle(), note.getContent()));
    System.out.println("note = " + note);
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
       notes.get(id);
            note.setTitle(title);
            note.setContent(content);
            notes.put(uniId(), note);
        }
   else if(!notes.containsKey(id)) {
       throw new IllegalStateException("There is no value to update for key '" + id + "'.");
   }
}

// get note by id
    public  Note getById(long id) {
        return notes.get(id);
    }
    
//method create Id
    public static final long uniId(){
        long a =  ( long ) (Math.random() * Math.abs(900000000L));
        long b = 1;
        long uniIdCode = a*b;
        return uniIdCode;

    }


}












