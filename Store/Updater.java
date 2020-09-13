package store;

import java.util.function.BiConsumer;
import java.util.ArrayList;
public class Updater implements BiConsumer<String, ItemHeap>{

	@Override 
	public void accept(String s, ItemHeap ih){
		ih.remove_expired();
	}

	@Override
	public BiConsumer<String, ItemHeap> andThen(BiConsumer<? super String, ? super ItemHeap> after){
		return null;
	}
}