package com.example.eventbustest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.example.eventbustest.event.MyEvent;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by cuifei on 16/5/2.
 */
public class SecondActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second_activity_layout);
  }

  public void onClick(View view) {
    MyEvent myEvent = new MyEvent();
    myEvent.setId(1);
    myEvent.setMsg("This is from SecondActivity");
    EventBus.getDefault().post(myEvent);

    //test git branch
  }
}
