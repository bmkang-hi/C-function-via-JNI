# C-function-via-JNI
This is the source code of an assignment for my Program Structures course taught by Ravi Narayan at UH Manoa, Fall 2016.

The application itself is a simple temperature converter that takes a user input max temperature value in Celsius > 0 then displays all temperatures in Fahrenheit from 0 C to the given temperature rounded to the next multiple of 5, in multiples of 5.

### Main purpose
The application uses the Java Native Interface (JNI) to make calls from a Java frontend that handles all user interfacing functions, to C functions that do the calculations. 

This assignment had minimal direct instruction and was focused on the ability to do research and write code using techniques and libraries we had not yet been exposed to, independently
