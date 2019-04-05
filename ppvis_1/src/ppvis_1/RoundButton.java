package ppvis_1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class RoundButton extends JButton implements MouseListener {

	public RoundButton() {
		setBackground(Color.lightGray);
		setContentAreaFilled(false);
		addMouseListener(this);
	}

	public RoundButton(String label) {
		setText(label);
		setBackground(Color.lightGray);
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(Color.yellow);
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		setBackground(Color.green);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(Color.lightGray);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}