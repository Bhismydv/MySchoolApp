package com.example.myschoolapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingMenuLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    FlowingDrawer flowingDrawer;
    FlowingMenuLayout flowingMenuLayout;

FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

auth=FirebaseAuth.getInstance();


flowingDrawer=findViewById(R.id.drawerLayout);

flowingDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);


setupMenu();

         androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

    toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowingDrawer.toggleMenu();
            }
        });

    }



    private void  setupMenu(){
        FragmentManager fm=getSupportFragmentManager();
        MenuListFragment menuListFragment= (MenuListFragment) fm.findFragmentById(R.id.frameLayout);
if (menuListFragment==null){
    menuListFragment=new MenuListFragment();
    fm.beginTransaction().add(R.id.frameLayout,menuListFragment).commit();
}
    }

    @Override
    public void onBackPressed() {
        if (flowingDrawer.isMenuVisible()){
            flowingDrawer.closeMenu();
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.main_menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){


           case R.id.action_logout:
               auth.signOut();
               startActivity(new Intent(getApplicationContext(),LogInSingUp.class));
               finish();
               return true;

               default:
                   return false;

       }



    }

}
