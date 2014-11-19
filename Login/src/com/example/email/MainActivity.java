package com.example.email;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText txtNombre;
	EditText txtContrasenia;
	TextView txtError;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtNombre = (EditText) findViewById(R.id.txtName);
		txtContrasenia = (EditText) findViewById(R.id.txtPassword);
		txtError = (TextView) findViewById(R.id.txtError);
	}
	
	public void clicEntrarEmail(View v)
	{
		String nombre = "root", contrasenia="moviles";
		String getName = txtNombre.getText().toString();
		String getPassword = txtContrasenia.getText().toString();
		
		if(nombre.equals(getName) && contrasenia.equals(getPassword))
		{
			Intent intencionCorreo = new Intent(this, Email.class);
			startActivity(intencionCorreo);
		}else{
			txtError.setText("Falló al entrar");
		}
		
	}
}