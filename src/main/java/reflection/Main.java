package reflection;

import java.lang.reflect.*;


public class Main{
	public static void main(String[] args){
		try{
			Class c = Class.forName("Task10");
			Object o = c.newInstance();
			Method[] methods = c.getMethods();
			methods[0].invoke(o, 10);
			methods[1].invoke(o);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}