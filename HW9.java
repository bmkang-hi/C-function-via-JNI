/* 
Java Requirements:

    Must have a user-interface function which requests the user to enter the maximum temperature (as an int).
    
    If the maximum temperature entered is less than or equal to 0, the program must display an error message and prompt the user to re-enter the temperature.
    
    Contains a print function which uses a while loop to generate a table starting from 0 C to the maximum temperature in increments of 5 C.
    
    The table output must be formatted.
    
    Make sure the program catches floats!
    
    Uses JNI(Java Native Interface to call C functions
        int roundingFunction(int) 
        AND 
        float convertCtoF(int)
 */
 import java.util.Scanner;
 import java.util.InputMismatchException;
 
 public class HW9
 {
	 static
	 {
		 System.loadLibrary("HW9");
	 }
	 
	 private native float convertCtoF(int tempInF);
	 private native int roundingFunction(int inTemp);
	 
	 public static void main(String[] args)
	 {
		 HW9 nativeMethods = new HW9();
		 Scanner keyboard = new Scanner(System.in);
		 
		 int tempInput, errorCode, inputTemperature, roundedMaxTemp;
		 tempInput = 0;
		 errorCode = 1;
		 
		 System.out.format("This a temperature conversion program that will display a temperature table in Celsius and Fahrenheit.%nPlease enter a maximum temperature in degrees Celsius greater than 0 as an integer (i.e. 10, 32, 100)%n");
		 try
		 {
			 errorCode = 1;
			 tempInput = keyboard.nextInt();
		 }
		 catch(InputMismatchException e)
		 {
			 errorCode = -1;
			 keyboard.nextLine();
		 }
		 
		 while(tempInput <= 0 || errorCode <= 0)
		 {
			 System.out.format("%nInvalid entry, please enter an integer number greater than 0. (i.e. 1,32,54)%n");
			 try
			 {
				 errorCode = 1;
				 tempInput = keyboard.nextInt();
			 }
			 catch(InputMismatchException e)
			 {
				 errorCode = -1;
				 keyboard.nextLine();
			 }
		 }
			 keyboard.close();
			 
			 inputTemperature = tempInput;
			 roundedMaxTemp = nativeMethods.roundingFunction(inputTemperature);
			 
			 printTempTable(roundedMaxTemp, nativeMethods);
		 
	 }
	 
	 
	 
	 static void printTempTable(int maxTemp, HW9 nativeMethods)
	 {
		 int currConvTempC = 0;
		 float currConvTempF;
		 
		 System.out.format("    Temperature in C        Temperature in F%n");
		 while(currConvTempC <= maxTemp)
		 {
			 currConvTempF = nativeMethods.convertCtoF(currConvTempC);
			 System.out.format("%20d%24.2f%n", currConvTempC, currConvTempF);
			 currConvTempC = currConvTempC + 5;
		 }
	 }
 }