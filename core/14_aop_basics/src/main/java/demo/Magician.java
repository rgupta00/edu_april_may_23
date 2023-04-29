package demo;

import org.springframework.stereotype.Component;

//When magician is showing the maginc then Audiance must do clapping after
@Component(value = "m")
 public class Magician {

	public void doMagic() {
		System.out.println("abra ka dabra...");
		if(1==2)
			throw new MagicianHeartAttack("call the Dr now :(");
	}

	public void doEat() {
		System.out.println("doing lunch!.");

	}
}
