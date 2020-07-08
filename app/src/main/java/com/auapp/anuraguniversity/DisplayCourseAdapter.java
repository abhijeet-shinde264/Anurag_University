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

class DisplayCourseAdapter extends RecyclerView.Adapter<DisplayCourseAdapter.ViewHolder1> {
    Context context;
    ArrayList<RecycleModel> recycleModels;
    private  ClickListener clicklistener = null;

    public DisplayCourseAdapter(Context context, ArrayList<RecycleModel> recycleModels) {
        this.context = context;
        this.recycleModels = recycleModels;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_card,null);
        return new ViewHolder1(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        holder.t1.setText(recycleModels.get(position).getText());
        holder.i1.setImageResource(recycleModels.get(position).getImg());
    }
    @Override
    public int getItemCount() {
        return recycleModels.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView t1;
        CardView cv;
        ImageView i1;
        public ViewHolder1(@NonNull final View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tview1);
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
