package test.prod.lbc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class LoginDisplayActivity extends Activity {

	// On d�clare les deux identifiants utiles 
	// pour pour le passage de donn�es
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);

       // Initialiser les deux zones de textes 
       // servant � afficher les informations utilisateurs (login / password)
       Intent intent = getIntent();
       TextView loginDisplay = (TextView) findViewById(R.id.email_display);
       TextView passwordDisplay = (TextView) findViewById(R.id.password_display);
       
       // Si les donn�es r�cup�r�es ne sont pas nulles
       if (intent != null) {
    	   // Lors du clic sur le bouton "Connecter" 
    	   // on r�cup�re les deux informations � l�aide de leurs cl�s 
    	   // et de la m�thode getStringExtra
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