![Bintray](https://img.shields.io/bintray/v/devilsen/Android/dialog?color=1E88E5&label=version)

# BottomDialog
底部显示的的Dialog

#### 0. 引入
在Gradle中：
```groovy
implementation 'me.devilsen:dialog:0.2'
implementation 'com.google.android.material:material:1.1.0'
```

#### 1. 直接使用
1.1 使用Bottom Sheet
```java
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
```

1.2 使用Bottom Dialog
```java
ListBottomDialog bottomDialog = new ListBottomDialog();
bottomDialog.setData(this, R.menu.create);
bottomDialog.show(getSupportFragmentManager(), bottomDialog.getTag());
```

#### 2. 自定义内容
```java
public class ShareBottomDialog extends BaseBottomDialog {

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_layout;
    }

    @Override
    public void bindView(View v) {
        // do any thing you want
    }
}

ShareBottomDialog shareBottomDialog = new ShareBottomDialog();
shareBottomDialog.show(getSupportFragmentManager());
```

#### 3. 效果展示
|                             :--:                             | :--:                                                         |
| :----------------------------------------------------------: | ------------------------------------------------------------ |
| ![](https://github.com/devilsen/dialog/blob/master/screenshots/case/bottom_dialog.png) | ![](https://github.com/devilsen/dialog/blob/master/screenshots/case/bottom_sheet.png) |



## License

    Copyright 2020 Devilsen
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.