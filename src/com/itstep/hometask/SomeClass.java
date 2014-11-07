/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itstep.hometask;

/**
 *
 * @author dimaputrya
 */
public class SomeClass implements Student{
    
private String txt = "Hi all";
    
    @Override
    public void say() {
       System.out.println(txt);
    }
    
}
