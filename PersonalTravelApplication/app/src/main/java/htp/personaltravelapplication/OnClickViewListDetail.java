package htp.personaltravelapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import htp.personaltravelapplication.bean.ObjectList;

/**
 * Created by phuchtgc60244 on 4/22/2016.
 */
public class OnClickViewListDetail implements View.OnClickListener{
        @Override
    public  void  onClick(View v){
            DatabaseHandler db;

            final Context context =v.getContext();
            TableController tb = new TableController(context);
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final  View elementView =inflater.inflate(R.layout.activity_list_view,null,false);
            Toast.makeText(context, "View all", Toast.LENGTH_SHORT).show();
            ObjectList ol = new ObjectList();


        }
}
