package com.example.goplaybookdemoapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class CustomVideoAdapter extends RecyclerView.Adapter<CustomVideoAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList<ModelClass> modelClasses;

    public CustomVideoAdapter(Context context,ArrayList<ModelClass> modelClasses){
        this.context=context;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public CustomVideoAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.video_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomVideoAdapter.CustomViewHolder customViewHolder, int i) {
        customViewHolder.videMainImg.setImageResource(modelClasses.get(i).getVideMainImg());
        customViewHolder.videoMainTitle.setText(modelClasses.get(i).getVideoMainTitle());
        customViewHolder.videoTimeDuration.setText(modelClasses.get(i).getVideoTimeDuration());
        customViewHolder.videoDescription.setText(modelClasses.get(i).getVideoDescription());
        MediaController mediaControls;
            // create an object of media controller class
            mediaControls = new MediaController(context);
            mediaControls.setAnchorView(customViewHolder.videoView);
        // set the media controller for video view
        customViewHolder.videoView.setMediaController(mediaControls);
        // set the uri for the video view
        customViewHolder.videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + modelClasses.get(i).getVideoView()));
        // start a video
        customViewHolder.videoView.start();

        // implement on completion listener on video view
        customViewHolder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(context, "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        customViewHolder.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(context, "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });

        customViewHolder.likeNo.setText(modelClasses.get(i).getLikeNo());
        customViewHolder.viewNo.setText(modelClasses.get(i).getViewNo());
        customViewHolder.shareNo.setText(modelClasses.get(i).getShareNo());

    }

    @Override
    public int getItemCount() {

        if(modelClasses !=null){
            return modelClasses.size();
        }
        else
            return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView videMainImg;
        private TextView videoMainTitle;
        private TextView videoTimeDuration;
        private TextView videoDescription;
        private VideoView videoView;
        private TextView likeNo;
        private TextView viewNo;
        private TextView shareNo;
        private Button likeBtn;
        private Button shareBtn;

        public CustomViewHolder(View view){
            super(view);
            videMainImg=view.findViewById(R.id.video_img1);
            videoMainTitle=view.findViewById(R.id.video_maintitle);
            videoTimeDuration=view.findViewById(R.id.video_timeduration);
            videoDescription=view.findViewById(R.id.video_description);
            videoView=view.findViewById(R.id.videoView);
            likeNo=view.findViewById(R.id.video_likes);
            viewNo=view.findViewById(R.id.video_views);
            shareNo=view.findViewById(R.id.video_share);
            likeBtn=view.findViewById(R.id.video_like_btn);
            shareBtn=view.findViewById(R.id.video_share_btn);
        }

    }
}
