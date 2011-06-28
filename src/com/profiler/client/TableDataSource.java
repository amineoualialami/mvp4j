package com.profiler.client;

public interface TableDataSource {
	
	public String[] getHeaderRow();
	public int getRowCount();
	public String[] getRow(int row);

}
