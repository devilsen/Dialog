package me.devilsen.bottomdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import me.devilsen.list.ItemClickListener;
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

//        ListBottomDialog bottomSheetFragment = new ListBottomDialog();
//        bottomSheetFragment.setData(this, R.menu.create);
//        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

//        ListBottomSheet bottomSheetFragment = new ListBottomSheet();
//        bottomSheetFragment.setData(this, R.menu.create);
//        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

        ListBottomSheet sheet = new ListBottomSheet
                .Builder(this, getSupportFragmentManager())
                .sheet(R.menu.create)
                .listener(new ItemClickListener() {
                    @Override
                    public void OnItemClickListener(MenuItem item) {

                    }
                })
                .build();

        sheet.show(getSupportFragmentManager(), sheet.getTag());

    }

}
