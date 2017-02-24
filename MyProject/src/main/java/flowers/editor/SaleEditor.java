package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.SaleService;

public class SaleEditor extends PropertyEditorSupport{
	
	private  SaleService saleService;

	public void SaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(saleService.findOne(Integer.parseInt(text)));
	}


}
