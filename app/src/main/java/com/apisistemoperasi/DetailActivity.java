package com.apisistemoperasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.apisistemoperasi.MainActivity.EXTRA_DESKRIPSI;
import static com.apisistemoperasi.MainActivity.EXTRA_URL;
import static com.apisistemoperasi.MainActivity.EXTRA_VERSI;
import static com.apisistemoperasi.MainActivity.EXTRA_WEBSITE;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail Image");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String logoUrl = intent.getStringExtra(EXTRA_URL);
        String versi = intent.getStringExtra(EXTRA_VERSI);
        String deskripsi = intent.getStringExtra(EXTRA_DESKRIPSI);
        String website= intent.getStringExtra(EXTRA_WEBSITE);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewVersi = findViewById(R.id.text_view_versi_detail);
        TextView textViewdeskripsi = findViewById(R.id.text_view_deskripsi_detail);
        TextView textViewWebsite = findViewById(R.id.text_view_website_detail);

        Picasso.get().load(logoUrl).fit().centerCrop().into(imageView);
        textViewVersi.setText(versi);
        textViewdeskripsi.setText(deskripsi);
        textViewWebsite.setText(website);
    }
}