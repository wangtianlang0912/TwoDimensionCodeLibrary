package com.huyi.zxing;






import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class BarCodeActivity  extends Activity{
	private Button btn_scan;
	private TextView resultTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.barcode);
		 
		 resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
		 btn_scan = (Button) findViewById(R.id.btn_scan);
		 
		 btn_scan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//��ɨ�����ɨ����������ά��
				Intent openCameraIntent = new Intent(BarCodeActivity.this,CaptureActivity.class);
				startActivityForResult(openCameraIntent, 0);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//����ɨ�����ڽ�������ʾ��
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			resultTextView.setText(scanResult);
			
			/*Intent intent = new Intent(BarCodeActivity.this,WebViewActivity.class);
			Intent intent = new Intent(BarCodeActivity.this,MainActivity.class);
			intent.putExtra("url", scanResult);
			startActivity(intent);*/
		}
	}
}
