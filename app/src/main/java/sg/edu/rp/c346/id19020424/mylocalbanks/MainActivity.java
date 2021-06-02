package sg.edu.rp.c346.id19020424.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;
    String wordClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB = findViewById(R.id.tvUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu((UOB));
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 2, "Contact the bank");
        menu.add(0, 2, 3, "Toggle Favourite");

        if (v == DBS) {
            wordClick = "dbs";
        } else if (v == OCBC) {
            wordClick = "ocbc";
        } else if (v == UOB) {
            wordClick = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "Procceding to the website", Toast.LENGTH_LONG).show();
            if (wordClick.equalsIgnoreCase("dbs")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentcall);
            } else if (wordClick.equalsIgnoreCase("ocbc")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentcall);

            } else if (wordClick.equalsIgnoreCase("uob")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentcall);
            }


        } else if (item.getItemId() == 1) {
            Toast.makeText(MainActivity.this, "Procceding to Contacts", Toast.LENGTH_LONG).show();
            if (wordClick.equalsIgnoreCase("dbs")) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentcall);
            } else if (wordClick.equalsIgnoreCase("ocbc")) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentcall);

            } else if (wordClick.equalsIgnoreCase("uob")) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentcall);
            }


        }
        else if(item.getItemId()==2){
            if (wordClick.equalsIgnoreCase("dbs")) {
                if(DBS.getCurrentTextColor()== Color.BLACK){
                    DBS.setTextColor(Color.RED);

                }
                else if(DBS.getCurrentTextColor()== Color.RED){
                    DBS.setTextColor(Color.BLACK);
                }}
            else if (wordClick.equalsIgnoreCase("ocbc")) {
                if(OCBC.getCurrentTextColor()== Color.BLACK){
                    OCBC.setTextColor(Color.RED);

                }
                else if(OCBC.getCurrentTextColor()== Color.RED){
                    OCBC.setTextColor(Color.BLACK);
                }
            }



            else if (wordClick.equalsIgnoreCase("uob")) {
                if(UOB.getCurrentTextColor()== Color.BLACK){
                    UOB.setTextColor(Color.BLUE);

                }
                else if(UOB.getCurrentTextColor()== Color.BLUE){
                    UOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Chi){
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");

        }
        else if(item.getItemId()==R.id.Eng){
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");

        }
        return super.onOptionsItemSelected(item);
    }
}

