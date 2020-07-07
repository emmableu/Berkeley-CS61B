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
}
