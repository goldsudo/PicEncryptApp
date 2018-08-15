package hhu.jswang.enpicture;

import hhu.jswang.enpicture.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start);
        new Thread(){
        	public void run(){
        		try{
        			Thread.sleep(1500);
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		Intent intent=new Intent(StartActivity.this,RunTimeActivity.class);
        		startActivity(intent);
        		finish();
        }
    }.start();
 }
}
