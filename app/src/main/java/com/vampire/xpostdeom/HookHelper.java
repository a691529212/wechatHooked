package com.vampire.xpostdeom;/**
 * Created by tarena on 2017/1/4.
 */

import android.content.Context;

/**
 * created by Vampire
 * on: 2017/1/4 下午5:59
 */
public class HookHelper {
    private static final String TAG = "HookHelper-vampire";
    private Context appContext;
    private Context context;
    private WeChatHookInterface hookInterface;
    private Class aClass;
    private String pName;
    private String vName;

    public HookHelper(Context context, Context appContext) {
        this.context = context;
        this.appContext = appContext;
    }


    public HookHelper(Context appContext, String pName, Context context, String vName) {
        this.appContext = appContext;
        this.pName = pName;
        this.context = context;
        this.vName = vName;
    }

//    private void loadDexClass(ClassLoader loader) {
//        //
//        // This method could not be decompiled.
//        //
//        // Original Bytecode:
//        //
//        //     1: astore          5
//        //     3: aconst_null
//        //     4: astore          6
//        //     6: aconst_null
//        //     7: astore          4
//        //     9: aload_0
//        //    10: getfield        com/vampire/xpostdeom/HookHelper.appContext:Landroid/content/Context;
//        //    13: ldc             "cache"
//        //    15: iconst_0
//        //    16: invokevirtual   android/content/Context.getDir:(Ljava/lang/String;I)Ljava/io/File;
//        //    19: astore          9
//        //    21: new             Ljava/lang/StringBuilder;
//        //    24: dup
//        //    25: invokespecial   java/lang/StringBuilder.<init>:()V
//        //    28: aload           9
//        //    30: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
//        //    33: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        //    36: getstatic       java/io/File.separator:Ljava/lang/String;
//        //    39: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        //    42: ldc             "classes4.jar"
//        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        //    47: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
//        //    50: astore          7
//        //    52: new             Ljava/io/File;
//        //    55: dup
//        //    56: aload           7
//        //    58: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
//        //    61: astore          8
//        //    63: aload_0
//        //    64: getfield        com/vampire/xpostdeom/HookHelper.context:Landroid/content/Context;
//        //    67: ldc             "cn.fxnn.wcautoreply"
//        //    69: iconst_2
//        //    70: invokevirtual   android/content/Context.createPackageContext:(Ljava/lang/String;I)Landroid/content/Context;
//        //    73: astore_2
//        //    74: aload           8
//        //    76: invokevirtual   java/io/File.exists:()Z
//        //    79: ifne            212
//        //    82: aload           8
//        //    84: invokevirtual   java/io/File.createNewFile:()Z
//        //    87: pop
//        //    88: aload_2
//        //    89: aload_0
//        //    90: getfield        com/vampire/xpostdeom/HookHelper.appContext:Landroid/content/Context;
//        //    93: ldc             "bb"
//        //    95: ldc             "cc"
//        //    97: ldc             "nn"
//        //    99: aload           8
//        //   101: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
//        //   104: invokestatic    cn/fxnn/wcautoreply/InitInterfaceB.a:(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
//        //   107: new             Ldalvik/system/DexClassLoader;
//        //   110: astore_3
//        //   111: aload_3
//        //   112: aload           7
//        //   114: aload           9
//        //   116: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
//        //   119: aconst_null
//        //   120: aload_1
//        //   121: invokespecial   dalvik/system/DexClassLoader.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
//        //   124: aload           8
//        //   126: invokevirtual   java/io/File.delete:()Z
//        //   129: pop
//        //   130: new             Ljava/lang/StringBuilder;
//        //   133: astore_1
//        //   134: aload_1
//        //   135: invokespecial   java/lang/StringBuilder.<init>:()V
//        //   138: aload_0
//        //   139: aload_3
//        //   140: aload_1
//        //   141: aload_2
//        //   142: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
//        //   145: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        //   148: ldc             ".hook.WechatHook"
//        //   150: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        //   153: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
//        //   156: invokevirtual   dalvik/system/DexClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//        //   159: putfield        com/vampire/xpostdeom/HookHelper.libClazz:Ljava/lang/Class;
//        //   162: aload_0
//        //   163: aload_0
//        //   164: getfield        com/vampire/xpostdeom/HookHelper.libClazz:Ljava/lang/Class;
//        //   167: iconst_2
//        //   168: anewarray       Ljava/lang/Class;
//        //   171: dup
//        //   172: iconst_0
//        //   173: ldc             Ljava/lang/String;.class
//        //   175: aastore
//        //   176: dup
//        //   177: iconst_1
//        //   178: ldc             Ljava/lang/String;.class
//        //   180: aastore
//        //   181: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//        //   184: iconst_2
//        //   185: anewarray       Ljava/lang/Object;
//        //   188: dup
//        //   189: iconst_0
//        //   190: aload_0
//        //   191: getfield        com/vampire/xpostdeom/HookHelper.pName:Ljava/lang/String;
//        //   194: aastore
//        //   195: dup
//        //   196: iconst_1
//        //   197: aload_0
//        //   198: getfield        com/vampire/xpostdeom/HookHelper.vName:Ljava/lang/String;
//        //   201: aastore
//        //   202: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//        //   205: checkcast       Lcn/fxnn/wcautoreply/hook/WCHinterface;
//        //   208: putfield        com/vampire/xpostdeom/HookHelper.hook:Lcn/fxnn/wcautoreply/hook/WCHinterface;
//        //   211: return
//        //   212: aload           8
//        //   214: invokevirtual   java/io/File.delete:()Z
//        //   217: pop
//        //   218: aload_2
//        //   219: aload_0
//        //   220: getfield        com/vampire/xpostdeom/HookHelper.appContext:Landroid/content/Context;
//        //   223: ldc             "bb"
//        //   225: ldc             "cc"
//        //   227: ldc             "nn"
//        //   229: aload           8
//        //   231: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
//        //   234: invokestatic    cn/fxnn/wcautoreply/InitInterfaceB.a:(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
//        //   237: goto            107
//        //   240: astore_3
//        //   241: aload_3
//        //   242: invokevirtual   java/io/IOException.printStackTrace:()V
//        //   245: goto            107
//        //   248: astore_3
//        //   249: aload           5
//        //   251: astore_2
//        //   252: aload_3
//        //   253: invokevirtual   android/content/pm/PackageManager$NameNotFoundException.printStackTrace:()V
//        //   256: goto            107
//        //   259: astore_3
//        //   260: aload           6
//        //   262: astore_2
//        //   263: aload_3
//        //   264: invokevirtual   java/lang/Exception.printStackTrace:()V
//        //   267: goto            107
//        //   270: astore_1
//        //   271: aload_1
//        //   272: invokevirtual   java/lang/Exception.printStackTrace:()V
//        //   275: goto            211
//        //   278: astore_3
//        //   279: goto            263
//        //   282: astore_3
//        //   283: goto            252
//        //   286: astore_3
//        //   287: aload           4
//        //   289: astore_2
//        //   290: goto            241
//        //    Exceptions:
//        //  Try           Handler
//        //  Start  End    Start  End    Type
//        //  -----  -----  -----  -----  ---------------------------------------------------------
//        //  63     74     286    293    Ljava/io/IOException;
//        //  63     74     248    252    Landroid/content/pm/PackageManager$NameNotFoundException;
//        //  63     74     259    263    Ljava/lang/Exception;
//        //  74     107    240    241    Ljava/io/IOException;
//        //  74     107    282    286    Landroid/content/pm/PackageManager$NameNotFoundException;
//        //  74     107    278    282    Ljava/lang/Exception;
//        //  107    211    270    278    Ljava/lang/Exception;
//        //  212    237    240    241    Ljava/io/IOException;
//        //  212    237    282    286    Landroid/content/pm/PackageManager$NameNotFoundException;
//        //  212    237    278    282    Ljava/lang/Exception;
//        //
//        // The error that occurred was:
//        //
//        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0107:
//        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
//        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
//        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
//        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
//        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
//        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
//        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
//        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
//        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
//        //     at us.deathmarine.luyten.DecompilerLinkProvider.generateContent(DecompilerLinkProvider.java:96)
//        //     at us.deathmarine.luyten.OpenFile.decompileWithNavigationLinks(OpenFile.java:497)
//        //     at us.deathmarine.luyten.OpenFile.decompile(OpenFile.java:470)
//        //     at us.deathmarine.luyten.Model.extractClassToTextPane(Model.java:359)
//        //     at us.deathmarine.luyten.Model.openEntryByTreePath(Model.java:278)
//        //     at us.deathmarine.luyten.Model$TreeListener$1.run(Model.java:234)
//        //
//        throw new IllegalStateException("An error occurred while decompiling this method.");
//    }

    public void hook(ClassLoader loader) {
        if (this.hookInterface != null) {
            this.hookInterface.hook(loader);
        }
    }

//    public void init(ClassLoader loader) {
//        this.loadDexClass(loader);
//    }
}
