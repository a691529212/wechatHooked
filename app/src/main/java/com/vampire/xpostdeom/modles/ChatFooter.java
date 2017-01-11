package com.vampire.xpostdeom.modles;/**
 * Created by tarena on 2017/1/11.
 */

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v4.BuildConfig;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by Vampire
 * on: 2017/1/11 上午8:24
 */
public class ChatFooter extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener
        , com.tencent.mm.pluginsdk.ui.chat.h.a// int getYFromBottom();
{
    private static final int[] cCa = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    //图片id
    private static final int[] picID = new int[]{2130970510, 2130970511, 2130970471, 2130970512, 2130970540, 2130970447, 2130970462};
    private static int count = 0;
    private Activity activity;
    public String galleryUiToUser;
    public String galleryUiFromUser;
    private final aa log;
    private ImageView cCj;
    private boolean cCr;
    private View cMbView;
    private Context context;
    public View dQvView;
    public View dQwView;
    public View dQxView;
    public View dQyView;
    private String talkerName;
    public EditText editText;
    public Button button;
    public LinearLayout linearLayout;
    public PopupWindow popupWindow;
    private TextView textView;
    private ImageView hvW;
    public View hvX;
    f iGC;
    private int iGD;
    private boolean iLA;
    public Fragment fragment;
    private boolean iLC;
    private Animation iLD;
    private Animation iLE;
    private AlphaAnimation iLF;
    private boolean iLG;
    private com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a interfaceFour; //public interface StringStringInt {void aiv();void aiw();void append(String var1);void cZ(boolean var1);}
    private com.tencent.mm.pluginsdk.ui.chat.AppPanel.b interfaceOne; // public interface InitInterfaceB { void aSv();}
    public ChatFooter.d textWatcher;
    private int iLK;
    public boolean iLL;
    private final int iLM;
    private final int iLN;
    private final int iLO;
    private final int iLP;
    private final int iLQ;
    private final int iLR;
    private final int iLS;
    private int iLT;
    private int iLU;
    private int iLV;
    private boolean iLW;
    private final int messageWhatNum1;
    private final int messageWhatNum2;
    private volatile boolean iLZ;
    public LinearLayout iLa;
    public AppPanel iLb;
    public RelativeLayout relativeLayout;
    public TextView iLd;
    public Button iLe;
    public ImageButton iLf;
    public LinearLayout iLg;
    public ChatFooterBottom iLh;
    public ImageButton iLi;
    public ImageButton iLj;
    private Dialog dialog;
    private Fragment iLl;
    public l emioj;
    private com.tencent.mm.pluginsdk.ui.chat.b tenMeathInterface;
    private InitInterface initInterface;
    public final StringStringInt stringStringInt;
    public boolean iLq;
    private boolean iLr;
    private TextView iLs;
    private InputMethodManager iLt;
    private int iLu;
    private boolean iLv;
    private boolean iLw;
    public boolean iLx;
    public InitInterfaceB initInterFaceInitInterfaceB;
    private com.tencent.mm.pluginsdk.ui.chat.l.a clearInterface;
    private aa thread;
    private int iMb;
    private int iMc;
    private int iMd;
    private View iMe;
    public boolean iMf;
    private int iMg;
    public final aa mHandler;
    private int rl;

    static {
        if(!BuildConfig.SKIP) {
            A.a();
        }

    }

    public ChatFooter(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
        if(!BuildConfig.SKIP) {
            A.a();
        }

    }

    public ChatFooter(final Context var1, AttributeSet var2, int var3) {
        super(var1, var2);
        this.cMbView = null;
        this.relativeLayout = null;
        this.editText = null;
        this.button = null;
        this.iLd = null;
        this.initInterface = null;
        this.stringStringInt = new StringStringInt((byte)0);
        this.iLq = false;
        this.iLr = false;
        this.cCr = false;
        this.iLv = false;
        this.iLw = false;
        this.iLx = false;
        // editText 设置""值
        this.clearInterface = new com.tencent.mm.pluginsdk.ui.chat.l.a() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }
            }
            public final void clear() {
                ChatFooter var1 = ChatFooter.this;
                if(var1.editText != null) {
                    var1.editText.setText("");
                }

            }
        };
        // 设置editText动态透明度
        this.mHandler = new aa() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }
            }
            @SuppressLint({"NewApi"})
            @TargetApi(11)
            public final void handleMessage(Message var1) {
                switch(var1.what) {
                    case 1002:
                        if(ChatFooter.this.editText != null && var1.obj != null) {
                            boolean var2 = ((Boolean)var1.obj).booleanValue();
                            if(var2) {
                                ChatFooter.this.editText.setAlpha(1.0F);
                            } else {
                                ChatFooter.this.editText.setAlpha(0.5F);
                            }

                            ChatFooter.this.ge(var2);
                        }
                    default:
                }
            }
        };
        this.iLA = false;
        this.iLC = false;
        this.iLF = null;
        this.iLG = false;

        this.interfaceFour = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }
            }
            public final void aiv() {
                ChatFooter.z(ChatFooter.this);
                ChatFooter.this.iLg.setVisibility(0);
                ChatFooter.this.iLe.setVisibility(8);
                ChatFooter.this.ge(true);
                ChatFooter.B(ChatFooter.this);
                if(ChatFooter.this.button != null) {
                    // 执行点击事件
                    ChatFooter.this.button.performClick();
                }
            }

            // 键盘事件监听
            public final void aiw() {
                ChatFooter.z(ChatFooter.this);
                ChatFooter.this.iLg.setVisibility(0);
                ChatFooter.this.iLe.setVisibility(8);
                ChatFooter.this.ge(true);
                ChatFooter.B(ChatFooter.this);
                ChatFooter.this.editText.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                ChatFooter.this.editText.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            }

            // 设置editText光标位置
            public final void append(String var1) {
                ChatFooter.z(ChatFooter.this);
                ChatFooter.this.iLg.setVisibility(0);
                ChatFooter.this.iLe.setVisibility(8);
                ChatFooter.this.ge(true);
                ChatFooter.B(ChatFooter.this);
                try {
                    ChatFooter.this.editText.Ir(var1);
                } catch (Exception var2) {
                    ;
                }
            }

            //setToSendTextColor
            public final void cZ(boolean var1) {
                ChatFooter.z(ChatFooter.this);
                ChatFooter.this.iLg.setVisibility(0);
                ChatFooter.this.iLe.setVisibility(8);
                ChatFooter.B(ChatFooter.this);
                if(ChatFooter.this.editText != null) {
                    ChatFooter.this.setToSendTextColor(var1);
                }

            }
        };

        this.interfaceOne = new com.tencent.mm.pluginsdk.ui.chat.AppPanel.b() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void aSv() {
                boolean var1 = com.tencent.mm.pluginsdk.g.a.a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 1280, "", "");
                u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "summerper checkPermission checkmicrophone[%InitInterfaceB], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(var1), ba.aWQ(), ChatFooter.this.activity});
                if(var1) {
                    // c方法未知
                    ChatFooter.C(ChatFooter.this);
                }

            }
        };
        this.log = new aa() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }
            }

            public final void handleMessage(Message var1) {
                super.handleMessage(var1);
                if(ChatFooter.this.popupWindow != null) {
                    ChatFooter.this.popupWindow.dismiss();
                    ChatFooter.this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(ChatFooter.this.getContext(), 2130970250));
                    ChatFooter.this.iLe.setEnabled(true);
                }
            }
        };
        this.iLK = 0;
        this.iLL = false;
        this.iLM = 0;
        this.iLN = 1;
        this.iLO = 2;
        this.iLP = 3;
        this.iLQ = 20;
        this.iLR = 21;
        this.iLS = 22;
        this.iLT = 0;
        this.iLU = 0;
        this.iLV = -1;
        this.rl = -1;
        this.iLW = false;
        this.messageWhatNum1 = 4097;
        this.messageWhatNum2 = 4098;
        this.thread = new aa() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void handleMessage(Message var1) {
                super.handleMessage(var1);
                switch(var1.what) {
                    case 4097:
                        ChatFooter.this.iLZ = true;
                        LayoutParams var3 = ChatFooter.this.iLh.getLayoutParams();
                        int var2 = ChatFooter.this.iLh.getBottom() - ChatFooter.this.iLh.getTop();
                        if(ChatFooter.this.aSS()) {
                            if(ChatFooter.this.linearLayout != null) {
                                ChatFooter.this.linearLayout.setVisibility(8);
                            }

                            ChatFooter.this.iLb.setVisibility(8);
                            ChatFooter.this.iLh.setVisibility(4);
                        }

                        if(var2 <= 3) {
                            ChatFooter.this.iLZ = false;
                            ChatFooter.this.iLh.setVisibility(8);
                            ChatFooter.this.pc(ChatFooter.this.getKeyBordHeightPX());
                        } else {
                            var3.height = Math.max(var2 - 60, 1);
                            ChatFooter.this.iLh.setLayoutParams(var3);
                            ChatFooter.L(ChatFooter.this);
                        }
                    default:
                }
            }
        };
        this.iMb = -1;
        this.iMc = -1;
        this.iMd = -1;
        this.iMe = null;
        this.iMf = true;
        this.iMg = 0;
        long var4 = System.currentTimeMillis();
        this.iLt = (InputMethodManager)var1.getSystemService("input_method");
        this.cMbView = inflate(var1, 2131363091, this);
        this.editText = (MMEditText)this.cMbView.findViewById(2131169163);
        com.tencent.mm.ui.tools.a.c.a(this.editText).sB(com.tencent.mm.g.b.nX()).a((com.tencent.mm.ui.tools.a.c.a)null);
        this.editText.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        jm var6 = new jm();
        var6.asP.asR = this.editText;
        var6.asP.asQ = new com.tencent.mm.pluginsdk.ui.a.a() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void Bi(final String var1) {
                u.e("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "hakon onImageReceived, %s", new Object[]{var1});
                if(!ba.kU(ChatFooter.this.talkerName) && !ba.kU(var1)) {
                    g.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131431412), "", new OnClickListener() {
                        {
                            if(!BuildConfig.SKIP) {
                                A.a();
                            }

                        }

                        public final void onClick(DialogInterface var1x, int var2) {
                            byte var5 = 1;
                            boolean var3 = com.tencent.mm.model.h.b(var1, ChatFooter.this.talkerName, true);
                            ChatFooter var4 = ChatFooter.this;
                            if(!var3) {
                                var5 = 0;
                            }

                            ChatFooter.a(var4, var5, var1);
                        }
                    }, new OnClickListener() {
                        {
                            if(!BuildConfig.SKIP) {
                                A.a();
                            }

                        }

                        public final void onClick(DialogInterface var1, int var2) {
                        }
                    });
                } else {
                    u.e("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "onImageReceived, error args");
                }

            }
        };
        com.tencent.mm.sdk.c.a.jWF.m(var6);
        this.iLg = (LinearLayout)this.cMbView.findViewById(2131169162);
        this.iLh = (ChatFooterBottom)this.findViewById(2131169169);
        this.iLi = (ImageButton)this.cMbView.findViewById(2131169167);
        this.button = (Button)this.cMbView.findViewById(2131169168);
        this.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.iLe = (Button)this.cMbView.findViewById(2131169165);
        this.iLf = (ImageButton)this.findViewById(2131169161);
        this.cY(false);
        this.aSY();
        this.iLl = new i(this.getContext(), this.getRootView(), this, new com.tencent.mm.pluginsdk.ui.chat.i.a() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void Bm(String var1x) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(var1x);
                if(ChatFooter.this.galleryUiFromUser != null) {
                    intent.putExtra("GalleryUI_FromUser", ChatFooter.this.galleryUiFromUser);
                }

                if(ChatFooter.this.galleryUiToUser != null) {
                    intent.putExtra("GalleryUI_ToUser", ChatFooter.this.galleryUiToUser);
                }

                intent.putExtra("query_source_type", 3);
                intent.putExtra("preview_image", true);
                intent.putStringArrayListExtra("preview_image_list", arrayList);
                intent.putExtra("max_select_count", 1);
                intent.addFlags(67108864);
                if(ChatFooter.this.fragment != null) {
                    com.tencent.mm.au.c.a(ChatFooter.this.fragment, "gallery", ".ui.GalleryEntryUI", intent, 217);
                } else {
                    com.tencent.mm.au.c.a(var1, "gallery", ".ui.GalleryEntryUI", intent, 217);
                }

            }
        });
        this.iLl.iMH = this;
        this.emioj = new l(this.getContext(), this.getRootView(), this, this.editText);
        this.emioj.iLz = this.clearInterface;
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "send edittext ime option %s", new Object[]{Integer.valueOf(this.editText.getImeOptions())});
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                boolean var4;
                if(i != 4 && (i != 0 || !ChatFooter.this.iLw)) {
                    var4 = false;
                } else {
                    ChatFooter.this.button.performClick();
                    var4 = true;
                }

                return var4;
            }
        });
        this.editText.setOnTouchListener(new OnTouchListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onTouch(View var1, MotionEvent var2) {
                ChatFooter.this.setToSendTextColor(true);
                ChatFooter.i(ChatFooter.this);
                ChatFooter.this.tenMeathInterface.ajf();
                ChatFooter.k(ChatFooter.this);
                return false;
            }
        });
        this.editText.setOnLongClickListener(new OnLongClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onLongClick(View var1) {
                return false;
            }
        });
        this.button.setOnClickListener(new android.view.View.OnClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void onClick(View view) {
                synchronized(this){}

                try {
                    String content = ChatFooter.this.editText.getText().toString();
                    u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "send msg onClick");
                    if(content.trim().length() == 0 && content.length() != 0) {
                        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "empty message cant be sent");
                        if(ChatFooter.this.dialog == null || !ChatFooter.this.dialog.isShowing()) {
                            ChatFooter.this.dialog = g.f(ChatFooter.this.getContext(), 2131427901, 2131430945);
                        }
                    } else if(ChatFooter.this.tenMeathInterface.rM(content)) {
                        ChatFooter.this.editText.clearComposingText();
                        ChatFooter.this.editText.setText("");
                    }
                } finally {
                    ;
                }

            }
        });
        this.iLe.setOnTouchListener(new OnTouchListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onTouch(View var1, MotionEvent var2) {
                if(var1 == ChatFooter.this.iLe) {
                    u.v("RcdBtnEvent", "event.getAction():" + var2.getAction());
                    switch(var2.getAction()) {
                        case 0:
                            u.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[]{Integer.valueOf(ChatFooter.count)});
                            if(ChatFooter.this.context instanceof Activity) {
                                ((Activity)ChatFooter.this.context).getWindow().addFlags(128);
                            }

                            if(!ChatFooter.this.cCr && !ChatFooter.this.iLv) {
                                ChatFooter.this.cCr = true;
                                ChatFooter.this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(ChatFooter.this.getContext(), 2130970214));
                                ChatFooter.this.iLe.setText(2131428019);
                                ChatFooter.this.tenMeathInterface.ajc();
                                ChatFooter.this.iLe.setContentDescription(ChatFooter.this.getContext().getString(2131429638));
                            }
                            break;
                        case 1:
                            if(ChatFooter.this.context instanceof Activity) {
                                ((Activity)ChatFooter.this.context).getWindow().clearFlags(128);
                            }

                            u.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP:[%d]", new Object[]{Integer.valueOf(ChatFooter.count)});
                            ChatFooter.this.aSW();
                            u.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP:[%d]", new Object[]{Integer.valueOf(ChatFooter.aTa())});
                            break;
                        case 2:
                            if(ChatFooter.this.dQxView == null || ChatFooter.this.dQyView == null) {
                                u.e("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[]{ChatFooter.this.dQxView, ChatFooter.this.dQyView});
                            }

                            if(var2.getX() > 0.0F && var2.getY() > (float)(-ChatFooter.this.iLK / 2) && var2.getX() < (float)ChatFooter.this.iLe.getWidth()) {
                                if(ChatFooter.this.dQxView != null) {
                                    ChatFooter.this.dQxView.setVisibility(0);
                                }

                                if(ChatFooter.this.dQyView != null) {
                                    ChatFooter.this.iLe.setText(2131428019);
                                    ChatFooter.this.dQyView.setVisibility(8);
                                }
                            } else {
                                u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", new Object[]{Float.valueOf(var2.getX()), Float.valueOf(var2.getY()), Integer.valueOf(ChatFooter.this.iLK), Integer.valueOf(ChatFooter.this.iLe.getWidth()), Integer.valueOf(ChatFooter.this.iLe.getHeight())});
                                if(ChatFooter.this.dQxView != null) {
                                    ChatFooter.this.dQxView.setVisibility(8);
                                }

                                if(ChatFooter.this.dQyView != null) {
                                    ChatFooter.this.iLe.setText(2131428025);
                                    ChatFooter.this.dQyView.setVisibility(0);
                                }
                            }
                            break;
                        case 3:
                            u.i("RcdBtnEvent", "ACTION_CANCEL");
                            if(ChatFooter.this.context instanceof Activity) {
                                ((Activity)ChatFooter.this.context).getWindow().clearFlags(128);
                            }
                    }
                }

                return false;
            }
        });
        this.iLe.setOnKeyListener(new OnKeyListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onKey(View var1, int var2, KeyEvent var3) {
                switch(var3.getAction()) {
                    case 0:
                        if((var2 == 23 || var2 == 66) && !ChatFooter.this.iLv && !ChatFooter.this.cCr) {
                            ChatFooter.this.iLv = true;
                            ChatFooter.this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(ChatFooter.this.getContext(), 2130970214));
                            ChatFooter.this.iLe.setText(2131428019);
                            ChatFooter.this.tenMeathInterface.ajc();
                            ChatFooter.this.iLe.setContentDescription(ChatFooter.this.getContext().getString(2131429638));
                        }
                        break;
                    case 1:
                        if(var2 == 23 || var2 == 66) {
                            ChatFooter.this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(ChatFooter.this.getContext(), 2130970250));
                            ChatFooter.this.iLe.setText(2131428018);
                            ChatFooter.this.tenMeathInterface.aiZ();
                            ChatFooter.this.iLv = false;
                        }
                }

                return false;
            }
        });
        this.iLf.setOnClickListener(new android.view.View.OnClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void onClick(View var1) {
                ChatFooter.q(ChatFooter.this);
            }
        });
        this.aSy();
        this.iLi.setVisibility(0);
        this.iLi.setContentDescription(this.getContext().getString(2131429644));
        this.iLi.setOnClickListener(new android.view.View.OnClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void onClick(View var1) {
                ChatFooter.this.aSw();
                if(com.tencent.mm.model.h.sa().booleanValue() && ChatFooter.this.initInterFaceInitInterfaceB != null) {
                    ChatFooter.this.initInterFaceInitInterfaceB.a(Boolean.valueOf(true), Boolean.valueOf(true));
                }

            }
        });
        this.pc(-1);
        this.relativeLayout = (F2FButton)this.cMbView.findViewById(2131169160);
        this.relativeLayout.setVisibility(8);
        this.relativeLayout.setOnClickListener(new android.view.View.OnClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void onClick(View var1) {
                am var2 = new am();
                com.tencent.mm.sdk.c.a.jWF.m(var2);
            }
        });
        this.findViewById(2131169158).setOnTouchListener(new OnTouchListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final boolean onTouch(View var1, MotionEvent var2) {
                return true;
            }
        });
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - var4)});
        if(!BuildConfig.SKIP) {
            A.a();
        }

    }

    private boolean aSU() {
        boolean var1;
        if(this.iLV > 0 && this.iLV < this.rl) {
            var1 = true;
        } else {
            var1 = false;
        }

        return var1;
    }

    private void aSy() {
        this.iLb = (AppPanel)this.findViewById(2131169170);
        this.iLb.setOnSwitchPanelListener(this.interfaceOne);
        this.iLb.setPortHeighPx(this.getKeyBordHeightPX());
        if(!com.tencent.mm.model.i.eX(this.talkerName) && !com.tencent.mm.model.i.eR(this.talkerName)) {
            if(com.tencent.mm.model.i.ep(this.talkerName)) {
                this.iLb.init(4);
            } else if(com.tencent.mm.model.i.dA(this.talkerName)) {
                this.iLb.init(2);
            } else {
                this.iLb.init(1);
            }
        } else {
            this.iLb.init(0);
        }

    }

    private void cY(boolean var1) {
        if(this.iLD == null) {
            this.iLD = AnimationUtils.loadAnimation(this.getContext(), 2130837586);
            this.iLD.setDuration(150L);
        }

        if(this.iLE == null) {
            this.iLE = AnimationUtils.loadAnimation(this.getContext(), 2130837595);
            this.iLE.setDuration(150L);
        }

        if(this.button != null && this.iLi != null) {
            if(this.iLA) {
                if(this.iLi.getVisibility() != 0) {
                    this.iLi.setVisibility(0);
                }
            } else if((this.button.getVisibility() != 0 || !var1) && (this.iLi.getVisibility() != 0 || var1)) {
                if(var1) {
                    this.button.startAnimation(this.iLD);
                    this.button.setVisibility(0);
                    this.iLi.startAnimation(this.iLE);
                    this.iLi.setVisibility(8);
                } else {
                    this.iLi.startAnimation(this.iLD);
                    if(!this.iLr) {
                        this.iLi.setVisibility(0);
                    }

                    this.button.startAnimation(this.iLE);
                    this.button.setVisibility(8);
                }

                u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks canSend:%B", new Object[]{Boolean.valueOf(var1)});
                this.button.getParent().requestLayout();
            }
        }

    }

    private void gj(boolean var1) {
        if(this.iLj != null && (!this.iLW || !var1) && (this.iLW || var1)) {
            this.iLW = var1;
            if(var1) {
                this.iLj.setImageDrawable(this.getContext().getResources().getDrawable(2130903670));
            } else {
                this.iLj.setImageDrawable(this.getContext().getResources().getDrawable(2130969974));
            }
        }

    }

    private void oY(int var1) {
        if(this.iLf != null) {
            boolean var2;
            if(var1 == 2130970246) {
                var2 = true;
            } else {
                var2 = false;
            }

            if(this.iLf != null) {
                if(var2) {
                    this.iLf.setContentDescription(this.getContext().getString(2131429640));
                } else {
                    this.iLf.setContentDescription(this.getContext().getString(2131429641));
                }
            }

            this.iLf.setImageResource(var1);
            this.iLf.setPadding(0, this.getResources().getDimensionPixelSize(2131034645), 0, this.getResources().getDimensionPixelSize(2131034576));
        }

    }

    private void pb(int var1) {
        this.iLu = var1;
        switch(var1) {
            case 1:
                this.iLg.setVisibility(0);
                this.iLe.setVisibility(8);
                this.oY(2130970246);
                break;
            case 2:
                this.iLg.setVisibility(8);
                this.iLe.setVisibility(0);
                this.oY(2130970295);
                if(com.tencent.mm.model.h.sa().booleanValue() && this.initInterFaceInitInterfaceB != null) {
                    this.initInterFaceInitInterfaceB.b(Boolean.valueOf(true), Boolean.valueOf(true));
                }
        }

    }

    public final void J(int var1, boolean var2) {
        boolean var3 = true;
        this.pb(var1);
        switch(var1) {
            case 1:
                this.ge(true);
                this.aSV();
                if(var2) {
                    this.i(1, -1, true);
                    if(this.editText.length() > 0) {
                        var2 = var3;
                    } else {
                        var2 = false;
                    }

                    this.cY(var2);
                } else {
                    this.cY(false);
                }
                break;
            case 2:
                this.i(0, -1, false);
                this.cY(false);
                break;
            default:
                this.setVisibility(0);
        }

    }

    public final void RZ() {
        this.iLx = true;
        if(this.linearLayout != null) {
            this.linearLayout.RZ();
        }

    }

    public final void XP() {
        this.post(new Runnable() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void run() {
                if(ChatFooter.this.popupWindow != null) {
                    ChatFooter.this.popupWindow.dismiss();
                    ChatFooter.this.dQvView.setVisibility(0);
                    ChatFooter.this.hvX.setVisibility(8);
                    ChatFooter.this.dQwView.setVisibility(8);
                    ChatFooter.this.dQyView.setVisibility(8);
                    ChatFooter.this.dQxView.setVisibility(0);
                }

                ChatFooter.this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(ChatFooter.this.getContext(), 2130970250));
                ChatFooter.this.iLe.setText(2131428018);
                ChatFooter.this.iLv = false;
                ChatFooter.this.cCr = false;
            }
        });
    }

    public final void a(Context var1, Activity var2) {
        this.activity = var2;
        this.aSY();
        if(this.linearLayout != null) {
            this.linearLayout.onResume();
        }

        if(!this.iLA && this.iLw) {
            u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks chatting footer disable enter button send");
            this.iLw = false;
            this.editText.setImeOptions(0);
            this.editText.setInputType(this.editText.getInputType() | 64);
        } else if(this.iLA && !this.iLw) {
            this.aSP();
        }

        if(this.iLb != null) {
            this.iLb.context = var1;
        }

        this.context = var1;
        this.iLl.iMG = false;
        this.cMbView.findViewById(2131169166).setVisibility(0);
        this.aSO();
        this.post(new Runnable() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void run() {
                com.tencent.mm.compatible.util.h.e(ChatFooter.this.activity);
            }
        });
    }

    public final void aSA() {
        this.iLe.setEnabled(false);
        this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(this.getContext(), 2130970307));
        if(this.popupWindow != null) {
            this.dQwView.setVisibility(0);
            this.dQvView.setVisibility(8);
            this.hvX.setVisibility(8);
            this.popupWindow.update();
        }

        this.log.sendEmptyMessageDelayed(0, 500L);
    }

    public final void aSB() {
        this.hvX.setVisibility(8);
        this.dQvView.setVisibility(0);
    }

    public final void aSC() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKD.value = false;
        var1.aSo();
    }

    public final void aSD() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKV.value = false;
        var1.aSo();
    }

    public final void aSE() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKE.value = false;
        var1.aSo();
    }

    public final void aSF() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKG.value = false;
        var1.aSo();
    }

    public final void aSG() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKH.value = false;
        var1.aSo();
    }

    public final void aSH() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKU.value = false;
        var1.aSo();
    }

    public final void aSI() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKI.value = false;
        var1.aSo();
        u.d("!32@/B4Tb64lLpIswCbzJzq2kbhBmMfFikWd", "enable false" + " isVoipPluginEnable " + var1.iKm.iKJ.value);
        this.iLb.ga(true);
    }

    public final void aSJ() {
        AppPanel var1 = this.iLb;
        var1.iKt = true;
        var1.iKm.gd(false);
        var1.aSo();
    }

    public final void aSK() {
        AppPanel var1 = this.iLb;
        var1.iKu = true;
        var1.iKm.gc(false);
        var1.aSo();
    }

    public final void aSL() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKN.value = false;
        var1.aSo();
        u.d("!32@/B4Tb64lLpIswCbzJzq2kbhBmMfFikWd", "disableTalkroom enable false");
    }

    public final void aSM() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKS.value = false;
        var1.aSo();
    }

    public final void aSN() {
        AppPanel var1 = this.iLb;
        var1.iKm.iKM.value = false;
        var1.aSo();
    }

    public final void aSO() {
        this.iLj = (ImageButton)this.cMbView.findViewById(2131169164);
        this.iLj.setVisibility(0);
        this.iLj.setOnClickListener(new android.view.View.OnClickListener() {
            {
                if(!BuildConfig.SKIP) {
                    A.a();
                }

            }

            public final void onClick(View var1) {
                ChatFooter.this.tenMeathInterface.ajd();
                if(!ChatFooter.this.iLh.awe && ChatFooter.this.linearLayout != null && ChatFooter.this.linearLayout.getVisibility() == 0) {
                    ChatFooter.this.i(1, -1, true);
                } else {
                    if(ChatFooter.this.iLr) {
                        ChatFooter.this.RZ();
                    }

                    ChatFooter.this.aSz();
                    if(!ba.kU(ChatFooter.this.editText.getText().toString())) {
                        ChatFooter.this.linearLayout.Sc();
                    }
                }

            }
        });
        if(this.emioj != null) {
            this.emioj.iMQ = this.iLj;
        }

    }

    public final void aSP() {
        u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks chatting footer enable enter button send");
        this.iLw = true;
        this.editText.setImeOptions(4);
        this.editText.setInputType(this.editText.getInputType() & -65);
    }

    public final void aSQ() {
        if(this.linearLayout != null) {
            this.linearLayout.RY();
        }

    }

    public final void aSR() {
        this.iLb.refresh();
    }

    public final boolean aSS() {
        boolean var1;
        if(this.iLh.getVisibility() == 0) {
            var1 = true;
        } else {
            var1 = false;
        }

        return var1;
    }

    public final void aST() {
        this.i(2, 20, false);
    }

    public final void aSV() {
        this.iLh.setVisibility(8);
        this.iLb.setVisibility(8);
        if(this.linearLayout != null) {
            this.linearLayout.setVisibility(8);
        }

        this.gj(false);
    }

    public final void aSW() {
        this.cCr = false;
        this.iLe.setBackgroundDrawable(com.tencent.mm.az.a.B(this.getContext(), 2130970250));
        this.iLe.setText(2131428018);
        if(this.tenMeathInterface != null) {
            if(this.dQyView != null && this.dQyView.getVisibility() == 0) {
                this.tenMeathInterface.ajb();
            } else {
                this.tenMeathInterface.aiZ();
            }
        }

    }

    public final boolean aSX() {
        boolean var1;
        if(this.iLU - this.getTop() > 50) {
            var1 = true;
        } else {
            var1 = false;
        }

        return var1;
    }

    public final void aSY() {
        this.iLA = ((Boolean)ah.sR().qE().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public final void aSw() {
        this.tenMeathInterface.aje();
        if(this.iLb.getVisibility() == 0 && !this.iLh.awe) {
            if(this.iLu == 1) {
                this.i(1, -1, true);
            } else {
                this.i(0, -1, false);
            }
        } else {
            this.i(2, 22, true);
            if(this.iLa != null && this.iLa.getVisibility() == 0) {
                u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.iLa.setVisibility(8);
                this.iLa.iMV.aRY();
            }

            ak var1 = ak.aQM();
            Context var2 = y.getContext();
            if(ah.qy() && var2 != null) {
                label80: {
                    try {
                        String var3 = com.tencent.mm.g.h.oy().getValue("ShowAPPSuggestion");
                        if(ba.kU(var3) || Integer.valueOf(var3).intValue() != 1) {
                            u.w("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "cfgShowAppSuggestion %s, return", new Object[]{var3});
                            break label80;
                        }
                    } catch (Exception var4) {
                        u.e("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "exception in getSuggestionAppList, %s", new Object[]{var4.getMessage()});
                    }

                    if(var1.iCb) {
                        u.w("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "SuggestionApp is Loading");
                    } else {
                        u.i("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "getSuggestionAppList");
                        var1.iCb = true;
                        if(System.currentTimeMillis() - var1.iCe < 43200000L) {
                            u.d("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "not now");
                            var1.iCb = false;
                        } else {
                            var1.iCe = ah.sR().qE().qa(352275);
                            if(System.currentTimeMillis() - var1.iCe < 43200000L) {
                                u.w("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "not now sp");
                                var1.iCb = false;
                            } else {
                                if(var1.bPb == null) {
                                    var1.bPb = t.d(var2.getSharedPreferences(y.aVK(), 0));
                                }

                                ac var5 = new ac(var1.bPb, new LinkedList());
                                aj.acu();
                                com.tencent.mm.pluginsdk.model.app.d.a(4, var5);
                            }
                        }
                    }
                }
            }

            var1 = ak.aQM();
            var2 = y.getContext();
            if(ah.qy() && var2 != null) {
                if(var1.iCc) {
                    u.d("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "ServiceAppInfo is loading, return");
                } else {
                    var1.iCc = true;
                    if(System.currentTimeMillis() - var1.iCh < 43200000L) {
                        u.d("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "getServiceAppInfo not now");
                        var1.iCc = false;
                    } else {
                        var1.iCh = ah.sR().qE().qa(352276);
                        if(System.currentTimeMillis() - var1.iCh < 43200000L) {
                            u.d("!44@/B4Tb64lLpJUej9RrA1bOWmsIpR3UVONBzVGWKMsBOw=", "getServiceAppInfo not now pp");
                            var1.iCc = false;
                        } else {
                            if(var1.bPb == null) {
                                var1.bPb = t.d(var2.getSharedPreferences(y.aVK(), 0));
                            }

                            ak.aJ(var1.bPb, var1.iCg);
                        }
                    }
                }
            }
        }

    }

    public final void aSx() {
        if(e.iMA == null) {
            this.linearLayout = new com.tencent.mm.pluginsdk.ui.chat.d(this.context);
        } else {
            if(this.linearLayout != null) {
                this.linearLayout.destroy();
            }

            this.linearLayout = e.iMA.bs(this.context);
            if(this.linearLayout != null) {
                if(this.linearLayout != null) {
                    this.linearLayout.setVisibility(8);
                }

                if(this.linearLayout != null) {
                    this.linearLayout.setFooterType(this.iGD);
                }

                if(this.iLh != null) {
                    this.iLh.addView(this.linearLayout, -1, -2);
                }

                if(this.linearLayout != null) {
                    this.linearLayout.setOnTextOperationListener(this.interfaceFour);
                }

                if(this.linearLayout != null) {
                    ChatFooterPanel var2 = this.linearLayout;
                    boolean var1;
                    if(this.editText.getText().length() > 0) {
                        var1 = true;
                    } else {
                        var1 = false;
                    }

                    var2.setSendButtonEnable(var1);
                }

                if(this.linearLayout != null) {
                    this.linearLayout.setTalkerName(this.talkerName);
                    this.linearLayout.setPortHeightPx(this.getKeyBordHeightPX());
                    if(!ba.kU(this.editText.getText().toString())) {
                        this.linearLayout.Sc();
                    }
                }

                if(this.iLx) {
                    this.RZ();
                }

                this.setSmileyPanelCallback(this.iGC);
            }
        }

    }

    public final void aSz() {
        this.iLu = 1;
        this.iLg.setVisibility(0);
        this.iLe.setVisibility(8);
        if(this.iLa != null) {
            this.iLa.setVisibility(8);
        }

        this.i(2, 21, true);
    }

    public final void addTextChangedListener(TextWatcher var1) {
        this.textWatcher = new ChatFooter.d(var1);
        this.editText.addTextChangedListener(this.textWatcher);
    }

    public final void destroy() {
        if(this.linearLayout != null) {
            u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks chat footer desctory smiley panel");
            this.linearLayout.RX();
            this.linearLayout.destroy();
            this.linearLayout = null;
        }

        if(this.tenMeathInterface != null) {
            this.tenMeathInterface.release();
        }

        if(this.emioj != null) {
            this.emioj.iLz = null;
            this.emioj.iMR = null;
        }

        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks destory");
    }

    public final void ge(boolean var1) {
        this.gf(var1);
        this.gg(var1);
    }

    public String getAtSomebody() {
        return this.stringStringInt.iMm;
    }

    public int getBarGroupHeight() {
        return this.findViewById(2131169158).getHeight();
    }

    public f getCallback() {
        return this.iGC;
    }

    public char getCharAtCursor() {
        int var2 = this.getSelectionStart();
        char var1;
        if(var2 <= 0) {
            var1 = 120;
        } else {
            var1 = this.getLastText().charAt(var2 - 1);
        }

        return var1;
    }

    public int getInsertPos() {
        return this.stringStringInt.iMn;
    }

    public int getKeyBordHeightPX() {
        return com.tencent.mm.compatible.util.h.ay(this.getContext());
    }

    public String getLastContent() {
        return this.stringStringInt.iMl;
    }

    public String getLastText() {
        String var1;
        if(this.editText == null) {
            var1 = "";
        } else {
            var1 = this.editText.getText().toString();
        }

        return var1;
    }

    public int getMode() {
        return this.iLu;
    }

    public View getPanel() {
        return this.iLh;
    }

    public int getSelectionStart() {
        return this.editText.getSelectionStart();
    }

    public int getSmieyType() {
        return 0;
    }

    public int getYFromBottom() {
        int var3 = com.tencent.mm.compatible.util.h.aB(this.getContext());
        int var2 = this.getHeight();
        int var1 = var2;
        if(var2 < var3) {
            var1 = var2 + var3;
        }

        return var1;
    }

    public final void gf(boolean var1) {
        if(this.editText != null) {
            if(var1) {
                this.editText.requestFocus();
            } else {
                this.editText.clearFocus();
            }
        }

    }

    public final void gg(boolean var1) {
        if(this.cMbView != null) {
            if(var1) {
                this.cMbView.findViewById(2131169162).setEnabled(true);
            } else {
                this.cMbView.findViewById(2131169162).setEnabled(false);
            }
        }

    }

    public final void gh(boolean var1) {
        AppPanel var2 = this.iLb;
        if(!var1) {
            var1 = true;
        } else {
            var1 = false;
        }

        var2.iKm.iKX.value = var1;
        var2.aSo();
        u.d("!32@/B4Tb64lLpIswCbzJzq2kbhBmMfFikWd", "enable " + var2.iKm.iKX.value + " isMultiTalkEnable " + var1);
    }

    public final void gi(boolean var1) {
        AppPanel var2 = this.iLb;
        if(!var1) {
            var1 = true;
        } else {
            var1 = false;
        }

        var2.iKm.iKQ.value = var1;
        var2.aSo();
    }

    public final void i(int var1, int var2, boolean var3) {
        boolean var5 = true;
        boolean var4;
        if(var3) {
            if(com.tencent.mm.model.h.sa().booleanValue() && this.initInterFaceInitInterfaceB != null) {
                this.initInterFaceInitInterfaceB.a(Boolean.valueOf(true), Boolean.valueOf(false));
                this.initInterFaceInitInterfaceB.b(Boolean.valueOf(true), Boolean.valueOf(false));
            }

            this.iLi.setContentDescription(this.getContext().getString(2131429643));
            switch(var1) {
                case 1:
                    this.iLh.setIsHide(true);
                    this.ge(true);
                    this.setToSendTextColor(true);
                    this.iLt.showSoftInput(this.editText, 0);
                    var4 = var3;
                    break;
                case 2:
                    if(var2 == 22) {
                        if(this.iLb == null) {
                            this.aSy();
                        }

                        this.iLb.aSs();
                        if(this.linearLayout != null) {
                            this.linearLayout.setVisibility(8);
                        }

                        this.iLb.setVisibility(0);
                        i var6 = this.iLl;
                        2 var7 = new 2(var6, var6.context.getMainLooper());
                        ah.sJ().t(new 3(var6, var7));
                        this.ge(false);
                        if(this.iLu == 2) {
                            this.pb(1);
                        }
                    } else if(var2 == 21) {
                        if(this.iLb != null) {
                            this.iLb.setVisibility(8);
                        }

                        if(this.linearLayout == null) {
                            this.aSx();
                        }

                        this.linearLayout.onResume();
                        if(this.linearLayout != null) {
                            this.linearLayout.setVisibility(0);
                        }

                        this.gj(true);
                        this.ge(true);
                    }

                    this.iLh.setVisibility(0);
                    if(!this.aSU() || !com.tencent.mm.compatible.util.h.aD(this.getContext())) {
                        LayoutParams var8 = this.iLh.getLayoutParams();
                        if(var8 != null && var8.height == 0) {
                            var8.height = com.tencent.mm.compatible.util.h.aB(this.getContext());
                            this.iLh.setLayoutParams(var8);
                        }
                    }

                    ba.ai(this);
                    var4 = var3;
                    break;
                case 3:
                    this.iLh.setIsHide(true);
                    this.ge(true);
                    this.setToSendTextColor(true);
                    var4 = var3;
                    break;
                default:
                    var4 = false;
            }
        } else {
            this.iLi.setContentDescription(this.getContext().getString(2131429644));
            switch(var1) {
                case 0:
                    ba.ai(this);
                    this.aSV();
                    var4 = var3;
                    break;
                case 1:
                    ba.ai(this);
                    var4 = var3;
                    break;
                case 2:
                    if(var2 == 20) {
                        this.aSV();
                        var4 = var3;
                    } else if(var2 == 22) {
                        this.iLb.setVisibility(8);
                        var4 = var3;
                    } else {
                        var4 = var3;
                        if(var2 == 21) {
                            var4 = var3;
                            if(this.linearLayout != null) {
                                this.linearLayout.setVisibility(8);
                                var4 = var3;
                            }
                        }
                    }
                    break;
                default:
                    var4 = var3;
            }
        }

        if(var4 && var2 != 21 && this.iLj != null || this.iLj != null && !var4 && (var2 == 21 || var2 == 20)) {
            this.gj(false);
        }

        if(var1 == 0 && !var4) {
            this.gj(false);
        } else if(var4 && var2 != 22) {
            if(this.editText.length() > 0) {
                var3 = var5;
            } else {
                var3 = false;
            }

            this.cY(var3);
        }

    }

    public final void i(String var1, int var2, boolean var3) {
        if(var3 && (var1 == null || var1.length() == 0 || this.editText == null)) {
            this.editText.setText("");
        } else {
            this.iLq = true;
            this.editText.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.getContext(), var1, this.editText.getTextSize()));
            this.iLq = false;
            if(var2 >= 0 && var2 <= this.editText.getText().length()) {
                this.editText.setSelection(var2);
            } else {
                this.editText.setSelection(this.editText.getText().length());
            }
        }

    }

    public final void oZ(int var1) {
        this.iLK = 0;
        int var2 = com.tencent.mm.az.a.fromDPToPix(this.getContext(), 180);
        int var3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.getContext(), 50.0F);
        if(var1 + var3 < var2) {
            this.iLK = -1;
        } else {
            this.iLK = (var1 - var2) / 2 + var3;
        }

        if(this.popupWindow == null) {
            this.popupWindow = new o(View.inflate(this.getContext(), 2131363196, (ViewGroup)null), -1, -2);
            this.cCj = (ImageView)this.popupWindow.getContentView().findViewById(2131166521);
            this.dQxView = this.popupWindow.getContentView().findViewById(2131166519);
            this.dQyView = this.popupWindow.getContentView().findViewById(2131166523);
            this.textView = (TextView)this.popupWindow.getContentView().findViewById(2131166525);
            this.hvW = (ImageView)this.popupWindow.getContentView().findViewById(2131166524);
            this.hvX = this.popupWindow.getContentView().findViewById(2131169456);
            this.dQvView = this.popupWindow.getContentView().findViewById(2131166518);
            this.dQwView = this.popupWindow.getContentView().findViewById(2131166526);
            this.iLs = (TextView)this.popupWindow.getContentView().findViewById(2131169455);
        }

        if(this.iLK != -1) {
            this.dQwView.setVisibility(8);
            this.dQvView.setVisibility(8);
            this.hvX.setVisibility(0);
            this.popupWindow.showAtLocation(this, 49, 0, this.iLK);
        }

    }

    public void onGlobalLayout() {
        if(this.activity != null && this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null) {
            if(this.iMd == -1) {
                u.w("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "chattingui layout id == -1!");
            } else {
                if(this.iMe == null) {
                    this.iMe = this.activity.getWindow().getDecorView().findViewById(this.iMd);
                }

                if(this.iMe == null) {
                    u.e("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "can\'t get chattinguilayout by chattinguilayoutid: %d", new Object[]{Integer.valueOf(this.iMd)});
                } else {
                    int var2 = this.iMe.getHeight();
                    int var1 = this.iMe.getWidth();
                    u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "ashutest::keybord:ChatFooter measure height: %d, height: %d", new Object[]{Integer.valueOf(this.iMe.getMeasuredHeight()), Integer.valueOf(var2)});
                    if(this.rl < var2) {
                        this.rl = var2;
                    }

                    this.iLV = var2;
                    if(this.iMb <= 0) {
                        this.iMb = var2;
                    } else if(this.iMc <= 0) {
                        this.iMc = var1;
                    } else if(this.iMb != var2 || this.iMc != var1) {
                        if(this.aSU() && this.iLC) {
                            this.iLC = false;
                            u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                            this.postDelayed(new Runnable() {
                                {
                                    if(!BuildConfig.SKIP) {
                                        A.a();
                                    }

                                }

                                public final void run() {
                                    ChatFooter.this.aST();
                                }
                            }, 10L);
                        }

                        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:Chatfooter keybord old: %d, new: %d", new Object[]{Integer.valueOf(this.iMb), Integer.valueOf(var2)});
                        int var3 = Math.abs(this.iMb - var2);
                        this.iMb = var2;
                        var2 = Math.abs(this.iMc - var1);
                        this.iMc = var1;
                        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "alvinluo widthDiff: %d", new Object[]{Integer.valueOf(var2)});
                        if(this.iMf) {
                            if(var3 != 0) {
                                if(!com.tencent.mm.compatible.util.h.aD(this.context)) {
                                    return;
                                }

                                u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "alvinluo keyboard current height: %d", new Object[]{Integer.valueOf(this.iLT)});
                                if(this.iLT != var3 || var3 == -1) {
                                    var2 = com.tencent.mm.compatible.util.h.aB(this.context);
                                    u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "alvinluo valid panel height: %d", new Object[]{Integer.valueOf(var2)});
                                    var1 = var2;
                                    if(var3 >= com.tencent.mm.compatible.util.h.aA(this.context)) {
                                        if(var3 > com.tencent.mm.compatible.util.h.az(this.context)) {
                                            var1 = var2;
                                        } else {
                                            var1 = var3;
                                        }
                                    }

                                    if(this.iLL) {
                                        this.iLL = false;
                                        var2 = var1;
                                        if(var1 < this.iLT) {
                                            var2 = this.iLT;
                                        }

                                        this.iLT = var2;
                                        this.pc(var2);
                                    } else {
                                        this.iLT = var1;
                                        u.i("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "jacks calc keyBord dialog height:%d", new Object[]{Integer.valueOf(this.iLT)});
                                        com.tencent.mm.compatible.util.h.d(this.getContext(), var1);
                                        this.pc(var1);
                                    }
                                }
                            } else {
                                if(this.iLb != null) {
                                    this.iLb.setNeedRefreshHeight(true);
                                    this.iLb.aSr();
                                }

                                if(this.linearLayout != null) {
                                    this.linearLayout.setPortHeightPx(com.tencent.mm.compatible.util.h.aB(this.context));
                                    this.aSQ();
                                    this.linearLayout.Sb();
                                }
                            }
                        }

                        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:Chatfooter Keyboard Size: " + var3);
                    }
                }
            }
        }

    }

    protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, InitInterfaceB:%d", new Object[]{Boolean.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3), Integer.valueOf(var4), Integer.valueOf(var5)});
        super.onLayout(var1, var2, var3, var4, var5);
        if(this.getTop() != 0) {
            if(this.getTop() > this.iLU) {
                this.iLU = this.getTop();
            }

            if(this.iLU - this.getTop() > 50) {
                if(this.tenMeathInterface != null) {
                    this.tenMeathInterface.da(true);
                }
            } else if(this.tenMeathInterface != null) {
                this.tenMeathInterface.da(false);
            }
        }

        if(var1 && this.emioj != null) {
            l var6 = this.emioj;
            if(var6.iMO.isShowing()) {
                var6.iMO.dismiss();
                var6.aTf();
            }
        }

    }

    protected void onMeasure(int var1, int var2) {
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[]{Integer.valueOf(MeasureSpec.getSize(var2)), Integer.valueOf(this.getMeasuredHeight())});
        super.onMeasure(var1, var2);
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:ChatFooter onMeasure  height:%d", new Object[]{Integer.valueOf(this.getMeasuredHeight())});
    }

    public final void onPause() {
        this.iLC = true;
        if(this.linearLayout != null) {
            this.linearLayout.onPause();
        }

        if(this.iLa != null) {
            this.iLa.iMV.aRY();
        }

        this.tenMeathInterface.onPause();
        this.iMf = false;
    }

    protected void onSizeChanged(int var1, int var2, int var3, int var4) {
        super.onSizeChanged(var1, var2, var3, var4);
        u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3), Integer.valueOf(var4)});
    }

    public final void pa(int var1) {
        for(int var2 = 0; var2 < picID.length; ++var2) {
            if(var1 >= cCa[var2] && var1 < cCa[var2 + 1]) {
                this.cCj.setBackgroundDrawable(com.tencent.mm.az.a.B(this.getContext(), picID[var2]));
                break;
            }
        }

        if(var1 == -1 && this.popupWindow != null) {
            this.popupWindow.dismiss();
            this.hvX.setVisibility(0);
            this.dQvView.setVisibility(8);
            this.dQwView.setVisibility(8);
        }

    }

    public final void pc(int var1) {
        com.tencent.mm.compatible.util.h.nH();
        var1 = com.tencent.mm.compatible.util.h.e(this.context, var1);
        this.iLT = var1;
        if(var1 > 0 && this.iLh != null) {
            u.d("!32@/B4Tb64lLpJ/7uFBkt7iPG30XecwVaGJ", "set bottom panel height: %d", new Object[]{Integer.valueOf(var1)});
            android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(-1, 0);
            var2.height = var1;
            this.iLh.setLayoutParams(var2);
        }

        if(this.iLb != null) {
            this.iLb.setPortHeighPx(var1);
            AppPanel var3 = this.iLb;
            var3.aSs();
            var3.aSr();
        }

        if(this.iLa != null) {
            this.iLa.setPortHeightPX(var1);
            this.iLa.aSs();
        }

        if(this.linearLayout != null) {
            if(!this.aSU()) {
                this.aSQ();
            }

            this.linearLayout.setPortHeightPx(var1);
            this.linearLayout.Sb();
        }

    }

    public void setAppPanelListener(com.tencent.mm.pluginsdk.ui.chat.AppPanel.a var1) {
        this.iLb.setAppPanelListener(var1);
    }

    public void setAppPanelVisible(int var1) {
        this.iLb.setVisibility(var1);
    }

    public void setAtSomebody(String var1) {
        this.stringStringInt.iMm = var1;
    }

    public void setBottomPanelVisibility(int var1) {
        if(var1 == 0) {
            this.iLh.setVisibility(var1);
        } else {
            this.aST();
        }

    }

    public void setCattingRootLayoutId(int var1) {
        this.iMe = null;
        this.iMd = var1;
    }

    public void setDefaultSmileyByDetail(String var1) {
        if(!ba.kU(var1)) {
            if(this.linearLayout == null) {
                this.aSx();
            }

            this.linearLayout.setDefaultEmojiByDetail(var1);
        }

    }

    @TargetApi(11)
    public void setEditTextOnDragListener(OnDragListener var1) {
        this.editText.setOnDragListener(var1);
    }

    public void setFooterEventListener(com.tencent.mm.pluginsdk.ui.chat.b tenMeathInterface) {
        this.tenMeathInterface = tenMeathInterface;
    }

    public void setFooterType(int var1) {
        this.iGD = var1;
        if(this.linearLayout != null) {
            this.linearLayout.setFooterType(var1);
        }

    }

    public void setHint(String var1) {
        if(this.editText != null) {
            this.editText.setHint(var1);
        }

    }

    public void setInsertPos(int var1) {
        this.stringStringInt.iMn = var1;
    }

    public void setLastContent(String var1) {
        this.stringStringInt.iMl = var1;
    }

    public void setLastText(String var1) {
        this.i(var1, -1, true);
    }

    public void setLbsMode(boolean var1) {
        this.iLr = var1;
    }

    public void setMode(int var1) {
        this.J(var1, true);
    }

    public void setOnEditFocusChangeListener(OnFocusChangeListener var1) {
        this.editText.setOnFocusChangeListener(var1);
    }

    public void setOnFooterSwitchListener(InitInterface var1) {
        this.initInterface = var1;
        if(var1 != null) {
            View var2 = this.findViewById(2131169159);
            var2.setVisibility(0);
            var2.setOnClickListener(new android.view.View.OnClickListener() {
                {
                    if(!BuildConfig.SKIP) {
                        A.a();
                    }

                }

                public final void onClick(View var1) {
                    if(ChatFooter.this.initInterface != null) {
                        ChatFooter.this.initInterface.gk(false);
                    }

                }
            });
        }

    }

    public void setRecordNormalWording(String var1) {
        if(var1 != null && this.iLs != null) {
            this.iLs.setText(var1);
        }

    }

    public void setSetTolastCustomPage(boolean var1) {
    }

    public void setSmileyPanelCallback(f var1) {
        this.iGC = var1;
        if(this.linearLayout != null) {
            this.linearLayout.setCallback(var1);
        }

    }

    public void setSmileyPanelCallback2(j var1) {
        this.emioj.iMR = var1;
    }

    public void setTipsShowCallback(InitInterfaceB var1) {
        this.initInterFaceInitInterfaceB = var1;
    }

    @TargetApi(11)
    public void setToSendTextColor(final boolean var1) {
        if(com.tencent.mm.compatible.util.e.ci(11)) {
            com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a() {
                {
                    if(!BuildConfig.SKIP) {
                        A.a();
                    }

                }

                public final void run() {
                    Message var1x = new Message();
                    var1x.what = 1002;
                    var1x.obj = Boolean.valueOf(var1);
                    ChatFooter.this.mHandler.sendMessage(var1x);
                }
            });
        } else if(var1) {
            this.editText.setTextColor(this.getResources().getColor(2131231266));
        } else {
            this.editText.setTextColor(this.getResources().getColor(2131231096));
            this.ge(false);
        }

    }

    public void setUserName(String var1) {
        this.talkerName = var1;
        if(this.linearLayout != null) {
            this.linearLayout.setTalkerName(this.talkerName);
        }

        if(this.iLb != null) {
            if(!com.tencent.mm.model.i.eX(this.talkerName) && !com.tencent.mm.model.i.eR(this.talkerName)) {
                if(com.tencent.mm.model.i.ep(this.talkerName)) {
                    this.iLb.setServiceShowFlag(4);
                } else if(com.tencent.mm.model.i.dA(this.talkerName)) {
                    this.iLb.setServiceShowFlag(2);
                } else {
                    this.iLb.setServiceShowFlag(1);
                }
            } else {
                this.iLb.setServiceShowFlag(0);
            }
        }

    }

    public void setWordCountLimit(int var1) {
        this.iLd = (TextView)this.cMbView.findViewById(2131167812);
        this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(var1)});
    }

    private static final class StringStringInt {
        public String iMl;
        String iMm;
        int iMn;

        private StringStringInt() {
            if(!BuildConfig.SKIP) {
                A.a();
            }

        }
    }

    public interface InitInterfaceB {
        void a(Boolean var1, Boolean var2);

        void b(Boolean var1, Boolean var2);
    }

    public interface InitInterface {
        boolean gk(boolean var1);
    }

    public final class d implements TextWatcher {
        TextWatcher iMo;
        private boolean iMp = false;
        private boolean iMq = com.tencent.mm.compatible.util.e.cj(11);

        public d(TextWatcher var2) {
            this.iMo = var2;
            if(!BuildConfig.SKIP) {
                A.a();
            }

        }

        public final void afterTextChanged(Editable var1) {
            boolean var2 = true;
            if(ChatFooter.this.iLw && this.iMp && var1.length() > 0) {
                this.iMp = false;
                ChatFooter.this.editText.setText(var1.subSequence(0, var1.length() - 1));
                if(ChatFooter.this.editText.length() > 0) {
                    ChatFooter.this.button.performClick();
                }
            } else {
                this.iMo.afterTextChanged(var1);
                if(ChatFooter.this.iLd != null) {
                    if(ChatFooter.this.editText.getLineCount() > 1) {
                        ChatFooter.this.iLd.setVisibility(0);
                        ChatFooter.this.iLd.setText(var1.length() + "/140");
                    } else {
                        ChatFooter.this.iLd.setVisibility(8);
                    }
                }

                if(var1.length() <= 0 || var1.toString().trim().length() <= 0) {
                    var2 = false;
                }

                ChatFooter.this.cY(var2);
                if(ChatFooter.this.linearLayout != null) {
                    ChatFooter.this.linearLayout.setSendButtonEnable(var2);
                }
            }

        }

        public final void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            this.iMo.beforeTextChanged(var1, var2, var3, var4);
        }

        public final void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            if(ChatFooter.this.iLw && var3 == 0 && var2 == var1.length() - 1 && var4 == 1 && var1.charAt(var1.length() - 1) == 10) {
                this.iMp = true;
            } else {
                this.iMo.onTextChanged(var1, var2, var3, var4);
            }

        }
    }
}

