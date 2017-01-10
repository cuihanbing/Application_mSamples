package mi.email.activity;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mi.learn.com.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMail extends Activity {
	private Button btnClick;
	private EditText txtToAddress;
	private EditText txtSubject;
	private EditText txtContent;
	private static final String SAVE_INFORMATION = "save_information";
	String username;
	String password;
	String sendhost;
	public void SendMail() throws MessagingException, IOException {
		// ��sharedpreference����ȡ��ֵ
		SharedPreferences pre = getSharedPreferences(SAVE_INFORMATION,
				MODE_WORLD_READABLE);
		String content = pre.getString("save", "");
		String[] Information = content.split(";");
		username = Information[0];
		password = Information[1];
		sendhost=pre.getString("send_host", "");
		// �ò����д����ƣ���������������������������������������������������������������
		Properties props = new Properties();
		props.put("mail.smtp.host", sendhost);// �洢�����ʼ�����������Ϣ
		props.put("mail.smtp.auth", "true");// ͬʱͨ����֤
		// �������ʼ��Ự
		Session session = Session.getInstance(props);
		session.setDebug(true);// ���õ��Ա�־
		// ������Ϣ��
		MimeMessage message = new MimeMessage(session);

		// ������ַ
		Address fromAddress = null;
		// fromAddress = new InternetAddress("sarah_susan@sina.com");
		fromAddress = new InternetAddress(username);
		message.setFrom(fromAddress);

		// �ռ���ַ
		Address toAddress = null;
		toAddress = new InternetAddress(txtToAddress.getText().toString());
		message.addRecipient(Message.RecipientType.TO, toAddress);

		// �����ʼ�����

		message.setSubject(txtSubject.getText().toString());// �����ż��ı���
		message.setText(txtContent.getText().toString());// �����ż�����
		message.saveChanges(); // implicit with send()//�洢����Ϣ

		// send e-mail message

		Transport transport = null;
		transport = session.getTransport("smtp");
		transport.connect(sendhost, username, password);

		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		System.out.println("�ʼ����ͳɹ���");

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.send_email);

		txtToAddress = (EditText) findViewById(R.id.txtToAddress);
		txtSubject = (EditText) findViewById(R.id.txtSubject);
		txtContent = (EditText) findViewById(R.id.txtContent);

		txtToAddress.setText("simgsg@qq.com");
		txtSubject.setText("Hello~");
		txtContent.setText("��ã�������������~");

		btnClick = (Button) findViewById(R.id.btnSEND);
		btnClick.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					//�����ʼ�
					SendMail();
					//Toast��ʾ
					Toast toast=Toast.makeText(getApplicationContext(), "�ʼ����ͳɹ���",Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER,0,0);
					toast.show();
					//������ת
					Intent intent =new Intent();
					intent.setClass(SendMail.this, ReceiveAndSend.class);
					startActivity(intent);
				} catch (MessagingException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}

}