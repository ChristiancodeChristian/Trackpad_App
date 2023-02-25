// include for LEDs
# include <Adafruit_NeoPixel.h>    
# include <avr/power.h>
# include "Colors_LED.h"    // define LED-colors



int ledStripePins[] = {2,3,4};    //define Pin for each LED stripe
int numLedPerStripe = 3;          //number of Leds per Stripe
int numLedStripes = 3;            //number of Stripes
int iStripe;                      //variable which stripe 
String whichColor[3]={"dark", "dark", "dark"};               //define color of LEDs
String allDark[3]={"dark", "dark", "dark"};               //define color of LEDs

int fsrButtonsPin[9] = {A4, A5, A6, A7, A8, A9, A10, A11, A12};      //define Pin for each pressure Button
int fsrButtonsReading[9];         //define variable to store sensor readings

int lvlspeed = 1000;
int lvl = 0;  //level of games: 0=low, 1=medium, 2=high


void setup() {

  // Begin serial communication at a baud rate of 9600:
  Serial.begin(9600);

  for(int i=0; i<numLedStripes; i++){
    ledStripe[i] = Adafruit_NeoPixel(numLedStripes, ledStripePins[i], NEO_GRB + NEO_KHZ800);
    ledStripe[i].begin();
  }
  
}

void buttonPressed(int Pin){
    // Which LED stripe?
        if(Pin<3){
          iStripe = 0;
        }
        else if(Pin>5){
          iStripe = 2;
        }
        else {
          iStripe = 1;
        }
  
      if (analogRead(Pin) > 200) {
      //right button is pressed
      Colors_LED(iStripe,allDark);      //  LED off
      delay(500);
      String whichColor[3]={"dark", "dark", "dark"};
      whichColor[1]={"green"};  
      Colors_LED(iStripe,whichColor);      //  LED green
      delay(500);
      Colors_LED(iStripe,allDark);      //  LED off
    }
    else {
      //wrong or no button is pressed
      Colors_LED(iStripe,allDark);      //  LED off
      delay(500);
      String whichColor[3]={"dark", "dark", "dark"};
      whichColor[1]={"red"};  
      Colors_LED(iStripe,whichColor);      //  LED red
      delay(500);
      Colors_LED(iStripe,allDark);      //  LED off
    }
}

void level(int lvl){
  // Higher Level = higher speed
  if(lvl == 0){
    lvlspeed = 1000; //slow
  }
  else if (lvl == 1){
    lvlspeed = 500; //medium
  }
  else if(lvl ==2){
    lvlspeed = 250; //fast
  }
}


void loop() {
    // define Level speed:
      lvl = 0;
      level(lvl);
  
    

    //Pressure Button
      // Read the FSR pin and store the output as fsrreading:
      fsrButtonsReading[0] = analogRead(fsrButtonsPin[0]);
      // Print the fsrreading in the serial monitor:
        // Print the string "Analog reading = ".
        Serial.print("Analog reading 1 = ");
        // Print the fsrreading:
        Serial.print(fsrButtonsReading[0]);
        if(fsrButtonsReading[0] < 200){
          Serial.println(" - No pressure");
        }
        else if(fsrButtonsReading[0] < 500){
          Serial.println(" - Medium Touch");
        }
        else {
          Serial.println(" - Big squeeze");
        }
        //delay(20);

}
