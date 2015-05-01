# How to create a customized model component for a view specific component #

MVP4j provides a set of  predefined model components, this model component represents the rules of the bind between the view and the model entities. However, some programmers may need to define or modify those bind rules for a special need, to make it possible, The interface MVPBinding allow the programmer,through the method **setComponentModel**, to assign a customized model component to a specific view component.

## A Customized Model Component ##
Example: A Customized Model Component for **JTable**
```
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.impl.swing.JTableModelComponent;

public class CustomizedTableModel extends JTableModelComponent {
@Override
public Object initTableModel(Map<String, String> customizedColumns)
	{     
                getCustomizedColumns().put("name","name");
		getCustomizedColumns().put("date","date");
                // first param is the name of the property present in the class of initProperty
                // second param is the chosen name of the customized column of JTable

		return super.initTableModel(getCustomizedColumns());
	}	
}
```
**JTableModelComponent** contains a method called _initTableModel_ on which mvp4j is based to set the JTable model (**dont confuse the JTable model with the model entity**) by a model based on the values specified on the initProperty on the view:

```
        @Model(initProperty = "users", property = "user")
	JTable table;
```

We suppose that users had a lot of attributes(name,phone,mail,date ...) but the programmer need to keep just two of them for table columns (name and date), by using a customizedTableModel , particularly by overriding the method **initTableModel** of that class, the programmer pass to the initTableModel Method the new Columns, the first parameter is the name of the column and the second is the name of the attribute .

## Assign the Customized Model Component to an appropriate combination of the layers View,Model and presenters ##

```
public class Launch {

	public static void main(String[] args) {
       	UserView view = new UserView();
        UserModel model = new UserModel();
        UserPresenter presenter = new UserPresenter(view, model);
        MVPBinding mvpBinding = appController.bind(view, model, presenter);
        mvpBinding.setComponentModel(view.getTable(),CustomizedTableModel.class)

        ;}
}
```

**MVPBinding** is an interface that symbolizes the combination between one view, one model and one presenter according to MVP design pattern, it is implemented dependently of the library (Swing, GWT ...), it contains useful methods to get control over MVP4J functionalists. For this moment, we use it's method **setComponentModel** to assign ower CustomizedTableModel to the Table Component of the view.
**NB: you can have more than one Customized Model Component for more than one table of the view**