# How to use JComboBox #

### The vue class ###

```


@MVP(modelClass = ClientModel.class, presenterClass = ClientPresenter.class)
public class ClientView extends JFrame {

@Model(property = "profil", initProperty = "profils")
JComboBox comboBox;

public ClientView() {

		setTitle("Client Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanel());
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
                add(getComboBox ());

	}


      
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(70, 60, 150, 30);

		}
		return comboBox;
	}



}
```

### The model class ###

```
public class ClientModel implements Serializable {

      private ProfilDTO profil;
    
      private List<ProfilDTO> profils; 
 
      public ProfilDTO getProfil() {
		return profil;
	}
      public List<ProfilDTO> getProfils() {
              //some code to retrieve profils
	      return profils;
	}
```


  * **_initProperty_** Attribute contains _profils_ property which is of type List _ProfilDTO_, it will be used to populate the combobox, it must first be initialized in the model (see example), the list can contain any type of object but it must redefine the toString () method.
  * When the selection of the JCombobox changes the property of the model **_profil_** is automatically initialized by the selected profile, the attribute **_property_** must contain the same type as the object present in the attribute **_initProperty_**.
  * If the **_initProperty_** or **_property_** attributs does not refer to existing objects in the model class, a PropertyNotFoundException is thrown.
  * If the **_initProperty_** attribute refers to an Object Model that is not initialized, a PropertyNotInitializedException is thrown.
  * If the **_initProperty_** attribute refers to an object type model that does not implement the Collection interface, a PropertyNotBindableException is thrown.