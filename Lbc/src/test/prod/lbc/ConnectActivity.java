package test.prod.lbc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log; 

public class ConnectActivity extends Activity {

	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("Debug", "debut onCreate()");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connect);

		final EditText login = (EditText) findViewById(R.id.user_email);
		final EditText pass = (EditText) findViewById(R.id.user_password);
		final Button loginButton = (Button) findViewById(R.id.connect);
		final Button submitFormButton = (Button) findViewById(R.id.create_account);

		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final String loginTxt = login.getText().toString();
				final String passTxt = pass.getText().toString();
				
				// Si l'adresse mail et le login saisis sont vides 
				if (loginTxt.equals("") || passTxt.equals("")) {
					
					Toast.makeText(ConnectActivity.this,
							R.string.email_or_password_empty,
							Toast.LENGTH_SHORT).show();
					return;
				}

				// On déclare le pattern que l’on doit suivre
				Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
				// On déclare un matcher, qui comparera le pattern avec la
				// string passée en argument
				Matcher m = p.matcher(loginTxt);
				// Si l’adresse mail saisie ne correspond au format d’une
				// adresse mail
				if (!m.matches()) {
					// On crée un nouveau Toast (classe SDK Android)
					// pour afficher les messages dans des minis pop up
					// Le premier argument => le Context
					// Le second argument => le message
					// Le troisième argument => la durée
					Toast.makeText(ConnectActivity.this,
							R.string.email_format_error, Toast.LENGTH_SHORT)
							.show();
					return;
				}

				// On crée un nouveau Intent 
				// Le premier argument => contexte 
				// le second argument => l’activité d’arrivée
				Intent intent = new Intent(ConnectActivity.this,
						LoginDisplayActivity.class);
				// Ajout des données à l'intent pour les transmettre 
				intent.putExtra(EXTRA_LOGIN, loginTxt);
				intent.putExtra(EXTRA_PASSWORD, passTxt);
				// Démarre la nouvelle activité
				startActivity(intent);
			}


		});
		

  		submitFormButton.setOnClickListener(new View.OnClickListener() {
  			public void onClick(View v) {
				Intent intent = new Intent(ConnectActivity.this,
						RegistryActivity.class);
				startActivity(intent);
			}
			
		}
				);

 
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_connect, menu);
		return true;
	}
}
