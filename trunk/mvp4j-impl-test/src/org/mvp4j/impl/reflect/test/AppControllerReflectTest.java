package org.mvp4j.impl.reflect.test;



import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import javax.swing.JTextField;




import org.junit.Test;

import org.mvp4j.impl.reflect.AppControllerReflect;



import junit.framework.Assert;
import junit.framework.TestCase;

public class AppControllerReflectTest extends TestCase {
	
	public AppControllerReflect appController = new AppControllerReflect();
    
	public ViewClass viewClass;
	public ModelClass modelClass;
	public PresenterClass presenterClass;
	
	

	@Test
	public void testBindModel(){
		modelClass=new ModelClass();
		viewClass=new ViewClass();
		
		
		
		JTextField jtextfield=(JTextField) viewClass.getNameTextField();
		
		//JTextField4Test jtextfield=new JTextField4Test();
		
		jtextfield.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				System.out.println("The event of the JTextField is invoked");
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				System.out.println("The event of the JTextField is invoked");
				
			}
			
		});
		
		FocusEvent e=new FocusEvent(jtextfield,FocusEvent.FOCUS_GAINED);
		
		class Profil{
			private String nom;
			private Integer id;
			public Profil(String nom,Integer id){
				this.nom=nom;
				this.id=id;
			}
			public String getNom() {
				return nom;
			}
			public void setNom(String nom) {
				this.nom = nom;
			}
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			
		}
		Profil profil=new Profil("nom",1);
		List<Object> profils=new ArrayList<Object>();
		profils.add(profil);
		modelClass.setProfils(profils);
		JTable jtable=(JTable)viewClass.getTable();
		
		
		JComboBox jcombobox=(JComboBox)viewClass.getProfilComboBox();
	    
		appController.bindModel(viewClass,modelClass);
		Assert.assertTrue(viewClass.getTable().getRowCount()==1);
		Assert.assertTrue(viewClass.getProfilComboBox().getItemCount()==1);
	
		
	}
	
	@Test
	public void testBindPresenter(){
	
		presenterClass=new PresenterClass("");
		modelClass=new ModelClass();
	    ViewClass viewClass=new ViewClass();
		appController.bindPresenter(viewClass, presenterClass);
		JButton okButton=viewClass.getOkButton();	
		Assert.assertTrue("The MVP wasn't able to associate an event listener to this component",okButton.getActionListeners().length!=0);		 	 
		okButton.doClick();
		
          
	}
	
	
	
	
//@Test
	/*public void testprocessView() {
		
		
		
		
		
		
		
		
		try {
			Class appControllerClass = appController.getClass();
			Method processViewMethod=null ;

			Method[] methods = appControllerClass.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().equals("processView")){
					processViewMethod = method;
					processViewMethod.setAccessible(true);
					break;
				}
			}
			
			
			
			Map<String, ActionViewPresenterInfo> actionInfoMap = new HashMap<String, ActionViewPresenterInfo>();
			Map<String, ModelViewInfo> modelViewInfoMap = new HashMap<String, ModelViewInfo>();

			List<ActionInfo> actionsInfo = new ArrayList<ActionInfo>();
			List<ModelInfo> modelsInfo = new ArrayList<ModelInfo>();
			
			ActionViewPresenterInfo actionViewPresenterInfo = new ActionViewPresenterInfo();
			ModelViewInfo modelViewInfo = new ModelViewInfo();
			
			ActionInfo actionInfo = new ActionInfo();
			actionInfo.setAction("addUser");
			actionInfo.setActionMethod(PresenterClass.class.getDeclaredMethod("addUser"));
			actionInfo.setEventType(ActionListener.class);
			actionInfo.setMethod(ViewClass.class.getDeclaredMethod("getOkButton"));
			
			actionsInfo.add(actionInfo);
		    
			actionViewPresenterInfo.setActionsInfo(actionsInfo);
			actionViewPresenterInfo.setViewClass(ViewClass.class);
			actionViewPresenterInfo.setPresenterClass(PresenterClass.class);

			actionInfoMap.put(ViewClass.class.toString(), actionViewPresenterInfo);
			
			
			ModelInfo modelInfo = new ModelInfo();
			modelInfo.setPropertyName("name");
			modelInfo.setIniPropertyName("");
			modelInfo.setMethod(ViewClass.class.getDeclaredMethod("getNameTextField"));
			
			ModelInfo modelInfo2= new ModelInfo();
			modelInfo2.setIniPropertyName("profils");
			modelInfo2.setPropertyName("profil");
			modelInfo2.setMethod(ViewClass.class.getDeclaredMethod("getProfilComboBox"));
			
			ModelInfo modelInfo3=new ModelInfo();
			modelInfo3.setIniPropertyName("profils");
			modelInfo3.setPropertyName("");
			modelInfo3.setMethod(ViewClass.class.getDeclaredMethod("getTable"));
			
			modelsInfo.add(modelInfo);
			modelsInfo.add(modelInfo2);
			modelsInfo.add(modelInfo3);
			
			modelViewInfo.setModelsInfo(modelsInfo);
			modelViewInfo.setModelClass(ModelClass.class);
			modelViewInfo.setViewClass(ViewClass.class);
			
			modelViewInfoMap.put(ViewClass.class.toString(), modelViewInfo);
			
	//		processViewMethod.invoke(appController, new ViewClass().getClass());
			
//			Field field = AppControllerReflect.class.getDeclaredField("actionInfoMap");
//			field.setAccessible(true);
//			Object object = field.get(appController);
			
			
			
			Method method = appControllerClass.getDeclaredMethod("getActionInfoMap");
			Object object = method.invoke(appController);
			
			
			
			
			Map<String, ActionViewPresenterInfo> actionInfoMapProcessView = (Map<String, ActionViewPresenterInfo>) object;
			System.out.println(actionInfoMapProcessView.get(ViewClass.class.toString()).getViewClass());
			System.out.println(actionInfoMapProcessView.get(ViewClass.class.toString()).getPresenterClass());
			
			System.out.println(actionInfoMap.get(ViewClass.class.toString()).getViewClass());
			System.out.println(actionInfoMap.get(ViewClass.class.toString()).getPresenterClass());
			
			
			
			//assertEquals(actionInfoMap.get(ViewClass.class.toString()).getActionsInfo(), actionInfoMapProcessView.get(ViewClass.class.toString()).getActionsInfo());
			//assertEquals(actionInfoMap, actionInfoMapProcessView);
			//assertTrue(actionInfoMap.get(ViewClass.class.toString()).getActionsInfo().equals(actionInfoMapProcessView.get(ViewClass.class.toString()).getActionsInfo()));
			
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}
	*/
	
}
