_MVP4J_ is a useful framework that is based primarily on practical design pattern MVP (Model View Presenter), therefore it facilitates the development of presentation layer technologies based on the principle of development events, it supports the different libraries _Swing_, _AWT_ and _GWT ( comming very soon )._



# **Introduction :** #
> Mvp4j provides a set of software components flexible and scalable, it's able to produce an application easy to maintain, these components are organized to be used in interaction with each other, in some advanced use cases, mvp4j allows the developer to implement its own component.
> Mvp4j requires an architecture based on the MVP design pattern to separate the layers described in classes and defining the responsibilities of each

# **Architecture :** #

![http://nsa29.casimages.com/img/2012/12/30/12123010340895171.png](http://nsa29.casimages.com/img/2012/12/30/12123010340895171.png)

> ## **The View ##
The view is the main element of the framework, it consists of a set of core graphics component used in a single class or in some cases a set of classes with one that manages vision, called the class of the view (View class),access to the graphic components of the class of sight must pass through getter methods like getters of java beans.**

Example :

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

> ## **The Model ##
Each view is associated with a single model, which is specified in a class that should have accessors (getter and setter) like the java beans, accessors access the data model used by the view.**

Example :

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

> ## **The Presenter ##
The presenter manages the view, combining the events of the Views to the Presenter methods , these action methods must be defined in a java class called the Presenter class.**

Example :

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


> ## **The Appcontroller ##**

Mvp4j provides a set of annotations to bind the three layers View, Model and Presenter, the AppController is a special class that collect these annotations, perform error checking and bind values displayed on a graphic component of the view to a property or event of the present action.

> ## **The Adapter ##**

The adapter contains two types of components, Action Components and Model Components, they react dynamically to any type of UI component that can compose a view.
Mvp4j implements two native adapters, Swing adapter and Gwt Adapter


# **The Annotations of MVP4J :** #

> ## **@MVP ##
The @ MVP annotation is used in the View class to associate the Presenter class and the Model class.**

> Example :

```
@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView {

}
```

> ## **@Action ##
The @ Action annotation is also used in the view, it helps define an action when an event is fired by a component in the view.**

Example :

```
@Action(name="addUser")	
JButton button;
	
```

> ## **@Model ##
This annotation is used to link the view component to the properties of the model**

Example :
```
@Model(property="name")
JTextField textField;

```

_more information about a specific component, follow the link TableOfContent_