package com.example.grocery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocery.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    private int[] itemsImages;
    private String[] itemsTitles;
    private OnItemClickListener onItemClickListener;

    //this for click on items listener interface method
    public interface OnItemClickListener{
        void OnClickListener(int position);
    }

    public void setOnclickListener(OnItemClickListener onClickListener)
    {
        onItemClickListener = onClickListener;
    }

    public CartAdapter(Context context, int[] itemsImages, String[] itemsTitles) {
        this.context = context;
        this.itemsImages = itemsImages;
        this.itemsTitles = itemsTitles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_sample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(itemsTitles[position]);
        holder.imageView.setImageResource(itemsImages[position]);
    }

    @Override
    public int getItemCount() {
        return itemsTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cartImageItemId);
            textView = itemView.findViewById(R.id.cartTitleId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(onItemClickListener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            onItemClickListener.OnClickListener(position);
                        }
                    }

                }
            });

        }
    }
}
