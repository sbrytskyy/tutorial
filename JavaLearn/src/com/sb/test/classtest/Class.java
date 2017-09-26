package com.sb.test.classtest;

public class Class<E> {
    
    private E attribute;
    
    public void set (E value){
        this.attribute = value;
    }
    
    public E get(){
        return attribute;
    }

    public String method (Class<E> c, E e){
        c.set(e);
        return c.get().toString();
    }
}