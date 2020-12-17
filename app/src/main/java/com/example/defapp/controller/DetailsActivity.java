package com.example.defapp.controller;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.defapp.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ImageView img_app;
    TextView txt_appName,txt_creators,txt_date,txt_ranking,txt_website,txt_entreprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        img_app=findViewById(R.id.img_details_app);
        txt_appName=findViewById(R.id.tv_appname);
        txt_creators=findViewById(R.id.tv_creators);
        txt_date=findViewById(R.id.tv_createdate);
        txt_ranking=findViewById(R.id.tv_ranking);
        txt_entreprise=findViewById(R.id.tv_entreprise);
        txt_website=findViewById(R.id.tv_website);

        Bundle bundle = getIntent().getExtras();
        getData(bundle);

    }

    public void getData(Bundle bundle){
        if(bundle!=null){
            int imageapp = bundle.getInt("appImage");
            String nameapp = bundle.getString("appName");
            ArrayList<String> Creators = bundle.getStringArrayList("creatorsList");

            String createdDate = bundle.getString("createdDate");
            int rank = bundle.getInt("classement");
            String proprietaire = bundle.getString("entreprise");
            String webSite = bundle.getString("webSite");
            int color = bundle.getInt("txt_color");


            img_app.setImageResource(imageapp);
            txt_appName.setText(nameapp);
            txt_appName.setTextColor(color);
            txt_creators.setText(getCreators(Creators));
            txt_date.setText(createdDate);
            txt_ranking.setText(String.valueOf(rank));
            txt_entreprise.setText(proprietaire);
            txt_website.setText(webSite);

        }


    }
    public String getCreators(ArrayList<String>creatorsList){
        String appCreators="";
        for(int i=0;i<creatorsList.size();i++){
            if(creatorsList.size()-i==1)
                appCreators+=creatorsList.get(i)+".";
            else
                appCreators+=creatorsList.get(i)+" ,";
        }
        return appCreators;
    }
}