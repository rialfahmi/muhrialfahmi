package com.apisistemoperasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context context;
    private ArrayList<ExampleItem> exampleItems;
    private OnBtnDetailClickListener detailClickListener;

    public interface OnBtnDetailClickListener {
        void onBtnClick(int position);
    }

    public void setOnItemClickListener(OnBtnDetailClickListener detailClickListener) {
        this.detailClickListener = detailClickListener;
    }

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleItems) {
        this.context = context;
        this.exampleItems = exampleItems;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem item = exampleItems.get(position);

        String logoUrl = item.getLogoUrl();
        String versi = item.getVersi();
        String deskripsi = item.getDeskripsi();
        String website = item.getWebsite();

        holder.textViewVersi.setText(versi);
        holder.textViewWebsite.setText(website);
        holder.textViewDeskripsi.setText(deskripsi);
        Picasso.get().load(logoUrl).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewVersi, textViewWebsite, textViewDeskripsi;
        public Button btnDetail;

        public ExampleViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_view);
            textViewVersi = view.findViewById(R.id.text_view_versi);
            textViewDeskripsi = view.findViewById(R.id.text_view_deskripsi);
            textViewWebsite = view.findViewById(R.id.text_view_website);
            btnDetail = view.findViewById(R.id.btn_detail);

            btnDetail.setOnClickListener(v -> {
                if (detailClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        detailClickListener.onBtnClick(position);
                    }
                }
            });
        }
    }
}
