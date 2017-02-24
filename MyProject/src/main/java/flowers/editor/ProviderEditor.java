package flowers.editor;

import java.beans.PropertyEditorSupport;

import flowers.service.ProvidersService;


public class ProviderEditor extends PropertyEditorSupport{
	
	private ProvidersService providersService;
	
	public void ProvidersService(ProvidersService providersService){
		this.providersService = providersService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(providersService.findOne(Integer.parseInt(text)));
	}

}
