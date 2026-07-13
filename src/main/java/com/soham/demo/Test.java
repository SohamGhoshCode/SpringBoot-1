package com.soham.demo;


class p{
    void m1(){
        System.out.println("m1");
    }
    void m2(){
        System.out.println("m2");
    }
}
class c1 extends p{
    void m3(){
        System.out.println("m3");
    }
}
class c2 extends c1{
    void m4(){
        System.out.println("m4");
    }
}



public class Test {
    p obj = new c1();
    //c1 c = new p(); //not copy reference from parent
}
