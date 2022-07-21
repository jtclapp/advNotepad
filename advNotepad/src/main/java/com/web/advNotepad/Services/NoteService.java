package com.web.advNotepad.Services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.web.advNotepad.models.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NoteService
{
    private Firestore firestore;
    private CollectionReference getNoteCollection() {
        firestore = FirestoreClient.getFirestore();
        return firestore.collection("Notes");
    }
    public void createNote(Note note) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> apiFuture =
                getNoteCollection().document().set(note);
        apiFuture.get();
        addIdToNote(note);
    }
    public void addIdToNote(Note note) throws ExecutionException, InterruptedException {
        CollectionReference noteCollection = getNoteCollection();
        ApiFuture<QuerySnapshot> querySnapshot = noteCollection.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Note note1 = doc.toObject(Note.class);
            assert note1 != null;
            if(note1.getCreator().equals(note.getCreator()) && note1.getCreateDate().equals(note.getCreateDate()))
            {
                note.setId(doc.getId());
            }
        }
        ApiFuture<WriteResult> apiFuture = getNoteCollection().document(getNoteId(note.getCreateDate(),note.getCreator())).update("id",note.getId());
        apiFuture.get();
    }
    public String getNoteId(String dateTime,String creator) throws ExecutionException, InterruptedException {
        CollectionReference notes = getNoteCollection();
        ApiFuture<QuerySnapshot> querySnapshot = notes.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Note note = doc.toObject(Note.class);
            assert note != null;
            if(note.getCreateDate().equals(dateTime) && note.getCreator().equals(creator))
            {
                return doc.getId();
            }
        }
        return "";
    }
    public List<Note> getAllUserNotes(String username) throws ExecutionException, InterruptedException {
        List<Note> notesList = new ArrayList<>();
        firestore = FirestoreClient.getFirestore();
        CollectionReference notes = firestore.collection("Notes");
        ApiFuture<QuerySnapshot> querySnapshot = notes.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Note note = doc.toObject(Note.class);
            assert note != null;
            if(note.getCreator().equals(username))
            {
                notesList.add(note);
            }
        }
        return notesList;
    }
    public Note getNote(String id,String username) throws ExecutionException, InterruptedException {
        List<Note> noteList = getAllUserNotes(username);
        for(int i = 0; i <= noteList.size()-1; i++)
        {
            if (noteList.get(i).getId().equals(id)) {
                return noteList.get(i);
            }
        }
        return new Note();
    }
}
