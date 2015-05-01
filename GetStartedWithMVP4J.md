# Get started with MVP4J #

## Installation ##

to integrate MVP4J to your project you need to add the latest jar of

Before we start you must add the latest jar of mvp4j to your project :
  * Swing Application : mvp4j-api-x.x.jar and mvp4j-impl-swing-x.x.jar
  * GWT Application : mvp4j-api-x.x.jar and mvp4j-impl-gwt-x.x.jar ( comming soon )

## Define the entry point ##
We must get the appController object using the factory   AppControllerReflectFactory.getAppControllerInstance ()

```

public class Launch {

	public static void main(String[] args) {

            		
         ClientView view = new ClientView();
         ClientModel model = new ClientModel();
	 ClientPresenter presenter = new ClientPresenter(view, model);
		
         view.setVisible(true);
		
		
	AppControllerReflect appController = AppControllerReflectFactory
				.getAppControllerInstance();
	appController.bind(view, model, presenter);
		

      }
```

We instantiate the different classes ClientView, and ClientModel ClientPresenter representing layers of our client application, then we pass them as parameters to the bind method.

## Annotate the View Class ##
```
@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

@Action(name = "actionExemple")
JButton button;

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
		add(getButton());
	}


  
  public JButton getButton() {
		if (button == null) {
			button = new JButton("OK");
			button.setBounds(10, 10, 70, 40);

		}
		return button;
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

## Create the model class ##

```
public class ClientModel implements Serializable {

	private String modelProperty;
      
      public String getModelProperty() {
		return modelProperty;
	}

	public void setModelProperty(String modelProperty) {
		this.modelProperty = modelProperty;
	}
}
```

## Create the presenter class ##

```
public class ClientPresenter {

  ClientView view;
  ClientModel model;

	
  public ClientPresenter(ClientView view, ClientModel model) {
	this.view = view;
	this.model = model;
  }
	
   public void actionExemple(){
	System.out.println("Hello world, this action event work just fine");
  }
}
```