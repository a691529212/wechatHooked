package com.vampire.xpostdeom;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.vampire.xpostdeom.hook.pac.GsonTool;
import com.vampire.xpostdeom.hook.pac.TextFile;
import com.vampire.xpostdeom.hook.path.HookFileBean;
import com.vampire.xpostdeom.hook.path.XPosedSettingHelper;
import com.vampire.xpostdeom.modles.MyCompat;
import com.vampire.xpostdeom.modles.WeChatContent;
import com.vampire.xpostdeom.modles.WeChatContentFeed;
import com.vampire.xpostdeom.service.MyService;
import com.vampire.xpostdeom.utils.ShellUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<WeChatContent> contentList;//l
    private TextView textView; // m
    public SwitchCompat isOpenCompat; // n
    private Button buttonRules;//p t
    private Button buttonContent;// r
    private TextView contentTv; // s
    public XPosedSettingHelper settingHelper; // u
    private SwitchCompat compatAll; // v
    private String string; // w
    private Context context;


    public MainActivity() {
        this.string = "";
        this.contentList = new ArrayList<>();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] shell = new String[]{"am start -n com.tencent.mm/com.tencent.mm.ui.chatting.ChattingUI -e Chat_User wxid_okqdswv95fv621" };
                ShellUtils.execCommand(shell, true);
                Log.d("MainActivity", "click");
            }
        });

    }


    public void posed() {
        // hook.InitInterfaceB.InitInterfaceB.a
        try {
            string = TextFile.string(HookFileBean.filePath + "k.bbc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        if (GsonTool.ghost(string, WeChatContentFeed.class) != null) {
            contentList = GsonTool.ghost(string, WeChatContentFeed.class).contentList;
        }
        if (contentList == null) {
            contentList = new ArrayList<>();
        }
    }

    private void initView() {
//        // 设置回复内容
//        buttonContent = (Button) findViewById(R.id.set_world_btn);
//        buttonContent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setContent();
//            }
//
//            private void setContent() {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_view, null);
//                builder.setView(dialogView);
//                final EditText editText = (EditText) dialogView.findViewById(R.id.dialog_et);
//                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if (editText.getText().length() > 0) {
//                            settingHelper.setString("content", editText.getText().toString());
//                        }
//                    }
//                });
//            }
//        });
//        // 设置回复对象
//        buttonRules = (Button) findViewById(R.id.btn_set_talker);
//        buttonRules.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                choosetalker();
//            }
//
//            private void choosetalker() {
//                posed();
//                ArrayList<String> lists = new ArrayList<String>();
//                Iterator<WeChatContent> iterator = contentList.iterator();
//                while (iterator.hasNext()) {
//                    lists.add(iterator.next().getNickName());
//                }
//            }
//        });
//        settingHelper = new XPosedSettingHelper(this, "com.vampire.xpostdeom");
//        isOpenCompat = (SwitchCompat) findViewById(R.id.is_open_compat);
//        compatAll = (SwitchCompat) findViewById(R.id.all_reply_compat);
//        settingHelper.setString("content", "vampire");
//        isOpenCompat.setOnCheckedChangeListener(new MyCompat(this));
//        isOpenCompat.setChecked(settingHelper.getBoolean("open", false));
//        contentTv = (TextView) findViewById(R.id.tv_content);
//        contentTv.setText(this.settingHelper.getString("content", ""));
//        compatAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean InitInterfaceB) {
//                isReplyAll(InitInterfaceB);
//            }
//
//            private void isReplyAll(boolean InitInterfaceB) {
//                settingHelper.getBoolean("all_user_open", InitInterfaceB);
//                if (settingHelper.getBoolean("all_user_open", InitInterfaceB)) {
//                    buttonContent.setVisibility(View.GONE);
//                } else {
//                    buttonContent.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        if (settingHelper.getBoolean("all_user_open", false)) {
//            buttonRules.setVisibility(View.GONE);
//        } else {
//            buttonRules.setVisibility(View.VISIBLE);
//        }

    }

}
