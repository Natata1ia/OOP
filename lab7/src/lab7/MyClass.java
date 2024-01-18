package lab7;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class MyClass {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(300, 350);
		frame.setTitle("Геншин Импакт");
		frame.setLayout(new BorderLayout(30,0));
		
		Panels mainPanels = new Panels();
		frame.add(mainPanels.getLeftPanel(), BorderLayout.WEST);
		frame.add(mainPanels.getRightPanel(), BorderLayout.EAST);
		frame.add(mainPanels.getCenterPanel(), BorderLayout.CENTER);

		MenuBar mainMenuBar = new MenuBar(mainPanels);
		frame.setJMenuBar(mainMenuBar.getMenuBar());
		
		frame.setVisible(true);
	}
}