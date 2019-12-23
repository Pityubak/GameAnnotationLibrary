/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.components;

/**
 *
 * @author Pityubak
 */
public interface SwingComponent {

    void init();
    
    default void afterInit(){
        System.out.println("After init");
    }

}
