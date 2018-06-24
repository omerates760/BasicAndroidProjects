package merhabadunya.com.vcutkitleendeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Edit_boy;
    private TextView Boy,Kilo,Ideal,Durum;
    private SeekBar SKilo;
    private int intKilo=20;
    private Boolean Erkekmi=true;
    private Double intBoy=0.0;
    private RadioGroup radioGroup;
    private RadioGroup.OnCheckedChangeListener ErkekKadin=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i==R.id.Bay)
            {
                Erkekmi=true;
            }
            else if(i==R.id.Bayan)
            {
                Erkekmi=false;
            }
            Guncelle();
        }
    };
    private SeekBar.OnSeekBarChangeListener SeekBarAnlikOlay=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            intKilo=i+20;
            Guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TextWatcher EditTextAnlikOlay=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                intBoy=Double.parseDouble(charSequence.toString())/100.0;
            }catch (NumberFormatException e)
               {
                    intBoy=0.0;
            }
            Guncelle();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit_boy=findViewById(R.id.Edit_Boy);
        Boy=findViewById(R.id.Boy);
        Kilo=findViewById(R.id.Kilo);
        Ideal=findViewById(R.id.Ideal);
        SKilo=findViewById(R.id.seekBar);
        Durum=findViewById(R.id.Durum);
        radioGroup=findViewById(R.id.RadioGrup);

        Edit_boy.addTextChangedListener(EditTextAnlikOlay);
        SKilo.setOnSeekBarChangeListener(SeekBarAnlikOlay);
        radioGroup.setOnCheckedChangeListener(ErkekKadin);
        
        Guncelle();
    }

    private void Guncelle() {

        Kilo.setText(String.valueOf(intKilo)+"Kg");
        Boy.setText(String.valueOf(intBoy)+"m");
        int ideal_kilo_bay= (int) (50+2.3*(intBoy*100*0.4-60));
        int ideal_kilo_bayan= (int) (45.5+2.3*(intBoy*100*0.4-60));
        Double Vki=intKilo/(intBoy*intBoy);
        if(Erkekmi)
        {
           Ideal.setText(String.valueOf(ideal_kilo_bay));
           if(Vki<17.5)
           {
               Durum.setBackgroundResource(R.color.Cok_Zayif);
               Ideal.setText("Çok Zayıf");
           }
           else if(17.5>=Vki && Vki<= 20.7)
           {
               Durum.setBackgroundResource(R.color.Zayif);
               Ideal.setText("Zayıf");
           }
           else if(20.7 >=Vki && Vki<= 26.4)
           {
               Durum.setBackgroundResource(R.color.Saglikli_ideal_kilo);
               Ideal.setText("Sağlıklısınız !!!");
           }
           else if(26.4 >=Vki && Vki<=  27.8)
           {
               Durum.setBackgroundResource(R.color.Normal_Kilodan_Fazla);
               Ideal.setText("Normal kilodan fazla");
           }
           else if(27.8>=Vki && Vki<= 31.1)
           {
               Durum.setBackgroundResource(R.color.Fazla_Kilo);
               Ideal.setText("Fazla kilo");
           }
           else if(31.1>=Vki && Vki<= 34.9)
           {
               Durum.setBackgroundResource(R.color.Cok_Fazla_Kilolu);
               Ideal.setText("Çok fazla kilo");
           }
           else if(35 >=Vki && Vki<= 40)
           {
               Durum.setBackgroundResource(R.color.Yuksek_Risk);
               Ideal.setText("Yüksek risk");
           }
           else if(40>=Vki && Vki<= 50)
           {
               Durum.setBackgroundResource(R.color.Acil_Tedavi_Kilo);
               Ideal.setText("Acil tedavi edilmeli");
           }
           else if(50>=Vki && Vki<= 60)
           {
               Durum.setBackgroundResource(R.color.Super_Asiri_Kilo);
               Ideal.setText("Süper aşırı kilo !!!");
           }



            //ERKEK İSE
        }
        else
        {
            Ideal.setText(String.valueOf(ideal_kilo_bayan));
            if(Vki<17.5)
            {
                Durum.setBackgroundResource(R.color.Cok_Zayif);
                Ideal.setText("Çok Zayıf");
            }
            else if(17.5>=Vki && Vki<= 19.1)
            {
                Durum.setBackgroundResource(R.color.Zayif);
                Ideal.setText("Zayıf");
            }
            else if(19.1 >=Vki && Vki<= 25.8)
            {
                Durum.setBackgroundResource(R.color.Saglikli_ideal_kilo);
                Ideal.setText("Sağlıklısınız !!!");
            }
            else if(25.8 >=Vki && Vki<=  27.3)
            {
                Durum.setBackgroundResource(R.color.Normal_Kilodan_Fazla);
                Ideal.setText("Normal kilodan fazla");
            }
            else if(27.3>=Vki && Vki<= 32.3)
            {
                Durum.setBackgroundResource(R.color.Fazla_Kilo);
                Ideal.setText("Fazla kilo");
            }
            else if(32.3>=Vki && Vki<= 34.9)
            {
                Durum.setBackgroundResource(R.color.Cok_Fazla_Kilolu);
                Ideal.setText("Çok fazla kilo");
            }
            else if(35 >=Vki && Vki<= 40)
            {
                Durum.setBackgroundResource(R.color.Yuksek_Risk);
                Ideal.setText("Yüksek risk");
            }
            else if(40>=Vki && Vki<= 50)
            {
                Durum.setBackgroundResource(R.color.Acil_Tedavi_Kilo);
                Ideal.setText("Acil tedavi edilmeli");
            }
            else if(50>=Vki && Vki<= 60)
            {
                Durum.setBackgroundResource(R.color.Super_Asiri_Kilo);
                Ideal.setText("Süper aşırı kilo !!!");
            }


            //BAYAN İSE
        }
    }
}
