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

	public FWContext() {
		try {
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
		Properties properties = ConfigFileReader.getConfigProperties();
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
		Object service = null;
		try {
			for (Object theTestClass : objectMap) {
				Class<?>[] interfaces = theTestClass.getClass().getInterfaces();

				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName()))
						service = theTestClass;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

}
