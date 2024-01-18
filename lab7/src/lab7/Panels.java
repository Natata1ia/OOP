package lab7;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panels {
	private JList<String> playerList, teamList;
	private DefaultListModel<String> playerModel, teamModel;

	private JButton buttonRight;
	private JButton buttonRightRight;
	private JButton buttonLeft;
	private JButton buttonLeftLeft;

	private JPanel buttonPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;

	public Panels() {
		playerModel = new DefaultListModel<String>();
		playerList = new JList<String>(playerModel);
		playerList.setMinimumSize(new Dimension(200, 200));
		teamModel = new DefaultListModel<String>();
		teamList = new JList<String>(teamModel);
		teamList.setMinimumSize(new Dimension(200, 200));

		buttonPanel = new JPanel();
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0, 1));
		leftPanel.add(playerList);
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(0, 1));
		rightPanel.add(teamList);

		buttonRight = new JButton(">");
		buttonRight.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> selection = playerList.getSelectedValuesList();
				for (String player : selection) {
					teamModel.addElement(player);
					playerModel.removeElement(player);
				}
			}
		});
		buttonRightRight = new JButton(">>");
		buttonRightRight.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				Enumeration<String> elements = playerModel.elements();
				while (elements.hasMoreElements())
					teamModel.addElement(elements.nextElement());
				playerModel.removeAllElements();
			}
		});
		buttonLeft = new JButton("<");
		buttonLeft.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> selection = teamList.getSelectedValuesList();
				for (String player : selection) {
					playerModel.addElement(player);
					teamModel.removeElement(player);
				}
			}
		});
		buttonLeftLeft = new JButton("<<");
		buttonLeftLeft.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				Enumeration<String> elements = teamModel.elements();
				while (elements.hasMoreElements())
					playerModel.addElement(elements.nextElement());
				teamModel.removeAllElements();
			}
		});
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(buttonRight);
		buttonPanel.add(buttonRightRight);
		buttonPanel.add(buttonLeft);
		buttonPanel.add(buttonLeftLeft);
		this.reset();
	}
	
	public void save() {
		String all = "";
		Enumeration<String> elements = teamModel.elements();
		while (elements.hasMoreElements()) {
			all += elements.nextElement() + "\n";
		}
		if (all.length() > 0) 
			JOptionPane.showConfirmDialog(rightPanel, all, 
					"Сохранить персонажей?", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null);
		else
			JOptionPane.showMessageDialog(playerList, 
					"Вы не выбрали ни одного персонажа", 
					"Сохранить невозможно", 
					JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reset() {
		playerModel.removeAllElements();
		teamModel.removeAllElements();
		for (String player : PlayersList.getNames()) 
			playerModel.addElement(player);
	}
	
	public JPanel getLeftPanel() {
		return leftPanel;
	}
	
	public JPanel getRightPanel() {
		return rightPanel;
	}

	public JPanel getCenterPanel() {
		return buttonPanel;
	}
}
