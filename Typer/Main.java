package Typer;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.awt.Robot;
import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {
	
	static HashMap<String, Integer> x = new HashMap<String, Integer>();
	static HashSet<String> capitalized = new HashSet<String>();

	void pressKey(Robot robot, String code, boolean caps) {
		
		if (caps) {
			robot.keyPress(KeyEvent.VK_SHIFT);
			try {
				Thread.sleep(7);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		robot.keyPress(x.get(code));
		try {
			Thread.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		robot.keyRelease(x.get(code));
		if (caps) {
			robot.keyRelease(KeyEvent.VK_SHIFT);
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void start(Stage stage1) throws Exception {
		
		Robot robot = new Robot();
		
		Thread.sleep(2000);
		
		//32 SPACE
		//64 Shift
		//65 - 91 ABC
		
		/*for(int i = 65; i < 91; i++) {
			robot.keyPress(InputEvent.SHIFT_DOWN_MASK);
			robot.keyPress(i);
			robot.keyRelease(i);
			Thread.sleep(50);
		}*/
		
		String string = "A random testing string";
		
		for (int i = 0; i < string.length(); i++) {
			
			String key = Character.toString(string.charAt(i));
			
			boolean caps = false;
			
			if (Character.isLetter(key.charAt(0)))
				if (Character.isUpperCase(key.charAt(0)))
					caps = true;
			
			if (capitalized.contains(key))
				caps = true;
			
			if (x.containsKey(key.toLowerCase())) {
				pressKey(robot, key.toLowerCase(), caps);
			}
			
		}
		
		System.exit(0);
		
		AnimationTimer timer = new AnimationTimer() {
			
	    		int times = 0;
	    		
	    		final LongProperty lastUpdateTime = new SimpleLongProperty(0);
	    		
	    	    @Override
	    	    public void handle(long dt) {
	    	    	
	    	    		times++;
	    	    		
	    	    		if(times%100 == 0) {
	    	    			
	    	    			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
	    	    			
	    	    		}
	    	    		else if (times%100 == 50) {
	    	    			robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
	    	    		}
	    	    	
	    	    }
		};
		
		timer.start();
		
	}
	
	public static void main(String[] args) {
		
		x.put("a", 65);
		x.put("b", 66);
		x.put("c", 67);
		x.put("d", 68);
		x.put("e", 69);
		x.put("f", 70);
		x.put("g", 71);
		x.put("h", 72);
		x.put("i", 73);
		x.put("j", 74);
		x.put("k", 75);
		x.put("l", 76);
		x.put("m", 77);
		x.put("n", 78);
		x.put("o", 79);
		x.put("p", 80);
		x.put("q", 81);
		x.put("r", 82);
		x.put("s", 83);
		x.put("t", 84);
		x.put("u", 85);
		x.put("v", 86);
		x.put("w", 87);
		x.put("x", 88);
		x.put("y", 89);
		x.put("z", 90);
		x.put(" ", 32);
		x.put(".", KeyEvent.VK_PERIOD);
		x.put(",", KeyEvent.VK_COMMA);
		x.put(":", KeyEvent.VK_COLON);
		x.put(";", KeyEvent.VK_SEMICOLON);
		x.put("!", KeyEvent.VK_1);
		x.put("'", KeyEvent.VK_QUOTE);
		x.put("\n", KeyEvent.VK_ENTER);
		
		capitalized.add("!");
		
		launch(args);
		
	}
	
}
/*	



*/