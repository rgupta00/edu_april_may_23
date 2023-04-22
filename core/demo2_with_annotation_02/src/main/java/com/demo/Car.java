package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Car class is resp for managing its own dep :(
//Car should get its dep form outside :)
/*
<bean id="car" class="com.demo.Car"
>
        <property name="carName" value="tata "/>
    </bean>
 */
@Component(value = "car")
public class Car {
    @Value("tata car")
    private String carName;

    @Autowired
    private Tyre tyre;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public void move(){
        tyre.rotate();
        System.out.println("moving in a car "+ carName);
    }
}
