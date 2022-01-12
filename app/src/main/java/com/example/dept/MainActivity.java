package com.example.dept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.dept.adapter.CustomAdapter;
import com.example.dept.model.Member;
import com.example.dept.model.MemberSub;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }

    private void refreshAdapter(ArrayList<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Member> prepareMemberList() {
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            if(i == 1 || i == 10){
                members.add(new Member("Full name" + i, prepareSubMembers()));
            } else {
                members.add(new Member("Full name" + i, null));
            }
        }
        return members;

    }





    private ArrayList<MemberSub> prepareSubMembers(){
        ArrayList<MemberSub> memberSubs = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            memberSubs.add(new MemberSub());
        }
        return memberSubs;
    }
    
}