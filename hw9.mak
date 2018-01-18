HW9.h : HW9.class
	javah HW9

HW9.o : HW9.c HW9.h
	gcc -c -shared -fpic -I"/usr/jdk/latest/include" -I"/usr/jdk/latest/include/solaris" HW9.c

libHW9.so : HW9.o
	gcc -o libHW9.so -fpic -shared -I"/usr/jdk/latest/include" -I"/usr/jdk/latest/include/solaris" HW9.o
	
HW9.class : HW9.java
	javac HW9.java
	
clean :
	-rm *.class *.o HW9.h libHW9.so