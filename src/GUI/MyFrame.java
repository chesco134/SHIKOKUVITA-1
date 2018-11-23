/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Desecho.Desecho;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Juan Capiz
 */
public class MyFrame extends ApplicationFrame {
    
    private Desecho desecho;
    private Desecho[] desechos;
    private ChartPanel chartPanel;
    private String categoria;
    
    public String getCategoria(){
        return categoria;
    }
   
   public MyFrame(Desecho desecho, String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      this.desecho = desecho;
      this.categoria = desecho.getCategoria();
      init(chartTitle);
   }
   
   public MyFrame(Desecho[] desechos, String applicationTitle) {
      super( applicationTitle );
      this.desechos = desechos;
      desecho = null;
      categoria = "Todos";
      init();
   }
   
   public ChartPanel getChartPanel(){ return chartPanel; }
   
   private void init(String chartTitle){
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
      chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 360 , 147 ) );        
      setContentPane( chartPanel ); 
   }
   
   private void init(){
       
      JFreeChart barChart = ChartFactory.createBarChart(
         "Todos los desechos",           
         "Desecho",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
      chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 360 , 167 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
//      final String fiat = "FIAT";        
//      final String audi = "AUDI";        
//      final String ford = "FORD";
//      
//      final String speed = "Speed";        
//      final String millage = "Millage";        
//      final String userrating = "User Rating";        
//      final String safety = "safety";        
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

//      dataset.addValue( 1.0 , fiat , speed );        
//      dataset.addValue( 3.0 , fiat , userrating );        
//      dataset.addValue( 5.0 , fiat , millage ); 
//      dataset.addValue( 5.0 , fiat , safety );           
//
//      dataset.addValue( 5.0 , audi , speed );        
//      dataset.addValue( 6.0 , audi , userrating );       
//      dataset.addValue( 10.0 , audi , millage );        
//      dataset.addValue( 4.0 , audi , safety );
//
//      dataset.addValue( 4.0 , ford , speed );        
//      dataset.addValue( 2.0 , ford , userrating );        
//      dataset.addValue( 3.0 , ford , millage );        
//      dataset.addValue( 6.0 , ford , safety );               
        if(desecho != null){
            dataset.addValue(desecho.getCantidad(), desecho.getCategoria(), "");
        }else{
            for(Desecho desecho : desechos){
                dataset.addValue(desecho.getCantidad(), "Desecho", desecho.getCategoria());
            }
        }
      return dataset; 
   }
}