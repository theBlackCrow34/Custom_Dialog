package com.sale.refaq.custom_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button showDialogBtn;//to show dialog
    Button showBottomSheetDialogBtn;//to show bottom sheet dialog //must add material

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogBtn = findViewById(R.id.showDialogBtn);
        showBottomSheetDialogBtn = findViewById(R.id.showBottomSheetDialogBtn);

        showDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        showBottomSheetDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });
    }

    private void showBottomSheetDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.custom_layout,null);

        final EditText nameEt = view.findViewById(R.id.nameEt);
        final EditText passwordEt = view.findViewById(R.id.passwordEt);
        Button showDataBtn = view.findViewById(R.id.showDataBtn);

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);

        bottomSheetDialog.show();

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameEt.getText().toString();
                String password = passwordEt.getText().toString();

                showBottomSheetDialogBtn.setText("name is :"+name+" password is :"+password);
                bottomSheetDialog.dismiss();//cancel sheet
            }
        });
    }

    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.custom_layout,null);

        final EditText nameEt = view.findViewById(R.id.nameEt);
        final EditText passwordEt = view.findViewById(R.id.passwordEt);
        Button showDataBtn = view.findViewById(R.id.showDataBtn);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.show();

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameEt.getText().toString();
                String password = passwordEt.getText().toString();

                showDialogBtn.setText("name is :"+name+" password is :"+password);
                dialog.dismiss();//cancel dialog
            }
        });
    }
}
