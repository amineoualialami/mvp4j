# How to use JTextField #

### The view class ###

```
@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

@Model(property = "modelProperty")
JTextField textField;

public ClientView() {

		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		add(getTextField());
	}


public JTextField getTextField() {
	if (textField == null) {
			textField = new JTextField();
			textField.setBounds(70, 150, 150, 30);

	}
	return textField;
   }

  

}

```

### The model class ###

```
public class ClientModel implements Serializable {

	private String modelProperty;
      
      public String getModelProperty() {
		return modelProperty;
	}

	public void setModelProperty(String modelProperty) {
		this.modelProperty = modelProperty;
	}
```

  * The **_property_**  Attribute of the annotation @Model goes directly linked the value of text field to the attribute of the model specified, in this case _ModelProperty_
  * If the attribute  **_property_** does not refer to an object existing in the model class, a **PropertyNotFoundException** exception is thrown.