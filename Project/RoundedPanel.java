package Project;

import java.awt.*;
import javax.swing.*;



public class RoundedPanel extends JPanel {
	private Color backgroundColor;
    private int cornerRadius = 15;
    
    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
        //graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
    }
}

class RoundBorderedPanel extends JPanel {
    private Color backgroundColor;
    private int cornerRadius = 15;
    
    public RoundBorderedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public RoundBorderedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 1, width-2, height-2, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 1, width-2, height-2, arcs.width, arcs.height); //paint border
    }
}

class jPanelGradient extends JLayeredPane {
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		
		Color color1 = new Color(0, 31, 63);
		Color color2 = new Color(0, 64, 128);
		GradientPaint gp = new GradientPaint(0,0,color1,100,height,color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
		
	}
}

class GradientPanel extends JPanel {
	private int cornerRadius = 15;
	
	protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension arcs = new Dimension(cornerRadius, cornerRadius);
		int width = getWidth();
		int height = getHeight();
		
		Color color1 = Color.decode("#193e83");//#0a2d4f
		Color color2 = Color.decode("#061851");//#193e83
		GradientPaint gp = new GradientPaint(0,0,color1, 50, height,color2);
		g2d.setPaint(gp);
		g2d.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
		//g2d.setColor(color1);
		//g2d.drawRoundRect(1, 1, width, height+10, arcs.width, arcs.height); //paint border
		setBackground(null);
	}
}

class BorderedPanel extends JPanel {
    private Color backgroundColor;
    private int cornerRadius = 15;
    
    public BorderedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public BorderedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(1, 1, width-2, height-2, arcs.width, arcs.height); //paint background
        graphics.setColor(Color.white);
        graphics.drawRoundRect(1, 1, width-2, height-2, arcs.width, arcs.height); //paint border
    }
}
