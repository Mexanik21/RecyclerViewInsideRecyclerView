package com.example.dept.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dept.R;
import com.example.dept.model.MemberSub;

import java.util.ArrayList;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList <MemberSub> memberSubs;

    public CustomSubAdapter(Context context, ArrayList<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dept_layout_sub_view,parent,false);
        return new CustomSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MemberSub memberSub = memberSubs.get(position);

    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    private class CustomSubViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CustomSubViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
