package com.example.email;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends ActionBarActivity {
	private Button boton;
	private EditText destinatario,asunto,mensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		boton = (Button) findViewById(R.id.btnEnviar);
		destinatario = (EditText) findViewById(R.id.txtCorreo);
		asunto = (EditText) findViewById(R.id.txtAsunto);
		mensaje = (EditText) findViewById(R.id.txtMensaje);
		
		boton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!destinatario.getText().toString().trim().equals(""))
				{
					enviarMail(v);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}
	
	public void enviarMail(View v)
	{
		Intent mailIntent = new Intent(Intent.ACTION_SEND);
		mailIntent.setType("text/plain");//tipo texto plain o html
		mailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{destinatario.getText().toString()});
		mailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
		mailIntent.putExtra(Intent.EXTRA_TEXT, mensaje.getText().toString());
		
		try{
			startActivity(Intent.createChooser(mailIntent, "Enviando Correo"));
		}catch(Exception e){
			
		}
	}
}
