package com.example.nsc.firebase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nsc.firebase.R;
import com.example.nsc.firebase.model.Comment;

import java.util.ArrayList;

/**
 * Created by NSC on 9/1/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    Context context;
    ArrayList<Comment> commentArrayList = new ArrayList<>();

    public CommentAdapter(Context context, ArrayList<Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentAdapter.CommentViewHolder holder, int position) {
        holder.tvName.setText(String.valueOf(commentArrayList.get(position).getName()));
        holder.tvDate.setText(String.valueOf(commentArrayList.get(position).getDate()));
        holder.tvComment.setText(String.valueOf(commentArrayList.get(position).getComment()));

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDate;
        TextView tvComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
        }
    }
}
