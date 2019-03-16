public class Test {

    public static void main(String[] args) {
       int Ax=-1;
       int Ay=3;
       int Bx=3;
       int By=-1;

        System.out.println(solution(Ax,Ay,Bx,By));
    }


    public static String solution(int AX, int AY, int BX, int BY) {
        double y_diff= (BY-AY);
        double x_diff=(BX-AX);
        double slope=y_diff/x_diff;
        System.out.println("test");
        //((BX - AX)*(c_Y - AY) - (BY - AY)*(c.X - BX))
//        double perpendicluar=-1/slope;
//        double x_intercept=BX-BY/perpendicluar;
//        double y_intercept=perpendicluar*BX+BY;

        return null;
    }
}
