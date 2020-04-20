package com.example.myschoolapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class MenuListFragment extends Fragment {

    private ImageView imageView;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu,container,false);

        imageView=view.findViewById(R.id.image);

        NavigationView navigationView=view.findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                switch (id){
                    case R.id.dashboard:

                        Intent intent=new Intent(getContext(),MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.student:
                        Intent intent1=new Intent(getContext(),Student.class);
                        startActivity(intent1);
                        break;
                    case R.id.teacher:
                        Intent intent2=new Intent(getContext(),Teachers.class);
                        startActivity(intent2);
                        break;
                    case R.id.subject:
                        Intent intent3=new Intent(getContext(),Subjects.class);
                        startActivity(intent3);
                        break;

// this listener will be called when there is change in firebase user session



                }
                return false;


            }
        });
   //     setupHeader();
        return  view;
    }





  //  private void setupHeader(){
  //      int avatarSize=getResources()
   //             .getDimensionPixelSize(d);
   //     String profilePhoto=getResources()
  //              .getString(R.string.user_profile_photo);
  //      Picasso.with(getActivity())
 //               .load(profilePhoto)
 //             .placeholder(R.drawable.img_circle_placeholder)
 //               .resize(avatarSize,avatarSize)
   //             .centerCrop();

  //  }
}
