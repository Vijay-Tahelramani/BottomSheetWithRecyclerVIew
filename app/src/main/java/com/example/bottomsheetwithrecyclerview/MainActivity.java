package com.example.bottomsheetwithrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button toggleBottomSheet;

    //BottomSheet Variables
    private BottomSheetBehavior bottomSheetBehavior;
    private static final String TAG = "BottomSheetTAG";
    private ConstraintLayout bottomSheetLayout;

    //RecyclerView Variables
    private ArrayList<String> list;
    private RecyclerView recyclerView;
    private RecAdapter recAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind UI
        toggleBottomSheet = findViewById(R.id.toggleBottomSheet);

        // get the bottom sheet view
        bottomSheetLayout = findViewById(R.id.bottomSheetLayout);

        // init the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
        // set callback for changes
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:

                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:

                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:

                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:

                        break;
                    case BottomSheetBehavior.STATE_SETTLING:

                        break;
                }
                Log.d(TAG, "onStateChanged: " + newState);
            }
            @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

        toggleBottomSheet.setOnClickListener(view -> {
            if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        //Config Recycler View
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add("Text1");
        list.add("Text2");
        list.add("Text3");
        list.add("Text4");
        list.add("Text5");
        list.add("Text6");
        list.add("Text7");
        list.add("Text8");
        list.add("Text9");
        list.add("Text10");
        list.add("Text11");
        list.add("Text12");
        list.add("Text13");
        list.add("Text14");
        list.add("Text15");
        recAdapter = new RecAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recAdapter);

    }
}