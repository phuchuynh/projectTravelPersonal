package htp.personaltravelapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import htp.personaltravelapplication.bean.ObjectList;

/**
 * Created by phuchtgc60244 on 4/12/2016.
 */
public class OnClickListenerAddContent implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        final Context context = v.getContext();
        // Toast.makeText(context, "View add", Toast.LENGTH_SHORT).show();
        String title = ((AddListActivity) context).eTitle.getText().toString();
        String content = ((AddListActivity) context).eContent.getText().toString();
        String lng = ((AddListActivity) context).tLng.getText().toString();
        String lat = ((AddListActivity) context).tLat.getText().toString();
        ObjectList objList = new ObjectList();
        objList.title = title;
        objList.content = content;
        objList.lng = lng;
        objList.lat = lat;


        boolean result = ((AddListActivity) context).tableController.createListItem(objList);
        if (result) {

            Toast.makeText(context, "Create List successfull", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "Failed to create note", Toast.LENGTH_SHORT).show();
        }


    }
}
