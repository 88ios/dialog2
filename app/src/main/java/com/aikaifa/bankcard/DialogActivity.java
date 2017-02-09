package com.aikaifa.bankcard;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5;
    private Button btn6, btn7, btn8, btn9, btn10;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        activity = this;
        initView();
        initClick();
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        switch (v.getId()) {
            case R.id.btn1:
                builder.setTitle("温馨提示");//标题
                builder.setMessage("天气冷，注意保暖");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.create();
                builder.show();
                break;
            case R.id.btn2:
                builder.setTitle("确定取消对话框");
                builder.setMessage("请选择确定或取消");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    //正能量按钮 Positive
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "你点击了确定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "你选择了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn3:

                builder.setTitle("多个按钮对话框");
                builder.setMessage("请选择");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("我没玩够", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "继续浏览精彩内容", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("开启", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "起床了", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("我累了，要休息一下", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "欢迎再来", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn4:
                final String arrItem[] = getResources().getStringArray(R.array.aikaifa);
                builder.setItems(arrItem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "你选择了第" + arrItem[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn5:
                builder.setTitle("带Adapter的对话框");
                builder.setIcon(R.mipmap.ic_launcher);
                final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                int arrImg[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
                for (int i = 0; i < arrImg.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("img", arrImg[i]);
                    map.put("title", "爱开发" + i);
                    list.add(map);
                }
                SimpleAdapter adapter = new SimpleAdapter(activity, list, R.layout.list_item, new String[]{"img", "title"}, new int[]{R.id.iv, R.id.tv});
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "你选择了" + list.get(which).get("title").toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn6:
                builder.setTitle("单选对话框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setSingleChoiceItems(R.array.aikaifa, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, which+"", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.btn7:
                builder.setTitle("多选对话框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMultiChoiceItems(R.array.aikaifa, null, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(activity, which+""+isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn8:
                DatePickerDialog datePickerDialog=new DatePickerDialog(activity,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                Toast.makeText(activity,
                                        year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
                            }
                        },
                        2017, 02, 9);
                datePickerDialog.show();
                break;
            case R.id.btn9:
                TimePickerDialog timePickerDialog=new TimePickerDialog(activity,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(activity,
                                        hourOfDay+"小时"+minute+"分钟", Toast.LENGTH_SHORT).show();
                            }
                        },
                        17, 49, true);
                timePickerDialog.show();
                break;
            case R.id.btn10:

                View view= LayoutInflater.from(activity).inflate(R.layout.dialog_login, null);
                builder.setView(view);
                builder.create();
                final EditText et_phone=(EditText)view.findViewById(R.id.et_phone);
                final EditText et_password=(EditText)view.findViewById(R.id.et_password);
                Button btn_submit=(Button)view.findViewById(R.id.btn_submit);
                btn_submit.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(activity, "手机号码:"+et_phone.getText().toString()+" 短信验证码:"+et_password.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;

        }
    }

    /**
     * 按钮点击
     */
    private void initClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
    }

    /**
     * 初始化View
     */
    private void initView() {

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);

    }
}
