1. Create `HelloWorld.java`  with below contents
    ```
    class HelloWorld
    {

        public native void displayHello();

        static
        {
            System.loadLibrary("hello");
        }


        public static void main(String[] ar)
        {
            new HelloWorld().displayHello();
        }

    }
    ```
1. `javac HelloWorld.java` - Compile the source code
1. `javah -jni HelloWorld` - For generating header file `HelloWorld.h`
1. Create HelloWorldImpll.c with below contents
    ```
    #include <jni.h>
    #include <stdio.h>
    #include "HelloWorld.h"
    
    JNIEXPORT void JNICALL
    Java_HelloWorld_displayHello(JNIEnv *env, jobject obj)
    {
        printf("Test~For~JNI\n");
        return;
    }
    
    ```
1. Compile C to generate binary
   ```
     **IMPORTANT:** library extension should exactly be `.jnilib` (not `.so`!), and should have `lib` prefix, i.e. `libhello.jnilib`:
    ```
1. ```gcc  -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/darwin"  -shared HelloWorldImpl.c -o libhello.jnilib```
1. `java -Djava.library.path=`pwd` HelloWorld` or `java -Djava.library.path=`pwd` HelloWorld`
    1. Output: ```Test~For~JNI```