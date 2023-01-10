#include <stdio.h>
#include <jni.h>
#include "HelloWorld.h"

JNIEXPORT void JNICALL
Java_HelloWorld_displayHello(JNIEnv *env, jobject obj)
{
	printf("Test~For~JNI");
	return;
}
