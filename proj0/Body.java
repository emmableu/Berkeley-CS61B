import examples.StdDraw;

public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    public static final double G = 6.67 * Math.pow(10, -11);

    public Body(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double xDis = xxPos - b.xxPos;
        double yDis = yyPos - b.yyPos;
        double distance = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
        return distance;
    }

    public double calcForceExertedBy(Body b){
        double force = (G * mass * b.mass)/Math.pow((this.calcDistance(b)), 2);
        return force;
    }

    public double calcForceExertedByX(Body b){
        if (calcDistance(b) == 0){
            return 0;
        }
        double forceX = 0;
        double f = calcForceExertedBy(b);
        double dx = b.xxPos-xxPos;
        forceX += f*dx/calcDistance(b);
        return forceX;
    }


    public double calcNetForceExertedByX(Body[] bodys){

        double forceX = 0;
        for (Body b: bodys){
            forceX += calcForceExertedByX(b);
        }
        return forceX;
    }

    public double calcNetForceExertedByY(Body[] bodys){
        double forceY = 0;
        for (Body b: bodys){
            forceY += calcForceExertedByY(b);
        }
        return forceY;
    }

    public double calcForceExertedByY(Body b){
        if (calcDistance(b) == 0){
            return 0;
        }
        double forceY = 0;
        double f = calcForceExertedBy(b);
        double dy = b.yyPos-yyPos;
        forceY += f*dy/calcDistance(b);
        return forceY;
    }

    public void update(double dt, double forceX, double forceY){
        double ax = forceX/mass;
        xxVel += ax*dt;
        double ay = forceY/mass;
        yyVel += ay*dt;

        xxPos += xxVel*dt;
        yyPos += yyVel*dt;
    }

    public void draw(){
        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
