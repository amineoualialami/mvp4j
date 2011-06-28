package com.profiler.client;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.SourcesTableEvents;
import com.google.gwt.user.client.ui.TableListener;

public class Table extends FlexTable implements TableListener {

	private String headerStyle;
	private String selectedStyle;
	private TableDataSource source;
	private int selectedRow;
	
	
	public Table(TableDataSource source, String stylePrefix) {
		super();
		this.setCellPadding(1);
		this.setCellSpacing(0);
		//this.setWidth("100%");
		this.selectedStyle = stylePrefix + "-selected";
		this.headerStyle= stylePrefix +  "-header";
		this.addTableListener(this);
		this.setSource(source);
	}
	
	
	
	
	@Override
	public void onCellClicked(SourcesTableEvents sender, int row, int cell) {
		// TODO Auto-generated method stub
		
	}




	public void setSource(TableDataSource source) {
		 for( int i = this.getRowCount(); i > 0; i-- ){
	            this.removeRow( 0 );
	        }
	        if( source == null ){
	            return;
	        }
	        
	        int row = 0;
	        String[] headers = source.getHeaderRow();
	        if( headers != null ){
	            for( int i=0; i < headers.length; i++ ){
	                this.setText( row, i , headers[i] );
	            }
	            this.getRowFormatter().addStyleName( row, headerStyle );
	            row++;
	        }
	        int rows = source.getRowCount();
	        for( int i=0 ; i <rows; i++ ){
	            String[] values = source.getRow(i);
	            for( int col=0; col < values.length; col++ ){
	                this.setText( row, col, values[col] );
	            }
	            row++;
	        }
	        this.selectedRow = 0;
	        this.source = source;
	}
	
	
	

}
