// include for LEDs
# include <Adafruit_NeoPixel.h>    
//# include <avr/power.h>
# include "Colors_LED.h"    // define LED-colors


//####  LED ####
//int ledPins = 2;    //define Pin for each LED stripe
//int numLed = 9;                //number of Leds per Stripe 
int randomLED;

//####  FSR Button ####
int fsrButtonsPin[9] = {13, 15, 27, 4, 26 ,25, 12, 32, 34};      //define Pin for each pressure Button
int fsrButtonsReading[9];           //define variable to store sensor readings

//####  Level ####
int lvlNum;   //how many buttons must be pressed
int lvl = 0;  //level of game: 0=easy, 1=hard

//####  diffrent times ####
long lvlTime;                       // velocity of game
long startTime ;                    // start time for stop watch
long startReactTime ;               // start react time for stop watch
long elapsedTime ;                  // elapsed time for stop watch
long elapsedReactTime ;             // elapsed react time for stop watch
long sumReactTime = 0;              // sum of all react times
long aveReactTime = 0;              // average of react time

//####  Counter ####
int counter = 0;                    // Counter: right pressed buttons


//####  Setup ####
void setup() {
  // Begin serial communication at a baud rate of 9600:
  Serial.begin(9600);
}


//####  Is button pressed?  ####
void buttonPressed(int Pin){  
  int checked = 0;        // 0 = Button ISN'T pressed;  1 = Button IS pressed
  long previousMillis = millis();
  Serial.println("before while");
  Serial.println(Pin);
  delay(500);
    while((millis() - previousMillis < 2000)){
        fsrButtonsReading[Pin] = analogRead(fsrButtonsPin[Pin]);
        // 2 sec time for pressing button
        if (fsrButtonsReading[Pin] > 4000) {
          //right button is pressed
            elapsedReactTime =   millis() - startReactTime;              // store elapsed react time
            sumReactTime = sumReactTime + elapsedReactTime;
            LEDgreen(Pin);
            counter = counter + 1;    // Counter +1 because right Button is pressed
            checked = 1;        
            break;    
        }
    }   

   if(checked == 0){
      //wrong or no button is pressed
      LEDred(Pin);
   }
}


//####  main loop ####
void loop() {
  // von APP: Start und level

  
    // define Level 
    lvl = 0;                                         // to do: mqtt from APP
    if(lvl == 0){
      lvlTime = 500;
      lvlNum = 9;                                    // easy               
    }
    else if (lvl == 1){
      lvlTime = 300;
      lvlNum = 18;                                   // hard
    }

    allDark();                                       // set all LEDs to dark
  
    //9 or 18 times: 1 LED is bright -> press button -> LED green
    startTime = millis();                              // store the start time
    for (int i = 0; i < lvlNum; i++) {
      randomLED = random(0,9);                         //random number between 0 & 8
      LEDblue(randomLED);                              // LED blue
      startReactTime = millis();                       // store the start react time
      buttonPressed(randomLED);                        // is right button pressed?
      delay(lvlTime);

      allDark();                                       // all LEDs dark
    }
    elapsedTime =   millis() - startTime;              // store elapsed time
    aveReactTime = sumReactTime/9;                     // average of react time
    Serial.print("Gesamtzeit= ");
    Serial.println(elapsedTime);
    Serial.print("Reaktionszeit= ");
    Serial.println(aveReactTime);
    delay(1000);
  


// an APP: TIME: gesamt und Durchschnitt der Reaktionszeit und SCORE und FORCE-DATA
}
