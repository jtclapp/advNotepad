package com.web.advNotepad.Services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.web.advNotepad.models.Group;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@Service
public class GroupService
{
    private Firestore firestore;

    private CollectionReference getGroupCollection() {
        firestore = FirestoreClient.getFirestore();
        return firestore.collection("Groups");
    }
    public void createGroup(Group group) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> apiFuture =
                getGroupCollection().document().set(group);
        apiFuture.get();
        addIdToGroup(group);
    }
    public void addIdToGroup(Group group) throws ExecutionException, InterruptedException {
        CollectionReference groupCollection = getGroupCollection();
        ApiFuture<QuerySnapshot> querySnapshot = groupCollection.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Group group1 = doc.toObject(Group.class);
            assert group1 != null;
            if(group1.getCreator().equals(group.getCreator()) && group1.getGroup_name().equals(group.getGroup_name()))
            {
                group.setId(doc.getId());
            }
        }
        ApiFuture<WriteResult> apiFuture = getGroupCollection().document(getGroupId(group.getGroup_name(),group.getCreator())).update("id",group.getId());
        apiFuture.get();
    }
    public String getGroupId(String group_name,String creator) throws ExecutionException, InterruptedException {
        CollectionReference groups = getGroupCollection();
        ApiFuture<QuerySnapshot> querySnapshot = groups.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            Group group = doc.toObject(Group.class);
            assert group != null;
            if(group.getGroup_name().equals(group_name) && group.getCreator().equals(creator))
            {
                return doc.getId();
            }
        }
        return "";
    }
}
