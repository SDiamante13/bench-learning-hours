package chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartWindow extends JPanel {

    private String chartMode;
    private String title;

    public static final int CHART_TYPE_BAR = 406;

    public static final String CHART_MODE_SINGLE_DISPLAY_MODE = "rpfll";
    public static final String CHART_MODE_SHARED_DISPLAY = "shareddisplay";

    private int chartType;

    public void showChartIThink(int chartType, String chartMode, boolean shouldShow) {
        this.chartType = chartType;
        this.chartMode = chartMode;

        if (shouldShow) {
            initializeDrawArea();
        }
    }

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));

        if (chartType == CHART_TYPE_BAR) {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {
        if (chartType == CHART_TYPE_BAR) {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                drawRectangle(g, Color.RED, 100, 90, getWidth() - 200, 420);

                int bottomY = 500;
                drawRectangle(g, Color.CYAN, 112, bottomY - 200, 75, 200);
                drawRectangle(g, Color.CYAN, 187, bottomY - 400, 75, 400);
                drawRectangle(g, Color.CYAN, 262, bottomY - 300, 75, 300);
                drawRectangle(g, Color.CYAN, 337, bottomY - 250, 75, 250);
                drawRectangle(g, Color.CYAN, 412, bottomY - 340, 75, 340);

                drawText(g, Color.BLACK, "Arial Black", 55, "Bar Chart", 130, 400);
            } else {
                drawRectangle(g, Color.BLACK, 95, 95, 210, 210);

                int bottomY = 300;
                drawRectangle(g, Color.CYAN, 100, bottomY - 100, 40, 100);
                drawRectangle(g, Color.CYAN, 140, bottomY - 200, 40, 200);
                drawRectangle(g, Color.CYAN, 180, bottomY - 150, 40, 150);
                drawRectangle(g, Color.CYAN, 220, bottomY - 125, 40, 125);
                drawRectangle(g, Color.CYAN, 260, bottomY - 170, 40, 170);

                drawText(g, Color.RED, "Arial Black", 25, "Bar Chart", 130, 250);
                drawText(g, Color.RED, "Arial Black", 25, "Small", 130, 270);
            }
        } else {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                drawCircle(g, Color.BLUE, 100, 100, 450, getHeight() - 150);

                drawText(g, Color.WHITE, "Bookman Old Style", 55, "Pie Chart", 200, 340);
            } else {
                drawCircle(g, Color.BLUE, 100, 100, 225, 225);

                drawText(g, Color.WHITE, "Bookman Old Style", 30, "Pie Chart", 145, 205);
                drawText(g, Color.WHITE, "Bookman Old Style", 30, "Small", 170, 235);
            }
        }
    }

    private void drawCircle(Graphics g, Color circleColor, int x, int y, int width, int height) {
        g.setColor(circleColor);
        g.fillOval(x, y, width, height);
    }

    private void drawText(Graphics g, Color textColor, String fontStyle, int size, String text, int x, int y) {
        g.setColor(textColor);
        g.setFont(new Font(fontStyle, Font.BOLD, size));
        g.drawString(text, x, y);
    }

    private void drawRectangle(Graphics g, Color backgroundColor, int x, int y, int width, int height) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, width, height);
    }

}
