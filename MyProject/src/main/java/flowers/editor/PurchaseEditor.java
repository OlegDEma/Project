package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.PurchaseService;

public class PurchaseEditor extends PropertyEditorSupport {
	private PurchaseService purchaseService;

	public void PurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(purchaseService.findOne(Integer.parseInt(text)));
	}

}
