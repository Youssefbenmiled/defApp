package com.example.defapp.controller;



import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defapp.R;
import com.example.defapp.global.Constants;
import com.example.defapp.model.Application;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rv_list;
    TextView tv_logout;
    ArrayList<Application>apps=new ArrayList<>();

    ArrayList<String>whatsappCreators=new ArrayList<>();
    ArrayList<String>faceCreators=new ArrayList<>();
    ArrayList<String>instCreators=new ArrayList<>();
    ArrayList<String>snapCreators=new ArrayList<>();
    ArrayList<String>uberCreators=new ArrayList<>();
    ArrayList<String>yutbCreators=new ArrayList<>();
    ArrayList<String>twitCreators=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rv_list=findViewById(R.id.rv_apps);
        tv_logout=findViewById(R.id.tv_disconnect);
        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disconnect();
            }
        });

        createRecyclerView();





    }
    private void disconnect() {
        AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Disconnect");
        builder.setMessage("Are you sure you want to logout !");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                endData();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();


    }
    private void endData(){
        SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constants.USER_CONNECTED, false);
        editor.apply();
        finishAffinity();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }



    public void createRecyclerView(){
        Adapter adapter=new Adapter(initApps(),getApplicationContext());
        rv_list.setAdapter(adapter);
        rv_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public ArrayList<Application>initApps(){

        whatsappCreators.add("Jan Koum");
        whatsappCreators.add("Brian Acton");
        apps.add(new Application(R.drawable.wahtsapp,"WhatsApp",whatsappCreators,"3 mai 2009.",1,"whatsapp.com","WhatsApp Inc. (propriété de Facebook)"));


        faceCreators.add("Mark Zuckerberg");
        faceCreators.add("Sheryl Sandberg");
        apps.add(new Application(R.drawable.facebook,"Facebook",faceCreators,"4 février 2004.",2,"facebook.com","Facebook"));


        instCreators.add("Kevin Systrom");
        instCreators.add("Mike Krieger");
        apps.add(new Application(R.drawable.instagram,"Instagram",instCreators,"6 octobre 2010.",3,"instagram.com","Facebook"));

        snapCreators.add("Evan Spiegel");
        snapCreators.add("Bobby Murphy");
        apps.add(new Application(R.drawable.snapchat,"Snapchat",snapCreators,"8 juillet 2011.",4,"snapchat.com","Snap Inc"));


        uberCreators.add("Garrett Camp");
        uberCreators.add("Travis Kalanick");
        uberCreators.add("Oscar Salazar");
        apps.add(new Application(R.drawable.uber,"Uber",uberCreators,"mars 2009.",6,"uber.com","Uber"));



        yutbCreators.add("Steve Chen");
        yutbCreators.add("Chad Hurley");
        yutbCreators.add("Jawed Karim");
        apps.add(new Application(R.drawable.youtube,"Youtube",yutbCreators,"14 février 2005.",7,"YouTube.com","Google"));



        twitCreators.add("Jack Dorsey1");
        twitCreators.add("Noah Glass");
        twitCreators.add("Biz Stone");
        twitCreators.add("Evan Williams");
        apps.add(new Application(R.drawable.twitter,"Twitter",twitCreators,"21 mars 2006.",17,"twitter.com","Twitter Inc"));

        return apps;

    }


}