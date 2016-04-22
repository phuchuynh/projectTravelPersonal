package htp.personaltravelapplication;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import htp.personaltravelapplication.bean.ObjectAccount;

/**
 * Created by phuchtgc60244 on 3/15/2016.
 */
public class OnClickListenerCreateAccount implements View.OnClickListener {

    @Override
    public  void  onClick(View view)
    {
        final Context context= view.getContext();
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final  View elementView =inflater.inflate(R.layout.register_form,null,false);
        final EditText editTextEmail =(EditText) elementView.findViewById(R.id.editTextEmail);
        final  EditText editTextPass=(EditText)elementView.findViewById(R.id.editTextPass);

        new AlertDialog.Builder(context)
                .setView(elementView)
                .setTitle("Create Account")
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //dialog.cancel() Toast.makeText(context, "Create List successfull", Toast.LENGTH_SHORT).show();;
                        String emailAcconut = editTextEmail.getText().toString();
                        String passAccount = editTextPass.getText().toString();

                        ObjectAccount obj = new ObjectAccount();
                        obj.email = emailAcconut;
                        obj.pass = passAccount;
                        boolean createAcc = new TableController(context).createAccount(obj);
                        if (emailAcconut.equals("") && passAccount.equals("")) {
                            Toast.makeText(context, "Email and Password  invalid", Toast.LENGTH_SHORT).show();
                        } else {
                            if (createAcc) {
                                Toast.makeText(context, "Create successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Create fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                       // ((LoginActivity) context).readRecords();

                    }
                }).show();
    }







}

