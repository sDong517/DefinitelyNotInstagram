package com.example.definitelynotinstagram;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    public static final String TAG = "PostAdapter";

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // SWIPE TO REFRESH CLEAR
    public void clear(){
        posts.clear();
        notifyDataSetChanged();
    }
    // SWIPE TO REFRESH ADD BACK
    public void addAll(List<Post> postList){
        posts.addAll(postList);
        notifyDataSetChanged();

    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvComment;
        private ImageView ivProfile;
        private TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvComment = itemView.findViewById(R.id.tvComment);
            ivProfile = itemView.findViewById(R.id.ivProfile);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        public void bind(Post post) {
            tvComment.setText(post.getDescription());
            tvName.setText(post.getUser().getUsername());
            tvTime.setText(post.getCreation().toString());


            Log.i(TAG, "This works!" + post.getCreation());

            ParseFile image = post.getImage();

            if (image != null){
                Glide.with(context).load(post.getImage().getUrl()).into(ivProfile);
            }


            //Clicking on the name will create a detailed view to 'PostDetail'
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, PostDetail.class);

                    i.putExtra("description", post.getDescription());

                    i.putExtra("user", post.getUser().getUsername());

                    i.putExtra("time",post.getCreation().toString());


                    //i.putExtra("post", Parcels.wrap(post));

                    context.startActivity(i);

                }
            });


        }


    }
}
