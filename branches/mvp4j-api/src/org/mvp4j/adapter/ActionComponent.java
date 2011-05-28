package org.mvp4j.adapter;


/**
 * <p>
 * This class is used to simplify the binding between the event 
 * of the current component in the view and associated action in the presenter
 * and simplify add event and action call operations during implementing an adapter class {@link MVPAdapter} to a specific library.
 * <p>
 * The user can use the instance actionBinding of type {@link ActionBinding} 
 * to add an event to the current view component and call the associated action in the current presenter.
 * 
 * Example with JButton in Swing Adapter :
 public class JButtonEventActionComponent extends ActionComponenet {

	private JButton button;
	private ActionBinding actionBinding;	
	private static final Class<?> DEFAULT_EVENT_TYPE = ActionListener.class;	
	private ActionListener listener = null;

	public JButtonEventActionComponent(ActionBinding actionBinding) {
		super(actionBinding);
		this.button = (JButton) actionBinding.getComponent();
		this.eventActionBinding = actionBinding;
	}

	@Override
	public void bind() {
		Class<?> eventType = actionBinding.getEventType();
		if(eventType == null)
			eventType = DEFAULT_EVENT_TYPE;
		if(eventType == ActionListener.class){
			listener = new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					actionBinding.callAction();					
				}
			};
			button.addActionListener( listener);
		}else
			throw new IllegalArgumentException("The event type is not supported");
		
	}
	@Override
	public void unbind() {
		button.removeActionListener(listener);
		
	}

}
 *
 */
public abstract class ActionComponent {
	
	/**
	 * This field is useful to interact with the component and presenter and get all binding informations.
	 */
	private ActionBinding actionBinding;
	
	
	/**
	 * initialize the actionComponent with the necessary parameters  
	 * @param actionBinding
	 */
	public abstract void initActionComponent(ActionBinding actionBinding);
	
	/**
	 * Bind the current component with the current action in the presenter
	 * Add the current type event(or the default event if is not specified) to the current view component 
	 * and call the presenter action associated when the event is invoked
	 * if the event type is specified and is not supported, than throw an {@link IllegalArgumentException}
	 */
	public abstract void bind();
	
	/**
	 * Unbind the current component with the current presenter action,
	 * remove the event added by the method bind
	 */
	public abstract void unbind();

	/**
	 * Get the This field to interact with the component and presenter and get all binding informations.
	 * @return ActionBinding
	 */
	public ActionBinding getEventActionBinding() {
		return actionBinding;
	}		
	
}
