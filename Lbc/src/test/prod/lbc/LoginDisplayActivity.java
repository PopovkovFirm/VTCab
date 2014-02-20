package test.prod.lbc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class LoginDisplayActivity extends Activity {

	// On déclare les deux identifiants utiles 
	// pour pour le passage de données
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);

       // Initialiser les deux zones de textes 
       // servant à afficher les informations utilisateurs (login / password)
       Intent intent = getIntent();
       TextView loginDisplay = (TextView) findViewById(R.id.email_display);
       TextView passwordDisplay = (TextView) findViewById(R.id.password_display);
       
       // Si les données récupérées ne sont pas nulles
       if (intent != null) {
    	   // Lors du clic sur le bouton "Connecter" 
    	   // on récupére les deux informations à l’aide de leurs clés 
    	   // et de la méthode getStringExtra
    	   loginDisplay.setText(intent.getStringExtra(EXTRA_LOGIN));
    	   passwordDisplay.setText(intent.getStringExtra(EXTRA_PASSWORD));
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_display, menu);
        return true;
    }
}