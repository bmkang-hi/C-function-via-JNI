/*********************************
//
// Name:        Brandon Kang
//
// Homework:    9
//
// Class:       ICS 212
//
// Instructor:  Ravi Narayan
//
// Date:        12/2/2016
//
// File:        HW9.c
//
// Description: This is the C file that implements the native methods that are called from the Java environment via the JNI
//
//*******************************/

#include "HW9.h"

/*********************************
//
// Function name: Java_HW9_roundingFunction
//
// Description:   This function takes the user input value from the Java environment and rounds it up the next multiple of 5
//
// Parameters:    int inTemp : This is the max temp input by the user from the Java environment
//
// Return values:  roundMaxTemp : the input temp rounded up to the nearest multiple of 5
//
//*******************************/

JNIEXPORT jint JNICALL Java_HW9_roundingFunction(JNIEnv * env, jobject obj, jint inTemp)
{
    int modResult, roundMaxTemp;
    
    modResult = (inTemp % 5);
    if(modResult != 0)
    {
        roundMaxTemp = inTemp + (5 - modResult);
    }
    else
    {
        roundMaxTemp = inTemp;
    }
    
    return roundMaxTemp;
}


/*********************************
//
// Function name: Java_HW9_convertCtoF
//
// Description:   This function takes an int represnting temperatue in degrees Celsius and converts them into a float represntation of the equivalent temperatue in degrees Fahrenheit.
//
// Parameters:    int tempInC : Takes the temperature in degrees celsius from Java environment
//
// Return values:  float tempInF : returns the conversion of tempInC to Fahrenheit as a float.
//
//*******************************/
JNIEXPORT jfloat JNICALL Java_HW9_convertCtoF(JNIEnv * env, jobject obj, jint tempInC)
{
    float tempInF;
    tempInF = ((tempInC * 9) / 5) + 32;
    return tempInF;
}

