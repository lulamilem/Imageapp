package com.example.admin.imageapp;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loux on 20-November-2017.
 */

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    activity_swipe activity_swipe;
    //FIREBASE CONNECTION
    private DatabaseReference database;
    private StorageReference mStorageReference;
    private ProgressDialog mDialog;

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        activity_swipe =new activity_swipe(this);
        viewPager.setAdapter(activity_swipe);


        ArrayList<Object> catalogList = new ArrayList<>();
        final List<Image> image = new ArrayList<>();
        DatabaseReference mDatabase;

// ...
//        mDatabase = FirebaseDatabase.getInstance().getReference();


        database = FirebaseDatabase.getInstance().getReference().child("slide").child("Regus").child("pictures");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                RecyclerView ListViewCatalog = findViewById(R.id.recycler_view);
                ImagesAdapter adapter = new ImagesAdapter(MainActivity.this, image);
//                    Toast.makeText(CatalogActivity.this, ""+catalog.getCatalogtitle(), Toast.LENGTH_SHORT).show();
                RecyclerView.LayoutManager layoutManager = null;
                ListViewCatalog.setLayoutManager(layoutManager);

                ListViewCatalog.setAdapter(adapter);



            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}


