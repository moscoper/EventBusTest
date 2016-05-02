package com.example.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.example.eventbustest.event.MyEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

  public final static String Tag="MainActivity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    EventBus.getDefault().register(this);
  }
  public void onClick(View view){
    Intent intent = new Intent(this,SecondActivity.class);
    startActivity(intent);
  }

  @Subscribe(threadMode = ThreadMode.ASYNC) //标准此方法是 EventBus 接受消息的方法
  public void onEvent(MyEvent myEvent){
    Log.i(Tag,"MainActivity"+myEvent.getId()+"==="+myEvent.getMsg()+"==Thread="+Thread.currentThread());
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }
}
