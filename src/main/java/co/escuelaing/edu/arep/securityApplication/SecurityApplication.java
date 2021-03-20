package co.escuelaing.edu.arep.securityApplication;





import co.escuelaing.edu.arep.calc.impl.CalculatorImpl;

import static spark.Spark.*;
public class SecurityApplication {

    public static void main(String[] args) {
        secure("keystores/Apikey.p12", "123456", "keystores/myTrustStore", "123456");
        port(getPort());
        staticFiles.location("/staticfiles");
        options("/",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", ""));
        init();
        post("/suma",(req,res)->{
            CalculatorImpl calculator= new CalculatorImpl();
            System.out.println(req.body());
            calculator.controller(req.body());
            return calculator.sum();

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
