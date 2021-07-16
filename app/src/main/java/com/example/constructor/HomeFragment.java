package com.example.constructor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.canvas.CanvasCompat;

public class HomeFragment extends Fragment {
    Button btnAddNewProject;
    Window window;
    ListView listView;
    String tittle[]={"Colombo","Colombo","Mathara","Jaffna","Kandy","Anuradhapura","Gampaha","Kurunegala"};
    String description[]={"Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21","Start Date: 2020.05.21"};
    int image[]={R.drawable.homes,R.drawable.homes,R.drawable.homes,R.drawable.homes,R.drawable.homes,R.drawable.homes,R.drawable.homes,R.drawable.homes};


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home,container,false);

        Window window=((Activity)view.getContext()).getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.myStatusBar));


        btnAddNewProject=view.findViewById(R.id.btnAddNewProject);

        btnAddNewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Home.class);
                startActivity(intent);
            }
        });

        listView=view.findViewById(R.id.listView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(),tittle,image,description);
        listView.setAdapter(adapter);

        return view;


    }

}


class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    int[] images;
    String[] title;
    String[] des;

    CustomAdapter(Context context, String[] title, int[] images, String[] des) {
        super(context, R.layout.row, R.id.title, title);
        this.context = context;
        this.images = images;
        this.title = title;
        this.des = des;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row, parent, false);
        ImageView imageView = row.findViewById(R.id.image);
        TextView titleView = row.findViewById(R.id.title);
        TextView descriptionView = row.findViewById(R.id.description);


        imageView.setImageResource(images[position]);
        titleView.setText(title[position]);
        descriptionView.setText(des[position]);


        return row;
    }
}
