/* Simple example code for Force Sensitive Resistor (FSR) with Arduino. More info: https://www.makerguides.com */

// Define FSR pin:
#define fsrpin1 13


//Define variable to store sensor readings:
int fsrreading1; //Variable to store FSR value


void setup() {
  // Begin serial communication at a baud rate of 9600:
  Serial.begin(9600);
  
}

void loop() {
  // Read the FSR pin and store the output as fsrreading:
  fsrreading1 = analogRead(fsrpin1);


  // Print the fsrreading in the serial monitor:
  // Print the string "Analog reading = ".
  //Serial.print("Analog reading 1 = ");
  // Print the fsrreading:
  Serial.println(fsrreading1);


//  // We can set some threshholds to display how much pressure is roughly applied:
//  if (fsrreading < 10) {
//    Serial.println(" - No pressure");
//  } else if (fsrreading < 200) {
//    Serial.println(" - Light touch");
//  } else if (fsrreading < 500) {
//    Serial.println(" - Light squeeze");
//  } else if (fsrreading < 800) {
//    Serial.println(" - Medium squeeze");
//  } else {
//    Serial.println(" - Big squeeze");
//  }

  delay(100); //Delay 20000 ms.
}
