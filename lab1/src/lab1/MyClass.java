package lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyClass {
	public static void main(String[] args) {
	Collection col[]= new Collection[5];
	
	col[0] = new Collection(2.01, "Токовая защита", 600, 1);
	col[1] = new Collection(3.00, "Время пуска", 10.5f, 1);
	col[2] = new Collection(5.02, "Начальное напряжение", 220, 3);
	col[3] = new Collection(1.11, "Режим работы", 3, 2);
	col[4] = new Collection(1.10, "Разрешение ПИ-регулятора", 0.1659f, 3);
	
	Collection tmp = new Collection();
	for (int i = 0; i < col.length; i++) {
		for (int j = 0; j < (col.length - 1); j++) {
			if (col[j].index > col[j + 1].index) {
				tmp = col[j];
				col[j] = col[j + 1];
				col[j + 1] = tmp;
			}
		}
	}
	
	try {
		PrintStream out = new PrintStream(new File("file.txt"));
		for (Collection col1 : col) {
			col1.printToFile(out);
		}
	} catch (FileNotFoundException e) {
		System.err.println(e.getMessage());
	}
}}
