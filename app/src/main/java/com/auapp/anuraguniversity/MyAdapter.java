package com.auapp.anuraguniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    Context context;
    ArrayList<RecycleModel> recycleModels;
    private  ClickListener clicklistener = null;

    public MyAdapter(Context context, ArrayList<RecycleModel> recycleModels) {
        this.context = context;
        this.recycleModels = recycleModels;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.t1.setText(recycleModels.get(position).getText());
        holder.i1.setImageResource(recycleModels.get(position).getImg());
    }
    @Override
    public int getItemCount() {
        return recycleModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        CardView cv;
        ImageView i1;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.textview);
            cv = itemView.findViewById(R.id.cardview);
            i1 = itemView.findViewById(R.id.img1);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    if(clicklistener !=null){
                        clicklistener.itemClicked(v,getAdapterPosition());
                    }
                }
            });
        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
    }
}
