package org.mvp4j.impl.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.exception.PropertyNotBindableException;

import org.mvp4j.impl.swing.utils.JtableUtils;
import org.mvp4j.impl.swing.utils.LoggerUtils;

public class JTableModelComponent extends ModelComponent {

	private JTable table;
	private MouseListener mouseListener;
	private ModelBinding modelBinding;
	private List<Object> initValues;
	private DefaultTableModel tableModel;
	private Map<String , String > customizedColumns;
	private Logger logger = LoggerUtils.getLogger();

	public JTableModelComponent(ModelBinding modelBinding) {
		super(modelBinding);
		this.modelBinding = modelBinding;
		table = (JTable) modelBinding.getComponent();
		try {
			initValues = (List<Object>) modelBinding.getInitPropertyValue();
		}
		catch (ClassCastException e) {
			logger.error("initProperty '"+modelBinding.getInitPropertyName()+"' must be Collection");
        	throw new PropertyNotBindableException(
					modelBinding.getInitPropertyName(), modelBinding
							.getInitPropertyName().getClass(),
							table.getClass());
        	
		}
	}

	@Override
	public void bind() {
	   
		final Runnable runInit=new Runnable(){

			@Override
			public void run() {
				table.setModel((DefaultTableModel) initTableModel(getCustomizedColumns()));
				
			}
			
		};
	
		try {
			SwingUtilities.invokeAndWait(runInit);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		mouseListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public  void mousePressed(MouseEvent e) {
				
				modelBinding.setPropertyValue(initValues.get(table
						.getSelectedRow()));
				
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		table.addMouseListener(mouseListener);
	}

	@Override
	public void unbind() {
		System.out.println("unbind");
		tableModel = null;

	}
	public Object initTableModel(Map<String , String > customizedColumns) {
		if (tableModel == null) {
			tableModel = new DefaultTableModel();
			initValues = (List<Object>) modelBinding.getInitPropertyValue();
				List<Object> listObject = JtableUtils.getColumns(initValues,getCustomizedColumns());
				List columns = new ArrayList();

				for (Object field : listObject) {
					columns.add(field.toString());
				}

				tableModel.setColumnIdentifiers(columns.toArray());
               
				for (Object object2 : (List) initValues) {
					tableModel.addRow(JtableUtils.getRow(object2).toArray());
				}

		}
		return tableModel;
	}

	public Map<String, String> getCustomizedColumns() {
  	if(customizedColumns ==null){
		customizedColumns= new HashMap<String, String>();
		}
		return customizedColumns;
	}

	public void setCustomizedColumns(Map<String, String> customizedColumns) {
		this.customizedColumns = customizedColumns;
	}

	@Override
	public void setConverter(Converter converter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Converter getConverter() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	

}
