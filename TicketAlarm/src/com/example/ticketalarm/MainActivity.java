package com.example.ticketalarm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


/*http://partners.api.skyscanner.net/apiservices/browsequotes/
 * v1.0/{market}/{currency}/{locale}/{originPlace}/{destinationPlace}/
 * {outboundPartialDate}/{inboundPartialDate}?apiKey={apiKey}
 * */

public class MainActivity extends Activity {

   private String url1 = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0";
   private String ApiKey = "prtl6749387986743898559646983194";
   private String url2 = "?apiKey=";
   private EditText location,country,temperature,humidity,pressure;
   private HandleXML obj;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      location = (EditText)findViewById(R.id.editText1);
      country = (EditText)findViewById(R.id.editText2);
      temperature = (EditText)findViewById(R.id.editText3);
      humidity = (EditText)findViewById(R.id.editText4);
      pressure = (EditText)findViewById(R.id.editText5);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
   // Inflate the menu; this adds items to the action bar if it is present.
   getMenuInflater().inflate(R.menu.main, menu);
   return true;
   }

   public void open(View view){
      String url = location.getText().toString();
      String finalUrl = url1 + url + url2;
      country.setText(finalUrl);
      obj = new HandleXML(finalUrl);
      obj.fetchXML();
      while(obj.parsingComplete);
      country.setText(obj.getCountry());
      temperature.setText(obj.getTemperature());
      humidity.setText(obj.getHumidity());
      pressure.setText(obj.getPressure());

   }

}