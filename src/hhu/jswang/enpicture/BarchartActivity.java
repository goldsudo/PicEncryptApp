package hhu.jswang.enpicture;
import hhu.jswang.enpicture.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
  
public class BarchartActivity extends Activity {  
	  
    private BarChart mBarChart;  
    private BarData mBarData;
    private Button back;
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.barchart); 
        Intent intent=getIntent();
        if(intent!=null)
        {
        byte [] bis=intent.getByteArrayExtra("bitmap");  
        Bitmap bitmap=BitmapFactory.decodeByteArray(bis, 0, bis.length);
        mBarChart = (BarChart) findViewById(R.id.spread_bar_chart);  
        mBarData = getBarData(256,bitmap);  
        showBarChart(mBarChart, mBarData);
        }
//        back=(Button) findViewById(R.id.back); 
//        back.setOnClickListener(new View.OnClickListener() {
//    		public void onClick(View v){
//    			BarchartActivity.this.finish();
//    		}
//        });

    }  
     
    private void showBarChart(BarChart barChart, BarData barData) {  
//        barChart.setDrawBorders(false);  ////�Ƿ�������ͼ����ӱ߿�   
            
        barChart.setDescription("����ֱ��ͼ");// ��������      
          
        // ���û�����ݵ�ʱ�򣬻���ʾ���������ListView��EmptyView      
        barChart.setNoDataTextDescription("You need to provide data for the chart.");      
                 
        barChart.setDrawGridBackground(false); // �Ƿ���ʾ�����ɫ      
        barChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // ���ĵ���ɫ�����������Ǹ���ɫ����һ��͸����      
        
        barChart.setTouchEnabled(true); // �����Ƿ���Դ���      
       
        barChart.setDragEnabled(true);// �Ƿ������ק      
        barChart.setScaleEnabled(true);// �Ƿ��������      
      
        barChart.setPinchZoom(false);//       
      
//      barChart.setBackgroundColor();// ���ñ���      
          
        barChart.setDrawBarShadow(true);  
         
        barChart.setData(barData);  // ��������      
  
        Legend mLegend = barChart.getLegend(); // ���ñ���ͼ��ʾ  
      
        mLegend.setForm(LegendForm.CIRCLE);// ��ʽ      
        mLegend.setFormSize(6f);// ����      
        mLegend.setTextColor(Color.BLACK);// ��ɫ      
          
//      X���趨  
        XAxis xAxis = barChart.getXAxis();  
        xAxis.setPosition(XAxisPosition.BOTTOM);  
      
        barChart.animateX(2500); // ����ִ�еĶ���,x��    
    }  
  
    private BarData getBarData(int count,Bitmap bitmap) { 
    	if(bitmap!=null){
    	int h=bitmap.getHeight(),w=bitmap.getWidth();
    	int[] pixels=new int[h*w];
    	int[] pixelsB=new int[h*w];
    	int[] pixelsG=new int[h*w];
    	int[] pixelsR=new int[h*w];
    	int[] arrB=new int[256];
        int[] arrG=new int[256];
        int[] arrR=new int[256];
		bitmap.getPixels(pixels, 0, w, 0, 0, w, h);
		for(int i=0;i<h*w;i++)
		{
			pixelsB[i]=-pixels[i]&0x000000FF;
		}
        for(int i=0;i<h*w;i++)
        {
            pixelsG[i]=(pixels[i]&0x00FF0000)>>16;
        }
        for(int i=0;i<h*w;i++)
        {
            pixelsR[i]=(pixels[i]&0x0000FF00)>>8;
        }
		for(int j=0;j<count;j++)
		{
			int sum=0;
			for(int i=0;i<h*w;i++)
			{
				if(j==pixelsB[i])
				{
					sum=sum+1;
				}
			}
			arrB[j]=sum;
		}
        for(int j=0;j<count;j++)
        {
            int sum=0;
            for(int i=0;i<h*w;i++)
            {
                if(j==pixelsG[i])
                {
                    sum=sum+1;
                }
            }
            arrG[j]=sum;
        }
        for(int j=0;j<count;j++)
        {
            int sum=0;
            for(int i=0;i<h*w;i++)
            {
                if(j==pixelsR[i])
                {
                    sum=sum+1;
                }
            }
            arrR[j]=sum;
        }
        ArrayList<String> xValues = new ArrayList<String>();  
        for (int i = 0; i < count; i++) {  
            xValues.add("" + (i));  
        }  
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();    
        for (int i = 0; i < count; i++) {      
            int value = arrB[i];  
            yValues.add(new BarEntry(value, i));      
        
        }  
        ArrayList<BarEntry> yValues1 = new ArrayList<BarEntry>();    
        for (int i = 0; i < count; i++) {      
            int value = arrG[i];  
            yValues1.add(new BarEntry(value, i));      
        
        }
        ArrayList<BarEntry> yValues2 = new ArrayList<BarEntry>();    
        for (int i = 0; i < count; i++) {      
            int value = arrR[i];  
            yValues2.add(new BarEntry(value, i));      
        
        }
        // y������ݼ���      
        BarDataSet barDataSetB = new BarDataSet(yValues, "Blue");  
        BarDataSet barDataSetR = new BarDataSet(yValues1, "Green");
        BarDataSet barDataSetG = new BarDataSet(yValues2, "Red");
          
        barDataSetB.setColor(Color.rgb(114, 188, 223));  
        barDataSetG.setColor(Color.rgb(2, 201, 87));
        barDataSetR.setColor(Color.rgb(227, 23, 13));
      
        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();      
        barDataSets.add(barDataSetB); 
        barDataSets.add(barDataSetG);
        barDataSets.add(barDataSetR);// add the datasets      
      
        BarData barData = new BarData(xValues, barDataSets);
        return barData;
    	}
    	else
    	{	int range=100;
    		ArrayList<String> xValues = new ArrayList<String>();  
            for (int i = 0; i < count; i++) {  
                xValues.add("11" + (i + 1) + "1111");  
            }  
              
            ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();  
              
            for (int i = 0; i < count; i++) {      
                float value = (float) (Math.random() * range/*100���ڵ������*/) + 3;  
                yValues.add(new BarEntry(value, i));      
            }  
              
            // y������ݼ���      
            BarDataSet barDataSet = new BarDataSet(yValues, "22222");   
              
            barDataSet.setColor(Color.rgb(114, 188, 223));  
          
            ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();      
            barDataSets.add(barDataSet); // add the datasets      
          
            BarData barData = new BarData(xValues, barDataSets);
            return barData;
    	}  
    }
}   
