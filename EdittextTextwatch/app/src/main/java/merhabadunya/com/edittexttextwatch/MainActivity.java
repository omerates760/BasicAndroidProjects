package merhabadunya.com.edittexttextwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    EditText tx;
    TextView ttt;
    ToggleButton buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttt=(TextView) findViewById(R.id.textView);
        tx=(EditText) findViewById(R.id.txt1);
        buton=(ToggleButton) findViewById(R.id.btn);
       tx.addTextChangedListener(this);
       buton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if (b==true){
                   tx.setEnabled(false);
               }
               else
               {
                   tx.setEnabled(true);
               }
           }
       });

    }



    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }


    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            ttt.setText(charSequence);

    }


    public void afterTextChanged(Editable editable) {



    }

}
