package com.example.demo2513.service;


import com.example.demo2513.entity.Product;

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
public class ProcedureService {
    private static final String COLLECTION_NAME = "products";
    public String saveProcedure(Product product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getId()).set(product);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public List<Product> getProductDetail() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Product> productsList = new ArrayList<>();
        Product product = null;
        while (iterator.hasNext())
        {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future =documentReference1.get();
            DocumentSnapshot document = future.get();
            product = document.toObject(Product.class);
            productsList.add(product);
        }
        return productsList;


    }
    public Product getProductDetailByname(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Product product = null;
        if(document.exists()){
            product=document.toObject(Product.class);
            return product;
        }
        else
            return null;

    }

    public String updateProcedure(Product product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getId()).set(product);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public String deleteProcedure(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(name).delete();
        return name+"has been delete";

    }
}
