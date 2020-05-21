package me.devilsen.bottomdialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import me.devilsen.dialog.bottom.ListBottomDialog;
import me.devilsen.list.ItemClickListener;
import me.devilsen.sheet.bottom.listsheet.ListBottomSheet;

public class MainActivity extends AppCompatActivity {

    private ListBottomSheet sheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showShareBottomDialog(View view) {
        ShareBottomDialog shareBottomDialog = new ShareBottomDialog();
        shareBottomDialog.show(getSupportFragmentManager());
    }

    public void showListBottomDialog(View view) {
        ListBottomDialog bottomDialog = new ListBottomDialog();
        bottomDialog.setData(this, R.menu.create);
        bottomDialog.show(getSupportFragmentManager(), bottomDialog.getTag());
    }

    // sheet与dialog最大的区别就是能滑动这个界面
    public void showListBottomSheet(View view) {
//        ListBottomSheet bottomSheetFragment = new ListBottomSheet();
//        bottomSheetFragment.setData(this, R.menu.create);
//        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

        sheet = new ListBottomSheet
                .Builder(this)
                .sheet(R.menu.create)
                .listener(new ItemClickListener() {
                    @Override
                    public void OnItemClickListener(MenuItem item) {

                    }
                })
                .build();

        sheet.show(getSupportFragmentManager(), sheet.getTag());
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            sheet.setData(MainActivity.this, R.menu.test);
            return true;
        }
    });

}
