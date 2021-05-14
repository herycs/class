package com.w.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.util.ArrayList;

public class XY2 extends ApplicationFrame {


    public XY2(String applicationTitle, String chartTitle) {
        super(applicationTitle);


        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "X", "Y",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,
                true, 
                false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(0.1f));

        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        final XYSeries firefox = new XYSeries("y=x^2");

        ArrayList<Integer> xList = new ArrayList<Integer>();
        for(int i = -100; i < 100; i++) {
            xList.add(i);
        }

        xList.forEach(x -> {
            double y = Math.pow(x, 2);
            firefox.add((double)x, y);
        });


        final XYSeriesCollection dataset = new XYSeriesCollection();


        dataset.addSeries(firefox);

        return dataset;
    }



    public static void main(String[] args) {

        XY2 chart = new XY2("X_Y", "Y&X");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);

        chart.setVisible(true);

    }
}