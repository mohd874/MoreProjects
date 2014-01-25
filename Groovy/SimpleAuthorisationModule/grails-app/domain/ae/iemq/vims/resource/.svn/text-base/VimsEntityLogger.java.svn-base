package ae.iemq.vims.resource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import org.apache.log4j.Logger;

/**
 * This class provides a utility method for debugging the internal values of ViMS domain classes.
 */
public class VimsEntityLogger {
	
	static Logger LOG = Logger.getLogger(VimsEntityLogger.class);

	private StringBuffer output = new StringBuffer();

	private int childLevel = 0;

	private VimsEntityLogger() {
	}

	public static void displayClass(Object classToLog) {

		LOG.debug("!!!!!!!!! REFLECT CLASS - START !!!!!!!!!!");
		VimsEntityLogger voLogger = new VimsEntityLogger();
		voLogger.logClass(classToLog);
		LOG.debug("!!!!!!!!! REFLECT CLASS - END !!!!!!!!!!");
	}

	public void logClass(Object classToLog) {
		if (classToLog == null) {
			output.append("Null Class passed in\n");
			return;
		}
		try {
			// Creates an object of type Class of the passed in.
			String classNameStr = classToLog.getClass().getName();
			Class clazz = Class.forName(classNameStr);
			output.append("clazz -->" + classNameStr + "\n");
			// getBasicInfo(clazz);

			Method methodArr[] = clazz.getMethods();
			childLevel++;
			output.append("$$$ Getters Start $$$\n");
			for (int i = 0; i < methodArr.length; i++) {
				Method iMethod = methodArr[i];
				String methodNameStr = iMethod.getName();
				// seperate methods starting with "get"
				if (methodNameStr.startsWith("get")
						|| methodNameStr.startsWith("is")) {
					try {
						Class[] parmArr = iMethod.getParameterTypes();
						if (parmArr.length == 0) {

							Method method = clazz
									.getMethod(methodNameStr, null);
							Object reflectedObject = method.invoke(classToLog,
									null);

							if (reflectedObject == null) {
								output.append("property:" + methodNameStr
										+ "\tvalue is null\n");
								continue;
							}

							extractData(reflectedObject, methodNameStr);
						}
					} catch (Exception e) {
						output.append(e.getMessage() + "\n");
					}
				}
			}
			childLevel--;

			if (childLevel == 0)
				LOG.debug(output);
		} catch (Exception e) {
			LOG.debug(output);
			output.append(e.getMessage() + "\n");
		}
	}

	private void extractData(Object reflectedObject, String propertyNameStr)
			throws ClassNotFoundException {

		output.append("property:" + propertyNameStr + "\t");

		try {
			if (Class.forName("java.lang.String").isInstance(reflectedObject)) {
				output.append("type:String:" + "\tvalue:" + reflectedObject
						+ " length:" + reflectedObject.toString().length());

			} else if (Class.forName("java.lang.Integer").isInstance(
					reflectedObject)) {
				output.append("type:Integer:" + "\tvalue:" + reflectedObject);

			} else if (Class.forName("java.lang.Double").isInstance(
					reflectedObject)) {
				output.append("type:Double:" + "\tvalue:" + reflectedObject);

			} else if (Class.forName("java.lang.Long").isInstance(
					reflectedObject)) {
				output.append("type:Long:" + "\tvalue:" + reflectedObject);

			} else if (Class.forName("java.lang.Short").isInstance(
					reflectedObject)) {
				output.append("type:Short:" + "\tvalue:" + reflectedObject);

			} else if (Class.forName("java.lang.Character").isInstance(
					reflectedObject)) {
				output.append("type:Character:" + "\tvalue:" + reflectedObject);
			} else if (Class.forName("java.lang.Boolean").isInstance(
					reflectedObject)) {
				output.append("type:Boolean:" + "\tvalue:" + reflectedObject);
			} else if (Class.forName("java.sql.Date").isInstance(
					reflectedObject)) {
				output.append("type:java.sql.Date:" + "\tvalue:"
						+ reflectedObject);
			} else if (Class.forName("java.util.Date").isInstance(
					reflectedObject)) {
				output.append("type:java.util.Date:" + "\tvalue:"
						+ reflectedObject);
			} else if (Class.forName("java.sql.Timestamp").isInstance(
					reflectedObject)) {
				output.append("type:java.sql.Timestamp:" + "\tvalue:"
						+ reflectedObject + "\n");

			} else if (Class.forName("java.util.Collection").isInstance(
					reflectedObject)) {
				output.append("type:java.util.Collection:\n");
				Collection coll = (Collection) reflectedObject;

				if (coll != null) {
					for (Object o : coll) {
						output.append("\tStart Child for -->" + propertyNameStr
								+ "\tLevel=" + childLevel + "\n");
						//this.logClass(o);
						output.append("\tEnd Child for -->" + propertyNameStr
								+ "\tLevel=" + childLevel + "\n");
					}
				}
			} else if (Class.forName("ae.iemq.vims.domain.BaseEntity")
					.isInstance(reflectedObject)) {
				output.append("\tStart Child for -->" + propertyNameStr
						+ "\tLevel=" + childLevel + "\n");
				//this.logClass(reflectedObject);
				output.append("\tEnd Child for -->" + propertyNameStr
						+ "\tLevel=" + childLevel + "\n");
//			} else if (Class.forName("net.sf.mpxj.ProjectEntity").isInstance(
//					reflectedObject)) {
//				output.append("type:net.sf.mpxj.ProjectEntity:" + "\tvalue:"
//						+ reflectedObject + "\n");
//				this.logClass(reflectedObject);
			} else {
				output.append("\tno implementation for type\t"
						+ reflectedObject.toString());
			}
		} catch (Exception e) {
			output.append("!!Exception!!");
			output.append(e.getMessage());
		} finally {
			output.append("\n");
		}
	}

	private void getBasicInfo(Class clazz) {
		try {
			// getDeclaredFields() returns all the constructors of the class.
			Constructor cnst[] = clazz.getConstructors();
			output.append("***** Constructors *****\n");
			for (int i = 0; i < cnst.length; i++) {
				output.append(cnst[i].getName());
			}

			// getFields() returns all the declared fields of the class.
			Field fld[] = clazz.getDeclaredFields();
			output.append("Name of the Declared fields\n");
			for (int i = 0; i < fld.length; i++) {
				output.append(fld[i].getName() + "\n");
			}

			// getMethods() returns all the declared methods of the class.
			Method mtd[] = clazz.getMethods();
			output.append("Name of the Methods\n");
			for (int i = 0; i < mtd.length; i++) {
				output.append(mtd[i].getName() + "\n");
			}
		} catch (Exception e) {
			output.append(e.getMessage() + "\n");
		}
	}
}
