package merhabadunya.com.tumnesneler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ikinciActivity extends AppCompatActivity {
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);
        this.setTitle("");
        wb=findViewById(R.id.wb);
        wb.loadUrl("https://www.google.com.tr/");
        wb.getSettings().getJavaScriptEnabled();
        wb.setWebViewClient(new WebViewClient());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ikinci_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.geri)
        {
            Intent i=new Intent(ikinciActivity.this,MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
