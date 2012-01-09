package org.mvp4j.impl.reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvp4j.AppController;
import org.mvp4j.adapter.ActionComponent;
import org.mvp4j.adapter.MVPAdapter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.annotation.Action;
import org.mvp4j.annotation.Actions;
import org.mvp4j.annotation.MVP;
import org.mvp4j.annotation.Model;
import org.mvp4j.exception.ActionNotFoundException;
import org.mvp4j.impl.gwt.GwtAdapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Constructor;
import com.gwtent.reflection.client.Field;
import com.gwtent.reflection.client.Method;
import com.gwtent.reflection.client.TypeOracle;

public class AppControllerReflect implements AppController {

	public static final MVPAdapter DEFAULT_ADAPTER = new GwtAdapter();

	private MVPAdapter currentAdapter = DEFAULT_ADAPTER;

	private Map<String, ActionViewPresenterInfo> actionInfoMap = new HashMap<String, ActionViewPresenterInfo>();
	private Map<String, ModelViewInfo> modelViewInfoMap = new HashMap<String, ModelViewInfo>();
	private Map<Object, Object> mapViewModel = new HashMap<Object, Object>();

	private MVPBinding mvpBinding;

	@Override
	public MVPBinding bind(Object view, Object model, Object presenter) {
		System.out.println("call bind OK");
		Window.alert("alert");
		mvpBinding = new MVPBindingImpl();
		bindModel(view, model,mvpBinding);
		bindPresenter(view, presenter,mvpBinding);
		return mvpBinding;
	}

	private MVPBinding bindModel(Object view, Object model,
			MVPBinding mvpBinding) {

		// logger.info("Bind View :" + view.getClass().getName().toString()
		// + " with model :" + model.getClass().getName().toString());
		GWT.log("Bind View :" + view.getClass().getName().toString()
				+ " with model :" + model.getClass().getName().toString());

		mvpBinding.setView(view);
		mvpBinding.setModel(model);

		if (modelViewInfoMap.get(view.getClass().toString()) == null) {
			processView(view.getClass());
		}
		ModelViewInfo modelViewInfo = modelViewInfoMap.get(view.getClass()
				.toString());
		if (mapViewModel.get(view) == null) {
			mapViewModel.put(view, model);
		}

		List<ModelInfo> modelsInfo = modelViewInfo.getModelsInfo();
		for (ModelInfo modelInfo : modelsInfo) {
			Method method = modelInfo.getMethod();
			Object object = method.invoke(view);

			ClassType<? extends ModelComponent> componentModelClass = TypeOracle.Instance
					.getClassType(currentAdapter.getComponentModel(object
							.getClass()));

			Constructor<? extends ModelComponent> constructor = componentModelClass
					.findConstructor();

			ModelComponent componentModel = (ModelComponent) constructor
					.newInstance();
			componentModel.init(new ModelBindingImpl(view, model,
					modelInfo,mvpBinding));
			modelInfo.setComponentModel(componentModel);
			componentModel.bind();

		}

		// logger.info("Exit Bind View :" + view.getClass().getName().toString()
		// + " with model :" + model.getClass().getName().toString());

		GWT.log("Exit Bind View :" + view.getClass().getName().toString()
				+ " with model :" + model.getClass().getName().toString());
		return mvpBinding;
	}

	@Override
	public MVPBinding bindModel(Object view, Object model) {

		mvpBinding = new MVPBindingImpl();
		bindModel(view, model, mvpBinding);
		return mvpBinding;
	}

	private MVPBinding bindPresenter(Object view, Object presenter,
			MVPBinding mvpBinding) {
		// logger.info("Bind View :" + view.getClass().getName().toString()
		// + " with presenter :"
		// + presenter.getClass().getName().toString());

		GWT.log("Bind View :" + view.getClass().getName().toString()
				+ " with presenter :"
				+ presenter.getClass().getName().toString());

		mvpBinding.setView(view);
		mvpBinding.setPresenter(presenter);

		if (actionInfoMap.get(view.getClass().toString()) == null) {
			processView(view.getClass());
		}
		ActionViewPresenterInfo actionViewPresenterInfo = actionInfoMap
				.get(view.getClass().toString());

		List<ActionInfo> actionsInfo = actionViewPresenterInfo.getActionsInfo();
		for (ActionInfo actionInfo : actionsInfo) {

			Object component = actionInfo.getMethod().invoke(view);
			ClassType<? extends ActionComponent> componentActionClassType = TypeOracle.Instance
					.getClassType(currentAdapter.getComponentAction(component
							.getClass()));
			Constructor<? extends ActionComponent> constructor = componentActionClassType
					.findConstructor();

			// ActionComponent componentAction = (ActionComponent)
			// constructor
			// .newInstance(new ActionBindingImpl(view, presenter,
			// actionInfo));
			ActionComponent componentAction = (ActionComponent) constructor
					.newInstance();
			componentAction.init(new ActionBindingImpl(view,
					presenter, actionInfo));
			componentAction.bind();

		}

		// logger.info(" Exit Bind View :" +
		// view.getClass().getName().toString()
		// + " with presenter :"
		// + presenter.getClass().getName().toString());
		GWT.log(" Exit Bind View :" + view.getClass().getName().toString()
				+ " with presenter :"
				+ presenter.getClass().getName().toString());
		return mvpBinding;
	}

	@Override
	public MVPBinding bindPresenter(Object view, Object presenter) {

		mvpBinding = new MVPBindingImpl();
		bindPresenter(view, presenter, mvpBinding);

		return mvpBinding;
	}

	@Override
	public void refreshView(Object view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAdapter(MVPAdapter adapter) {
		currentAdapter = adapter;

	}

	public MVPAdapter getCurrentAdapter() {
		return currentAdapter;
	}

	private void processView(Class<?> viewClass) {

		// logger.info("Parsing View");
		GWT.log("Parsing View");
		ClassType viewClassType = TypeOracle.Instance.getClassType(viewClass);

		if (viewClassType.getAnnotation(MVP.class) == null) {
			// logger.severe("MVP annotation is missed " + viewClass.getName());
			GWT.log("MVP annotation is missed " + viewClass.getName());
			throw new IllegalArgumentException();
		}
		MVP mvp = viewClassType.getAnnotation(MVP.class);

		List<ActionInfo> actionsInfo = new ArrayList<ActionInfo>();
		List<ModelInfo> modelsInfo = new ArrayList<ModelInfo>();

		Field[] listFieldsView = viewClassType.getFields();
		Method[] listMethodsView = viewClassType.getMethods();
		Class<?> presenterClass = mvp.presenterClass();
		ClassType presenterClassType = TypeOracle.Instance
				.getClassType(presenterClass);
		Method[] listMethodsPresenter = presenterClassType.getMethods();
		Class<?> modelClass = mvp.modelClass();

		for (Field field : listFieldsView) {
			if (field.isAnnotationPresent(Action.class)) {
				Method method = findMethod(field, viewClass);
				Action action = field.getAnnotation(Action.class);
				actionsInfo.add(initActionInfo(method, action));
			}
		}

		for (Method method : listMethodsView) {
			if (method.isAnnotationPresent(Action.class)) {
				if (!fieldIsAnnotated(method, viewClass)) {
					Action action = method.getAnnotation(Action.class);
					actionsInfo.add(initActionInfo(method, action));
				}
			}
		}

		for (Field field : listFieldsView) {
			if (field.isAnnotationPresent(Model.class)) {
				Method method = findMethod(field, viewClass);
				Model model = field.getAnnotation(Model.class);
				modelsInfo.add(initModelInfo(method, model));
			}
		}

		for (Method method : listMethodsView) {
			if (method.isAnnotationPresent(Model.class)) {
				Model model = method.getAnnotation(Model.class);
				if (!fieldIsAnnotated(method, viewClass)) {
					modelsInfo.add(initModelInfo(method, model));
				}

			}
		}

		for (Field field : listFieldsView) {
			if (field.isAnnotationPresent(Actions.class)) {
				Method method = findMethod(field, viewClass);
				Actions actions = field.getAnnotation(Actions.class);
				Action[] listActions = actions.value();

				for (Action action : listActions) {
					actionsInfo.add(initActionInfo(method, action));
				}
			}
		}

		for (Method method : listMethodsView) {
			if (method.isAnnotationPresent(Actions.class)) {
				if (!fieldIsAnnotated(method, viewClass)) {
					Actions actions = method.getAnnotation(Actions.class);
					Action[] listActions = actions.value();
					for (Action action : listActions) {
						actionsInfo.add(initActionInfo(method, action));
					}
				}
			}
		}

		for (ActionInfo actionInfo : actionsInfo) {
			for (Method method : listMethodsPresenter) {
				if (method.getName().equals(actionInfo.getAction())) {
					// logger.info("Action in Presenter Match ===> Action name: "
					// + actionInfo.getAction() + "  Method name: "
					// + method.getName());

					GWT.log("Action in Presenter Match ===> Action name: "
							+ actionInfo.getAction() + "  Method name: "
							+ method.getName());
					actionInfo.setActionMethod(method);
				}
			}
			if (actionInfo.getActionMethod() == null) {
				// logger.severe("Action " + actionInfo.getAction() +
				// " not match ");
				GWT.log("Action " + actionInfo.getAction() + " not match ");
				throw new ActionNotFoundException(actionInfo.getAction(),
						presenterClass);
			}
		}

		ActionViewPresenterInfo actionViewPresenterInfo = processViewPresenter(
				viewClass, presenterClass, actionsInfo);

		actionInfoMap.put(viewClass.toString(), actionViewPresenterInfo);

		ModelViewInfo modelViewInfo = processViewModel(viewClass, modelClass,
				modelsInfo);

		modelViewInfoMap.put(viewClass.toString(), modelViewInfo);
		// logger.info("Exit Parsing View");
		GWT.log("Exit Parsing View");

	}

	private ActionViewPresenterInfo processViewPresenter(Class<?> viewClass,
			Class<?> presenterClass, List<ActionInfo> actionsInfo) {
		for (ActionInfo actionInfo : actionsInfo) {
			// logger.info("----- Action Name: " + actionInfo.getAction()
			// + " Method: " + actionInfo.getMethod().getName()
			// + " Action Method: "
			// + actionInfo.getActionMethod().getName()
			// + " Action EventType: "
			// + actionInfo.getEventType().getName());
			GWT.log("----- Action Name: " + actionInfo.getAction()
					+ " Method: " + actionInfo.getMethod().getName()
					+ " Action Method: "
					+ actionInfo.getActionMethod().getName()
					+ " Action EventType: "
					+ actionInfo.getEventType().getName());
		}
		ActionViewPresenterInfo actionViewPresenterInfo = new ActionViewPresenterInfo();
		actionViewPresenterInfo.setViewClass(viewClass);
		actionViewPresenterInfo.setPresenterClass(presenterClass);
		actionViewPresenterInfo.setActionsInfo(actionsInfo);
		return actionViewPresenterInfo;
	}

	private ModelViewInfo processViewModel(Class<?> viewClass,
			Class<?> modelClass, List<ModelInfo> modelsInfo) {
		for (ModelInfo modelInfo : modelsInfo) {
			// logger.info("----- Property Name: " + modelInfo.getPropertyName()
			// + " Init Property Name: " + modelInfo.getIniPropertyName()
			// + " Method: " + modelInfo.getMethod().getName());
			GWT.log("----- Property Name: " + modelInfo.getPropertyName()
					+ " Init Property Name: " + modelInfo.getIniPropertyName()
					+ " Method: " + modelInfo.getMethod().getName());
		}
		ModelViewInfo modelViewInfo = new ModelViewInfo();
		modelViewInfo.setViewClass(viewClass);
		modelViewInfo.setModelClass(modelClass);
		modelViewInfo.setModelsInfo(modelsInfo);
		return modelViewInfo;
	}

	private ActionInfo initActionInfo(Method method, Action action) {
		ActionInfo actionInfo = new ActionInfo();
		actionInfo.setAction(action.name());
		actionInfo.setMethod(method);
		actionInfo.setEventType(action.EventType());
		actionInfo.setEventAction(action.EventAction());
		return actionInfo;
	}

	private ModelInfo initModelInfo(Method method, Model model) {

		ModelInfo modelInfo = new ModelInfo();
		modelInfo.setPropertyName(model.property());
		modelInfo.setIniPropertyName(model.initProperty());
		modelInfo.setMethod(method);
		return modelInfo;
	}

	private Method findMethod(Field field, Class<?> viewClass) {

		ClassType viewClassType = TypeOracle.Instance.getClassType(viewClass);
		Method method = viewClassType.getMethod("get"
				+ (field.getName().charAt(0) + "").toUpperCase()
				+ field.getName().substring(1), null);

		return method;
	}

	private boolean fieldIsAnnotated(Method method, Class<?> viewClass) {
		boolean annotated = false;

		ClassType viewClassType = TypeOracle.Instance.getClassType(viewClass);
		Field field = viewClassType.getField((method.getName().charAt(3) + "")
				.toLowerCase() + method.getName().substring(4));

		if (field.isAnnotationPresent(Action.class)
				|| field.isAnnotationPresent(Model.class)
				|| field.isAnnotationPresent(Actions.class)) {
			annotated = true;
		}

		return annotated;
	}

	public Map<String, ActionViewPresenterInfo> getActionInfoMap() {
		return actionInfoMap;
	}

	public void setActionInfoMap(
			Map<String, ActionViewPresenterInfo> actionInfoMap) {
		this.actionInfoMap = actionInfoMap;
	}

	public Map<String, ModelViewInfo> getModelViewInfoMap() {
		return modelViewInfoMap;
	}

	public void setModelViewInfoMap(Map<String, ModelViewInfo> modelViewInfoMap) {
		this.modelViewInfoMap = modelViewInfoMap;
	}

	public MVPBinding getMvpBinding() {
		return mvpBinding;
	}

}
