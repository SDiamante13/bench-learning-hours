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
                BarChartWithSingleDisplay barChartWithSingleDisplay = new BarChartWithSingleDisplay();
                barChartWithSingleDisplay.renderBackground(g, getWidth());
                barChartWithSingleDisplay.renderTitle(g);
            } else {
                renderChartBackgroundForBarChartSharedDisplay(g);
                renderBarChartTitleForSharedDisplay(g);
            }
        } else {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                renderChartBackgroundForPieChartSingleDisplay(g);
                renderPieChartTitleForSingleDisplay(g);
            } else {
                renderChartBackgroundForPieChartSharedDisplay(g);
                renderPieChartTitleForSharedDisplay(g);
            }
        }
    }

    private void renderChartBackgroundForBarChartSharedDisplay(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(95, 95, 210, 210);
    }

    private void renderChartBackgroundForPieChartSingleDisplay(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 450, getHeight() - 150);
    }

    private void renderChartBackgroundForPieChartSharedDisplay(Graphics g) {
        g.setColor(Color.BLUE);
        double isq = 405;
        float padding = 90;
        int sc = (int) (isq - padding * 2);
        g.fillOval(100, 100, sc, sc);
    }

    private void renderBarChartTitleForSharedDisplay(Graphics g) {
        Font font = new Font("Arial Black", Font.BOLD, 25);
        g.setColor(Color.CYAN);
        int bottomY = 300;
        g.fillRect(100, bottomY - 100, 40, 100);
        g.fillRect(140, bottomY - 200, 40, 200);
        g.fillRect(180, bottomY - 150, 40, 150);
        g.fillRect(220, bottomY - 125, 40, 125);
        g.fillRect(260, bottomY - 170, 40, 170);
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString("Bar Chart", 130, 250);
        g.drawString("Small", 130, 270);
    }

    private void renderPieChartTitleForSingleDisplay(Graphics g) {
        Font font = new Font("Bookman Old Style", Font.BOLD, 55);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Pie Chart", 200, 340);
    }

    private void renderPieChartTitleForSharedDisplay(Graphics g) {
        Font font = new Font("Bookman Old Style", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Pie Chart", 145, 205);
        g.drawString("Small", 170, 235);
    }
}
