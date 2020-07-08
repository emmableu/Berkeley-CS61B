import examples.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        if (!in.isEmpty()) {
            in.readLine();
        }
        double radious = in.readDouble();
        return radious;
    }
    public static Body[] readBodies(String path){
        In in = new In(path);
        for (int i = 0; i < 2; i++){
            in.readLine();
        }
        int counter = 0;
        while (!in.isEmpty()) {
            try {
                in.readDouble();
            }
            catch (Exception e){
               break;
            }
            in.readLine();
            counter++;
        }
        Body[] bodys = new Body[counter];
        in = new In(path);
        for (int i = 0; i < 2; i++){
            in.readLine();
        }
        for (int counter2 = 0; counter2 < counter; counter2++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bodys[counter2] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return bodys;

    }

    private static double[] toDoubleArray(List<Double> list) {
        double[] res = new double[list.size()];
        int i = 0;
        for (double n:list) {
            res[i++] = n;
        }
        return res;
    }

    public static void drawBodys(double T, double dt, String path){
        StdDraw.enableDoubleBuffering();
        double time = 0;
        int waitTimeMilliseconds = 10;

        Body[] bodys = readBodies(path);

        int bodyCounter = 0;
        for (Body b : bodys) {
            bodyCounter++;
        }

        double[] xForces = new double[bodyCounter];
        double[] yForces = new double[bodyCounter];

        while (time < T) {

            double radius = readRadius(path);
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (int i = 0; i < bodys.length; i++) {
                Body b = bodys[i];
                double xForce = b.calcNetForceExertedByX(bodys);
                double yForce = b.calcNetForceExertedByY(bodys);
                xForces[i] = xForce;
                yForces[i] = yForce;
            }

            for (int i = 0; i < bodys.length; i++) {
                Body b = bodys[i];
                b.update(dt, xForces[i], yForces[i]);
                b.draw();
            }

            StdDraw.show();
            StdDraw.pause(waitTimeMilliseconds);
            time += dt;
        }
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String path = args[2];
        drawBodys(T, dt, path);
    }
}
