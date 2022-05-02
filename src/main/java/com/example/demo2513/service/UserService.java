package com.example.demo2513.service;

import com.example.demo2513.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static final String COLLECTION_NAME = "users";
    public String saveProcedure(User product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getUsername()).set(product);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public List<User> getUserDetail() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<User> productsList = new ArrayList<>();
        User product = null;
        while (iterator.hasNext())
        {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future =documentReference1.get();
            DocumentSnapshot document = future.get();
            product = document.toObject(User.class);
            productsList.add(product);
        }
        return productsList;


    }
    public User getUserDetailByname(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User product = null;
        if(document.exists()){
            product=document.toObject(User.class);
            return product;
        }
        else
            return null;

    }

    public String updateProcedure(User product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getUsername()).set(product);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public String deleteProcedure(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(name).delete();
        return name+"has been delete";

    }
}
