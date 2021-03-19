package co.escuelaing.edu.arep.calc.impl;

import co.escuelaing.edu.arep.calc.Calculator;



public class CalculatorImpl implements Calculator {
    private Integer numa=0;
    private Integer numb=0;
    public Integer controller(String json){
        String temp = json.replace("\"","");
        temp = temp.replace("}","");
        temp = temp.replace("{","");
        temp = temp.replace(" ","");
        String [] temp2=temp.split(",");
        numa = Integer.parseInt(temp2[0].split(":")[1]);
        numb = Integer.parseInt(temp2[1].split(":")[1]);
       ;
        return 15;
    }

    @Override
    public Integer sum() {
        return numa+numb;
    }

    @Override
    public Integer multi() {

        return numa*numb;
    }

    @Override
    public Integer sub() {
        return numa-numb;
    }

    @Override
    public Integer div() {
        return numa/numb;
    }
}
