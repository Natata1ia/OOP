package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBar {
	private JMenuBar menuBar;
	private Panels mypanel;
	public MenuBar(Panels panel) {
		menuBar = new JMenuBar();
		this.mypanel = panel;
		JMenu menuFile = new JMenu("Файл");
		JMenuItem menuItemExit = new JMenuItem("Выход");
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
		menuItemExit.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(menuBar, 
						"Вы действительно хотите выйти?", 
						"Подтверждение выхода", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null);
				if (option == JOptionPane.OK_OPTION) System.exit(0);
			}
		});
		
		JMenuItem menuItemSave = new JMenuItem("Сохранить");
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		menuItemSave.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.save();
			}
		});
		
		JMenuItem menuItemReset = new JMenuItem("Сбросить");
		menuItemReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));
		menuItemReset.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.reset();
			}
		});
		
		menuFile.add(menuItemSave);
		menuFile.add(menuItemReset);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		menuBar.add(menuFile);
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
