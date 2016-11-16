package tuhocandroid.thuchanhdanhbadienthoai;

import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tuhocandroid.thuchanhdanhbadienthoai.adapter.ContactAdapter;
import tuhocandroid.thuchanhdanhbadienthoai.model.Contact;


public class MainActivity extends AppCompatActivity {


    public List<Contact> arrayContact;
    private ContactAdapter adapter;
    private EditText edtName;
    private EditText edtNumber;
    private RadioButton rdbtMale;
    private RadioButton rdbtFemale;
    private Button btnAddContact;
    private ListView lvContact;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        arrayContact=new ArrayList<>();
        adapter = new ContactAdapter(this,R.layout.item_contact_listview,arrayContact);
        lvContact.setAdapter(adapter);
    }


    public void setWidget(){
        edtName=(EditText) findViewById(R.id.ed_name);
        edtNumber=(EditText) findViewById(R.id.ed_number);
        rdbtMale = (RadioButton) findViewById(R.id.rdbt_male);
        rdbtFemale = (RadioButton) findViewById(R.id.rdbt_female);
        btnAddContact = (Button) findViewById(R.id.bt_add);
        lvContact=(ListView) findViewById(R.id.lv_contact);

    }


    public void addContact(View view){
        if(view.getId()==R.id.bt_add){
            String number = edtNumber.getText().toString().trim();
            String name = edtName.getText().toString().trim();
            boolean isMale = true;
            if(rdbtMale.isChecked()){
                isMale=true;
            }
            else {
                isMale=false;
            }
            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(number)){
                Toast.makeText(this,"Please input name or number",Toast.LENGTH_SHORT).show();
            }
            else{
                Contact contact = new Contact(isMale,name,number);
                arrayContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
