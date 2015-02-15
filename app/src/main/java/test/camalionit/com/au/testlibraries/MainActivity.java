package test.camalionit.com.au.testlibraries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import icepick.Icepick;
import icepick.Icicle;


public class MainActivity extends Activity {

    @Icicle
    String username; // This will be automatically saved and restored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this); // register EventBus

        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this); // unregister EventBus
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    // method that will be called when someone posts an event NetworkStateChanged
    public void onEventMainThread(NetworkStateChanged event) {
        if (!event.isInternetConnected()) {
            Toast.makeText(this, "EventBus - No Internet connection!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "EventBus - Internet connection is up!", Toast.LENGTH_SHORT).show();
        }
    }


    // function to open the call activity for test SIP
    public void openCallActivity(View v) {
        Intent intent = new Intent(this, WalkieTalkieActivity.class);
        startActivity(intent);
    }
}
