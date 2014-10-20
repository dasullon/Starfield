import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {


Particle [] ha_mez = new Particle[100];

public void setup()
{
	size(500,500);
	for(int i = 0; i < ha_mez.length; i++){
		ha_mez[i] = new NormalParticle();
	}
	ha_mez[0]= new OddballParticle();
}
public void draw()
{
	translate (250,250);
	fill(0,0,0,10);
	rect(-250,-250,500,500);
	for(int i=0; i<ha_mez.length;i++){
		ha_mez[i].show();
		ha_mez[i].move();
	}
}

class NormalParticle implements Particle
{
	double x,y,dSpeed,dTheta; 
	int value1,value2,value3;
	
	NormalParticle(){
		x=0;
		y=0;
		dTheta= Math.random()*2*Math.PI;
		dSpeed= Math.random()*3;
		value1= ((int)((Math.random()*255)+1));
		value2= ((int)((Math.random()*255)+1));
		value3= ((int)((Math.random()*255)+1));
	}
	public void show(){
		noStroke();
		int c = color (value1, value2, value3);		
		fill(c);
		ellipse((float)x,(float)y,15,15);
		
	}
	public void move(){
		x+= Math.cos(dTheta)*dSpeed;
		y+= Math.sin(dTheta)*dSpeed;
		if((x>250||y>250 || x<-250 || y<-250)){
			x=0;
			y=0;
		}
	}
}//

interface Particle
{
	public void move();
	public void show();	
}

class OddballParticle  implements Particle
{
	double x,y,dSpeed,dTheta; 

	OddballParticle(){
		x=0;
		y=0;
		dTheta= Math.random()*2*Math.PI;
		dSpeed= Math.random()*3;

	}	
	public void show(){
		noStroke();
		int c = color(255);
		fill(c);
		ellipse((float)x,(float)y,25,25);
	}
	public void move(){
		
		x+= Math.cos(dTheta)*dSpeed;
		y+= Math.sin(dTheta)*dSpeed;
	}
}//
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
