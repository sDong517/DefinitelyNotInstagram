package com.example.definitelynotinstagram;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

public class PostDetail extends AppCompatActivity {

    TextView tvProfileName;
    TextView tvDetailTime;
    TextView tvDetailCaption;

    ImageView ivProfilePicture;
    ImageView ivPostImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_post);

        tvProfileName = findViewById(R.id.tvProfileName);
        tvDetailCaption = findViewById(R.id.tvDetailCaption);
        tvDetailTime = findViewById(R.id.tvDetailTime);

        ivPostImage = findViewById(R.id.ivPostImage);
        ivProfilePicture = findViewById(R.id.ivProfilePicture);


        //DOING OLD FASHION WAY SINCE I CANT GET PARCEL TO WORK
        String description = getIntent().getStringExtra("description");
        tvDetailCaption.setText(description);

        String user = getIntent().getStringExtra("user");
        tvProfileName.setText(user);

        String time = getIntent().getStringExtra("time");
        tvDetailTime.setText(time);


        //Glide.with(this).load(post.getImage().getUrl()).into(ivPostImage);

        //Glide.with(context).load(post.getImage().getUrl()).into(ivProfile);
        //Post post = Parcels.unwrap(getIntent().getParcelableExtra("post"));
        //tvDetailCaption.setText(post.getDescription());


    }
}
