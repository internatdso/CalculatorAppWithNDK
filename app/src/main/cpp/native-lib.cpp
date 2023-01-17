#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculatorappwithndk_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Enter two integers in the following:";
    return env->NewStringUTF(hello.c_str());
}

/*
 * Including four different methods for performing Add, Subtract, Multiply, Divide.
 * Note: Return type: jinit
 */

//add function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculatorappwithndk_MainActivity_add(
        JNIEnv* env,
        jobject,
        jint x, jint y
        ){
    // return an int
    return x + y;
}

//subtract function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculatorappwithndk_MainActivity_sub(
        JNIEnv* env,
        jobject,
        jint x, jint y
){
    // return an int
    return x - y;
}

//multiplication function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculatorappwithndk_MainActivity_multiply(
        JNIEnv* env,
        jobject,
        jint x, jint y
){
    // return an int
    return x * y;
}

//division function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculatorappwithndk_MainActivity_divide(
        JNIEnv* env,
        jobject,
        jint x, jint y
){
    // return an int
    return x / y;
}