package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.DeliveryService;

public class DeliveryEditor extends PropertyEditorSupport{

	private final DeliveryService deliveryService;
	
	public DeliveryEditor(DeliveryService deliveryService){
		this.deliveryService = deliveryService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(deliveryService.findOne(Integer.parseInt(text)));
	}
	
}
