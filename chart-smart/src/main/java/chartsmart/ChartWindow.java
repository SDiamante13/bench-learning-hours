package chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] data3point14 = new String[0];
        if (chartType == CHART_TYPE_BAR) {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                renderChartBackgroundForBarChartSingleDisplay(g);
            } else {
                renderChartBackgroundForBarChartSharedDisplay(g);
            }

            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                data = getTitleDataForBarChartSingleDisplay();
            } else {
                data = getTitleDataForBarChartSharedDisplay();
            }

            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                renderBarChartTitleForSingleDisplay(g, data);
            } else {
                renderBarChartTitleForSharedDisplay(g, data);
            }
        } else {
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                renderChartBackgroundForPieChartSingleDisplay(g);
            } else {
                renderChartBackgroundForPieChartSharedDisplay(g);
            }
            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                setTitleDataForPieChartSingleDisplay(specialData);
            } else {
                data3point14 = getTitleDataForPieChartSharedDisplay();
            }

            if (chartMode.equals(CHART_MODE_SINGLE_DISPLAY_MODE)) {
                renderPieChartTitleForSingleDisplay(g, specialData);
            } else {
                renderPieChartTitleForSharedDisplay(g, data3point14);
            }
        }

        if (specialData.contains("Monthly") || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Exception e) {
                repaint();
            }
        }
    }

    private void renderChartBackgroundForBarChartSingleDisplay(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(100, 90, getWidth() - 200, 420);
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

    private String[] getTitleDataForBarChartSingleDisplay() {
        return new String[]{"Bar Chart"};
    }

    private String[] getTitleDataForBarChartSharedDisplay() {
        String[] data;
        data = new String[]{"Bar Chart", "Small"};
        return data;
    }

    private String[] getTitleDataForPieChartSharedDisplay() {
        String[] data3point14;
        data3point14 = new String[]{"Pie Chart", "Small"};
        return data3point14;
    }

    private void setTitleDataForPieChartSingleDisplay(List<String> specialData) {
        specialData.add("Pie Chart");
    }

    private void renderBarChartTitleForSharedDisplay(Graphics g, String[] data) {
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
        g.drawString(data[0], 130, 250);
        g.drawString(data[1], 130, 270);
    }

    private void renderBarChartTitleForSingleDisplay(Graphics g, String[] data) {
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
        g.drawString(data[0], 130, 400);
    }

    private void renderPieChartTitleForSingleDisplay(Graphics g, List<String> specialData) {
        Font font = new Font("Bookman Old Style", Font.BOLD, 55);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(specialData.get(0), 200, 340);
    }

    private void renderPieChartTitleForSharedDisplay(Graphics g, String[] data3point14) {
        Font font = new Font("Bookman Old Style", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(data3point14[0], 145, 205);
        g.drawString(data3point14[1], 170, 235);
    }
}
