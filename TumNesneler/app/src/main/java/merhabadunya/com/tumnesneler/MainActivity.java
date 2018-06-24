package merhabadunya.com.tumnesneler;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button kapat;
    SeekBar sk;
    ProgressBar pg;
    TextView saat;
    Button btn,Bac,Bkapat,Bgoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saat = findViewById(R.id.saat);
        kapat=findViewById(R.id.button2);
        sk = findViewById(R.id.seekBar);
        btn = findViewById(R.id.button1);
        pg = findViewById(R.id.progressBar3);
        Bac=findViewById(R.id.Bac);
        Bkapat=findViewById(R.id.Bkapat);
        Bgoster=findViewById(R.id.Bgoster);
        final BluetoothAdapter Badap=BluetoothAdapter.getDefaultAdapter();
        Bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Badap==null)
                {
                    Toast.makeText(MainActivity.this,"Bülütüt aygıt bulunamadı.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!Badap.isEnabled())
                    {
                        Intent Bbaslat=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(Bbaslat,1);
                        Toast.makeText(MainActivity.this,"Bülütüt aygıt AÇIK.",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Badap.disable();
                    }
                }
            }
        });
        Bgoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent goster=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(goster,1);

            }
        });
        Bkapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Badap.isEnabled())
                {}
                else
                {
                    Badap.disable();
                    Toast.makeText(MainActivity.this,"Bülütüt aygıt KAPATILDI.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        pg.setMax(100);
        sk.setMax(100);
        Timer();

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pg.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Birinci İtem", Toast.LENGTH_LONG).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "İkinci İtem", Toast.LENGTH_LONG).show();
        } else if (id == R.id.item3) {
            Toast.makeText(this, "Üçüncü İtem", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public void Timer() {
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                saat.setText("Uygulama Kapatılıyor(" + l / 1000 + ")");

            }

            @Override
            public void onFinish() {
                saat.setText("Korktun mu ?  :D");
            }}.start();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button1) {
            Intent i = new Intent(MainActivity.this, ikinciActivity.class);
            startActivity(i);
        }else if (view.getId()==R.id.button2)
        {
            AlertDialog.Builder p=new AlertDialog.Builder(MainActivity.this);
            p.setTitle("ANKET");
            p.setIcon(R.drawable.ic_menu_gallery);

            p.setPositiveButton("Maaşımdan memnunum", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"Maşınızdan memnun olduğunuza sevindim :).",Toast.LENGTH_LONG).show();
                }
            });
            p.setNegativeButton("Maaşımdan memnun değilim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"Kimse memnun değil maaşından .merak etmeyin ;) :).",Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog mesaj=p.create();
            mesaj.show();
        }
    }
}

