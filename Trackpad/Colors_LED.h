Adafruit_NeoPixel ledStripe;

 void allDark(){
  for(int i=0; i<9;i++){
    ledStripe.setPixelColor(i, ledStripe.Color(0,0,0)); 
    ledStripe.show();
  }
 }
 void LEDdark(int LEDpin){
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(0,0,0)); 
    ledStripe.show(); 
 }  
   void LEDred(int LEDpin){
  // set the RGB LED to red
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(255,0,0)); 
    ledStripe.show(); 
  }

  void LEDgreen(int LEDpin){
  // set the RGB LED to green
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(0,255,0)); 
    ledStripe.show(); 
  }

  void LEDblue(int LEDpin){
  // set the RGB LED to blue
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(0,0,255)); 
    ledStripe.show(); 
  }

  void LEDpurple(int LEDpin){
  // set the RGB LED to purple
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(255,0,255)); 
    ledStripe.show(); 
  }

  void LEDyellow(int LEDpin){
  // set the RGB LED to yellow
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(255,255,0)); 
    ledStripe.show(); ;
  }

  void LEDorange(int LEDpin){
  // set the RGB LED to orange
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(255,165,0)); 
    ledStripe.show(); 
  }

  void LEDcyan(int LEDpin){
  // set the RGB LED to cyan
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(0, 255, 255)); 
    ledStripe.show(); 
  }

  void LEDsilver(int LEDpin){
  // set the RGB LED to silver
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(192,192,192)); 
    ledStripe.show(); 
  delay(1000);
  }

  void LEDlime(int LEDpin){
  // set the RGB LED to lime
    ledStripe.setPixelColor(LEDpin, ledStripe.Color(164, 196, 0)); 
    ledStripe.show(); 
  } 




 
