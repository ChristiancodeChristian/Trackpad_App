// include for LEDs
# include <Adafruit_NeoPixel.h>    
//# include <avr/power.h>
# include "Colors_LED.h"    // define LED-colors
#include <WiFi.h>
#include <PubSubClient.h>


//####  LED ####
int ledPins = 2;    //define Pin for each LED stripe
int numLed = 9;                //number of Leds per Stripe 
int randomLED;

//####  FSR Button ####
int fsrButtonsPin[6] = {13, 12, 14, 27, 26 ,25};      //define Pin for each pressure Button
int fsrButtonsReading[6];           //define variable to store sensor readings
//int fsrButtonsPin[1] = {A0};     //define Pin for each pressure Button
//int fsrButtonsReading[1];         //define variable to store sensor readings

//####  Level ####
int lvlNum;   //how many buttons must be pressed
int lvl = 0;  //level of game: 0=easy, 1=hard

//####  diffrent times ####
long startTime ;                    // start time for stop watch
long startReactTime ;               // start react time for stop watch
long elapsedTime ;                  // elapsed time for stop watch
long elapsedReactTime ;             // elapsed react time for stop watch
long sumReactTime = 0;                  // sum of all react times
long aveReactTime = 0;                  // average of react time

////####  MQTT ####
//const char* ssid = "TP-Link_D33C";
//const char* password =  "14201448";
//const char* mqtt_Server =  "broker.mqtt-dashboard.com"; //  // or  own PC  AIO_SERVER; for own Mosquitto broker
//const int mqttPort = 1883;
//
//const char* publishTopic = "AAL_MCI_esp_Publish_Poti/Elena"; // make a unique topic for yourself
//const char* subscribeTopicRed = "AAL_MCI_esp_Subscribe/Elena/red"; // make a unique topic for yourself
//const char* subscribeTopicGreen = "AAL_MCI_esp_Subscribe/Elena/green"; // make a unique topic for yourself
//const char* subscribeTopicBlue = "AAL_MCI_esp_Subscribe/Elena/blue"; // make a unique topic for yourself
//const char* clientName = "AAL_MCI_esp_Elena";  // make a unique topic for yourself
//
//const char* mqttUser = "yourMQTTuser_MCI_AAL_";  // for secure connection
//const char* mqttPassword = "yourMQTTpasswordpass"; // for secure connection
//
//WiFiClient espTrackpad;  // make the name unique
//PubSubClient client(espTrackpad);


void setup() {
  // Begin serial communication at a baud rate of 9600:
  Serial.begin(9600);

  //####  Setup LED ####
  ledStripe = Adafruit_NeoPixel(numLed, ledPins, NEO_GRB + NEO_KHZ800);
  ledStripe.begin();

//  //####  Setup MQTT ####
//  setup_wifi();
//  client.setServer(mqtt_Server, 1883);
//  client.setCallback(callback);
}


//void setup_wifi() {
//  delay(10);
//  // We start by connecting to a WiFi network
//  Serial.println();
//  Serial.print("Connecting to ");
//  Serial.println(ssid);
//
//  WiFi.begin(ssid, password);
//
//  while (WiFi.status() != WL_CONNECTED) {
//    delay(500);
//    Serial.print(".");
//  }
//
//  Serial.println("");
//  Serial.println("WiFi connected");
//  Serial.println("IP address: ");
//  Serial.println(WiFi.localIP()); // print your IP address
//}


//// constant mqtt connection 
//void reconnect() {
//  // Loop until we're reconnected
//  while (!client.connected()) {
//    Serial.print("Attempting MQTT connection...");
//    // Attempt to connect
//    if (client.connect(clientName)) {
//      Serial.println("connected");
//      // Once connected, publish an announcement...
//      client.publish(publishTopic, "Reconnected");
//      // ... and resubscribe
//      client.subscribe(subscribeTopicRed);
//      client.subscribe(subscribeTopicGreen);
//      client.subscribe(subscribeTopicBlue);
//    } else {
//      Serial.print("failed, rc=");
//      Serial.print(client.state());
//      Serial.println(" try again in 5 seconds");
//      // Wait 5 seconds before retrying
//      delay(5000);
//    }
//  }
//}


void buttonPressed(int Pin){  
  int checked = 0;      // 0 = Button ISN'T pressed;  1 = Button IS pressed
  long previousMillis = millis();

    while((millis() - previousMillis < 2000)){
      // 2 sec time for pressing button
      if (analogRead(Pin) > 250) {
      //right button is pressed
      elapsedReactTime =   millis() - startReactTime;              // store elapsed react time
      sumReactTime = sumReactTime + elapsedReactTime;
      LEDgreen(Pin);
      delay(500);
      checked = 1;        
      break;
      }}   

     if(checked == 0){
      //wrong or no button is pressed
      LEDred(Pin);
      delay(500);
    }
}



void loop() {
  // von APP: Wann Zeit starten soll bzw wenns los geht und level

  
  
    // define Level 
    lvl = 0;                                         // to do: mqtt from APP
    if(lvl == 0){
      lvlNum = 25;                                   // easy
    }
    else if (lvl == 1){
      lvlNum = 40;                                   // hard
    }

allDark();

  //25 or 40 times: 1 LED is bright -> press button -> LED red or green
  startTime = millis();                              // store the start time
  for (int i = 0; i < 9; i++) {
    randomLED = random(0,8);                         //random number between 0 & 8
    LEDblue(randomLED);                              // LED blue
    buttonPressed(randomLED);                        // is right button pressed?
    startReactTime = millis();                       // store the start react time
    LEDdark(randomLED);                              // LED dark
    
  }
  elapsedTime =   millis() - startTime;              // store elapsed time
  aveReactTime = sumReactTime/9;                // average of react time
  Serial.print("Gesamtzeit= ");
  Serial.println(elapsedTime);
  Serial.print("Reaktionszeit= ");
  Serial.println(aveReactTime);
  delay(10000);
  


// an APP: TIME: gesamt und Durchschnitt der Reaktionszeit und SCORE und FORCE-DATA
}
