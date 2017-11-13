package zeus;

import java.util.EventListener;

public interface WarEventListener<T> extends EventListener {

	public void handle(T event);
}
