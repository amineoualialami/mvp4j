# How to use JButton #

This page explains how to use JButton  component with  MVP4J

we define the class that represents the view

```
@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

  @Action(name = "actionExemple" EventType=MouseListener.class , EventAction="mouseEntered")
  JButton button;

  public ClientView() {

		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		add(getButton());
	}


  
  public JButton getButton() {
		if (button == null) {
			button = new JButton("OK");
			button.setBounds(10, 10, 70, 40);

		}
		return button;
	}

}
```

The Presenter Class

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


  * The **_name_** attribute of the @ Action annotation is the name of the action, in this case **actionExemple** is the method that is raised at the event, it must be defined in the class of Presenter.
  * Attribute **_EventType_** is the type of triggering event, it's an optional property of the annotation, if no one defined, MVP4J defines the default ActionListener event.
  * If the EventType supports many events, you can specify a single event through the attribute **EventAction** , if it does not specify, all the events of **_EventType_** will be invoked and bind with the action defined in the Presenter.
  * If the attribute **_name_** does not refer to a previous action in the present class, an **ActionNotFoundException** is thrown.