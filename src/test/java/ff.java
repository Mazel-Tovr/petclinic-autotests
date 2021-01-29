import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.util.Iterator;
import java.util.List;

public class ff {

    public class RunBefores extends Statement {
        private final Statement next;

        private final Object target;

        private final List<FrameworkMethod> befores;

        public RunBefores(Statement next, List<FrameworkMethod> befores, Object target) {
            this.next = next;
            this.befores = befores;
            this.target = target;
        }

        @Override
        public void evaluate() throws Throwable {
            for (int i = 0; i < befores.size(); i++) {
               FrameworkMethod method = befores.get(i);
               method.invokeExplosively(target);
            }
            Iterator<FrameworkMethod> iterator = befores.iterator();
            while (iterator.hasNext()) {
                System.out.println("$engineSegment/" + iterator.next().getDeclaringClass().getName() + "/" + iterator.next().getName());
                iterator.next().invokeExplosively(target,new Object[0]);
            }
            next.evaluate();
            return;
        }
    }
}
