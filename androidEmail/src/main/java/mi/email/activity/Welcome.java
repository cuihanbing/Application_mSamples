package mi.email.activity;

import java.util.ArrayList;
import java.util.List;

import mi.learn.com.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Welcome extends Activity {

	private EditText txtEmailAddress;
	private EditText txtPWD;
	private Button btnOK; 
	private Spinner emailTypeSpinner;
	private static final String SAVE_INFORMATION = "save_information";

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		txtEmailAddress = (EditText) findViewById(R.id.txtEmailAddress);
		txtPWD = (EditText) findViewById(R.id.txtPWD);
		btnOK = (Button) findViewById(R.id.btnOK);
		emailTypeSpinner=(Spinner)findViewById(R.id.emailType);
		List<EmailType> lst = new ArrayList<EmailType>();
		lst.add(new EmailType (1,"@163.com"));
		lst.add(new EmailType (2,"@126.com"));
		lst.add(new EmailType (3,"@qq.com"));
		lst.add(new EmailType (4,"@souhu.com"));
		lst.add(new EmailType (5,"@sina..cn"));
		lst.add(new EmailType (6,"@sina.com"));
		lst.add(new EmailType (7,"@yahoo.com"));
		ArrayAdapter<EmailType > adapter = new ArrayAdapter<EmailType>(this,     
				android.R.layout.simple_spinner_item, lst);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		emailTypeSpinner.setAdapter(adapter);
		emailTypeSpinner.requestFocus();
		// ��EditText���� ��ʼ����ֵ���Է������г���
		txtEmailAddress.setText("");
		txtPWD.setText("");

		btnOK.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				// ��ñ༭��
				SharedPreferences.Editor editor = getSharedPreferences(
						SAVE_INFORMATION, MODE_WORLD_WRITEABLE).edit();
				// ��EditText�ı�������ӵ��༭��
				editor.putString("save", txtEmailAddress.getText().toString()
						+ ";" + txtPWD.getText().toString());
				EmailType emailType=(EmailType)emailTypeSpinner.getSelectedItem();
				switch (emailType.getID()) {
				case 1://����163
					editor.putString("receive_host", "pop.163.com");
					editor.putString("send_host", "smtp.163.com");
					break;
				case 2://����126
					editor.putString("receive_host", "pop.126.com");
					editor.putString("send_host", "smtp.126.com");
					break;
				case 3://��Ѷ
					editor.putString("receive_host", "pop.qq.com");
					editor.putString("send_host", "smtp.qq.com");
					break;
				case 4://�Ѻ�
					editor.putString("receive_host", "pop.sohu.com");
					editor.putString("send_host", "smtp.sohu.com");
					break;
				case 5://����cn
					editor.putString("receive_host", "pop.sina.cn");
					editor.putString("send_host", "smtp.sina.cn");
					break;
				case 6://����com
					editor.putString("receive_host", "pop.sina.com");
					editor.putString("send_host", "smtp.sina.com");
					break;
				case 7://�Ż�
					editor.putString("receive_host", "pop.mail.yahoo.com.cn");
					editor.putString("send_host", "smtp.mail.yahoo.com.cn");
					break;
				}
				
				// �ύ�༭������
				editor.commit();
				// ����Intent��ʵ�ֵ����ť�����н�����ת
				Intent intent = new Intent();
				intent.setClass(Welcome.this, ReceiveAndSend.class);
				startActivity(intent);
			}
		});

	}
	

}
