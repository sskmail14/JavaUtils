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