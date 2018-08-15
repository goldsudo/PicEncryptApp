package hhu.jswang.enpicture;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.mikephil.charting.charts.BarChart;

import hhu.jswang.enpicture.BarchartActivity;
import hhu.jswang.enpicture.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class RunTimeActivity extends Activity {
	private EditText key1;
	private ImageView imageView;
	private Button choise;
	private Button encrypt;
	private Button decrypt;
	private Button out;
	private Button noise;
	private Button barchart;
	private static int GALLERY_REQUEST_CODE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.runtime);
        key1=(EditText)findViewById(R.id.key1);
        imageView=(ImageView)findViewById(R.id.imageView);
        choise=(Button)findViewById(R.id.choise);
        encrypt=(Button)findViewById(R.id.encrypt);
        decrypt=(Button)findViewById(R.id.decrypt);
        noise = (Button)findViewById(R.id.noise);
        barchart = (Button)findViewById(R.id.barchart);
        out=(Button)findViewById(R.id.out);
        imageView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				AlertDialog.Builder builder = new AlertDialog.Builder(
						RunTimeActivity.this);
				//builder.setIcon(R.drawable.tools);
				builder.setTitle("图像存储");
				builder.setMessage("是否要保存图片?");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								imageView=(ImageView)findViewById(R.id.imageView);
								if(imageView.getDrawable()==null)
								{
									Toast.makeText(RunTimeActivity.this, "请先选择一副图片.", Toast.LENGTH_LONG).show();
									return;
								}
								Bitmap bm1= ((BitmapDrawable)imageView.getDrawable()).getBitmap();
								File tmpDir=new File(Environment.getExternalStorageDirectory().toString()+File.separator+"tumi_de");
								if(!tmpDir.exists()){
									tmpDir.mkdir();
								}
								File img=new File(tmpDir.getAbsolutePath()+"enphoto.png");
								
								try {
									FileOutputStream fos = new FileOutputStream(img);
									bm1.compress(Bitmap.CompressFormat.PNG, 85, fos);
									fos.flush();
									fos.close();
									Toast.makeText(RunTimeActivity.this, "保存成功", Toast.LENGTH_LONG).show();
									return;
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									Toast.makeText(RunTimeActivity.this, "保存失败", Toast.LENGTH_LONG).show();
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
				builder.setNegativeButton("取消", null);
				builder.create();
				builder.show();
			}
		});
        choise.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(intent,GALLERY_REQUEST_CODE);
			}
		});
        out.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				AlertDialog.Builder builder = new AlertDialog.Builder(
						RunTimeActivity.this);
				//builder.setIcon(R.drawable.tools);
				builder.setTitle("程序关闭");
				builder.setMessage("是否要退出软件?");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								RunTimeActivity.this.finish();
							}
						});
				builder.setNegativeButton("取消", null);
				builder.create();
				builder.show();
			}
		});
        encrypt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				key1 = (EditText)findViewById(R.id.key1);
				imageView=(ImageView)findViewById(R.id.imageView);
				String key1Str=key1.getText().toString().trim();
				if(imageView.getDrawable()==null)
				{
					Toast.makeText(RunTimeActivity.this, "请选择一副图片", Toast.LENGTH_LONG).show();
					return;
				}
				else
				{
					if(key1Str.length()==0)
					{
						Toast.makeText(RunTimeActivity.this, "请输入密钥", Toast.LENGTH_LONG).show();
						return;
					}
					else
					{
						//获取输入的密钥
						EditText text=(EditText)findViewById(R.id.key1);
						String str = text.getText().toString();
						double x=Double.valueOf(str);
						if(x>0&&x<1)
						{
							encrypt(x);	
							key1.setText("");
						}
						else
						{
							Toast.makeText(RunTimeActivity.this, "密钥应为0~1之间的任意小数(不包括0与1)", Toast.LENGTH_LONG).show();
							return;
						}
					}
				}
			}
		});
        decrypt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				key1 = (EditText)findViewById(R.id.key1);
				imageView=(ImageView)findViewById(R.id.imageView);
				String key1Str=key1.getText().toString().trim();
				if(imageView.getDrawable()==null)
				{
					Toast.makeText(RunTimeActivity.this, "请选择一副图片", Toast.LENGTH_LONG).show();
					return;
				}
				else
				{
					if(key1Str.length()==0)
					{
						Toast.makeText(RunTimeActivity.this, "请输入密钥", Toast.LENGTH_LONG).show();
						return;
					}
					else
					{
						//获取输入的密钥
						EditText text=(EditText)findViewById(R.id.key1);
						String str = text.getText().toString();
						double x=Double.valueOf(str);
						if(x>0&&x<1)
						{
							decrypt(x);
							key1.setText("");
						}
						else
						{
							Toast.makeText(RunTimeActivity.this, "密钥应为0~1之间的任意小数(不包括0与1)", Toast.LENGTH_LONG).show();
							return;
						}
					}	
				}
			}
       });
        noise.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				imageView=(ImageView)findViewById(R.id.imageView);
				if(imageView.getDrawable()==null)
				{
					Toast.makeText(RunTimeActivity.this, "请选择一副图片", Toast.LENGTH_LONG).show();
					return;
				}
				else
				{
					Toast.makeText(RunTimeActivity.this, "噪声", Toast.LENGTH_LONG).show();
					noise();
					return;
				}
			}
		});
            barchart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Toast.makeText(RunTimeActivity.this, "直方图", Toast.LENGTH_LONG).show();
				imageView=(ImageView)findViewById(R.id.imageView);	
		    	Bitmap bmp= ((BitmapDrawable)imageView.getDrawable()).getBitmap();
				Intent intent=new Intent(RunTimeActivity.this,BarchartActivity.class);
				ByteArrayOutputStream baos=new ByteArrayOutputStream();  
				bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);  
				byte [] bitmapByte =baos.toByteArray();  
				intent.putExtra("bitmap", bitmapByte);  
				startActivity(intent);
			}
        });	
   }
    
    void encrypt(double x)
    {
    	//获取算法对象
    	myAlgorithms ma=new myAlgorithms();
		ArrayFunctions af=new ArrayFunctions();
		//获取图像像素矩阵的行数与列数
		Bitmap bmp= ((BitmapDrawable)imageView.getDrawable()).getBitmap();
		int M=bmp.getHeight(),N=bmp.getWidth();

		//获取图像像素矩阵
		int[] pixel=new int[M*N];
		bmp.getPixels(pixel, 0, N, 0, 0, N, M);
		//像素矩阵转二维
		int [][]pixels = new int[M][N];
		af.change(pixel, pixels, M, N);
		//进行加密
		ma.encrypt(pixels, x, M, N);
		//加密后矩阵降一维
		af.recovery(pixels, pixel, M, N);
		//生成加密后的图像
		Bitmap bitmap = Bitmap.createBitmap(pixel, 0, N, N, M, Bitmap.Config.ARGB_8888);
    	imageView.setImageBitmap(bitmap);
    	
    }
    
    void decrypt(double x)
    {
    	//获取算法对象
    	myAlgorithms ma=new myAlgorithms();
		ArrayFunctions af=new ArrayFunctions();
		//获取图像像素矩阵的行数与列数
		Bitmap bmp= ((BitmapDrawable)imageView.getDrawable()).getBitmap();
		int M=bmp.getHeight(),N=bmp.getWidth();
		//获取图像像素矩阵
		int[] pixel=new int[M*N];
		bmp.getPixels(pixel, 0, N, 0, 0, N, M);
		//像素矩阵转二维
		int [][]pixels = new int[M][N];
		af.change(pixel, pixels, M, N);
		//进行加密
		ma.decrypt(pixels, x, M, N);
		//加密后矩阵降一维
		af.recovery(pixels, pixel, M, N);
		//生成加密后的图像
		Bitmap bitmap = Bitmap.createBitmap(pixel, 0, N, N, M, Bitmap.Config.ARGB_8888);
    	imageView.setImageBitmap(bitmap);
    	
    }
    
    //噪声
	 void noise(){
		//获取图像像素矩阵的行数与列数
		Bitmap bmp= ((BitmapDrawable)imageView.getDrawable()).getBitmap();
		int M=bmp.getHeight(),N=bmp.getWidth();

		//获取图像像素矩阵
		int[] pixel=new int[M*N];
		bmp.getPixels(pixel, 0, N, 0, 0, N, M);
		for(int i=0;i<M;++i){
			for(int j=0;j<N&&(i+j*i)<M*N;++j)
				pixel[i+j*i] = 255;
		}
		Bitmap bitmap = Bitmap.createBitmap(pixel, 0, N, N, M, Bitmap.Config.ARGB_8888);
    	imageView.setImageBitmap(bitmap);
	}
    
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	if(requestCode == GALLERY_REQUEST_CODE)
    	{
    		if(data == null)
            {
                return;
            }
            else
            {
                {
                	Uri uri;
                    uri = data.getData();
					try {
						Bitmap bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
						ImageView imageView=(ImageView)findViewById(R.id.imageView);
	                	imageView.setImageBitmap(bm);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
            }
    	}
    	
    }
}
