package my.edu.utem.myform;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText,phoneEditText,cellEditText,messageEditText;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    //ArrayAdapter<CharSequence> = adapter,adapter2; cara lain

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText=findViewById(R.id.main_nameEditText);
        emailEditText=findViewById(R.id.main_emailEditText);
        phoneEditText=findViewById(R.id.main_phoneEditText);
        cellEditText=findViewById(R.id.main_cellEditText);
        messageEditText=findViewById(R.id.main_messageEditText);
        spinner=findViewById(R.id.spinner);
        autoCompleteTextView=findViewById(R.id.autocomplete);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(MainActivity.this,R.array.occupation,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.state,android.R.layout.simple_list_item_1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       autoCompleteTextView.setAdapter(adapter2);

    }

    @Override
    //step 1
    //create menu dan keluarkan menu ke screen
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //step 2
    //bila click guna onOptionsItemSelected
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about_us:
                //create a link from MainActivity page to the SecondActivity
                //nak buka webpage dalam apps
                //1. bagi id utk page dalam activity_web.xml
                //2. define dalam file webactivity.java
                //3. letak permission dalam fail manifest
                Intent intent =new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_contact_us:
                Toast.makeText(MainActivity.this, "Android Course at UTeM", Toast.LENGTH_LONG).show();
            break;
            case R.id.menu_share:
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Are you sure?");
                alertDialogBuilder.setMessage("Are you sure you want to share this apps?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialogBuilder.show();
            break;
            case R.id.menu_exit:
            finish();
            break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonPressed(View view) {
        //nak buat page baru bila tekan button
        //create a link from MainActivity page to the SecondActivity
        Intent intent =new Intent(MainActivity.this,SecondActivity.class);
        //invoke action
        intent.putExtra("name",nameEditText.getText().toString());
        intent.putExtra("email",emailEditText.getText().toString());
        intent.putExtra("phone",phoneEditText.getText().toString());
        intent.putExtra("cell",cellEditText.getText().toString());
        intent.putExtra("message",messageEditText.getText().toString());

        //String selectedState = autoCompleteTextView.getText().toString();
        //String selectedOccupation = (String) (spinner.getSelectedItem());
        //Log.d("debug", "Selected state is" +selectedState);
        //Log.d("debug", "Selected Occupation is" +selectedOccupation);
        //intent.putExtra("state",selectedState.getText().toString())
        //intent.putExtra("occupation",selectedOccupation.getText().toString())
        startActivity(intent);

    }
}
