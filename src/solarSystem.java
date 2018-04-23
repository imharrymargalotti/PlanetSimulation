/**
 * Created by harrymargalotti on 4/11/17.
 */
import java.util.Scanner;
import java.io.FileInputStream;
public class solarSystem {
    private Planet[] planets;
    private int dt;

    public solarSystem(Planet[] planets){
        this.planets=planets;
        this.dt = 25000;
    }

    public void draw(){
        StdDraw.picture(0,0,"img/starfield.jpg");
        for (int i = 0; i < planets.length; i++) {
            planets[i].draw();
        }
    }

    public void calculations(){
        for (int i = 0; i < planets.length; i++) {
            planets[i].reset();
        }
        for (int i = 0; i < planets.length; i++) {
            for (int j = planets.length -1; j > -1; j--) {
                if (j!=i){
                    planets[i].forceWith(planets[j]);
                }
            }
        }

        for (int i = 0; i < planets.length; i++) {
            planets[i].newVelocity(dt);
        }
    }

    public void run(){
        int t = 0;
        while (true){
            draw();
            StdDraw.show(2);
            if (t!= 0){
                calculations();
            }
            t+=dt;
            StdDraw.clear();
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner (new FileInputStream("dankPlanets.txt"));
        Planet[] planets = new Planet[reader.nextInt()];
        double R = reader.nextDouble();
        StdDraw.setXscale(-R,R);
        StdDraw.setYscale(-R,R);
        for (int i = 0; i < planets.length; i++) {
            double xCoord = reader.nextDouble();
            double yCoord = reader.nextDouble();
            double vx = reader.nextDouble();
            double vy = reader.nextDouble();
            double mass = reader.nextDouble();
            String filename = "img/" + reader.next();
            planets[i] = new Planet(mass, xCoord, yCoord, 6.67e-11, vx, vy, filename);
        }
        solarSystem test=new solarSystem(planets);
        test.run();
    }
}
