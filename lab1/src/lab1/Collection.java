package lab1;

import java.io.PrintStream;

public class Collection {
	Double index;
	String name;
	float value;
	int level;
	
	public Collection (Double index, String name, float value, int level ) {
		this.index = index;
		this.name = name;
		this.value = value;
		this.level = level;
	}
	public Collection () {
		this.index = 0.0;
		this.name = "";
		this.value = -1;
		this.level = 0;
	}
	void printToFile(PrintStream stream) {
		stream.printf("%4.2f, %30s, %8.4f, %1d\n", 
				this.index, this.name, this.value, this.level);
		System.out.printf("%4.2f, %30s, %8.4f, %1d\n",
				this.index, this.name, this.value, this.level);
	}

}
