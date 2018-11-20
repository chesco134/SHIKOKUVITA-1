package LogicaGUI;

import java.awt.Dimension;
import org.jfree.*;


import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MenuPrincipalLog{

    public MenuPrincipalLog() {
    }

	public ChartPanel generateChart(String titulo, String tipoBasura, String categoria, String periodoTiempo, DefaultCategoryDataset dataset){
	JFreeChart chart = ChartFactory.createBarChart(categoria, periodoTiempo,"Basura generada (kg)", dataset, PlotOrientation.VERTICAL, true, true, false);
	
	ChartPanel panel = new ChartPanel(chart);
	//panel.setPreferredSize(new Dimension(800, 700));
	return panel;

	}

}
