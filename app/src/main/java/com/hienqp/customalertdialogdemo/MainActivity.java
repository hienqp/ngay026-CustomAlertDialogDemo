package com.hienqp.customalertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLogin = (TextView) findViewById(R.id.textview_login);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogin();
            }
        });
    }

    private void dialogLogin() {
        Dialog dialog = new Dialog(MainActivity.this);

//        // set nội dung trên thanh title cho dialog
//        dialog.setTitle("THÔNG BÁO");
        // hoặc bỏ tính năng thanh title cho dialog, lưu ý gọi phương thức này trước setContentView cho Dialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.dialog_custom_demo);
        dialog.setCanceledOnTouchOutside(false);

        EditText edittextUserName = (EditText) dialog.findViewById(R.id.edittext_username);
        EditText edittextPassword = (EditText) dialog.findViewById(R.id.edittext_password);
        Button buttonConfirm = (Button) dialog.findViewById(R.id.button_confirm);
        Button buttonCancel = (Button) dialog.findViewById(R.id.button_cancel);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edittextUserName.getText().toString().trim();
                String password = edittextPassword.getText().toString().trim();
                if (username.equals("jackpq") && password.equals("123")) {
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Sai Username hoặc Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sử dụng 1 trong 2 phương thức sau để hủy 1 Dialog
//                dialog.cancel();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}