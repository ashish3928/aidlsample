package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<String> dataList = new ArrayList<String>() {
        {
            add("asdasdasdas");
            add("adgdgdfgdfvdf");
            add("jfrvohrjcofiexe");
            add("jramcmforim");
            add("oprrvaoecnronw");
            add("oiejrcoqeiow");
            add("inoceuvrhngnec");
            add("ocnwfehnewouvne");
            add("cjwijwovinfrncwwowm");
            add("asdasdasdas");
            add("adgdgdfgdfvdf");
            add("jfrvohrjcofiexe");
            add("jramcmforim");
            add("oprrvaoecnronw");
            add("oiejrcoqeiow");
            add("inoceuvrhngnec");
            add("ocnwfehnewouvne");
            add("cjwijwovinfrncwwowm");
            add("asdasdasdas");
            add("adgdgdfgdfvdf");
            add("jfrvohrjcofiexe");
            add("jramcmforim");
            add("oprrvaoecnronw");
            add("oiejrcoqeiow");
            add("inoceuvrhngnec");
            add("ocnwfehnewouvne");
            add("cjwijwovinfrncwwowm");
            add("asdasdasdas");
            add("adgdgdfgdfvdf");
            add("jfrvohrjcofiexe");
            add("jramcmforim");
            add("oprrvaoecnronw");
            add("oiejrcoqeiow");
            add("inoceuvrhngnec");
            add("ocnwfehnewouvne");
            add("cjwijwovinfrncwwowm");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),LinearLayoutManager.VERTICAL));
    }
}