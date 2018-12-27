package com.example.fr.baimajidi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static com.example.fr.baimajidi.Login.admin;
import static com.example.fr.baimajidi.R.id.tab01;


/**
 * Created by FR on 2017/5/27.
 */
public class ControlActivity extends TabActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private Spinner s, s1, s2,s3,s4,s5,sp4_1,sp5_1;
    String[] data = new String[]{"1号房间", "2号房间", "3号房间", "4号房间", "5号房间", "6号房间", "7号房间", "8号房间", "9号房间", "10号房间",
            "11号房间", "12号房间", "13号房间", "14号房间", "15号房间", "16号房间", "17号房间", "18号房间"};
    String[] data2 = new String[]{ "2号房间", "3号房间", "4号房间", "5号房间", "6号房间", "7号房间", "8号房间", "9号房间", "10号房间",
            "11号房间", "12号房间"};
    String[] data3 = new String[]{"1组", "2组", "3组", "4组", "5组","6组"};
    String[] data4 = new String[]{"补光灯1", "补光灯2", "补光灯3", "补光灯4", "补光灯5","补光灯6", "补光灯7", "补光灯8", "补光灯9", "补光灯10","补光灯11", "补光灯12", "补光灯13", "补光灯14", "补光灯15",
            "补光灯16", "补光灯17", "补光灯18", "补光灯19", "补光灯20","补光灯21", "补光灯22", "补光灯23", "补光灯24", "补光灯25","补光灯26", "补光灯27", "补光灯28", "补光灯29", "补光灯30"};
    private LinearLayout home_img_bn_Layout, shopping_img_bn_layout, show_img_bn_layout, style_img_bn_layout, cam_img_bn_layout;
    private TextView shiwen;
    private Button Increase1,Decrease1,Increase2,Decrease2,Increase3,Decrease3,Increase4,Decrease4,Increase5,Decrease5,Increase6,Decrease6;
    private EditText Num1,Num2,Num3,Num4,Num5,Num6;
    public int i1 = 20,i2 = 20,i3 = 20,i4 = 20,i5 = 20,i6 = 20;
    private Button confirm1,quit1,confirm2,quit2,confirm3,quit3,confirm4,quit4,confirm5,quit5,confirm6,quit6;
    //自动控制
    private Button confirm11,quit11,confirm22,quit22,confirm33,quit33,confirm44,quit44,confirm55,quit55,confirm66,quit66;
    private EditText wendunum1,wendunum2,wendunum3,wendunum4,wendunum5,wendunum6;
    private EditText shidunum1,shidunum2,shidunum3,shidunum4,shidunum5,shidunum6;
    private EditText guangzhaonum1,guangzhaonum2,guangzhaonum3,guangzhaonum4,guangzhaonum5,guangzhaonum6;
    private String sheding11="",sheding12="",sheding13="",
            sheding21="",sheding22="",sheding23="",
            sheding31="",sheding32="",sheding33="",
            sheding41="",sheding42="",sheding43="",
            sheding51="",sheding52="",sheding53="",
            sheding61="",sheding62="",sheding63="";

    private Handler handler1;
    private String mResponse;
    public String receive_str="";
    private String Tab = "1";
    private String spinnerID1,spinnerID2,spinnerID3,spinnerID4,spinnerID5,spinnerID4_1,spinnerID5_1;
//    String path="http://192.168.1.200:8888/myApps";
//    String path="http://192.168.43.222:8888/myApps";
//    String path="http://192.168.127.200:8888/myApps";
    String path="http://121.196.198.106:8888/myApps";
//    String path="http://172.20.10.2:8888/myApps";
//    String path="http://192.168.43.232:8888/myApps";
//    String path="http://192.168.43.222:8888/myApps";
    URL url=null;
    HttpURLConnection urlConn=null;
    //���ҹ���ȼ�
    public String greenhouse_admin= admin;
    /**
    * 单栋温室 1  内的18个小温室
    * 单栋温室 2  内的2---12号小温室
    * 单栋温室 3  内的18个小温室
    */
    private String Autocommand11_on="1001";
    private String Autocommand11_off="1002";
    private String fengjicommand11_on="1011";
    private String fengjicommand11_off="1012";
    private String dingkaichuangcommand11_on="1007";
    private String dingkaichuangcommand11_onstop="1008";
    private String dingkaichuangcommand11_offstop="1010";
    private String dingkaichuangcommand11_off="1009";
    private String neizhemucommand11_on="1003";
    private String neizhemucommand11_off="1005";
    private String neizhemucommand11_onstop="1004";
    private String neizhemucommand11_offstop="1006";
    private String buguangcommand11_on="1015";
    private String buguangcommand11_off="1016";
    private String shiliancommand11_on=  "1013";
    private String shiliancommand11_off= "1014";

    /**
     * 单栋温室 2 内的1号小温室
     */
    private String Autocommand21_on="2001";
    private String Autocommand21_off="2002";
    private String neizhemucommand21_on="2003";
    private String neizhemucommand21_off="2005";
    private String neizhemucommand21_onstop="2004";
    private String neizhemucommand21_offstop="2006";
    private String dingkaichuangcommand21_on="2007";
    private String dingkaichuangcommand21_onstop="2008";
    private String dingkaichuangcommand21_offstop="2010";
    private String dingkaichuangcommand21_off="2009";

    //连栋东区 //连栋西区
    private String Autocommand41_on="5001";
    private String Autocommand41_off="5002";
    private String Autocommand42_on="4001";//补光灯
    private String Autocommand42_off="4002";
    private String neizheyincommand41_on="4003";
    private String neizheyincommand41_off="4005";
    private String neizheyincommand41_onstop="4004";
    private String neizheyincommand41_offstop="4006";
    private String dingkaichuangcommand41_on="4007";
    private String dingkaichuangcommand41_off="4009";
    private String dingkaichuangcommand41_onstop="4008";
    private String dingkaichuangcommand41_offstop="4010";
    private String dingkaichuangcommand42_on="4011";
    private String dingkaichuangcommand42_off="4013";
    private String dingkaichuangcommand42_onstop="4012";
    private String dingkaichuangcommand42_offstop="4014";
    private String cechuangcommand43_on="4015";
    private String cechuangcommand43_off="4017";
    private String cechuangcommand43_onstop="4016";
    private String cechuangcommand43_offstop="4018";
    private String waizheyangcommand41_on="4019";
    private String waizheyangcommand41_off="4021";
    private String waizheyangcommand41_onstop="4020";
    private String waizheyangcommand41_offstop="4022";
    private String zhouliufengjicommand41_on = "4023";
    private String zhouliufengjicommand41_off = "4024";
    private String zhouliufengjicommand42_on = "4025";
    private String zhouliufengjicommand42_off = "4026";
    private String zhouliufengjicommand43_on = "4027";
    private String zhouliufengjicommand43_off = "4028";
    private String huanliufengjicommand41_on = "4029";
    private String huanliufengjicommand41_off = "4030";
    private String huanliufengjicommand42_on = "4031";
    private String huanliufengjicommand42_off = "4032";
    private String shiliancommand41_on = "4033";
    private String shiliancommand41_off = "4034";

    //单栋一地源热泵
    private String address0101 = "0101";
    private String address0102 = "0201";
    private String address0103 = "0301";
    private String address0104 = "0401";
    private String address0105 = "0501";
    private String address0106 = "0601";
    private String address0107 = "0701";
    private String address0108 = "0801";
    private String address0109 = "0901";
    private String address01010 = "0A01";
    private String address01011 = "0B01";
    private String address01012 = "0C01";
    private String address01013 = "0D01";
    private String address01014 = "0E01";
    private String address01015 = "0F01";
    private String address01016 = "1001";
    private String address01017 = "1101";
    private String address01018 = "1201";
    private String address01019 = "1301";
    private String address01020 = "1401";
    private String address01021 = "1501";
    private String address01022 = "1601";
    private String address01023 = "1701";
    private String address01024 = "1801";
    private String address01025 = "1901";
    private String address01026 = "1A01";
    private String address01027 = "1B01";
    private String address01028 = "1C01";
    private String address01029 = "1D01";
    private String address01030 = "1E01";
    private String address01031 = "1F01";
    private String address01032 = "2001";
    private String address01033 = "2101";
    private String address01034 = "2201";
    private String address01035 = "2301";
    private String address01036 = "2401";
    private String address01037 = "2501";
    private String address01038 = "2601";
    private String address01039 = "2701";
    private String address01040 = "2801";
    private String address01041 = "2901";
    private String address01042 = "2A01";
    private String address01043 = "2B01";
    private String address01044 = "2C01";
    private String address01045 = "2D01";
    private String address01046 = "2E01";
    private String address01047 = "2F01";
    private String address01048 = "3001";
    private String address01049 = "0000";


    //单栋二地源热泵
    private String address0201 = "0102";
    private String address0202 = "0202";
    private String address0203 = "0302";
    private String address0204 = "0402";
    private String address0205 = "0502";
    private String address0206 = "0602";
    private String address0207 = "0702";
    private String address0208 = "0802";
    private String address0209 = "0902";
    private String address02010 = "0A02";
    private String address02011 = "0B02";
    private String address02012 = "0C02";
    private String address02013 = "0D02";
    private String address02014 = "0E02";
    private String address02015 = "0F02";
    private String address02016 = "1002";
    private String address02017 = "1102";
    private String address02018 = "1202";
    private String address02019 = "1302";
    private String address02020 = "1402";
    private String address02021 = "1502";
    private String address02022 = "1602";
    private String address02023 = "1702";
    private String address02024 = "1802";
    private String address02025 = "1902";
    private String address02026 = "1A02";
    private String address02027 = "1B02";
    private String address02028 = "1C02";
    private String address02029 = "1D02";
    private String address02030 = "1E02";
    private String address02031 = "1F02";
    private String address02032 = "2002";
    private String address02033 = "2102";
    private String address02034 = "2202";
    private String address02035 = "2302";
    private String address02036 = "2402";
    private String address02037 = "2502";
    private String address02038 = "2602";
    private String address02039 = "2702";
    private String address02040 = "2802";
    private String address02041 = "2902";
    private String address02042 = "2A02";
    private String address02043 = "2B02";
    private String address02044 = "2C02";
    private String address02045 = "2D02";
    private String address02046 = "2E02";
    private String address02047 = "2F02";
    private String address02048 = "3002";


    //单栋三地源热泵
    private String address0301 = "0103";
    private String address0302 = "0203";
    private String address0303 = "0303";
    private String address0304 = "0403";
    private String address0305 = "0503";
    private String address0306 = "0603";
    private String address0307 = "0703";
    private String address0308 = "0803";
    private String address0309 = "0903";
    private String address03010 = "0A03";
    private String address03011 = "0B03";
    private String address03012 = "0C03";
    private String address03013 = "0D03";
    private String address03014 = "0E03";
    private String address03015 = "0F03";
    private String address03016 = "1003";
    private String address03017 = "1103";
    private String address03018 = "1203";
    private String address03019 = "1303";
    private String address03020 = "1403";
    private String address03021 = "1503";
    private String address03022 = "1603";
    private String address03023 = "1703";
    private String address03024 = "1803";
    private String address03025 = "1903";
    private String address03026 = "1A03";
    private String address03027 = "1B03";
    private String address03028 = "1C03";
    private String address03029 = "1D03";
    private String address03030 = "1E03";
    private String address03031 = "1F03";
    private String address03032 = "2003";
    private String address03033 = "2103";
    private String address03034 = "2203";
    private String address03035 = "2303";
    private String address03036 = "2403";
    private String address03037 = "2503";
    private String address03038 = "2603";
    private String address03039 = "2703";
    private String address03040 = "2803";
    private String address03041 = "2903";
    private String address03042 = "2A03";
    private String address03043 = "2B03";
    private String address03044 = "2C03";
    private String address03045 = "2D03";
    private String address03046 = "2E03";
    private String address03047 = "2F03";
    private String address03048 = "3003";
    private String address03049 = "0000";

    private String address0401 = "0000";

    //连栋西区
    private String address0501 = "0000";

    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;
    private TextView tv16;
    private TextView tv17;

    private TextView tv21;
    private TextView tv22;
    private TextView tv23;
    private TextView tv24;
    private TextView tv25;
    private TextView tv26;
    private TextView tv27;

    private TextView tv31;
    private TextView tv32;
    private TextView tv33;
    private TextView tv34;
    private TextView tv35;
    private TextView tv36;
    private TextView tv37;

    private TextView tv41;
    private TextView tv42;
    private TextView tv43;
    private TextView tv44;
    private TextView tv45;
    private TextView tv46;
    private TextView tv47;
    private TextView tv48;
    private TextView tv49;
    private TextView tv410;

    private TextView tv51;
    private TextView tv52;
    private TextView tv53;
    private TextView tv54;
    private TextView tv55;
    private TextView tv56;
    private TextView tv57;
    private TextView tv58;
    private TextView tv59;
    private TextView tv510;

    private TextView tv61;
    private TextView tv62;
    private TextView tv63;
    private TextView tv64;
    private TextView tv65;

    private LinearLayout layout_tab11;
    private LinearLayout layout_tab12;
    private LinearLayout layout_tab13;
    private LinearLayout layout_tab14;
    private LinearLayout layout_tab15;
    private LinearLayout layout_tab16;
    private LinearLayout layout_tab17;

    private LinearLayout layout_tab21;
    private LinearLayout layout_tab22;
    private LinearLayout layout_tab23;
    private LinearLayout layout_tab24;
    private LinearLayout layout_tab25;
    private LinearLayout layout_tab26;
    private LinearLayout layout_tab27;

    private LinearLayout layout_tab31;
    private LinearLayout layout_tab32;
    private LinearLayout layout_tab33;
    private LinearLayout layout_tab34;
    private LinearLayout layout_tab35;
    private LinearLayout layout_tab36;
    private LinearLayout layout_tab37;

    private LinearLayout layout_tab41;
    private LinearLayout layout_tab42;
    private LinearLayout layout_tab43;
    private LinearLayout layout_tab44;
    private LinearLayout layout_tab45;
    private LinearLayout layout_tab46;
    private LinearLayout layout_tab47;
    private LinearLayout layout41;
    private LinearLayout layout_tab48;
    private LinearLayout layout_tab49;
    private LinearLayout layout_tab410;

    private LinearLayout layout51;
    private LinearLayout layout_tab51;
    private LinearLayout layout_tab52;
    private LinearLayout layout_tab53;
    private LinearLayout layout_tab54;
    private LinearLayout layout_tab55;
    private LinearLayout layout_tab56;
    private LinearLayout layout_tab57;
    private LinearLayout layout_tab58;
    private LinearLayout layout_tab59;
    private LinearLayout layout_tab510;

    private LinearLayout layout_tab61;
    private LinearLayout layout_tab62;
    private LinearLayout layout_tab63;
    private LinearLayout layout_tab64;
    private LinearLayout layout_tab65;

    //单栋1
    private RadioButton auto_11_on = null;
    private RadioButton auto_11_off = null;

    private RadioButton fengji_1_on = null;
    private RadioButton fengji_1_off = null;

    private RadioButton dingji_1_on = null;
    private RadioButton dingji_1_off = null;
    private RadioButton dingji_1_onstop = null;
    private RadioButton dingji_1_offstop = null;

    private RadioButton neizhemu_1_on = null;
    private RadioButton neizhemu_1_off = null;
    private RadioButton neizhemu_1_onstop = null;
    private RadioButton neizhemu_1_offstop = null;

    private RadioButton light_1_on = null;
    private RadioButton light_1_off = null;

    private RadioButton shilian_1_on = null;
    private RadioButton shilian_1_off = null;

    private RadioButton dianyuan_1_on = null;
    private RadioButton dianyuan_1_off = null;

    private RadioButton moshi_1_on = null;
    private RadioButton moshi_1_off = null;

    private RadioButton fengsu_1_low = null;
    private RadioButton fengsu_1_mid = null;
    private RadioButton fengsu_1_high = null;
    private RadioButton fengsu_1_auto = null;

    //单栋2
    private RadioButton auto_21_on = null;
    private RadioButton auto_21_off = null;

    private RadioButton fengji_2_on = null;
    private RadioButton fengji_2_off = null;

    private RadioButton dingji_2_on = null;
    private RadioButton dingji_2_off = null;
    private RadioButton dingji_2_onstop = null;
    private RadioButton dingji_2_offstop = null;

    private RadioButton neizhemu_2_on = null;
    private RadioButton neizhemu_2_off = null;
    private RadioButton neizhemu_2_onstop = null;
    private RadioButton neizhemu_2_offstop = null;

    private RadioButton light_2_on = null;
    private RadioButton light_2_off = null;

    private RadioButton shilian_2_on = null;
    private RadioButton shilian_2_off = null;

    private RadioButton dianyuan_2_on = null;
    private RadioButton dianyuan_2_off = null;

    private RadioButton moshi_2_on = null;
    private RadioButton moshi_2_off = null;

    private RadioButton fengsu_2_low = null;
    private RadioButton fengsu_2_mid = null;
    private RadioButton fengsu_2_high = null;
    private RadioButton fengsu_2_auto = null;

    //单栋3
    private RadioButton auto_31_on = null;
    private RadioButton auto_31_off = null;

    private RadioButton fengji_3_on = null;
    private RadioButton fengji_3_off = null;

    private RadioButton dingji_3_on = null;
    private RadioButton dingji_3_off = null;
    private RadioButton dingji_3_onstop = null;
    private RadioButton dingji_3_offstop = null;

    private RadioButton neizhemu_3_on = null;
    private RadioButton neizhemu_3_off = null;
    private RadioButton neizhemu_3_onstop = null;
    private RadioButton neizhemu_3_offstop = null;

    private RadioButton light_3_on = null;
    private RadioButton light_3_off = null;

    private RadioButton shilian_3_on = null;
    private RadioButton shilian_3_off = null;
    private RadioButton dianyuan_3_on = null;
    private RadioButton dianyuan_3_off = null;

    private RadioButton moshi_3_on = null;
    private RadioButton moshi_3_off = null;

    private RadioButton fengsu_3_low = null;
    private RadioButton fengsu_3_mid = null;
    private RadioButton fengsu_3_high = null;
    private RadioButton fengsu_3_auto = null;

    //连栋东区
    private RadioButton auto_41_on = null;
    private RadioButton auto_41_off = null;
    private RadioButton auto_42_on = null;
    private RadioButton auto_42_off = null;

    private RadioButton fengji_4_1_on = null;
    private RadioButton fengji_4_1_off = null;
    private RadioButton fengji_4_2_on = null;
    private RadioButton fengji_4_2_off = null;
    private RadioButton fengji_4_3_on = null;
    private RadioButton fengji_4_3_off = null;

    private RadioButton dingji_4_1_on = null;
    private RadioButton dingji_4_1_off = null;
    private RadioButton dingji_4_1_onstop = null;
    private RadioButton dingji_4_1_offstop = null;
    private RadioButton dingji_4_2_on = null;
    private RadioButton dingji_4_2_off = null;
    private RadioButton dingji_4_2_onstop = null;
    private RadioButton dingji_4_2_offstop = null;

    private RadioButton neizhemu_4_on = null;
    private RadioButton neizhemu_4_off = null;
    private RadioButton neizhemu_4_onstop = null;
    private RadioButton neizhemu_4_offstop = null;

    private RadioButton light_4_on = null;
    private RadioButton light_4_off = null;

    private RadioButton shilian_4_on = null;
    private RadioButton shilian_4_off = null;

    private RadioButton dianyuan_4_on = null;
    private RadioButton dianyuan_4_off = null;

    private RadioButton moshi_4_on = null;
    private RadioButton moshi_4_off = null;

    private RadioButton fengsu_4_low = null;
    private RadioButton fengsu_4_mid = null;
    private RadioButton fengsu_4_high = null;
    private RadioButton fengsu_4_auto = null;

    private RadioButton huanliu_4_1_on = null;
    private RadioButton huanliu_4_1_off = null;
    private RadioButton huanliu_4_2_on = null;
    private RadioButton huanliu_4_2_off = null;

    private RadioButton cechuang_4_on = null;
    private RadioButton cechuang_4_off = null;
    private RadioButton cechuang_4_onstop = null;
    private RadioButton cechuang_4_offstop = null;

    private  RadioButton waizheyang_4_on = null;
    private  RadioButton waizheyang_4_off = null;
    private  RadioButton waizheyang_4_onstop = null;
    private  RadioButton waizheyang_4_offstop = null;

    //连栋西区
    private RadioButton auto_51_on = null;
    private RadioButton auto_51_off = null;
    private RadioButton auto_52_on = null;
    private RadioButton auto_52_off = null;

    private RadioButton fengji_5_1_on = null;
    private RadioButton fengji_5_1_off = null;
    private RadioButton fengji_5_2_on = null;
    private RadioButton fengji_5_2_off = null;
    private RadioButton fengji_5_3_on = null;
    private RadioButton fengji_5_3_off = null;

    private RadioButton dingji_5_2_on = null;
    private RadioButton dingji_5_2_off = null;
    private RadioButton dingji_5_2_onstop = null;
    private RadioButton dingji_5_2_offstop = null;
    private RadioButton dingji_5_1_on = null;
    private RadioButton dingji_5_1_off = null;
    private RadioButton dingji_5_1_onstop = null;
    private RadioButton dingji_5_1_offstop = null;

    private RadioButton neizhemu_5_on = null;
    private RadioButton neizhemu_5_off = null;
    private RadioButton neizhemu_5_onstop = null;
    private RadioButton neizhemu_5_offstop = null;

    private RadioButton light_5_on = null;
    private RadioButton light_5_off = null;

    private RadioButton shilian_5_on = null;
    private RadioButton shilian_5_off = null;

    private RadioButton dianyuan_5_on = null;
    private RadioButton dianyuan_5_off = null;

    private RadioButton moshi_5_on = null;
    private RadioButton moshi_5_off = null;

    private RadioButton fengsu_5_low = null;
    private RadioButton fengsu_5_mid = null;
    private RadioButton fengsu_5_high = null;
    private RadioButton fengsu_5_auto = null;

    private RadioButton huanliu_5_1_on = null;
    private RadioButton huanliu_5_1_off = null;
    private RadioButton huanliu_5_2_on = null;
    private RadioButton huanliu_5_2_off = null;

    private RadioButton cechuang_5_on = null;
    private RadioButton cechuang_5_off = null;
    private RadioButton cechuang_5_onstop = null;
    private RadioButton cechuang_5_offstop = null;

    private RadioButton waizheyang_5_on = null;
    private RadioButton waizheyang_5_off = null;
    private RadioButton waizheyang_5_onstop = null;
    private RadioButton waizheyang_5_offstop = null;

    //控制室
    private RadioButton auto_61_on = null;
    private RadioButton auto_61_off = null;

    private RadioButton dingji_6_on = null;
    private RadioButton dingji_6_off = null;
    private RadioButton dingji_6_onstop = null;
    private RadioButton dingji_6_offstop = null;

    private RadioButton neizhemu_6_on = null;
    private RadioButton neizhemu_6_off = null;
    private RadioButton neizhemu_6_onstop = null;
    private RadioButton neizhemu_6_offstop = null;

    private RadioButton dianyuan_6_on = null;
    private RadioButton dianyuan_6_off = null;

    private RadioButton moshi_6_on = null;
    private RadioButton moshi_6_off = null;

    private RadioButton fengsu_6_low = null;
    private RadioButton fengsu_6_mid = null;
    private RadioButton fengsu_6_high = null;
    private RadioButton fengsu_6_auto = null;

    private RadioButton auto_65_on = null;
    private RadioButton auto_65_off = null;

    private RadioButton diancifa_61_on = null;
    private RadioButton diancifa_61_off = null;
    private RadioButton diancifa_61_onstop = null;
    private RadioButton diancifa_61_offstop = null;
    private RadioButton diancifa_62_on = null;
    private RadioButton diancifa_62_off = null;
    private RadioButton diancifa_62_onstop = null;
    private RadioButton diancifa_62_offstop = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private String fengsu1="00",fengsu2 ="00",fengsu3 ="00",fengsu4 ="00",fengsu5 ="00",fengsu6 ="00";
    private String moshi1= "0",moshi2= "0",moshi3= "0",moshi4= "0",moshi5= "0",moshi6= "0";
    private int dianyuan1= 0,dianyuan2= 0,dianyuan3= 0,dianyuan4= 0,dianyuan5= 0,dianyuan6= 0;
    private int wendutiaojie1= 20,wendutiaojie2= 20,wendutiaojie3= 20,wendutiaojie4= 20,wendutiaojie5= 20,wendutiaojie6= 20;
    private String str = "MCMD@";
    private String str1 = "MCME@";
    private GoogleApiClient client;
    TabWidget tabWidget ;
    private String Led_on1,Led_off1,Led_on2,Led_off2;
    boolean panduan;
    private String chuankou0101 = "0601";
    private String chuankou0102 = "0602";
    private String chuankou0201 = "0603";
    private String chuankou0202 = "0604";
    private String chuankou0301 = "0605";
    private String chuankou0302 = "0606";
    private String chuankou0401 = "0607";
    private String chuankou0402 = "0608";
    private String chuankou0403 = "0609";
    private String chuankou0404 = "0610";
    private String chuankou0405 = "0611";
    private String chuankou0406 = "0612";
    private String chuankou0501 = "0613";
    private String chuankou0502 = "0614";
    private String chuankou0503 = "0615";
    private String chuankou0504 = "0616";
    private String chuankou0505 = "0617";
    private String chuankou0506 = "0618";

    //数据库
    private String user;
    private String privilege;
    private String[] strs;
    private String[] kekongfangjian;
    private PrivilegeHelper ph;
    private SQLiteDatabase db;
    public static final String CREATE_B = "1";
//    DataThread dataThread;

//    private Handler handler = new Handler(){
//        public void handleMessage(Message msg){
//
//            switch (msg.what){
//                case CREATE_B:
//                    Cursor cursor = db.query("privilege_table",new String[]{"id","user","privilege"},"id=?",new String[]{"1"},null,null,null);
//                    while (cursor.moveToNext()){
//                        user = cursor.getString(cursor.getColumnIndex("user"));
//                        privilege = cursor.getString(cursor.getColumnIndex("privilege"));
//
//
//                    }
//                    String[] strs=privilege.split("@");
//                    System.arraycopy(strs,4,kekongfangjian,0,strs.length-4);
//
//
//                    break;
//                default:
//                    break;
//            }
//        }
//    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_layout);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Message message = new Message();
//                message.what = CREATE_B;
//                handler.sendMessage(message);
//            }
//        }).start();

        TabHost tabHost = getTabHost();
        tabWidget = tabHost.getTabWidget();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("单栋温室1").setContent(tab01);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("单栋温室2").setContent(R.id.tab02);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("单栋温室3").setContent(R.id.tab03);
        tabHost.addTab(tab3);
        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4").setIndicator("连栋温室东区").setContent(R.id.tab04);
        tabHost.addTab(tab4);
        TabHost.TabSpec tab5 = tabHost.newTabSpec("tab5").setIndicator("连栋温室西区").setContent(R.id.tab05);
        tabHost.addTab(tab5);
        TabHost.TabSpec tab6 = tabHost.newTabSpec("tab6").setIndicator("控制室").setContent(R.id.tab06);
        tabHost.addTab(tab6);
        for (int i =0; i < tabWidget.getChildCount(); i++) {
            //修改Tabhost高度和宽度
            tabWidget.getChildAt(i).getLayoutParams().height = 160;
            tabWidget.getChildAt(i).getLayoutParams().width =125;
            //修改显示字体大小
            TextView tv = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(12);
        }



//        Toast.makeText(ControlActivity.this,path,Toast.LENGTH_SHORT).show();
        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
        home_img_bn_Layout.setOnClickListener(clickListener_home);


        style_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_style_layout_ly);
        style_img_bn_layout.setOnClickListener(clickListener_style);

        cam_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_cam_layout_ly);
        cam_img_bn_layout.setOnClickListener(clickListener_cam);

        shopping_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_shopping_layout_ly);
        shopping_img_bn_layout.setOnClickListener(clickListener_shopping);
        shopping_img_bn_layout.setSelected(true);

        show_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_show_layout_ly);
        show_img_bn_layout.setOnClickListener(clickListener_show);

        //单栋1
        auto_11_on = (RadioButton)findViewById(R.id.auto_11_on);
        auto_11_off = (RadioButton)findViewById(R.id.auto_11_off);
        fengji_1_on = (RadioButton)findViewById(R.id.fengji_1_on);
        fengji_1_off = (RadioButton)findViewById(R.id.fengji_1_off);
        dingji_1_on = (RadioButton)findViewById(R.id.dingji_1_on);
        dingji_1_off = (RadioButton)findViewById(R.id.dingji_1_off);
        dingji_1_onstop = (RadioButton)findViewById(R.id.dingji_1_onstop);
        dingji_1_offstop = (RadioButton)findViewById(R.id.dingji_1_offstop);
        neizhemu_1_on = (RadioButton)findViewById(R.id.neizhemu_1_on);
        neizhemu_1_off = (RadioButton)findViewById(R.id.neizhemu_1_off);
        neizhemu_1_onstop = (RadioButton)findViewById(R.id.neizhemu_1_onstop);
        neizhemu_1_offstop = (RadioButton)findViewById(R.id.neizhemu_1_offstop);
        light_1_on = (RadioButton)findViewById(R.id.light_1_on);
        light_1_off = (RadioButton)findViewById(R.id.light_1_off);
        shilian_1_on = (RadioButton)findViewById(R.id.shilian_1_on);
        shilian_1_off = (RadioButton)findViewById(R.id.shilian_1_off);
        dianyuan_1_on = (RadioButton)findViewById(R.id.dianyuan_1_on);
        dianyuan_1_off = (RadioButton)findViewById(R.id.dianyuan_1_off);
        moshi_1_on = (RadioButton)findViewById(R.id.moshi_1_on);
        moshi_1_off = (RadioButton)findViewById(R.id.moshi_1_off);
        fengsu_1_low = (RadioButton)findViewById(R.id.fengsu_1_low);
        fengsu_1_mid = (RadioButton)findViewById(R.id.fengsu_1_mid);
        fengsu_1_high = (RadioButton)findViewById(R.id.fengsu_1_high);
        fengsu_1_auto = (RadioButton)findViewById(R.id.fengsu_1_auto);
        //单栋2
        auto_21_on = (RadioButton)findViewById(R.id.auto_21_on);
        auto_21_off = (RadioButton)findViewById(R.id.auto_21_off);
        fengji_2_on = (RadioButton)findViewById(R.id.fengji_2_on);
        fengji_2_off = (RadioButton)findViewById(R.id.fengji_2_off);
        dingji_2_on = (RadioButton)findViewById(R.id.dingji_2_on);
        dingji_2_off = (RadioButton)findViewById(R.id.dingji_2_off);
        dingji_2_onstop = (RadioButton)findViewById(R.id.dingji_2_onstop);
        dingji_2_offstop = (RadioButton)findViewById(R.id.dingji_2_offstop);
        neizhemu_2_on = (RadioButton)findViewById(R.id.neizhemu_2_on);
        neizhemu_2_off = (RadioButton)findViewById(R.id.neizhemu_2_off);
        neizhemu_2_onstop = (RadioButton)findViewById(R.id.neizhemu_2_onstop);
        neizhemu_2_offstop = (RadioButton)findViewById(R.id.neizhemu_2_offstop);
        light_2_on = (RadioButton)findViewById(R.id.light_2_on);
        light_2_off = (RadioButton)findViewById(R.id.light_2_off);
        shilian_2_on = (RadioButton)findViewById(R.id.shilian_2_on);
        shilian_2_off = (RadioButton)findViewById(R.id.shilian_2_off);
        dianyuan_2_on = (RadioButton)findViewById(R.id.dianyuan_2_on);
        dianyuan_2_off = (RadioButton)findViewById(R.id.dianyuan_2_off);
        moshi_2_on = (RadioButton)findViewById(R.id.moshi_2_on);
        moshi_2_off = (RadioButton)findViewById(R.id.moshi_2_off);
        fengsu_2_low = (RadioButton)findViewById(R.id.fengsu_2_low);
        fengsu_2_mid = (RadioButton)findViewById(R.id.fengsu_2_mid);
        fengsu_2_high = (RadioButton)findViewById(R.id.fengsu_2_high);
        fengsu_2_auto = (RadioButton)findViewById(R.id.fengsu_2_auto);
        //单栋3
        auto_31_on = (RadioButton)findViewById(R.id.auto_31_on);
        auto_31_off = (RadioButton)findViewById(R.id.auto_31_off);
        fengji_3_on = (RadioButton)findViewById(R.id.fengji_3_on);
        fengji_3_off = (RadioButton)findViewById(R.id.fengji_3_off);
        dingji_3_on = (RadioButton)findViewById(R.id.dingji_3_on);
        dingji_3_off = (RadioButton)findViewById(R.id.dingji_3_off);
        dingji_3_onstop = (RadioButton)findViewById(R.id.dingji_3_onstop);
        dingji_3_offstop = (RadioButton)findViewById(R.id.dingji_3_offstop);
        neizhemu_3_on = (RadioButton)findViewById(R.id.neizhemu_3_on);
        neizhemu_3_off = (RadioButton)findViewById(R.id.neizhemu_3_off);
        neizhemu_3_onstop = (RadioButton)findViewById(R.id.neizhemu_3_onstop);
        neizhemu_3_offstop = (RadioButton)findViewById(R.id.neizhemu_3_offstop);
        light_3_on = (RadioButton)findViewById(R.id.light_3_on);
        light_3_off = (RadioButton)findViewById(R.id.light_3_off);
        shilian_3_on = (RadioButton)findViewById(R.id.shilian_3_on);
        shilian_3_off = (RadioButton)findViewById(R.id.shilian_3_off);
        dianyuan_3_on = (RadioButton)findViewById(R.id.dianyuan_3_on);
        dianyuan_3_off = (RadioButton)findViewById(R.id.dianyuan_3_off);
        moshi_3_on = (RadioButton)findViewById(R.id.moshi_3_on);
        moshi_3_off = (RadioButton)findViewById(R.id.moshi_3_off);
        fengsu_3_low = (RadioButton)findViewById(R.id.fengsu_3_low);
        fengsu_3_mid = (RadioButton)findViewById(R.id.fengsu_3_mid);
        fengsu_3_high = (RadioButton)findViewById(R.id.fengsu_3_high);
        fengsu_3_auto = (RadioButton)findViewById(R.id.fengsu_3_auto);
        //连栋东区
        auto_41_on = (RadioButton)findViewById(R.id.auto_41_on);
        auto_41_off = (RadioButton)findViewById(R.id.auto_41_off);
        auto_42_on = (RadioButton)findViewById(R.id.auto_42_on);
        auto_42_off = (RadioButton)findViewById(R.id.auto_42_off);
        fengji_4_1_on = (RadioButton)findViewById(R.id.fengji_4_1_on);
        fengji_4_1_off = (RadioButton)findViewById(R.id.fengji_4_1_off);
        fengji_4_2_on = (RadioButton)findViewById(R.id.fengji_4_2_on);
        fengji_4_2_off = (RadioButton)findViewById(R.id.fengji_4_2_off);
        fengji_4_3_on = (RadioButton)findViewById(R.id.fengji_4_3_on);
        fengji_4_3_off = (RadioButton)findViewById(R.id.fengji_4_3_off);
        dingji_4_1_on = (RadioButton)findViewById(R.id.dingji_4_1_on);
        dingji_4_1_off = (RadioButton)findViewById(R.id.dingji_4_1_off);
        dingji_4_1_onstop = (RadioButton)findViewById(R.id.dingji_4_1_onstop);
        dingji_4_1_offstop = (RadioButton)findViewById(R.id.dingji_4_1_offstop);
        dingji_4_2_on = (RadioButton)findViewById(R.id.dingji_4_2_on);
        dingji_4_2_off = (RadioButton)findViewById(R.id.dingji_4_2_off);
        dingji_4_2_onstop = (RadioButton)findViewById(R.id.dingji_4_2_onstop);
        dingji_4_2_offstop = (RadioButton)findViewById(R.id.dingji_4_2_offstop);
        neizhemu_4_on = (RadioButton)findViewById(R.id.neizhemu_4_on);
        neizhemu_4_off = (RadioButton)findViewById(R.id.neizhemu_4_off);
        neizhemu_4_onstop = (RadioButton)findViewById(R.id.neizhemu_4_onstop);
        neizhemu_4_offstop = (RadioButton)findViewById(R.id.neizhemu_4_offstop);
        light_4_on = (RadioButton)findViewById(R.id.light_4_on);
        light_4_off = (RadioButton)findViewById(R.id.light_4_off);
        shilian_4_on = (RadioButton)findViewById(R.id.shilian_4_on);
        shilian_4_off = (RadioButton)findViewById(R.id.shilian_4_off);
        dianyuan_4_on = (RadioButton)findViewById(R.id.dianyuan_4_on);
        dianyuan_4_off = (RadioButton)findViewById(R.id.dianyuan_4_off);
        moshi_4_on = (RadioButton)findViewById(R.id.moshi_4_on);
        moshi_4_off = (RadioButton)findViewById(R.id.moshi_4_off);
        fengsu_4_low = (RadioButton)findViewById(R.id.fengsu_4_low);
        fengsu_4_mid = (RadioButton)findViewById(R.id.fengsu_4_mid);
        fengsu_4_high = (RadioButton)findViewById(R.id.fengsu_4_high);
        fengsu_4_auto = (RadioButton)findViewById(R.id.fengsu_4_auto);
        cechuang_4_on = (RadioButton)findViewById(R.id.cechuang_4_on);
        cechuang_4_off = (RadioButton)findViewById(R.id.cechuang_4_off);
        cechuang_4_onstop = (RadioButton)findViewById(R.id.cechuang_4_onstop);
        cechuang_4_offstop = (RadioButton)findViewById(R.id.cechuang_4_offstop);
        huanliu_4_1_on = (RadioButton)findViewById(R.id.huanliu_4_1_on);
        huanliu_4_1_off = (RadioButton)findViewById(R.id.huanliu_4_1_off);
        huanliu_4_2_on = (RadioButton)findViewById(R.id.huanliu_4_2_on);
        huanliu_4_2_off = (RadioButton)findViewById(R.id.huanliu_4_2_off);
        waizheyang_4_on = (RadioButton)findViewById(R.id.waizheyang_4_on);
        waizheyang_4_off = (RadioButton)findViewById(R.id.waizheyang_4_off);
        waizheyang_4_onstop = (RadioButton)findViewById(R.id.waizheyang_4_onstop);
        waizheyang_4_offstop = (RadioButton)findViewById(R.id.waizheyang_4_offstop);
        //连栋西区
        auto_51_on = (RadioButton)findViewById(R.id.auto_51_on);
        auto_51_off = (RadioButton)findViewById(R.id.auto_51_off);
        auto_52_on = (RadioButton)findViewById(R.id.auto_52_on);
        auto_52_off = (RadioButton)findViewById(R.id.auto_52_off);
        fengji_5_1_on = (RadioButton)findViewById(R.id.fengji_5_1_on);
        fengji_5_1_off = (RadioButton)findViewById(R.id.fengji_5_1_off);
        fengji_5_2_on = (RadioButton)findViewById(R.id.fengji_5_2_on);
        fengji_5_2_off = (RadioButton)findViewById(R.id.fengji_5_2_off);
        fengji_5_3_on = (RadioButton)findViewById(R.id.fengji_5_3_on);
        fengji_5_3_off = (RadioButton)findViewById(R.id.fengji_5_3_off);
        dingji_5_1_on = (RadioButton)findViewById(R.id.dingji_5_1_on);
        dingji_5_1_off = (RadioButton)findViewById(R.id.dingji_5_1_off);
        dingji_5_1_onstop = (RadioButton)findViewById(R.id.dingji_5_1_onstop);
        dingji_5_1_offstop = (RadioButton)findViewById(R.id.dingji_5_1_offstop);
        dingji_5_2_on = (RadioButton)findViewById(R.id.dingji_5_2_on);
        dingji_5_2_off = (RadioButton)findViewById(R.id.dingji_5_2_off);
        dingji_5_2_onstop = (RadioButton)findViewById(R.id.dingji_5_2_onstop);
        dingji_5_2_offstop = (RadioButton)findViewById(R.id.dingji_5_2_offstop);
        neizhemu_5_on = (RadioButton)findViewById(R.id.neizhemu_5_on);
        neizhemu_5_off = (RadioButton)findViewById(R.id.neizhemu_5_off);
        neizhemu_5_onstop = (RadioButton)findViewById(R.id.neizhemu_5_onstop);
        neizhemu_5_offstop = (RadioButton)findViewById(R.id.neizhemu_5_offstop);
        light_5_on = (RadioButton)findViewById(R.id.light_5_on);
        light_5_off = (RadioButton)findViewById(R.id.light_5_off);
        shilian_5_on = (RadioButton)findViewById(R.id.shilian_5_on);
        shilian_5_off = (RadioButton)findViewById(R.id.shilian_5_off);
        dianyuan_5_on = (RadioButton)findViewById(R.id.dianyuan_5_on);
        dianyuan_5_off = (RadioButton)findViewById(R.id.dianyuan_5_off);
        moshi_5_on = (RadioButton)findViewById(R.id.moshi_5_on);
        moshi_5_off = (RadioButton)findViewById(R.id.moshi_5_off);
        fengsu_5_low = (RadioButton)findViewById(R.id.fengsu_5_low);
        fengsu_5_mid = (RadioButton)findViewById(R.id.fengsu_5_mid);
        fengsu_5_high = (RadioButton)findViewById(R.id.fengsu_5_high);
        fengsu_5_auto = (RadioButton)findViewById(R.id.fengsu_5_auto);
        cechuang_5_on = (RadioButton)findViewById(R.id.cechuang_5_on);
        cechuang_5_off = (RadioButton)findViewById(R.id.cechuang_5_off);
        cechuang_5_onstop = (RadioButton)findViewById(R.id.cechuang_5_onstop);
        cechuang_5_offstop = (RadioButton)findViewById(R.id.cechuang_5_offstop);
        huanliu_5_1_on = (RadioButton)findViewById(R.id.huanliu_5_1_on);
        huanliu_5_1_off = (RadioButton)findViewById(R.id.huanliu_5_1_off);
        huanliu_5_2_on = (RadioButton)findViewById(R.id.huanliu_5_2_on);
        huanliu_5_2_off = (RadioButton)findViewById(R.id.huanliu_5_2_off);
        waizheyang_5_on = (RadioButton)findViewById(R.id.waizheyang_5_on);
        waizheyang_5_off = (RadioButton)findViewById(R.id.waizheyang_5_off);
        waizheyang_5_onstop = (RadioButton)findViewById(R.id.waizheyang_5_onstop);
        waizheyang_5_offstop = (RadioButton)findViewById(R.id.waizheyang_5_offstop);
        //控制室
        auto_61_on = (RadioButton)findViewById(R.id.auto_61_on);
        auto_61_off = (RadioButton)findViewById(R.id.auto_61_off);
        dingji_6_on = (RadioButton)findViewById(R.id.dingji_6_on);
        dingji_6_off = (RadioButton)findViewById(R.id.dingji_6_off);
        dingji_6_onstop = (RadioButton)findViewById(R.id.dingji_6_onstop);
        dingji_6_offstop = (RadioButton)findViewById(R.id.dingji_6_offstop);
        neizhemu_6_on = (RadioButton)findViewById(R.id.neizhemu_6_on);
        neizhemu_6_off = (RadioButton)findViewById(R.id.neizhemu_6_off);
        neizhemu_6_onstop = (RadioButton)findViewById(R.id.neizhemu_6_onstop);
        neizhemu_6_offstop = (RadioButton)findViewById(R.id.neizhemu_6_offstop);
        dianyuan_6_on = (RadioButton)findViewById(R.id.dianyuan_6_on);
        dianyuan_6_off = (RadioButton)findViewById(R.id.dianyuan_6_off);
        moshi_6_on = (RadioButton)findViewById(R.id.moshi_6_on);
        moshi_6_off = (RadioButton)findViewById(R.id.moshi_6_off);
        fengsu_6_low = (RadioButton)findViewById(R.id.fengsu_6_low);
        fengsu_6_mid = (RadioButton)findViewById(R.id.fengsu_6_mid);
        fengsu_6_high = (RadioButton)findViewById(R.id.fengsu_6_high);
        fengsu_6_auto = (RadioButton)findViewById(R.id.fengsu_6_auto);
        auto_65_on = (RadioButton)findViewById(R.id.auto_65_on);
        auto_65_off = (RadioButton)findViewById(R.id.auto_65_off);
        diancifa_61_on = (RadioButton)findViewById(R.id.diancifa_61_on);
        diancifa_61_off = (RadioButton)findViewById(R.id.diancifa_61_off);
        diancifa_61_onstop = (RadioButton)findViewById(R.id.diancifa_61_onstop);
        diancifa_61_offstop = (RadioButton)findViewById(R.id.diancifa_61_offstop);
        diancifa_62_on = (RadioButton)findViewById(R.id.diancifa_62_on);
        diancifa_62_off = (RadioButton)findViewById(R.id.diancifa_62_off);
        diancifa_62_onstop = (RadioButton)findViewById(R.id.diancifa_62_onstop);
        diancifa_62_offstop = (RadioButton)findViewById(R.id.diancifa_62_offstop);
        //单栋1
        Increase1 = (Button)findViewById(R.id.Increase1);
        Decrease1 = (Button)findViewById(R.id.Decrease1);
        Num1 = (EditText)findViewById(R.id.Num1);
        confirm1 = (Button)findViewById(R.id.Confirm1);
        quit1 = (Button)findViewById(R.id.Quit1);
        //单栋2
        Increase2 = (Button)findViewById(R.id.Increase2);
        Decrease2 = (Button)findViewById(R.id.Decrease2);
        Num2 = (EditText)findViewById(R.id.Num2);
        confirm2 = (Button)findViewById(R.id.Confirm2);
        quit2 = (Button)findViewById(R.id.Quit2);
        //单栋3
        Increase3 = (Button)findViewById(R.id.Increase3);
        Decrease3 = (Button)findViewById(R.id.Decrease3);
        Num3 = (EditText)findViewById(R.id.Num3);
        confirm3 = (Button)findViewById(R.id.Confirm3);
        quit3 = (Button)findViewById(R.id.Quit3);
        //连栋东区
        Increase4 = (Button)findViewById(R.id.Increase4);
        Decrease4 = (Button)findViewById(R.id.Decrease4);
        Num4 = (EditText)findViewById(R.id.Num4);
        confirm4 = (Button)findViewById(R.id.Confirm4);
        quit4 = (Button)findViewById(R.id.Quit4);
        //连栋西区
        Increase5 = (Button)findViewById(R.id.Increase5);
        Decrease5 = (Button)findViewById(R.id.Decrease5);
        Num5 = (EditText)findViewById(R.id.Num5);
        confirm5 = (Button)findViewById(R.id.Confirm5);
        quit5 = (Button)findViewById(R.id.Quit5);
        //控制室
        Increase6 = (Button)findViewById(R.id.Increase6);
        Decrease6 = (Button)findViewById(R.id.Decrease6);
        Num6 = (EditText)findViewById(R.id.Num6);
        confirm6 = (Button)findViewById(R.id.Confirm6);
        quit6 = (Button)findViewById(R.id.Quit6);
        setonchecked1();
        setonchecked2();
        setonchecked3();
        setonchecked4();
        setonchecked5();
        setonchecked6();
        setupView1();
        setupView2();
        setupView3();
        setupView4();
        setupView5();
        setupView6();

        ph = new PrivilegeHelper(ControlActivity.this,"Privilege.db",null,1);
        db = ph.getWritableDatabase();
        Cursor cursor = db.query("privilege_table",null,null,null,null,null,null);
        if(cursor.moveToLast()){
            user = cursor.getString(cursor.getColumnIndex("user"));
            privilege = cursor.getString(cursor.getColumnIndex("privilege"));

        }
        strs=privilege.split("@");
//        try{
//            System.arraycopy(strs,4,kekongfangjian,0,strs.length-4);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

//        Toast.makeText(ControlActivity.this,kekongfangjian+"有了",Toast.LENGTH_SHORT).show();
//        dataThread = new DataThread();
//        dataThread.start();
//        Message msg = new Message();
//        msg.what = 0x1111;
////                Bundle bundle = new Bundle();
////                bundle.putString(CREATE_B,spinnerID5);
////                msg.setData(bundle);
//        dataThread.mHandler.sendMessage(msg);
//        tab01.setChildClickable(false);

        s1 = (Spinner) this.findViewById(R.id.spinner1);
        s1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position<10){
                    spinnerID1 = "0"+position;
                }else {
                    spinnerID1 = ""+position;
                }
                if(!user.equals("admin")) {
                    if (!Arrays.asList(strs).contains("01"+spinnerID1)) {
                        tv11.setClickable(false);
                        tv12.setClickable(false);
                        tv13.setClickable(false);
                        tv14.setClickable(false);
                        tv15.setClickable(false);
                        tv16.setClickable(false);
                        tv17.setClickable(false);
                        layout_tab11.setVisibility(View.GONE);
                        layout_tab12.setVisibility(View.GONE);
                        layout_tab13.setVisibility(View.GONE);
                        layout_tab14.setVisibility(View.GONE);
                        layout_tab15.setVisibility(View.GONE);
                        layout_tab16.setVisibility(View.GONE);
                        layout_tab17.setVisibility(View.GONE);
                        Toast.makeText(ControlActivity.this, "您无此房间的权限", Toast.LENGTH_LONG).show();
                    }else{
                        tv11.setClickable(true);
                        tv12.setClickable(true);
                        tv13.setClickable(true);
                        tv14.setClickable(true);
                        tv15.setClickable(true);
                        tv16.setClickable(true);
                        tv17.setClickable(true);
                    }
                }else{
                    tv11.setClickable(true);
                    tv12.setClickable(true);
                    tv13.setClickable(true);
                    tv14.setClickable(true);
                    tv15.setClickable(true);
                    tv16.setClickable(true);
                    tv17.setClickable(true);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听

        s2 = (Spinner) this.findViewById(R.id.spinner2);
        s2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));
        s2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1+1;
                if (position<10){
                    spinnerID2 = "0"+position;
                }else {
                    spinnerID2 = ""+position;
                }
                if(!user.equals("admin")) {
                    if (!Arrays.asList(strs).contains("02"+spinnerID2)) {
                        tv21.setClickable(false);
                        tv22.setClickable(false);
                        tv23.setClickable(false);
                        tv24.setClickable(false);
                        tv25.setClickable(false);
                        tv26.setClickable(false);
                        tv27.setClickable(false);
                        layout_tab21.setVisibility(View.GONE);
                        layout_tab22.setVisibility(View.GONE);
                        layout_tab23.setVisibility(View.GONE);
                        layout_tab24.setVisibility(View.GONE);
                        layout_tab25.setVisibility(View.GONE);
                        layout_tab26.setVisibility(View.GONE);
                        layout_tab27.setVisibility(View.GONE);
                        Toast.makeText(ControlActivity.this,"您无此房间的权限", Toast.LENGTH_LONG).show();
                    }else{
                        tv21.setClickable(true);
                        tv22.setClickable(true);
                        tv23.setClickable(true);
                        tv24.setClickable(true);
                        tv25.setClickable(true);
                        tv26.setClickable(true);
                        tv27.setClickable(true);
                    }
                }else{
                    tv21.setClickable(true);
                    tv22.setClickable(true);
                    tv23.setClickable(true);
                    tv24.setClickable(true);
                    tv25.setClickable(true);
                    tv26.setClickable(true);
                    tv27.setClickable(true);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听
        s3 = (Spinner) this.findViewById(R.id.spinner3);
        s3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
        s3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position<10){
                    spinnerID3 = "0"+position;
                }else {
                    spinnerID3 = ""+position;
                }
                if(!user.equals("admin")) {
                    if (!Arrays.asList(strs).contains("03"+spinnerID3)) {
                        tv31.setClickable(false);
                        tv32.setClickable(false);
                        tv33.setClickable(false);
                        tv34.setClickable(false);
                        tv35.setClickable(false);
                        tv36.setClickable(false);
                        tv37.setClickable(false);
                        layout_tab31.setVisibility(View.GONE);
                        layout_tab32.setVisibility(View.GONE);
                        layout_tab33.setVisibility(View.GONE);
                        layout_tab34.setVisibility(View.GONE);
                        layout_tab35.setVisibility(View.GONE);
                        layout_tab36.setVisibility(View.GONE);
                        layout_tab37.setVisibility(View.GONE);
                        Toast.makeText(ControlActivity.this,"您无此房间的权限", Toast.LENGTH_LONG).show();
                    }else{
                        tv31.setClickable(true);
                        tv32.setClickable(true);
                        tv33.setClickable(true);
                        tv34.setClickable(true);
                        tv35.setClickable(true);
                        tv36.setClickable(true);
                        tv37.setClickable(true);
                    }
                }else{
                    tv31.setClickable(true);
                    tv32.setClickable(true);
                    tv33.setClickable(true);
                    tv34.setClickable(true);
                    tv35.setClickable(true);
                    tv36.setClickable(true);
                    tv37.setClickable(true);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听
        s4 = (Spinner) this.findViewById(R.id.spinner4);
//        s4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data3));
        s4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data3));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position<10){
                    spinnerID4 = "0"+position;
                }else {
                    spinnerID4 = ""+position;
                }
                if(!user.equals("admin")) {
                    if (!Arrays.asList(strs).contains("04"+spinnerID4)) {
                        tv41.setClickable(false);
                        tv42.setClickable(false);
                        tv43.setClickable(false);
                        tv44.setClickable(false);
                        tv45.setClickable(false);
                        tv46.setClickable(false);
                        tv47.setClickable(false);
                        tv48.setClickable(false);
                        tv49.setClickable(false);
                        tv410.setClickable(false);
                        layout_tab41.setVisibility(View.GONE);
                        layout_tab42.setVisibility(View.GONE);
                        layout_tab43.setVisibility(View.GONE);
                        layout_tab44.setVisibility(View.GONE);
                        layout_tab45.setVisibility(View.GONE);
                        layout_tab46.setVisibility(View.GONE);
                        layout_tab47.setVisibility(View.GONE);
                        layout_tab48.setVisibility(View.GONE);
                        layout_tab49.setVisibility(View.GONE);
                        layout_tab410.setVisibility(View.GONE);
                        Toast.makeText(ControlActivity.this,"您无此房间的权限", Toast.LENGTH_LONG).show();
                    }else{
                        tv41.setClickable(true);
                        tv42.setClickable(true);
                        tv43.setClickable(true);
                        tv44.setClickable(true);
                        tv45.setClickable(true);
                        tv46.setClickable(true);
                        tv47.setClickable(true);
                        tv48.setClickable(true);
                        tv49.setClickable(true);
                        tv410.setClickable(true);
                    }
                }else{
                    tv41.setClickable(true);
                    tv42.setClickable(true);
                    tv43.setClickable(true);
                    tv44.setClickable(true);
                    tv45.setClickable(true);
                    tv46.setClickable(true);
                    tv47.setClickable(true);
                    tv48.setClickable(true);
                    tv49.setClickable(true);
                    tv410.setClickable(true);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听
        s5 = (Spinner) this.findViewById(R.id.spinner5);
//        s5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data3));
        s5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data3));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position<10){
                    spinnerID5 = "0"+position;
                }else {
                    spinnerID5 = ""+position;
                }
                if(!user.equals("admin")) {
                    if (!Arrays.asList(strs).contains("05"+spinnerID5)) {
                        tv51.setClickable(false);
                        tv52.setClickable(false);
                        tv53.setClickable(false);
                        tv54.setClickable(false);
                        tv55.setClickable(false);
                        tv56.setClickable(false);
                        tv57.setClickable(false);
                        tv58.setClickable(false);
                        tv59.setClickable(false);
                        tv510.setClickable(false);
                        layout_tab51.setVisibility(View.GONE);
                        layout_tab52.setVisibility(View.GONE);
                        layout_tab53.setVisibility(View.GONE);
                        layout_tab54.setVisibility(View.GONE);
                        layout_tab55.setVisibility(View.GONE);
                        layout_tab56.setVisibility(View.GONE);
                        layout_tab57.setVisibility(View.GONE);
                        layout_tab58.setVisibility(View.GONE);
                        layout_tab59.setVisibility(View.GONE);
                        layout_tab510.setVisibility(View.GONE);
                        Toast.makeText(ControlActivity.this, "您无此房间的权限", Toast.LENGTH_LONG).show();
                    }else{
                        tv51.setClickable(true);
                        tv52.setClickable(true);
                        tv53.setClickable(true);
                        tv54.setClickable(true);
                        tv55.setClickable(true);
                        tv56.setClickable(true);
                        tv57.setClickable(true);
                        tv58.setClickable(true);
                        tv59.setClickable(true);
                        tv510.setClickable(true);
                    }
                }else{
                    tv51.setClickable(true);
                    tv52.setClickable(true);
                    tv53.setClickable(true);
                    tv54.setClickable(true);
                    tv55.setClickable(true);
                    tv56.setClickable(true);
                    tv57.setClickable(true);
                    tv58.setClickable(true);
                    tv59.setClickable(true);
                    tv510.setClickable(true);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听

        sp4_1 = (Spinner) this.findViewById(R.id.spinner4_1);
        sp4_1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data4));
        sp4_1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data4));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        sp4_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position==1){
                    Led_on1 = "5003";
                    Led_off1 = "5004";
                }else if (position==2){
                    Led_on1 = "5005";
                    Led_off1 = "5006";
                }else if (position==3){
                    Led_on1 = "5007";
                    Led_off1 = "5008";
                }else if (position==4){
                    Led_on1 = "5009";
                    Led_off1 = "5010";
                }else if (position==5){
                    Led_on1 = "5011";
                    Led_off1 = "5012";
                }else if (position==6){
                    Led_on1 = "5013";
                    Led_off1 = "5014";
                }else if (position==7){
                    Led_on1 = "5015";
                    Led_off1 = "5016";
                }else if (position==8){
                    Led_on1 = "5017";
                    Led_off1 = "5018";
                }else if (position==9){
                    Led_on1 = "5019";
                    Led_off1 = "5020";
                }else if (position==10){
                    Led_on1 = "5021";
                    Led_off1 = "5022";
                }else if (position==11){
                    Led_on1 = "5023";
                    Led_off1 = "5024";
                }else if (position==12){
                    Led_on1 = "5025";
                    Led_off1 = "5026";
                }else if (position==13){
                    Led_on1 = "5027";
                    Led_off1 = "5028";
                }else if (position==14){
                    Led_on1 = "5029";
                    Led_off1 = "5030";
                }else if (position==15){
                    Led_on1 = "5031";
                    Led_off1 = "5032";
                }else if (position==16){
                    Led_on1 = "5033";
                    Led_off1 = "5034";
                }else if (position==17){
                    Led_on1 = "5035";
                    Led_off1 = "5036";
                }else if (position==18){
                    Led_on1 = "5037";
                    Led_off1 = "5038";
                }else if (position==19){
                    Led_on1 = "5039";
                    Led_off1 = "5040";
                }else if (position==20){
                    Led_on1 = "5041";
                    Led_off1 = "5042";
                }else if (position==21){
                    Led_on1 = "5043";
                    Led_off1 = "5044";
                }else if (position==22){
                    Led_on1 = "5045";
                    Led_off1 = "5046";
                }else if (position==23){
                    Led_on1 = "5047";
                    Led_off1 = "5048";
                }else if (position==24){
                    Led_on1 = "5049";
                    Led_off1 = "5050";
                }else if (position==25){
                    Led_on1 = "5051";
                    Led_off1 = "5052";
                }else if (position==26){
                    Led_on1 = "5053";
                    Led_off1 = "5054";
                }else if (position==27){
                    Led_on1 = "5055";
                    Led_off1 = "5056";
                }else if (position==28){
                    Led_on1 = "5057";
                    Led_off1 = "5058";
                }else if (position==29){
                    Led_on1 = "5059";
                    Led_off1 = "5060";
                }else if (position==30){
                    Led_on1 = "5061";
                    Led_off1 = "5062";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听

        sp5_1 = (Spinner) this.findViewById(R.id.spinner5_1);
        sp5_1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data4));
        sp5_1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data4));//android.R.layout.simple_list_item_1是指安卓自带的下拉列表格式，data是数据源；
        sp5_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position +1;
                if (position==1){
                    Led_on2 = "5003";
                    Led_off2 = "5004";
                }else if (position==2){
                    Led_on2 = "5005";
                    Led_off2 = "5006";
                }else if (position==3){
                    Led_on2 = "5007";
                    Led_off2 = "5008";
                }else if (position==4){
                    Led_on2 = "5009";
                    Led_off2 = "5010";
                }else if (position==5){
                    Led_on2 = "5011";
                    Led_off2 = "5012";
                }else if (position==6){
                    Led_on2 = "5013";
                    Led_off2 = "5014";
                }else if (position==7){
                    Led_on2 = "5015";
                    Led_off2 = "5016";
                }else if (position==8){
                    Led_on2 = "5017";
                    Led_off2 = "5018";
                }else if (position==9){
                    Led_on2 = "5019";
                    Led_off2 = "5020";
                }else if (position==10){
                    Led_on2 = "5021";
                    Led_off2 = "5022";
                }else if (position==11){
                    Led_on2 = "5023";
                    Led_off2 = "5024";
                }else if (position==12){
                    Led_on2 = "5025";
                    Led_off2 = "5026";
                }else if (position==13){
                    Led_on2 = "5027";
                    Led_off2 = "5028";
                }else if (position==14){
                    Led_on2 = "5029";
                    Led_off2 = "5030";
                }else if (position==15){
                    Led_on2 = "5031";
                    Led_off2 = "5032";
                }else if (position==16){
                    Led_on2 = "5033";
                    Led_off2 = "5034";
                }else if (position==17){
                    Led_on2 = "5035";
                    Led_off2 = "5036";
                }else if (position==18){
                    Led_on2 = "5037";
                    Led_off2 = "5038";
                }else if (position==19){
                    Led_on2 = "5039";
                    Led_off2 = "5040";
                }else if (position==20){
                    Led_on2 = "5041";
                    Led_off2 = "5042";
                }else if (position==21){
                    Led_on2 = "5043";
                    Led_off2 = "5044";
                }else if (position==22){
                    Led_on2 = "5045";
                    Led_off2 = "5046";
                }else if (position==23){
                    Led_on2 = "5047";
                    Led_off2 = "5048";
                }else if (position==24){
                    Led_on2 = "5049";
                    Led_off2 = "5050";
                }else if (position==25){
                    Led_on2 = "5051";
                    Led_off2 = "5052";
                }else if (position==26){
                    Led_on2 = "5053";
                    Led_off2 = "5054";
                }else if (position==27){
                    Led_on2 = "5055";
                    Led_off2 = "5056";
                }else if (position==28){
                    Led_on2 = "5057";
                    Led_off2 = "5058";
                }else if (position==29){
                    Led_on2 = "5059";
                    Led_off2 = "5060";
                }else if (position==30){
                    Led_on2 = "5061";
                    Led_off2 = "5062";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });//是下拉列表的监听



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        //温度调节
        Increase1.setOnClickListener(new AddbtnListener1());
        Decrease1.setOnClickListener(new DecreasebtnListener1());
        Num1.setText("20");
        confirm1.setOnClickListener(new confirmListener1());
        quit1.setOnClickListener(new cancelListener1());

        Increase2.setOnClickListener(new AddbtnListener2());
        Decrease2.setOnClickListener(new DecreasebtnListener2());
        Num2.setText("20");
        confirm2.setOnClickListener(new confirmListener2());
        quit2.setOnClickListener(new cancelListener2());

        Increase3.setOnClickListener(new AddbtnListener3());
        Decrease3.setOnClickListener(new DecreasebtnListener3());
        Num3.setText("20");
        confirm3.setOnClickListener(new confirmListener3());
        quit3.setOnClickListener(new cancelListener3());

        Increase4.setOnClickListener(new AddbtnListener4());
        Decrease4.setOnClickListener(new DecreasebtnListener4());
        Num4.setText("20");
        confirm4.setOnClickListener(new confirmListener4());
        quit4.setOnClickListener(new cancelListener4());

        Increase5.setOnClickListener(new AddbtnListener5());
        Decrease5.setOnClickListener(new DecreasebtnListener5());
        Num5.setText("20");
        confirm5.setOnClickListener(new confirmListener5());
        quit5.setOnClickListener(new cancelListener5());

        Increase6.setOnClickListener(new AddbtnListener6());
        Decrease6.setOnClickListener(new DecreasebtnListener6());
        Num6.setText("20");
        confirm6.setOnClickListener(new confirmListener6());
        quit6.setOnClickListener(new cancelListener6());

        tabHost.setOnTabChangedListener(changeLis);

        HandlerThread handlerThread = new HandlerThread("myHandlerThread");//线程调用函数
        handlerThread.start();
        Looper looper = Looper.myLooper();
//        mHandler1 = new MyHandler(looper);
        HandlerThread handlerThread1 = new HandlerThread("myHandlerThread1");//����scoket�����߳�
        handlerThread1.start();
        handler1 = new Handler(handlerThread1.getLooper());


    }

//    class DataThread extends Thread{
//        public Handler mHandler;
//        public void run(){
//            Looper.prepare();
//            mHandler = new Handler(){
//                @Override
//                public void handleMessage(Message msg) {
//                    if(msg.what == 0x1111){
//                        Cursor cursor = db.query("privilege_table",null,null,null,null,null,null);
//                        if(cursor.moveToFirst()){
//                            user = cursor.getString(cursor.getColumnIndex("user"));
//                            privilege = cursor.getString(cursor.getColumnIndex("privilege"));
//
//                        }
//                        String[] strs=privilege.split("@");
//                        System.arraycopy(strs,4,kekongfangjian,0,strs.length-4);
//                        Toast.makeText(ControlActivity.this,"有了",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            };
//            Looper.loop();
//        }
//    }


    private TabHost.OnTabChangeListener changeLis= new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {
            if(tabId.equals("tab1"))
            {
                Tab = "1";
                setonchecked1();
            }
            else if(tabId.equals("tab2"))
            {
                Tab = "2";
                setonchecked2();
            }
            else if(tabId.equals("tab3"))
            {
                Tab = "3";
                setonchecked3();
            }
            else if(tabId.equals("tab4"))
            {
                Tab = "4";
                setonchecked4();
            } else if(tabId.equals("tab5"))
            {
                Tab = "5";
                setonchecked5();
            } else if(tabId.equals("tab6"))
            {
                Tab = "6";
                setonchecked6();
            }
        }
    };


    public String readInputStream(InputStream is) throws IOException
    {
        String temp = null;

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        int len=0;
        byte []buffer =new byte[1024];
        if((len=is.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }
        is.close();
        baos.close();
        byte[]result=baos.toByteArray();
        temp=new String(result);
        return temp;

    }
    public void  sendMessage_toServer(String str){
        final String command_String =str;
        Thread myThread=new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{
                    url =new URL(path);

                    urlConn=(HttpURLConnection) url.openConnection();
                    urlConn.setConnectTimeout(5000);
                    urlConn.setDoOutput(true);
                    urlConn.setDoInput(true);
                    urlConn.setRequestMethod("GET");
                    // TODO Auto-generated method stub
                    OutputStream out =urlConn.getOutputStream();
                    out.write(command_String.getBytes());
                //count--;
                    out.flush();
                    while(urlConn.getContentLength()!=-1){
                        int code=urlConn.getResponseCode();
                        if(code==200)
                        {
                            Toast.makeText(ControlActivity.this, "控制指令已发送",Toast.LENGTH_LONG ).show();
                            urlConn.disconnect();
                            break;
                        }
                    }
                }catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }catch(Exception e2)
                {
                    e2.printStackTrace();
                }

            }
        });
        myThread.start();

    }
    private void delay(int ms){
        try {
            Thread.currentThread();
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//单栋1，1-18控制机构
    public void setonchecked1() {
        auto_11_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+Autocommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+Autocommand11_on);
                }
            }
        });
        auto_11_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+Autocommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+Autocommand11_off);
                }
            }
        });
        fengji_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+spinnerID1+fengjicommand11_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+spinnerID1+fengjicommand11_on);
                }
            }
        });
        fengji_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+ fengjicommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+ fengjicommand11_off);
                }
            }
        });
        dingji_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_on);
                }
            }
        });
        dingji_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_off);
                }
            }
        });
        dingji_1_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_onstop);
                }
            }
        });
        dingji_1_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+dingkaichuangcommand11_offstop);
                }
            }
        });
        neizhemu_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_on);
                }
            }
        });
        neizhemu_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_off);
                }
            }
        });
        neizhemu_1_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_onstop);
                }
            }
        });
        neizhemu_1_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+neizhemucommand11_offstop);
                }
            }
        });
        light_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+buguangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+buguangcommand11_on);
                }
            }
        });
        light_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+buguangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+buguangcommand11_off);
                }
            }
        });
        shilian_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+shiliancommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+shiliancommand11_on);
                }
            }
        });
        shilian_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+shiliancommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID1+shiliancommand11_off);
                }
            }
        });
        dianyuan_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan1 = 1;
                }
            }
        });
        dianyuan_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan1 = 0;
                }
            }
        });
        moshi_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi1 = "1";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi1 = "0";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_1_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu1 = "11";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_1_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu1 = "10";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_1_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu1 = "01";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_1_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu1 = "00";
                    if (dianyuan1 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
    //单栋2，2-12控制机构
    public void setonchecked2() {
        auto_21_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+Autocommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+Autocommand11_on);
                }
            }
        });
        auto_21_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+Autocommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+Autocommand11_off);
                }
            }
        });
        fengji_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+spinnerID2+fengjicommand11_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+spinnerID2+fengjicommand11_on);
                }
            }
        });
        fengji_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+ fengjicommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+ fengjicommand11_off);
                }
            }
        });
        dingji_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_on);
                }
            }
        });
        dingji_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_off);
                }
            }
        });
        dingji_2_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_onstop);
                }
            }
        });
        dingji_2_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+dingkaichuangcommand11_offstop);
                }
            }
        });
        neizhemu_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_on);
                }
            }
        });
        neizhemu_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_off);
                }
            }
        });
        neizhemu_2_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_onstop);
                }
            }
        });
        neizhemu_2_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+neizhemucommand11_offstop);
                }
            }
        });
        light_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+buguangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+buguangcommand11_on);
                }
            }
        });
        light_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+buguangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+buguangcommand11_off);
                }
            }
        });
        shilian_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+shiliancommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+shiliancommand11_on);
                }
            }
        });
        shilian_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+shiliancommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID2+shiliancommand11_off);
                }
            }
        });
        dianyuan_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan2 = 1;
                }
            }
        });
        dianyuan_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan2 = 0;
                }
            }
        });
        moshi_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi2 = "1";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi2 = "0";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_2_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu2 = "11";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_2_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu2 = "10";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_2_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu2 = "01";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_2_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu2 = "00";
                    if (dianyuan2 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    //单栋3，1-18控制机构
    public void setonchecked3() {
        auto_31_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+Autocommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+Autocommand11_on);
                }
            }
        });
        auto_31_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+Autocommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+Autocommand11_off);
                }
            }
        });
        fengji_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+spinnerID3+fengjicommand11_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+spinnerID3+fengjicommand11_on);
                }
            }
        });
        fengji_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+ fengjicommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+ fengjicommand11_off);
                }
            }
        });
        dingji_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_on);
                }
            }
        });
        dingji_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_off);
                }
            }
        });
        dingji_3_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_onstop);
                }
            }
        });
        dingji_3_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+dingkaichuangcommand11_offstop);
                }
            }
        });
        neizhemu_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_on);
                }
            }
        });
        neizhemu_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_off);
                }
            }
        });
        neizhemu_3_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_onstop);
                }
            }
        });
        neizhemu_3_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+neizhemucommand11_offstop);
                }
            }
        });
        light_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+buguangcommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+buguangcommand11_on);
                }
            }
        });
        light_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+buguangcommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+buguangcommand11_off);
                }
            }
        });
        shilian_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+shiliancommand11_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+shiliancommand11_on);
                }
            }
        });
        shilian_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+shiliancommand11_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+spinnerID3+shiliancommand11_off);
                }
            }
        });
        dianyuan_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan3 = 1;
                }
            }
        });
        dianyuan_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan3 = 0;
                }
            }
        });
        moshi_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi3 = "1";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi3 = "0";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_3_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu3 = "11";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_3_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu3 = "10";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_3_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu3 = "01";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_3_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu3 = "00";
                    if (dianyuan3 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    //连栋东区1-5控制机构
    public void setonchecked4() {
        auto_41_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {//补光灯手自动控制
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_on);
                }
            }
        });
        auto_41_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_off);
                }
            }
        });
        auto_42_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_on);
                }
            }
        });
        auto_42_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_off);
                }
            }
        });
        fengji_4_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand41_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand41_on);
                }
            }
        });
        fengji_4_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+ "02"+ zhouliufengjicommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+ "02"+ zhouliufengjicommand41_off);
                }
            }
        });
        fengji_4_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand42_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand42_on);
                }
            }
        });
        fengji_4_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand42_off);
                }
            }
        });
        fengji_4_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand43_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand43_on);
                }
            }
        });
        fengji_4_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand43_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand43_off);
                }
            }
        });
        dingji_4_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_on);
                }
            }
        });
        dingji_4_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_off);
                }
            }
        });
        dingji_4_1_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_onstop);
                }
            }
        });
        dingji_4_1_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_offstop);
                }
            }
        });
        dingji_4_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_on);
                }
            }
        });
        dingji_4_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_off);
                }
            }
        });
        dingji_4_2_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_onstop);
                }
            }
        });
        dingji_4_2_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_offstop);
                }
            }
        });

        neizhemu_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_on);
                }
            }
        });
        neizhemu_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_off);
                }
            }
        });
        neizhemu_4_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_onstop);
                }
            }
        });
        neizhemu_4_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_offstop);
                }
            }
        });
        light_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0401"+Led_on1);
                    delay(750);
                    sendMessage_toServer(str+"0401"+Led_on1);
                }
            }
        });
        light_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0401"+Led_off1);
                    delay(750);
                    sendMessage_toServer(str+"0401"+Led_off1);
                }
            }
        });
        shilian_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_on);
                }
            }
        });
        shilian_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_off);
                }
            }
        });
        dianyuan_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan4 = 1;
                }
            }
        });
        dianyuan_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan4 = 0;
                }
            }
        });
        moshi_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi4 = "1";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi4 = "0";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_4_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu4 = "11";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_4_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu4 = "10";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_4_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu4 = "01";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_4_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu4 = "00";
                    if (dianyuan4 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        huanliu_4_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_on);
                }
            }
        });
        huanliu_4_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_off);
                }
            }
        });
        huanliu_4_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_on);
                }
            }
        });
        huanliu_4_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_off);
                }
            }
        });
        cechuang_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_on);
                }
            }
        });
        cechuang_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_off);
                }
            }
        });
        cechuang_4_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_onstop);
                }
            }
        });
        cechuang_4_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_offstop);
                }
            }
        });
        waizheyang_4_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_on);
                }
            }
        });
        waizheyang_4_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_off);
                }
            }
        });
        waizheyang_4_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_onstop);
                }
            }
        });
        waizheyang_4_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_offstop);
                }
            }
        });
    }
    //连栋西区1-5控制机构
    public void setonchecked5() {
        auto_51_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_on);
                }
            }
        });
        auto_51_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"01"+Autocommand42_off);
                }
            }
        });
        auto_52_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_on);
                }
            }
        });
        auto_52_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+Autocommand41_off);
                }
            }
        });
        fengji_5_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand41_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand41_on);
                }
            }
        });
        fengji_5_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand41_off);
                }
            }
        });
        fengji_5_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand42_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+zhouliufengjicommand42_on);
                }
            }
        });
        fengji_5_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand42_off);
                }
            }
        });
        fengji_5_3_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0"+Tab+"02"+ zhouliufengjicommand43_on);
                    delay(750);
                    sendMessage_toServer( str+"0"+Tab+"02"+ zhouliufengjicommand43_on);
                }
            }
        });
        fengji_5_3_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand43_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+ zhouliufengjicommand43_off);
                }
            }
        });
        dingji_5_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_on);
                }
            }
        });
        dingji_5_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_off);
                }
            }
        });
        dingji_5_1_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_onstop);
                }
            }
        });
        dingji_5_1_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand41_offstop);
                }
            }
        });
        dingji_5_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_on);
                }
            }
        });
        dingji_5_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_off);
                }
            }
        });
        dingji_5_2_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_onstop);
                }
            }
        });
        dingji_5_2_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+dingkaichuangcommand42_offstop);
                }
            }
        });
        neizhemu_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_on);
                }
            }
        });
        neizhemu_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_off);
                }
            }
        });
        neizhemu_5_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_onstop);
                }
            }
        });
        neizhemu_5_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+neizheyincommand41_offstop);
                }
            }
        });
        light_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0501"+Led_on2);
                    delay(750);
                    sendMessage_toServer(str+"0501"+Led_on2);
                }
            }
        });
        light_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0501"+Led_off2);
                    delay(750);
                    sendMessage_toServer(str+"0501"+Led_off2);
                }
            }
        });
        shilian_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_on);
                }
            }
        });
        shilian_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+shiliancommand41_off);
                }
            }
        });
        dianyuan_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan5 = 1;
                }
            }
        });
        dianyuan_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan5 = 0;
                }
            }
        });
        moshi_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi5 = "1";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi5 = "0";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_5_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu5 = "11";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_5_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu5 = "10";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_5_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu5 = "01";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_5_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu5 = "00";
                    if (dianyuan5 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        huanliu_5_1_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_on);
                }
            }
        });
        huanliu_5_1_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand41_off);
                }
            }
        });
        huanliu_5_2_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_on);
                }
            }
        });
        huanliu_5_2_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+huanliufengjicommand42_off);
                }
            }
        });
        cechuang_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_on);
                }
            }
        });
        cechuang_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_off);
                }
            }
        });
        cechuang_5_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_onstop);
                }
            }
        });
        cechuang_5_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+cechuangcommand43_offstop);
                }
            }
        });
        waizheyang_5_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_on);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_on);
                }
            }
        });
        waizheyang_5_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_off);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_off);
                }
            }
        });
        waizheyang_5_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_onstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_onstop);
                }
            }
        });
        waizheyang_5_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0"+Tab+"02"+waizheyangcommand41_offstop);
                }
            }
        });
    }
    //单栋2，1房间控制机构
    public void setonchecked6() {
        auto_61_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+Autocommand21_on);
                    delay(750);
                    sendMessage_toServer(str+"0201"+Autocommand21_on);
                }
            }
        });
        auto_61_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+Autocommand21_off);
                    delay(750);
                    sendMessage_toServer(str+"0201"+Autocommand21_off);
                }
            }
        });
        dingji_6_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0201"+dingkaichuangcommand21_on);
                    delay(750);
                    sendMessage_toServer( str+"0201"+dingkaichuangcommand21_on);
                }
            }
        });
        dingji_6_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+ dingkaichuangcommand21_off);
                    delay(750);
                    sendMessage_toServer(str+"0201"+ dingkaichuangcommand21_off);
                }
            }
        });
        dingji_6_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0201"+dingkaichuangcommand21_onstop);
                    delay(750);
                    sendMessage_toServer( str+"0201"+dingkaichuangcommand21_onstop);
                }
            }
        });
        dingji_6_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+ dingkaichuangcommand21_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0201"+ dingkaichuangcommand21_offstop);
                }
            }
        });
        neizhemu_6_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0201"+ neizhemucommand21_on);
                    delay(750);
                    sendMessage_toServer( str+"0201"+ neizhemucommand21_on);
                }
            }
        });
        neizhemu_6_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+ neizhemucommand21_off);
                    delay(750);
                    sendMessage_toServer(str+"0201"+ neizhemucommand21_off);
                }
            }
        });
        neizhemu_6_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer( str+"0201"+ neizhemucommand21_onstop);
                    delay(750);
                    sendMessage_toServer( str+"0201"+ neizhemucommand21_onstop);
                }
            }
        });
        neizhemu_6_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer(str+"0201"+ neizhemucommand21_offstop);
                    delay(750);
                    sendMessage_toServer(str+"0201"+ neizhemucommand21_offstop);
                }
            }
        });
        dianyuan_6_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan6 = 1;
                }
            }
        });
        dianyuan_6_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    dianyuan6 = 0;
                }
            }
        });
        moshi_6_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi6 = "1";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        moshi_6_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    moshi6 = "0";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_6_low.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu6 = "11";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_6_mid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu6 = "10";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_6_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu6 = "01";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        fengsu_6_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    fengsu6 = "00";
                    if (dianyuan6 == 0){
                        Toast.makeText(ControlActivity.this,"请先打开电源开关", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        auto_65_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035063");
                }
            }
        });
        auto_65_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035064");
                }
            }
        });
        diancifa_61_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035065");
                }
            }
        });
        diancifa_61_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035067");
                }
            }
        });
        diancifa_61_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035066");
                }
            }
        });
        diancifa_61_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035068");
                }
            }
        });
        diancifa_62_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035069");
                }
            }
        });
        diancifa_62_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035071");
                }
            }
        });
        diancifa_62_onstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035070");
                }
            }
        });
        diancifa_62_offstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    sendMessage_toServer("MCMD@05035072");
                }
            }
        });
    }

    class AddbtnListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num1.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i1++;
                wendutiaojie1 = i1;
                Num1.setText(""+i1);
            }
        }
    }

    class DecreasebtnListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num1.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i1--;
                wendutiaojie1 = i1;
                Num1.setText(""+i1);
            }
        }
    }
    class cancelListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            layout_tab17.setVisibility(View.GONE);
        }
    }

    //单栋1，1-18地源热泵
    class confirmListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab17.setVisibility(View.GONE);
            if (Tab.equals("1")&&dianyuan1 == 1)
            {
                if (spinnerID1.equals("01")){
                    sendMessage_toServer(str1+chuankou0101+address0101+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0101+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0102+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0102+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("02")){
                    sendMessage_toServer(str1+chuankou0101+address0103+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0103+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0104+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0104+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("03")){
                    sendMessage_toServer(str1+chuankou0101+address0105+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0105+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0106+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0106+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("04")){
                    sendMessage_toServer(str1+chuankou0101+address0107+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0107+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0108+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0108+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0109+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0109+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01010+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01010+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("05")){
                    sendMessage_toServer(str1+chuankou0101+address01011+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01011+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01012+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01012+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01013+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01013+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01014+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01014+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("06")){
                    sendMessage_toServer(str1+chuankou0101+address01015+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01015+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01016+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01016+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01017+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01017+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01018+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01018+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("07")){
                    sendMessage_toServer(str1+chuankou0101+address01019+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01019+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01020+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01020+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("08")){
                    sendMessage_toServer(str1+chuankou0101+address01021+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01021+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01022+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01022+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("09")){
                    sendMessage_toServer(str1+chuankou0101+address01023+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01023+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01024+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01024+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("10")){
                    sendMessage_toServer(str1+chuankou0102+address01025+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01025+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01026+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01026+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("11")){
                    sendMessage_toServer(str1+chuankou0102+address01027+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01027+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01028+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01028+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("12")){
                    sendMessage_toServer(str1+chuankou0102+address01029+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01029+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01030+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01030+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("13")){
                    sendMessage_toServer(str1+chuankou0102+address01031+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01031+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01032+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01032+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01033+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01033+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01034+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01034+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("14")){
                    sendMessage_toServer(str1+chuankou0102+address01035+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01035+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01036+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01036+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01037+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01037+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01038+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01038+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("15")){
                    sendMessage_toServer(str1+chuankou0102+address01039+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01039+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01040+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01040+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01041+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01041+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01042+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01042+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("16")){
                    sendMessage_toServer(str1+chuankou0102+address01043+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01043+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01044+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01044+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("17")){
                    sendMessage_toServer(str1+chuankou0102+address01045+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01045+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01046+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01046+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("18")){
                    sendMessage_toServer(str1+chuankou0102+address01047+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01047+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01048+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01048+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }
            }else   if (Tab.equals("1")&&dianyuan1 == 0) {
                if (spinnerID1.equals("01")){
                    sendMessage_toServer(str1+chuankou0101+address0101+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0101+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0102+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0102+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("02")){
                    sendMessage_toServer(str1+chuankou0101+address0103+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0103+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0104+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0104+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("03")){
                    sendMessage_toServer(str1+chuankou0101+address0105+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0105+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0106+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0106+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("04")){
                    sendMessage_toServer(str1+chuankou0101+address0107+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0107+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0108+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0108+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0109+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address0109+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01010+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01010+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("05")){
                    sendMessage_toServer(str1+chuankou0101+address01011+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01011+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01012+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01012+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01013+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01013+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01014+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01014+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("06")){
                    sendMessage_toServer(str1+chuankou0101+address01015+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01015+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01016+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01016+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01017+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01017+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01018+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01018+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("07")){
                    sendMessage_toServer(str1+chuankou0101+address01019+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01019+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01020+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01020+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("08")){
                    sendMessage_toServer(str1+chuankou0101+address01021+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01021+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01022+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01022+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("09")){
                    sendMessage_toServer(str1+chuankou0101+address01023+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01023+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01024+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0101+address01024+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("10")){
                    sendMessage_toServer(str1+chuankou0102+address01025+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01025+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01026+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01026+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("11")){
                    sendMessage_toServer(str1+chuankou0102+address01027+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01027+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01028+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01028+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("12")){
                    sendMessage_toServer(str1+chuankou0102+address01029+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01029+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01030+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01030+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("13")){
                    sendMessage_toServer(str1+chuankou0102+address01031+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01031+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01032+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01032+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01033+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01033+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01034+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01034+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("14")){
                    sendMessage_toServer(str1+chuankou0102+address01035+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01035+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01036+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01036+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01037+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01037+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01038+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01038+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("15")){
                    sendMessage_toServer(str1+chuankou0102+address01039+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01039+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01040+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01040+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01041+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01041+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01042+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01042+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("16")){
                    sendMessage_toServer(str1+chuankou0102+address01043+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01043+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01044+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01044+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("17")){
                    sendMessage_toServer(str1+chuankou0102+address01045+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01045+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01046+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01046+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }else if (spinnerID1.equals("18")){
                    sendMessage_toServer(str1+chuankou0102+address01047+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01047+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01048+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0102+address01048+"@"+moshi1+dianyuan1+fengsu1+"@"+wendutiaojie1);
                }
            }
        }
    }

    class AddbtnListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num2.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i2++;
                wendutiaojie2 = i2;
                Num2.setText(""+i2);
            }
        }
    }

    class DecreasebtnListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num2.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i2--;
                wendutiaojie2 = i2;
                Num2.setText(""+i2);
            }
        }
    }
    class cancelListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab27.setVisibility(View.GONE);
        }
    }
    //单栋2，2-12地源热泵
    class confirmListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            layout_tab27.setVisibility(View.GONE);
            if (Tab.equals("2")&&dianyuan2 == 1)
            {
               if (spinnerID2.equals("02")){
                   sendMessage_toServer(str1+chuankou0201+address0205+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0205+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0206+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0206+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0207+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0207+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0208+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0208+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("03")){
                   sendMessage_toServer(str1+chuankou0201+address0209+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address0209+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02010+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02010+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02011+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02011+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02012+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02012+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("04")){
                   sendMessage_toServer(str1+chuankou0201+address02013+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02013+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02014+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02014+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02015+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02015+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02016+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02016+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("05")){
                   sendMessage_toServer(str1+chuankou0201+address02017+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02017+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02018+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02018+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02019+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02019+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02020+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02020+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("06")){
                   sendMessage_toServer(str1+chuankou0201+address02021+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02021+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02022+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02022+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02023+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02023+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02024+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0201+address02024+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("07")){
                   sendMessage_toServer(str1+chuankou0202+address02025+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02025+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02026+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02026+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02027+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02027+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02028+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02028+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("08")){
                   sendMessage_toServer(str1+chuankou0202+address02029+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02029+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02030+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02030+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02031+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02031+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02032+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1+chuankou0202+address02032+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
               }else if (spinnerID2.equals("09")){
                   sendMessage_toServer(str1 + chuankou0202 + address02033 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02033 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02034 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02034 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02035 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02035 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02036 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02036 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
               }else if (spinnerID2.equals("10")){
                   sendMessage_toServer(str1 + chuankou0202 + address02037 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02037 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02038 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02038 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02039 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02039 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02040 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02040 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
               }else if (spinnerID2.equals("11")){
                   sendMessage_toServer(str1 + chuankou0202 + address02041 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02041 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02042 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02042 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02043 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02043 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02044 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02044 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
               }else if (spinnerID2.equals("12")){
                   sendMessage_toServer(str1 + chuankou0202 + address02045 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02045 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02046 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02046 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02047 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02047 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02048 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                   delay(750);
                   sendMessage_toServer(str1 + chuankou0202 + address02048 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
               }
            }else   if (Tab.equals("2")&&dianyuan2 == 0) {
                if (spinnerID2.equals("02")){
                    sendMessage_toServer(str1+chuankou0201+address0205+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0205+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0206+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0206+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0207+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0207+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0208+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0208+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("03")){
                    sendMessage_toServer(str1+chuankou0201+address0209+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address0209+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02010+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02010+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02011+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02011+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02012+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02012+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("04")){
                    sendMessage_toServer(str1+chuankou0201+address02013+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02013+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02014+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02014+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02015+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02015+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02016+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02016+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("05")){
                    sendMessage_toServer(str1+chuankou0201+address02017+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02017+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02018+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02018+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02019+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02019+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02020+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02020+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("06")){
                    sendMessage_toServer(str1+chuankou0201+address02021+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02021+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02022+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02022+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02023+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02023+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02024+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0201+address02024+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("07")){
                    sendMessage_toServer(str1+chuankou0202+address02025+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02025+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02026+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02026+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02027+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02027+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02028+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02028+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("08")){
                    sendMessage_toServer(str1+chuankou0202+address02029+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02029+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02030+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02030+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02031+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02031+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02032+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0202+address02032+"@"+moshi2+dianyuan2+fengsu2+"@"+wendutiaojie2);
                }else if (spinnerID2.equals("09")){
                    sendMessage_toServer(str1 + chuankou0202 + address02033 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02033 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02034 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02034 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02035 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02035 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02036 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02036 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                }else if (spinnerID2.equals("10")){
                    sendMessage_toServer(str1 + chuankou0202 + address02037 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02037 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02038 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02038 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02039 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02039 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02040 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02040 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                }else if (spinnerID2.equals("11")){
                    sendMessage_toServer(str1 + chuankou0202 + address02041 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02041 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02042 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02042 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02043 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02043 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02044 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02044 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                }else if (spinnerID2.equals("12")){
                    sendMessage_toServer(str1 + chuankou0202 + address02045 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02045 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02046 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02046 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02047 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02047 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02048 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0202 + address02048 + "@" + moshi2 + dianyuan2 + fengsu2 + "@" + wendutiaojie2);
                }
            }
        }
    }

    class AddbtnListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num3.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i3++;
                wendutiaojie3 = i3;
                Num3.setText(""+i3);
            }
        }
    }

    class DecreasebtnListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num3.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i3--;
                wendutiaojie3 = i3;
                Num3.setText(""+i3);
            }
        }
    }

    class cancelListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab37.setVisibility(View.GONE);

        }
    }
    //单栋3，1-18地源热泵
    class confirmListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            layout_tab37.setVisibility(View.GONE);
            {
                if (Tab.equals("3")&&dianyuan3 == 1)
                {
                    if (spinnerID3.equals("01")){
                    sendMessage_toServer(str1+chuankou0301+address0301+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0301+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0302+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0302+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("02")){
                    sendMessage_toServer(str1+chuankou0301+address0303+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0303+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0304+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0304+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("03")){
                    sendMessage_toServer(str1+chuankou0301+address0305+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0305+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0306+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0306+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("04")){
                    sendMessage_toServer(str1+chuankou0301+address0307+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0307+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0308+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0308+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0309+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address0309+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03010+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03010+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("05")){
                    sendMessage_toServer(str1+chuankou0301+address03011+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03011+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03012+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03012+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03013+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03013+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03014+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03014+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("06")){
                    sendMessage_toServer(str1+chuankou0301+address03015+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03015+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03016+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03016+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03017+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03017+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03018+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03018+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("07")){
                    sendMessage_toServer(str1+chuankou0301+address03019+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03019+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03020+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03020+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("08")){
                    sendMessage_toServer(str1+chuankou0301+address03021+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03021+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03022+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03022+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("09")){
                    sendMessage_toServer(str1+chuankou0301+address03023+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03023+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03024+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0301+address03024+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("10")){
                    sendMessage_toServer(str1+chuankou0302+address03025+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03025+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03026+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03026+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("11")){
                    sendMessage_toServer(str1+chuankou0302+address03027+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03027+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03028+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03028+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("12")){
                    sendMessage_toServer(str1+chuankou0302+address03029+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03029+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03030+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03030+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("13")){
                    sendMessage_toServer(str1+chuankou0302+address03031+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03031+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03032+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03032+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03033+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03033+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03034+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03034+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("14")){
                    sendMessage_toServer(str1+chuankou0302+address03035+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03035+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03036+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03036+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03037+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03037+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03038+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03038+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("15")){
                    sendMessage_toServer(str1+chuankou0302+address03039+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03039+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03040+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03040+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03041+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03041+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03042+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03042+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("16")){
                    sendMessage_toServer(str1+chuankou0302+address03043+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03043+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03044+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03044+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("17")){
                    sendMessage_toServer(str1+chuankou0302+address03045+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03045+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03046+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03046+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }else if (spinnerID3.equals("18")){
                    sendMessage_toServer(str1+chuankou0302+address03047+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03047+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03048+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0302+address03048+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                }
            }else if (Tab.equals("3")&&dianyuan3 == 0){
                    if (spinnerID3.equals("01")){
                        sendMessage_toServer(str1+chuankou0301+address0301+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0301+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0302+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0302+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("02")){
                        sendMessage_toServer(str1+chuankou0301+address0303+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0303+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0304+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0304+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("03")){
                        sendMessage_toServer(str1+chuankou0301+address0305+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0305+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0306+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0306+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("04")){
                        sendMessage_toServer(str1+chuankou0301+address0307+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0307+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0308+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0308+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0309+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address0309+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03010+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03010+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("05")){
                        sendMessage_toServer(str1+chuankou0301+address03011+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03011+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03012+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03012+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03013+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03013+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03014+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03014+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("06")){
                        sendMessage_toServer(str1+chuankou0301+address03015+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03015+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03016+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03016+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03017+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03017+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03018+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03018+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("07")){
                        sendMessage_toServer(str1+chuankou0301+address03019+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03019+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03020+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03020+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("08")){
                        sendMessage_toServer(str1+chuankou0301+address03021+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03021+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03022+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03022+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("09")){
                        sendMessage_toServer(str1+chuankou0301+address03023+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03023+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03024+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0301+address03024+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("10")){
                        sendMessage_toServer(str1+chuankou0302+address03025+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03025+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03026+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03026+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("11")){
                        sendMessage_toServer(str1+chuankou0302+address03027+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03027+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03028+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03028+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("12")){
                        sendMessage_toServer(str1+chuankou0302+address03029+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03029+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03030+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03030+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("13")){
                        sendMessage_toServer(str1+chuankou0302+address03031+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03031+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03032+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03032+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03033+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03033+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03034+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03034+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("14")){
                        sendMessage_toServer(str1+chuankou0302+address03035+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03035+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03036+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03036+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03037+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03037+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03038+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03038+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("15")){
                        sendMessage_toServer(str1+chuankou0302+address03039+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03039+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03040+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03040+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03041+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03041+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03042+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03042+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("16")){
                        sendMessage_toServer(str1+chuankou0302+address03043+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03043+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03044+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03044+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("17")){
                        sendMessage_toServer(str1+chuankou0302+address03045+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03045+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03046+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03046+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }else if (spinnerID3.equals("18")){
                        sendMessage_toServer(str1+chuankou0302+address03047+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03047+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03048+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                        delay(750);
                        sendMessage_toServer(str1+chuankou0302+address03048+"@"+moshi3+dianyuan3+fengsu3+"@"+wendutiaojie3);
                    }
                }
            }
        }
    }

    class AddbtnListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num4.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i4++;
                wendutiaojie4 = i4;
                Num4.setText(""+i4);
            }
        }
    }

    class DecreasebtnListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num4.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i4--;
                wendutiaojie4 = i4;
                Num4.setText(""+i4);
            }
        }
    }
    class cancelListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab410.setVisibility(View.GONE);
        }
    }
    //连栋东区，1-5地源热泵
    class confirmListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab49.setVisibility(View.GONE);
            if (Tab.equals("4")&&dianyuan4 == 1)
            {
                if (spinnerID4.equals("01")){
                    sendMessage_toServer(str1+chuankou0401+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0401+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("02")){
                    sendMessage_toServer(str1+chuankou0402+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0402+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("03")){
                    sendMessage_toServer(str1+chuankou0403+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0403+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("04")){
                    sendMessage_toServer(str1+chuankou0404+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0404+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("05")){
                    sendMessage_toServer(str1+chuankou0405+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0405+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("06")) {
                    sendMessage_toServer(str1 + chuankou0406 + address0401 + "@" + moshi4 + dianyuan4 + fengsu4 + "@" + wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0406 + address0401 + "@" + moshi4 + dianyuan4 + fengsu4 + "@" + wendutiaojie4);
                }
            }else   if (Tab.equals("4")&&dianyuan4 == 0) {
                if (spinnerID4.equals("01")){
                    sendMessage_toServer(str1+chuankou0401+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0401+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("02")){
                    sendMessage_toServer(str1+chuankou0402+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0402+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("03")){
                    sendMessage_toServer(str1+chuankou0403+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0403+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("04")){
                    sendMessage_toServer(str1+chuankou0404+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0404+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("05")){
                    sendMessage_toServer(str1+chuankou0405+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0405+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }else if (spinnerID4.equals("06")){
                    sendMessage_toServer(str1+chuankou0406+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0406+address0401+"@"+moshi4+dianyuan4+fengsu4+"@"+wendutiaojie4);
                }
            }
        }
    }

    class AddbtnListener5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num5.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i5++;
                wendutiaojie5 = i5;
                Num5.setText(""+i5);
            }
        }
    }

    class DecreasebtnListener5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num5.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i5--;
                wendutiaojie5 = i5;
                Num5.setText(""+i5);
            }
        }
    }
    class cancelListener5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab59.setVisibility(View.GONE);
        }
    }
    //连栋西区，1-5地源热泵
    class confirmListener5 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            layout_tab59.setVisibility(View.GONE);
            if (Tab.equals("5")&&dianyuan5 == 1)
            {
                if (spinnerID5.equals("01")){
                    sendMessage_toServer(str1+chuankou0501+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0501+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("02")){
                    sendMessage_toServer(str1+chuankou0502+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0502+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("03")){
                    sendMessage_toServer(str1+chuankou0503+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0503+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("04")){
                    sendMessage_toServer(str1+chuankou0504+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0504+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("05")){
                    sendMessage_toServer(str1+chuankou0505+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0505+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("06")) {
                    sendMessage_toServer(str1 + chuankou0506 + address0401 + "@" + moshi5 + dianyuan5 + fengsu5 + "@" + wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0506 + address0401 + "@" + moshi5 + dianyuan5 + fengsu5 + "@" + wendutiaojie5);
                }
            }else   if (Tab.equals("5")&&dianyuan5 == 0) {
                if (spinnerID5.equals("01")){
                    sendMessage_toServer(str1+chuankou0501+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0501+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("02")){
                    sendMessage_toServer(str1+chuankou0502+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0502+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("03")){
                    sendMessage_toServer(str1+chuankou0503+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0503+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("04")){
                    sendMessage_toServer(str1+chuankou0504+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0504+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("05")){
                    sendMessage_toServer(str1+chuankou0505+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1+chuankou0505+address0401+"@"+moshi5+dianyuan5+fengsu5+"@"+wendutiaojie5);
                }else if (spinnerID5.equals("06")) {
                    sendMessage_toServer(str1 + chuankou0506 + address0401 + "@" + moshi5 + dianyuan5 + fengsu5 + "@" + wendutiaojie5);
                    delay(750);
                    sendMessage_toServer(str1 + chuankou0506 + address0401 + "@" + moshi5 + dianyuan5 + fengsu5 + "@" + wendutiaojie5);
                }
            }
        }
    }
    class AddbtnListener6 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num6.getText().toString();
            if(input.equals("30")){
                Toast.makeText(ControlActivity.this,"设置的最高温度不能超过30℃",Toast.LENGTH_SHORT).show();
            }else {
                i6++;
                wendutiaojie6 = i6;
                Num6.setText(""+i6);
            }
        }
    }

    class DecreasebtnListener6 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            String input = Num6.getText().toString();
            if(input.equals("10")){
                Toast.makeText(ControlActivity.this,"设置的最低温度不能低于10℃",Toast.LENGTH_SHORT).show();
            }else {
                i6--;
                wendutiaojie6 = i6;
                Num6.setText(""+i6);
            }
        }
    }
    class cancelListener6 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO Auto-generated method stub
            layout_tab64.setVisibility(View.GONE);
        }
    }
    //单栋2，1房间地源热泵
    class confirmListener6 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            layout_tab64.setVisibility(View.GONE);
            sendMessage_toServer(str1+chuankou0201+address0201+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0201+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0202+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0202+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0203+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0203+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0204+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
            delay(750);
            sendMessage_toServer(str1+chuankou0201+address0204+"@"+moshi6+dianyuan6+fengsu6+"@"+wendutiaojie6);
        }
    }

    private void setupView1() {
        tv11 = (TextView) findViewById(R.id.tv11);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv13 = (TextView) findViewById(R.id.tv13);
        tv14 = (TextView) findViewById(R.id.tv14);
        tv15 = (TextView) findViewById(R.id.tv15);
        tv16 = (TextView) findViewById(R.id.tv16);
        tv17 = (TextView) findViewById(R.id.tv17);
        layout_tab11 = (LinearLayout) findViewById(R.id.layout_tab11);
        layout_tab12 = (LinearLayout) findViewById(R.id.layout_tab12);
        layout_tab13 = (LinearLayout) findViewById(R.id.layout_tab13);
        layout_tab14 = (LinearLayout) findViewById(R.id.layout_tab14);
        layout_tab15 = (LinearLayout) findViewById(R.id.layout_tab15);
        layout_tab16 = (LinearLayout) findViewById(R.id.layout_tab16);
        layout_tab17 = (LinearLayout) findViewById(R.id.layout_tab17);
        layout_tab11.setVisibility(View.GONE);
        layout_tab12.setVisibility(View.GONE);
        layout_tab13.setVisibility(View.GONE);
        layout_tab14.setVisibility(View.GONE);
        layout_tab15.setVisibility(View.GONE);
        layout_tab16.setVisibility(View.GONE);
        layout_tab17.setVisibility(View.GONE);
        tv11.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab11.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.VISIBLE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }
            }
        });
        tv12.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab12.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.VISIBLE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }
            }
        });
        tv13.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab13.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.VISIBLE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }

            }
        });
        tv14.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab14.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.VISIBLE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }
            }
        });
        tv15.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab15.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.VISIBLE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }

            }
        });
        tv16.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab16.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.VISIBLE);
                    layout_tab17.setVisibility(View.GONE);
                }

            }
        });
        tv17.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab17.getVisibility() == View.VISIBLE) {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.GONE);
                }else {
                    layout_tab11.setVisibility(View.GONE);
                    layout_tab12.setVisibility(View.GONE);
                    layout_tab13.setVisibility(View.GONE);
                    layout_tab14.setVisibility(View.GONE);
                    layout_tab15.setVisibility(View.GONE);
                    layout_tab16.setVisibility(View.GONE);
                    layout_tab17.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setupView2() {
        tv21 = (TextView) findViewById(R.id.tv21);
        tv22 = (TextView) findViewById(R.id.tv22);
        tv23 = (TextView) findViewById(R.id.tv23);
        tv24 = (TextView) findViewById(R.id.tv24);
        tv25 = (TextView) findViewById(R.id.tv25);
        tv26 = (TextView) findViewById(R.id.tv26);
        tv27 = (TextView) findViewById(R.id.tv27);

        layout_tab21 = (LinearLayout) findViewById(R.id.layout_tab21);
        layout_tab22 = (LinearLayout) findViewById(R.id.layout_tab22);
        layout_tab23 = (LinearLayout) findViewById(R.id.layout_tab23);
        layout_tab24 = (LinearLayout) findViewById(R.id.layout_tab24);
        layout_tab25 = (LinearLayout) findViewById(R.id.layout_tab25);
        layout_tab26 = (LinearLayout) findViewById(R.id.layout_tab26);
        layout_tab27 = (LinearLayout) findViewById(R.id.layout_tab27);

        layout_tab21.setVisibility(View.GONE);
        layout_tab22.setVisibility(View.GONE);
        layout_tab23.setVisibility(View.GONE);
        layout_tab24.setVisibility(View.GONE);
        layout_tab25.setVisibility(View.GONE);
        layout_tab26.setVisibility(View.GONE);
        layout_tab27.setVisibility(View.GONE);
        tv21.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab21.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.VISIBLE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }

            }
        });
        tv22.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab22.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.VISIBLE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }
            }
        });
        tv23.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab23.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.VISIBLE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }
            }
        });
        tv24.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab24.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.VISIBLE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }
            }
        });
        tv25.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab25.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.VISIBLE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }
            }
        });
        tv26.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab26.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.VISIBLE);
                    layout_tab27.setVisibility(View.GONE);
                }
            }
        });
        tv27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab27.getVisibility() == View.VISIBLE) {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.GONE);
                }else {
                    layout_tab21.setVisibility(View.GONE);
                    layout_tab22.setVisibility(View.GONE);
                    layout_tab23.setVisibility(View.GONE);
                    layout_tab24.setVisibility(View.GONE);
                    layout_tab25.setVisibility(View.GONE);
                    layout_tab26.setVisibility(View.GONE);
                    layout_tab27.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setupView3() {
        tv31 = (TextView) findViewById(R.id.tv31);
        tv32 = (TextView) findViewById(R.id.tv32);
        tv33 = (TextView) findViewById(R.id.tv33);
        tv34 = (TextView) findViewById(R.id.tv34);
        tv35 = (TextView) findViewById(R.id.tv35);
        tv36 = (TextView) findViewById(R.id.tv36);
        tv37 = (TextView) findViewById(R.id.tv37);

        layout_tab31 = (LinearLayout) findViewById(R.id.layout_tab31);
        layout_tab32 = (LinearLayout) findViewById(R.id.layout_tab32);
        layout_tab33 = (LinearLayout) findViewById(R.id.layout_tab33);
        layout_tab34 = (LinearLayout) findViewById(R.id.layout_tab34);
        layout_tab35 = (LinearLayout) findViewById(R.id.layout_tab35);
        layout_tab36 = (LinearLayout) findViewById(R.id.layout_tab36);
        layout_tab37 = (LinearLayout) findViewById(R.id.layout_tab37);

        layout_tab31.setVisibility(View.GONE);
        layout_tab32.setVisibility(View.GONE);
        layout_tab33.setVisibility(View.GONE);
        layout_tab34.setVisibility(View.GONE);
        layout_tab35.setVisibility(View.GONE);
        layout_tab36.setVisibility(View.GONE);
        layout_tab37.setVisibility(View.GONE);

        tv31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab31.getVisibility() == View.VISIBLE) {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                } else {
                    layout_tab31.setVisibility(View.VISIBLE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab32.getVisibility() == View.VISIBLE) {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.VISIBLE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab33.getVisibility() == View.VISIBLE) {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.VISIBLE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab34.getVisibility() == View.VISIBLE) {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.VISIBLE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab35.getVisibility() == View.VISIBLE) {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.VISIBLE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (layout_tab36.getVisibility() == View.VISIBLE) {
                    // TODO Auto-generated method stub
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.VISIBLE);
                    layout_tab37.setVisibility(View.GONE);
                }
            }
        });
        tv37.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (layout_tab37.getVisibility() == View.VISIBLE) {
                    // TODO Auto-generated method stub
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.GONE);
                }else {
                    layout_tab31.setVisibility(View.GONE);
                    layout_tab32.setVisibility(View.GONE);
                    layout_tab33.setVisibility(View.GONE);
                    layout_tab34.setVisibility(View.GONE);
                    layout_tab35.setVisibility(View.GONE);
                    layout_tab36.setVisibility(View.GONE);
                    layout_tab37.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setupView4() {
        tv41 = (TextView) findViewById(R.id.tv41);
        tv42 = (TextView) findViewById(R.id.tv42);
        tv43 = (TextView) findViewById(R.id.tv43);
        tv44 = (TextView) findViewById(R.id.tv44);
        tv45 = (TextView) findViewById(R.id.tv45);
        tv46 = (TextView) findViewById(R.id.tv46);
        tv47 = (TextView) findViewById(R.id.tv47);
        tv48 = (TextView) findViewById(R.id.tv48);
        tv49 = (TextView) findViewById(R.id.tv49);
        tv410 = (TextView) findViewById(R.id.tv410);
        layout_tab41 = (LinearLayout) findViewById(R.id.layout_tab41);
        layout_tab42 = (LinearLayout) findViewById(R.id.layout_tab42);
        layout_tab43 = (LinearLayout) findViewById(R.id.layout_tab43);
        layout_tab44 = (LinearLayout) findViewById(R.id.layout_tab44);
        layout_tab45 = (LinearLayout) findViewById(R.id.layout_tab45);
        layout_tab46 = (LinearLayout) findViewById(R.id.layout_tab46);
        layout_tab47 = (LinearLayout) findViewById(R.id.layout_tab47);
        layout41 = (LinearLayout) findViewById(R.id.layout41);
        layout_tab48 = (LinearLayout) findViewById(R.id.layout_tab48);
        layout_tab49 = (LinearLayout) findViewById(R.id.layout_tab49);
        layout_tab410 = (LinearLayout) findViewById(R.id.layout_tab410);
        layout_tab41.setVisibility(View.GONE);
        layout_tab42.setVisibility(View.GONE);
        layout_tab43.setVisibility(View.GONE);
        layout_tab44.setVisibility(View.GONE);
        layout_tab45.setVisibility(View.GONE);
        layout_tab46.setVisibility(View.GONE);
        layout_tab47.setVisibility(View.GONE);
        layout41.setVisibility(View.GONE);
        layout_tab48.setVisibility(View.GONE);
        layout_tab49.setVisibility(View.GONE);
        layout_tab410.setVisibility(View.GONE);
        tv41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab41.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.VISIBLE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab42.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.VISIBLE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab43.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.VISIBLE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab44.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.VISIBLE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab45.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.VISIBLE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab46.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.VISIBLE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });

        tv47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab47.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.VISIBLE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });

        tv48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab48.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.VISIBLE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab49.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.VISIBLE);
                    layout_tab410.setVisibility(View.GONE);
                }
            }
        });
        tv410.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab410.getVisibility() == View.VISIBLE) {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.GONE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.GONE);
                }else {
                    layout_tab41.setVisibility(View.GONE);
                    layout_tab42.setVisibility(View.GONE);
                    layout_tab43.setVisibility(View.GONE);
                    layout_tab44.setVisibility(View.GONE);
                    layout_tab45.setVisibility(View.GONE);
                    layout_tab46.setVisibility(View.GONE);
                    layout_tab47.setVisibility(View.GONE);
                    layout41.setVisibility(View.VISIBLE);
                    layout_tab48.setVisibility(View.GONE);
                    layout_tab49.setVisibility(View.GONE);
                    layout_tab410.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setupView5() {
        tv51 = (TextView) findViewById(R.id.tv51);
        tv52 = (TextView) findViewById(R.id.tv52);
        tv53 = (TextView) findViewById(R.id.tv53);
        tv54 = (TextView) findViewById(R.id.tv54);
        tv55 = (TextView) findViewById(R.id.tv55);
        tv56 = (TextView) findViewById(R.id.tv56);
        tv57 = (TextView) findViewById(R.id.tv57);
        tv58 = (TextView) findViewById(R.id.tv58);
        tv59 = (TextView) findViewById(R.id.tv59);
        tv510 = (TextView) findViewById(R.id.tv510);
        layout51 = (LinearLayout) findViewById(R.id.layout51);
        layout_tab51 = (LinearLayout) findViewById(R.id.layout_tab51);
        layout_tab52 = (LinearLayout) findViewById(R.id.layout_tab52);
        layout_tab53 = (LinearLayout) findViewById(R.id.layout_tab53);
        layout_tab54 = (LinearLayout) findViewById(R.id.layout_tab54);
        layout_tab55 = (LinearLayout) findViewById(R.id.layout_tab55);
        layout_tab56 = (LinearLayout) findViewById(R.id.layout_tab56);
        layout_tab57 = (LinearLayout) findViewById(R.id.layout_tab57);
        layout_tab58 = (LinearLayout) findViewById(R.id.layout_tab58);
        layout_tab59 = (LinearLayout) findViewById(R.id.layout_tab59);
        layout_tab510 = (LinearLayout) findViewById(R.id.layout_tab510);
        layout51.setVisibility(View.GONE);
        layout_tab51.setVisibility(View.GONE);
        layout_tab52.setVisibility(View.GONE);
        layout_tab53.setVisibility(View.GONE);
        layout_tab54.setVisibility(View.GONE);
        layout_tab55.setVisibility(View.GONE);
        layout_tab56.setVisibility(View.GONE);
        layout_tab57.setVisibility(View.GONE);
        layout_tab58.setVisibility(View.GONE);
        layout_tab59.setVisibility(View.GONE);
        layout_tab510.setVisibility(View.GONE);
        tv51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab51.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.VISIBLE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab52.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.VISIBLE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab53.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.VISIBLE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab54.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.VISIBLE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab55.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.VISIBLE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab56.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.VISIBLE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab57.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.VISIBLE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab58.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.VISIBLE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab59.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.VISIBLE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }
            }
        });
        tv510.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab510.getVisibility() == View.VISIBLE) {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.GONE);
                    layout51.setVisibility(View.GONE);
                }else {
                    layout_tab51.setVisibility(View.GONE);
                    layout_tab52.setVisibility(View.GONE);
                    layout_tab53.setVisibility(View.GONE);
                    layout_tab54.setVisibility(View.GONE);
                    layout_tab55.setVisibility(View.GONE);
                    layout_tab56.setVisibility(View.GONE);
                    layout_tab57.setVisibility(View.GONE);
                    layout_tab58.setVisibility(View.GONE);
                    layout_tab59.setVisibility(View.GONE);
                    layout_tab510.setVisibility(View.VISIBLE);
                    layout51.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setupView6() {
        tv61 = (TextView) findViewById(R.id.tv61);
        tv62 = (TextView) findViewById(R.id.tv62);
        tv63 = (TextView) findViewById(R.id.tv63);
        tv64 = (TextView) findViewById(R.id.tv64);
        tv65 = (TextView) findViewById(R.id.tv65);
        layout_tab61 = (LinearLayout) findViewById(R.id.layout_tab61);
        layout_tab62 = (LinearLayout) findViewById(R.id.layout_tab62);
        layout_tab63 = (LinearLayout) findViewById(R.id.layout_tab63);
        layout_tab64 = (LinearLayout) findViewById(R.id.layout_tab64);
        layout_tab65 = (LinearLayout) findViewById(R.id.layout_tab65);
        layout_tab61.setVisibility(View.GONE);
        layout_tab62.setVisibility(View.GONE);
        layout_tab63.setVisibility(View.GONE);
        layout_tab64.setVisibility(View.GONE);
        layout_tab65.setVisibility(View.GONE);
        tv61.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab61.getVisibility() == View.VISIBLE) {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }else {
                    layout_tab61.setVisibility(View.VISIBLE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }
            }
        });
        tv62.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab62.getVisibility() == View.VISIBLE) {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }else {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.VISIBLE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }
            }
        });
        tv63.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab63.getVisibility() == View.VISIBLE) {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }else {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.VISIBLE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }
            }
        });
        tv64.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab64.getVisibility() == View.VISIBLE) {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }else {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.VISIBLE);
                    layout_tab65.setVisibility(View.GONE);
                }
            }
        });
        tv65.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (layout_tab65.getVisibility() == View.VISIBLE) {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.GONE);
                }else {
                    layout_tab61.setVisibility(View.GONE);
                    layout_tab62.setVisibility(View.GONE);
                    layout_tab63.setVisibility(View.GONE);
                    layout_tab64.setVisibility(View.GONE);
                    layout_tab65.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            dialog();
            return true;
        }
        else
        {
            return super.onKeyDown(keyCode, event);
        }
    }
    protected void dialog()
    {
        Dialog dialog = new AlertDialog.Builder(this).setTitle("温室管理终端").setMessage(
                "确认退出应用程序？").setPositiveButton("退出",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                ControlActivity.this.finish();
            }
        }).setNegativeButton("取消",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).create();
        dialog.show();
    }
    protected void dialog1()
    {
        Dialog dialog = new AlertDialog.Builder(this).setTitle("温室管理终端").setMessage(
                "确认注销当前帐号？").setPositiveButton("确定",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(ControlActivity.this, Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                ControlActivity.this.finish();
            }
        }).setNegativeButton("取消",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).create();
        dialog.show();
    }

    private View.OnClickListener clickListener_home = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(true);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(ControlActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };
    private View.OnClickListener clickListener_style = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(true);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(ControlActivity.this, VideoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();

        }
    };
    private View.OnClickListener clickListener_cam = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(true);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(ControlActivity.this, CurveActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };
    private View.OnClickListener clickListener_shopping = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(true);
            show_img_bn_layout.setSelected(false);
        }
    };

    private View.OnClickListener clickListener_show = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            style_img_bn_layout.setSelected(false);
            cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
            show_img_bn_layout.setSelected(true);
            Intent intent = new Intent();
            intent.setClass(ControlActivity.this, ContactActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.zoommin, R.anim.zoomout);
            finish();
        }
    };


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Control Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.fr.baimajidi/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Control Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.fr.baimajidi/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
