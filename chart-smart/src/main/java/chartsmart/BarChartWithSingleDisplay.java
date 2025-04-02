package chartsmart;

import java.awt.*;

class BarChartWithSingleDisplay implements Chart {

    @Override
    public void renderBackground(Graphics g, int width) {
        g.setColor(Color.RED);
        g.fillRect(100, 90, width - 200, 420);
    }

    @Override
    public void renderTitle(Graphics g) {
        int bottomY = 500;
        g.setColor(Color.CYAN);
        g.fillRect(112, bottomY - 200, 75, 200);
        g.fillRect(187, bottomY - 400, 75, 400);
        g.fillRect(262, bottomY - 300, 75, 300);
        g.fillRect(337, bottomY - 250, 75, 250);
        g.fillRect(412, bottomY - 340, 75, 340);
        Font font = new Font("Arial Black", Font.BOLD, 55);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Bar Chart", 130, 400);
    }
}
