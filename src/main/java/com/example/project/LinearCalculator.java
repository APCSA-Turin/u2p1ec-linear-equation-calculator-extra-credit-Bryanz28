package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
     //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
private int x1;
private int x2;
private int y1;
private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String cord1,String cord2){ // <--add 2 string parameters to this constructor
        int mid1 = cord1.indexOf(",");
        int end1 = cord1.length()-1; //find the length of the string
        int mid2 = cord2.indexOf(",");
        int end2 = cord2.length()-1; //find the length of the string
      x1 = Integer.parseInt(cord1.substring(1,mid1));
      y1 = Integer.parseInt(cord1.substring(mid1+1,end1));
      x2 = Integer.parseInt(cord2.substring(1,mid2));
      y2 = Integer.parseInt(cord2.substring(mid2+1,end2));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){
        x1=newX1;
    }
    public void setY1(int newY1){
        y1=newY1;
    }
    public void setX2(int newX2){
        x2=newX2;
    }
    public void setY2(int newY2){
        y2=newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dst= Math.pow((Math.pow((x2-x1),2)+Math.pow((y2-y1),2)), 0.5);
        //rounding to nearest 100th 
        dst=dst*100;
        dst = Math.round(dst);
        dst=dst/100.00;
        return dst;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){

        if ((x2-x1)==0) {
            return -999.99; // undefined
        } 
        double yInt= y1- slope()*x1;
        //rounding to nearest 100th
        yInt*=100;
        yInt = Math.round(yInt);
        yInt/=100;
        return yInt;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2-x1)==0) {
            return -999.99; //undefined
        } 
        double slope= (double)(y2-y1)/(x2-x1);
        //rounding to nearest 100th
        slope*=100;
        slope = Math.round(slope);
        slope/=100;
        return slope;
        
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope()==-999.99) {
            return "undefined";
        }
        if (yInt()==0) {
            return "y="+slope()+"x";
        }
        if (slope()==0) {
            return "y="+yInt();
        }
        if (yInt()<0) {
            return"y="+slope()+"x"+yInt();
        }
       
        return "y="+slope()+"x+"+yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        x=x*100;
        x=Math.round(x);
        x=x/100;
        return x;
    }

    

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (y1 == -y2 && x1 == -x2) {
            return "Symmetric about the origin";
        } 
        if (y1==-y2) {
            return "Symmetric about the x-axis";
        }
        if (x1==-x2) {
            return "Symmetric about the y-axis";
        }
        
        
            return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double midx =(x1+x2)/2.0;
        double midy =(y1+y2)/2.0;
        return "The midpoint of this line is: "+"(" + midx + "," + midy + ")";
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," +y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: "+slope();
        str += "\nThe y-intercept of the line is: "+yInt();
        str += "\nThe distance between the two points is: " +distance();
        str += findSymmetry();
        str += Midpoint();
        return str;
    }



}



