package co.escuelaing.edu.arep.securityApplication;





import co.escuelaing.edu.arep.calc.impl.CalculatorImpl;

import static spark.Spark.*;
public class SecurityApplication {

    public static void main(String[] args) {
        secure("keystores/Apikey.p12", "123456", "keystores/myTrustStore", "123456");
        port(getPort());
        staticFiles.location("/staticfiles");
        init();
        post("/suma",(req,res)->{
            CalculatorImpl calculator= new CalculatorImpl();
            System.out.println(req.body());
            calculator.controller(req.body());
            return 10;

        });
        post("/multi",(req,res)->{
            CalculatorImpl calculator= new CalculatorImpl();
            System.out.println(req.body());
            calculator.controller(req.body());
            return calculator.multi();
        });
        post("/div",(req,res)->{
            CalculatorImpl calculator= new CalculatorImpl();
            System.out.println(req.body());
            calculator.controller(req.body());
            return calculator.div();
        });
        post("/resta",(req,res)->{
            CalculatorImpl calculator= new CalculatorImpl();
            System.out.println(req.body());
            calculator.controller(req.body());
            return calculator.sub();
        });
    }


    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
