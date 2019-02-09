package com.epiclancers.slideupmenu.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.epiclancers.slideupmenu.Data.DataProvider;
import com.epiclancers.slideupmenu.R;
import com.epiclancers.slideupmenu.pojo.Person;

import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class TheUserAdapter extends RecyclerView.Adapter<TheUserAdapter.UserViewHolder> {

    Context context;
    ArrayList<Person> userData;

    public TheUserAdapter(Context context) {
        this.context = context;
        userData = DataProvider.PERSON_LIST;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.single_list_item , viewGroup , false );
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        Person person = userData.get(i);
        userViewHolder.setData(person);
        Log.i("TheAdapter", "onBindViewHolder: " + person.toString());
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView userName,userDesc,lastActive;
        CircleImageView userImage;
        ImageView online;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.textView);
            userDesc = itemView.findViewById(R.id.textView3);
            userImage = itemView.findViewById(R.id.userImg);
            online = itemView.findViewById(R.id.online);
            lastActive = itemView.findViewById(R.id.lastActive);
        }

        public void setData(Person person){
            // Randomly Check if User is online or Not
            long onlineNum = person.getIsOnline();
            int lastOnline = person.getLastOnline();

            if (onlineNum==1) {
                online.setVisibility(View.VISIBLE);
            }else {
                online.setVisibility(View.GONE);
            }

            userName.setText(person.getName());
            userDesc.setText(person.getDesc());
            Glide.with(context).load(person.getImage())
                    .into(userImage);

            // Randomly check the last active time of User
            if (onlineNum == 0){
                lastActive.setVisibility(View.VISIBLE);
                lastActive.setText(lastOnline+"m");
            }else {
                lastActive.setVisibility(View.GONE);
            }

        }

    }
}
