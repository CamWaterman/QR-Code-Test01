package sdc.qrcodetest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class HomeScreen extends Activity {

    Button captureBtn;
    TextView scoreView;
    QR lol = new QR();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final Activity test = new Activity();

        captureBtn = (Button) findViewById(R.id.captureBtn);
        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getScanner();
            }
        });

        scoreView = (TextView) findViewById(R.id.scoreBody);
        scoreView.setText(String.valueOf(lol.getScore()));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getScanner()
    {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan Barcode");
        integrator.setWide();
        integrator.setResultDisplayDuration(500);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                char[] id = result.getContents().toCharArray();
                int numId = (10 * id[3]) + id[4];
                if(numId < 10)
                {
                    if(lol.isScanned[numId] == false)
                    {
                        Toast.makeText(this, "You earned 1 point!", Toast.LENGTH_LONG).show();
                        lol.addOne();
                    }
                    else
                    {
                        Toast.makeText(this, "You have already scanned this QR code!", Toast.LENGTH_LONG).show();
                    }
                }
                else if(numId >= 10 && numId < 20)
                {
                    if(lol.isScanned[numId] == false)
                    {
                        Toast.makeText(this, "You earned 5 points!", Toast.LENGTH_LONG).show();
                        lol.addFive();
                    }
                    else
                    {
                        Toast.makeText(this, "You have already scanned this QR code!", Toast.LENGTH_LONG).show();
                    }
                }
                else if(numId >= 20 && numId <30)
                {
                    if(lol.isScanned[numId] == false)
                    {
                        Toast.makeText(this, "You earned 10 points!", Toast.LENGTH_LONG).show();
                        lol.addTen();
                    }
                    else
                    {
                        Toast.makeText(this, "You have already scanned this QR code!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Invalid QR code!", Toast.LENGTH_LONG).show();
                }
                Log.d("Results", result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }

        scoreView.setText(String.valueOf(lol.getScore()));
    }
}
