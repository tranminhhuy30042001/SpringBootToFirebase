package com.example.demo2513.service;

import com.example.demo2513.entity.Sold;
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
public class SoldService {
    private static final String COLLECTION_NAME = "sold";
    public String saveProcedure(Sold cart) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(cart.getAddress()).set(cart);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public List<Sold> getSoldDetail() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Sold> cartsList = new ArrayList<>();
        Sold cart = null;
        while (iterator.hasNext())
        {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future =documentReference1.get();
            DocumentSnapshot document = future.get();
            cart = document.toObject(Sold.class);
            cartsList.add(cart);
        }
        return cartsList;


    }
    public Sold getSoldDetailByname(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Sold cart = null;
        if(document.exists()){
            cart=document.toObject(Sold.class);
            return cart;
        }
        else
            return null;

    }

    public String updateProcedure(Sold cart) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(cart.getAddress()).set(cart);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public String deleteProcedure(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(name).delete();
        return name+"has been delete";

    }
}
