package com.dev.dialogwithrbsdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gender(View veiw) {
        final String[] buttonsText = {"ok","Cancel"};
        showSingleChoiseDialog(this,"Intreseted in",buttonsText,
                new String[]{"Women","men"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /* if i returns -1 it means positive button clicked*/
                        if (i == DialogInterface.BUTTON_POSITIVE) {

                            if (mSelectedItem != null) {
                                Toast.makeText(getApplicationContext(), "you clicked " + mSelectedItem,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "You didn't select any thing!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else if(i == DialogInterface.BUTTON_NEGATIVE){
                            dialogInterface.dismiss();
                        }
                    }
                });
    }
    public void favoriteClick(View view) {
        final String[] buttonsText = {"ok","Cancel"};
        showSingleChoiseDialog(this,"Who is your favorite ?",buttonsText,
                new String[]{"God","me","father","mother","sister","brother","friend"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /* if i returns -1 it means positive button clicked*/
                        if (i == DialogInterface.BUTTON_POSITIVE) {

                            if (mSelectedItem != null) {
                                Toast.makeText(getApplicationContext(), "you clicked " + mSelectedItem,
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "You didn't select any thing!", Toast.LENGTH_SHORT).show();
                            }
                        }else if(i == DialogInterface.BUTTON_NEGATIVE){
                            dialogInterface.dismiss();
                        }
                    }
                });
    }

    private void showSingleChoiseDialog(final Context context, String title, String[] buttonsText,
                                        final String[] list, int checkedItem,
                                        DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(list, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSelectedItem = list[which];
            }
        });
        if (buttonsText.length > 0)
            builder.setPositiveButton(buttonsText[0], onClickListener);

        if (buttonsText.length > 1)
            builder.setNegativeButton(buttonsText[1], onClickListener);

        builder.show();

    }

}
