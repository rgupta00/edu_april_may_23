package com.demo;

import org.springframework.stereotype.Component;

//When magician is showing the maginc then Audiance must do clapping after
@Component(value = "m")
public class Magician {

	public void doMagic() {
		System.out.println("abra ka dabra...");
	}
}
