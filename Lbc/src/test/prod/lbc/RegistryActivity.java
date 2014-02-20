package test.prod.lbc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;



public class RegistryActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registry);		
	}
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_registry, menu);
        return true;
    }
	
	
	
}
