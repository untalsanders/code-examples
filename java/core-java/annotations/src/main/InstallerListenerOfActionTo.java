import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InstallerListenerOfActionTo {
    public static void processAnnotations(Object obj) {
        try {
            Class cl = obj.getClass();
            for (Method m : cl.getDeclaredMethods()) {
                ActionListener listenerOfActionTo = m.getAnnotation(ActionListener.class);
                if (listenerOfActionTo != null) {
                    Field f = cl.getDeclaredField(listenerOfActionTo.origin());
                    f.setAccessible(true);
                }
            }
        } catch (SecurityException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
