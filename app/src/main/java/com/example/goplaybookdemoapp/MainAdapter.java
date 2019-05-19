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

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ModelClass> modelClassList;

    public MainAdapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @Override
    public int getItemViewType(int position) {
        switch(modelClassList.get(position).getViewType()){
            case 0:return ModelClass.MATCH_ITEM_LAYOUT;
            case 1:return ModelClass.VIDEO_ITEM_LAYOUT;
            default:return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch(i){
            case ModelClass.MATCH_ITEM_LAYOUT:
                View matchItemLayout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.match_item,viewGroup,false);
                return new MatchItemLayout(matchItemLayout);
            case ModelClass.VIDEO_ITEM_LAYOUT:
                View videoItemLayout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item,viewGroup,false);
                return new VideoItemLayout(videoItemLayout);
            default:return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
         switch(modelClassList.get(position).getViewType()){
             case ModelClass.MATCH_ITEM_LAYOUT:
                  int matchImg = modelClassList.get(position).getMatchImg();
                  String matchName = modelClassList.get(position).getMatchName();
                  String matchDate = modelClassList.get(position).getMatchDate();
                  String matchTime = modelClassList.get(position).getMatchTime();
                  String matchPlace = modelClassList.get(position).getMatchPlace();
                  int matchTeam1ImgId = modelClassList.get(position).getMatchTeam1ImgId();
                  int matchTeam2Id = modelClassList.get(position).getMatchTeam2Id();
                  String matchTeam1Score = modelClassList.get(position).getMatchTeam1Score();
                  String matchTeam2Score = modelClassList.get(position).getMatchTeam2Score();
                  String matchTeam1Name = modelClassList.get(position).getMatchTeam1Name();
                  String matchTeam2Name = modelClassList.get(position).getMatchTeam2Name();
                 ((MatchItemLayout)viewHolder).setData(matchImg,matchName,matchDate,matchTime,matchPlace,matchTeam1ImgId,
                         matchTeam2Id,matchTeam1Score,matchTeam2Score,matchTeam1Name,matchTeam2Name);break;
             case ModelClass.VIDEO_ITEM_LAYOUT:

                  int videMainImg=modelClassList.get(position).getVideMainImg();
                  String videoMainTitle=modelClassList.get(position).getVideoMainTitle();
                  String videoTimeDuration=modelClassList.get(position).getVideoTimeDuration();
                  String videoDescription=modelClassList.get(position).getVideoDescription();
                  int videoView=modelClassList.get(position).getVideoView();
                  String likeNo=modelClassList.get(position).getLikeNo();
                  String viewNo=modelClassList.get(position).getViewNo();
                  String shareNo=modelClassList.get(position).getShareNo();

                 ((VideoItemLayout)viewHolder).setVideoItemData(videMainImg,videoMainTitle,videoTimeDuration,videoDescription,
                         videoView,likeNo,viewNo,shareNo);break;
             default:return;
         }
    }

    @Override
    public int getItemCount() {
       if(modelClassList!=null)
           return modelClassList.size();
       else
           return 0;
    }


    public class VideoItemLayout extends RecyclerView.ViewHolder{
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

        public VideoItemLayout(View view){
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


        public void setVideoItemData(int videMainImg,String videoMainTitle,String videoTimeDuration,String videoDescription,
                                     int videoView,String likeNo,String viewNo,String shareNo){
            this.videMainImg.setImageResource(videMainImg);
            this.videoMainTitle.setText(videoMainTitle);
            this.videoTimeDuration.setText(videoTimeDuration);
            this.videoDescription.setText(videoDescription);


            MediaController mediaControls;
            // create an object of media controller class
            mediaControls = new MediaController(context);
            mediaControls.setAnchorView(this.videoView);
            // set the media controller for video view
            this.videoView.setMediaController(mediaControls);
            // set the uri for the video view
            this.videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + videoView));
            // start a video
            this.videoView.start();

            // implement on completion listener on video view
            this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(context, "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
                }
            });
            this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Toast.makeText(context, "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                    return false;
                }
            });

            this.likeNo.setText(likeNo);
            this.viewNo.setText(viewNo);
            this.shareNo.setText(shareNo);

        }


    }

    public class MatchItemLayout extends RecyclerView.ViewHolder{
        private ImageView matchImg;
        private TextView matchName;
        private TextView matchDate;
        private TextView matchTime;
        private TextView matchPlace;
        private ImageView matchTeam1ImgId;
        private ImageView matchTeam2Id;
        private TextView matchTeam1Score;
        private TextView matchTeam2Score;
        private TextView matchTeam1Name;
        private TextView matchTeam2Name;

      public MatchItemLayout(View view){
          super(view);
          matchImg= view.findViewById(R.id.match_img);
          matchName= view.findViewById(R.id.match_name);
          matchDate= view.findViewById(R.id.match_date);
          matchTime= view.findViewById(R.id.match_time);
          matchPlace= view.findViewById(R.id.match_place);
          matchTeam1ImgId= view.findViewById(R.id.team1_img);
          matchTeam2Id= view.findViewById(R.id.team2_img);
          matchTeam1Score= view.findViewById(R.id.team1_score);
          matchTeam2Score= view.findViewById(R.id.team2_score);
          matchTeam1Name= view.findViewById(R.id.team1_name);
          matchTeam2Name= view.findViewById(R.id.team2_name);

      }

        public void setData(int matchImg, String matchName, String matchDate, String matchTime, String matchPlace, int matchTeam1ImgId, int matchTeam2Id,
                            String matchTeam1Score, String matchTeam2Score, String matchTeam1Name, String matchTeam2Name) {
            this.matchImg.setImageResource(matchImg);
            this.matchName.setText(matchName);
            this.matchDate.setText(matchDate);
            this.matchTime.setText(matchTime);
            this.matchPlace.setText(matchPlace);
            this.matchTeam1ImgId.setImageResource(matchTeam1ImgId);
            this.matchTeam2Id.setImageResource(matchTeam2Id);
            this.matchTeam1Score.setText(matchTeam1Score);
            this.matchTeam2Score.setText(matchTeam2Score);
            this.matchTeam1Name.setText(matchTeam1Name);
            this.matchTeam2Name.setText(matchTeam2Name);
        }

    }


}
