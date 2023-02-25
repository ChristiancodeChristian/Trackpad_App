Adafruit_NeoPixel ledStripe[3];

void Colors_LED(int iStripe, String whichColor[3]){
  for(int i=0; i<3; i++){
      if(whichColor[i] == "dark"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(0,0,0)); 
      }
      else if(whichColor[i] == "green"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(0,255,0));        
      }
      else if(whichColor[i] == "red"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(255,0,0));        
      }
      else if(whichColor[i] == "blue"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(0,0,255));        
      }
      else if(whichColor[i] == "purple"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(255,0,255));        
      }
      else if(whichColor[i] == "yellow"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(255,255,0));        
      }
      else if(whichColor[i] == "orange"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(255,165,0));        
      }
      else if(whichColor[i] == "cyan"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(0,255,255));        
      }
      else if(whichColor[i] == "silver"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(192,192,192));        
      }
      else if(whichColor[i] == "lime"){
          ledStripe[iStripe].setPixelColor(i, ledStripe[iStripe].Color(164,196,0));        
      }
     ledStripe[iStripe].show(); 
  }


  }    




 
