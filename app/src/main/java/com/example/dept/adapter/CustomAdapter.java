package com.example.dept.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dept.R;
import com.example.dept.model.Member;
import com.example.dept.model.MemberSub;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    Context context;
    ArrayList<Member> members;

    public CustomAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if(members.get(position).getMemberSubs() != null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM_LIST){
            View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dept_layout_list,parent,false);
            return new CustomListHolder(holder);
        }
        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dept_layout_view,parent,false);
        return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof CustomViewHolder){

        }

        if(holder instanceof CustomListHolder){
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));
            ArrayList<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdapter(recyclerView, memberSubs);
        }

    }

    private void refreshSubAdapter(RecyclerView recyclerView, ArrayList<MemberSub> memberSubs) {
        CustomSubAdapter adapter = new CustomSubAdapter(context,memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CustomViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    private class CustomListHolder extends RecyclerView.ViewHolder {
        public View view;
        RecyclerView recyclerView;
        public CustomListHolder(View v) {
            super(v);
            view = v;
            recyclerView = view.findViewById(R.id.recyclerSubView);
        }
    }
}
