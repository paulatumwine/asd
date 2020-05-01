package framework;

import java.lang.reflect.Field;

public class FWApplication {

	public static void run(Class applicationClass) {
        // create the context
		FWContext fWContext = new FWContext();
        
		try {
			// create instance of the application class
			Object applicationObject = (Object) applicationClass.newInstance();
			// find annotated fields
			for (Field field : applicationObject.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(Inject.class)) {
					// get the type of the field
					Class<?> theFieldType = field.getType();
					// get the object instance of this type
					Object instance = fWContext.getBeanOftype(theFieldType);
					// do the injection
					field.setAccessible(true);
					field.set(applicationObject, instance);
				}
			}
			//call the run() method
			if (applicationObject instanceof Runnable)
			   ((Runnable)applicationObject).run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
