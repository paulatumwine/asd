package framework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

	private static List<Object> objectMap = new ArrayList<>();
	Properties properties;
	String activeProfile;


	public FWContext() {
		try {
			properties = ConfigFileReader.getConfigProperties();
			activeProfile= properties.getProperty("activeprofile");
			// find and instantiate all classes annotated with the @Service annotation
			Reflections reflections = new Reflections("");
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> implementationClass : types) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		performReferenceDI();
		performStringDI();
	}

	private void performReferenceDI() {
		try {
			for (Object theTestClass : objectMap) {
				// find annotated fields
				for (Field field : theTestClass.getClass().getDeclaredFields()) {
					if (field.isAnnotationPresent(Inject.class)) {
						// get the type of the field
						Class<?> theFieldType = field.getType();
						// get the object instance of this type
						Object instance = getBeanOftype(theFieldType);
						// do the injection
						field.setAccessible(true);
						field.set(theTestClass, instance);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void performStringDI() {
		try {
			for (Object theTestClass : objectMap) {
				// find annotated fields
				for (Field field : theTestClass.getClass().getDeclaredFields()) {
					if (field.isAnnotationPresent(Inject.class)) {
						// get the type of the field
						Class<?> theFieldType = field.getType();
						if (field.getType().getName().contentEquals("java.lang.String")) {
							// get attribute value
							String attrValue = field.getAnnotation(Inject.class).value();
							// get the property value
							String toBeInjectedString = properties.getProperty(attrValue);
							// do the injection
							field.setAccessible(true);
							field.set(theTestClass, toBeInjectedString);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBeanOftype(Class interfaceClass) {
		List<Object> objectList = new ArrayList<Object>();
		try {
			for (Object theTestClass : objectMap) {
				Class<?>[] interfaces = theTestClass.getClass().getInterfaces();

				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName()))
						objectList.add(theTestClass);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (objectList.size() < 1) return null;
		if (objectList.size() == 1) return objectList.get(0);
		if (objectList.size() > 1) {
			for (Object theObject : objectList) {
				String profilevalue = theObject.getClass().getAnnotation(Profile.class).value();
				if (profilevalue.contentEquals(activeProfile)) {
					return theObject;
				}
			}
		}
		return null;
	}

}
