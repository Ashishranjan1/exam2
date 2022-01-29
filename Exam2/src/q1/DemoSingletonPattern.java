package q1;

import java.io.Serializable;

enum MySingleton {
	INSTANCE;

}
class Singleton implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
		private volatile Singleton singleton = null;	//lazy instantiation

	private Singleton() {
		if (singleton != null) {
			//AVOIDING REFLECTION ISSUE - 
			throw new IllegalStateException();
		}
	}

	public Singleton getSingleton10() {
		if (singleton == null) {
			if (singleton == null) {
				//using double lock checking with synchronized block to tackle multithreading issue
				synchronized (Singleton.class) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	//AVOIDING SERIALIZATION ISSUE
		private Object readResolve() {
		return singleton;
	}

	//CLONING ISSUE 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singleton;
	}
}

public  class DemoSingletonPattern {
	public static void main(String[] args) {
		//Implementing Enum singleton pattern, 
		MySingleton singletonEnum = MySingleton.INSTANCE;
		System.out.println(singletonEnum.hashCode());
		
		MySingleton singletonEnum2 = MySingleton.INSTANCE;
		System.out.println(singletonEnum2.hashCode());
	}
}

