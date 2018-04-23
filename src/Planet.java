/**
 * Created by harrymargalotti on 4/11/17.
 */


public class Planet {
    private double mass;
    private double xCoordinate;
    private double yCoordinate;
    public double OG=6.67e-11;
    private double xV;
    private double yV;
    private String img;
    private double fX;
    private double fY;

    public Planet(double mass, double xCoordinate, double yCoordinate, double OG, double vX, double vY, String img) {

        this.mass = mass;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        OG=6.67e-11;
        this.xV = vX;
        this.yV = vY;
        this.img = img;
        fX=0.0;
        fY=0.0;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void reset(){
        this.fX = 0;
        this.fY = 0;
    }

    public void draw(){//draws planet at its x and y coordinate
        StdDraw.picture(this.xCoordinate,this.yCoordinate,this.img);
    }

    public void forceWith(Planet z){
        double dx = z.getxCoordinate() - this.xCoordinate;
        double dy = z.getyCoordinate() - this.yCoordinate;
        double m2 = z.getMass() * this.mass;
        fX += (6.67e-11* m2 * dx) / (Math.pow((Math.pow(dx,2)+Math.pow(dy,2)),1.5));
        fY += (6.67e-11 * m2 * dy) / (Math.pow((Math.pow(dx,2)+Math.pow(dy,2)),1.5));
    }

    public void newVelocity(double dt){
        xV += dt * (fX/mass);
        yV += dt * (fY/mass);
        xCoordinate += dt * xV;
        yCoordinate += dt * yV;
    }


}