package mi.email.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import mi.email.core.ResolveMail;
import mi.learn.com.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ReceiveList extends Activity {

	private static final String SAVE_INFORMATION = "save_information";

	private ListView listview;
	private int number;

	String Title;
	String Date;
	String From;
	String Content;
	String username;
	String password;
	String receivehost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

		setContentView(R.layout.listmenu);
		listview = (ListView) findViewById(R.id.my_list);
        
		try {
			MenuList();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void MenuList() throws MessagingException, IOException {

		// sharedpreference��ȡ���ݣ���split�����������ֿ��ַ�����
		SharedPreferences pre = getSharedPreferences(SAVE_INFORMATION,
				MODE_WORLD_READABLE);
		String content = pre.getString("save", "");
		String[] Information = content.split(";");
		username = Information[0];
		password = Information[1];
		receivehost=pre.getString("receive_host", "");
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props); // ȡ��pop3Э����ʼ�������
		Store store = session.getStore("pop3");

		//����pop.sina.com�ʼ������� //
		store.connect(receivehost, username, password); // �����ļ��ж���

		Folder folder = store.getFolder("INBOX"); // ���ý���
		folder.open(Folder.READ_ONLY); // ��ȡ��Ϣ
		Message message[] = folder.getMessages();
		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();//����һ��List���ҽ���ʵ����
		for (int i = 0; i < message.length; i++) {//ͨ��for��佫��ȡ�����ʼ�����һ��һ������list����ʾ����
			ResolveMail receivemail = new ResolveMail((MimeMessage) message[i]);

			Title = receivemail.getSubject();//�õ��ʼ��ı���
			Date = receivemail.getSentDate();//�õ��ʼ��ķ���ʱ��

			HashMap<String, String> map = new HashMap<String, String>();//����һ��Map.����ȡ�������Լ�ֵ�ķ�ʽ������չ��
			map.put("title", Title);//��ʾ�ʼ��ı���
			map.put("info", Date);//��ʾ�ʼ�����Ϣ
			list.add(map);

			SimpleAdapter listAdapter = new SimpleAdapter(this, list,R.layout.item, new String[] { "title", "info" }, new int[] {
							R.id.title, R.id.info });
			listview.setAdapter(listAdapter);
		}

		folder.close(true);//�ú�֮��ǵý�floder��store���йر�
		store.close();

		// Item�����¼����õ�Item��ֵ��Ȼ�󴫵ݸ�MailDetail��ֵ
		listview.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("ID", position);
				intent.setClass(ReceiveList.this, MailDetails.class);
				startActivity(intent);
				return true;
			}

		});
	}
}
