package me.devilsen.bottomdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import me.devilsen.sheet.bottom.listsheet.ListBottomSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
//        ShareBottomDialog shareBottomDialog = new ShareBottomDialog();
//        shareBottomDialog.show(getSupportFragmentManager());

//        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
//        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

        ListBottomSheet bottomSheetFragment = new ListBottomSheet();

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        bottomSheetFragment.setData(list);
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());


    }

}
