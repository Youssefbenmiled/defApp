package com.example.defapp.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defapp.R;
import com.example.defapp.global.Constants;
import com.example.defapp.model.Application;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AppsviewHolder> {
        ArrayList<Application> apps;
        Context context;



        public Adapter(ArrayList<Application> appList, Context context)
        {
            this.apps=appList;
            this.context=context;
        }

        @NonNull
        @Override
        public AppsviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items,parent,false);
            AppsviewHolder appviewholder=new AppsviewHolder(view);
            return appviewholder;


        }

        @Override
        public void onBindViewHolder(@NonNull AppsviewHolder holder, final int position) {
            final Application app=apps.get(position);
            holder.app_img.setImageResource(app.getImageView());
            holder.app_name.setText(app.getAppName());

            editColor(position,holder);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    redirectToDetails(context,app,holder);

                }
            });
        }

    private void editColor(int position, AppsviewHolder holder) {

        switch(position) {
            case 0:
                holder.app_name.setTextColor(Color.parseColor(Constants.WHATSAPP_COLOR));
                break;
            case 1:
                holder.app_name.setTextColor(Color.parseColor(Constants.FACEBOOK_COLOR));
                break;
            case 2:
                holder.app_name.setTextColor(Color.parseColor(Constants.INSTAGRAM_COLOR));
                break;
            case 3:
                holder.app_name.setTextColor(Color.parseColor(Constants.SNAPCHAT_COLOR));
                break;
            case 4:
                holder.app_name.setTextColor(Color.parseColor(Constants.UBER_COLOR));
                break;
            case 5:
                holder.app_name.setTextColor(Color.parseColor(Constants.YOUTUBE_COLOR));
                break;
            case 6:
                holder.app_name.setTextColor(Color.parseColor(Constants.TWITTER_COLOR));
                break;


        }
    }

    private void redirectToDetails(Context context, Application app, AppsviewHolder holder) {
        Intent intent=new Intent(context, DetailsActivity.class);
        Bundle b=new Bundle();
        b.putInt("appImage",app.getImageView());
        b.putString("appName",app.getAppName());
        b.putString("createdDate",app.getCreateDate());
        b.putInt("classement",app.getRanking());
        b.putString("entreprise",app.getEntreprise());
        b.putString("webSite",app.getWebSite());
        b.putStringArrayList("creatorsList",app.getCreators());
        b.putInt("txt_color",holder.app_name.getCurrentTextColor());
        intent.putExtras(b);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
        public int getItemCount()
        {
            return apps.size();
        }

        public static class AppsviewHolder extends RecyclerView.ViewHolder {
            ImageView app_img;
            TextView app_name;


            public AppsviewHolder(View itemview)
            {
                super(itemview);
                app_img=itemview.findViewById(R.id.img_app);
                app_name=itemview.findViewById(R.id.tv_appname);


            }
        }





}
