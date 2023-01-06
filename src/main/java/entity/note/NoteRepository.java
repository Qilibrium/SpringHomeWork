package entity.note;

import entity.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NoteRepository {

    List<Note> notesList = new ArrayList<>();
   final Map<Long,Note> notes = new HashMap<Long, Note>();
}

