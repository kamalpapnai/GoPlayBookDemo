package com.example.goplaybookdemoapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class ModelClass {

    private int viewType;
    public static final int MATCH_ITEM_LAYOUT=0;
    public static final int VIDEO_ITEM_LAYOUT=1;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    //Video Model Class
    private int videMainImg;
    private String videoMainTitle;
    private  String videoTimeDuration;
    private  String videoDescription;
    private int videoView;
    private  String likeNo;
    private String viewNo;
    private  String shareNo;
    private Button likeBtn;
    private Button shareBtn;


    public ModelClass(int viewType,int videMainImg, String videoMainTitle, String videoTimeDuration, String videoDescription, int videoView, String likeNo,
                      String viewNo, String shareNo){
        this.viewType=viewType;
        this.videMainImg = videMainImg;
        this.videoMainTitle=videoMainTitle;
        this.videoTimeDuration=videoTimeDuration;
        this.videoDescription=videoDescription;
        this.videoView=videoView;
        this.likeNo=likeNo;
        this.viewNo=viewNo;
        this.shareNo=shareNo;
    }

    public int getVideMainImg() {
        return videMainImg;
    }

    public Button getLikeBtn() {
        return likeBtn;
    }

    public  String getLikeNo() {
        return likeNo;
    }

    public  String getVideoDescription() {
        return videoDescription;
    }

    public Button getShareBtn() {
        return shareBtn;
    }

    public  String getVideoMainTitle() {
        return videoMainTitle;
    }

    public  String getShareNo() {
        return shareNo;
    }

    public  String getViewNo() {
        return viewNo;
    }

    public  String getVideoTimeDuration() {
        return videoTimeDuration;
    }

    public int getVideoView() {
        return videoView;
    }

    public void setVideMainImg(int videMainImg) {
        this.videMainImg = videMainImg;
    }

    public void setLikeBtn(Button likeBtn) {
        this.likeBtn = likeBtn;
    }

    public void setVideoMainTitle( String videoMainTitle) {
        this.videoMainTitle = videoMainTitle;
    }

    public void setLikeNo( String likeNo) {
        this.likeNo = likeNo;
    }

    public void setShareBtn(Button shareBtn) {
        this.shareBtn = shareBtn;
    }

    public void setShareNo( String shareNo) {
        this.shareNo = shareNo;
    }

    public void setVideoDescription( String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public void setVideoTimeDuration( String videoTimeDuration) {
        this.videoTimeDuration = videoTimeDuration;
    }

    public void setVideoView(int videoView) {
        this.videoView = videoView;
    }

    public void setViewNo( String viewNo) {
        this.viewNo = viewNo;
    }


    //Match Model Class

    private int matchImg;
    private String matchName;
    private String matchDate;
    private String matchTime;
    private String matchPlace;
    private int matchTeam1ImgId;
    private int matchTeam2Id;
    private String matchTeam1Score;
    private String matchTeam2Score;
    private String matchTeam1Name;
    private String matchTeam2Name;

    public ModelClass(int viewType,int matchImg, String matchName, String matchDate, String matchTime, String matchPlace, int matchTeam1ImgId, int matchTeam2Id,
                      String matchTeam1Score, String matchTeam2Score, String matchTeam1Name, String matchTeam2Name) {
        this.viewType=viewType;
        this.matchImg = matchImg;
        this.matchName = matchName;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.matchPlace = matchPlace;
        this.matchTeam1ImgId = matchTeam1ImgId;
        this.matchTeam2Id = matchTeam2Id;
        this.matchTeam1Score = matchTeam1Score;
        this.matchTeam2Score = matchTeam2Score;
        this.matchTeam1Name = matchTeam1Name;
        this.matchTeam2Name = matchTeam2Name;
    }

    public int getMatchImg() {
        return matchImg;
    }

    public String getMatchName() {
        return matchName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public String getMatchPlace() {
        return matchPlace;
    }

    public int getMatchTeam1ImgId() {
        return matchTeam1ImgId;
    }

    public int getMatchTeam2Id() {
        return matchTeam2Id;
    }

    public String getMatchTeam1Score() {
        return matchTeam1Score;
    }

    public String getMatchTeam2Score() {
        return matchTeam2Score;
    }

    public String getMatchTeam1Name() {
        return matchTeam1Name;
    }

    public String getMatchTeam2Name() {
        return matchTeam2Name;
    }

    public void setMatchImg(int matchImg) {
        this.matchImg = matchImg;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
    }

    public void setMatchTeam1ImgId(int matchTeam1ImgId) {
        this.matchTeam1ImgId = matchTeam1ImgId;
    }

    public void setMatchTeam2Id(int matchTeam2Id) {
        this.matchTeam2Id = matchTeam2Id;
    }

    public void setMatchTeam1Score(String matchTeam1Score) {
        this.matchTeam1Score = matchTeam1Score;
    }

    public void setMatchTeam2Score(String matchTeam2Score) {
        this.matchTeam2Score = matchTeam2Score;
    }

    public void setMatchTeam1Name(String matchTeam1Name) {
        this.matchTeam1Name = matchTeam1Name;
    }

    public void setMatchTeam2Name(String matchTeam2Name) {
        this.matchTeam2Name = matchTeam2Name;
    }
}
