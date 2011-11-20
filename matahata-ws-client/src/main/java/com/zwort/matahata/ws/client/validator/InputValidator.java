package com.zwort.matahata.ws.client.validator;

import java.util.ArrayList;
import java.util.List;

import com.zwort.matahata.ws.client.model.Item;

public class InputValidator {
	
	public static List<String> validate(List<Item> itemsList) {
		List<String> errorList = new ArrayList<String>();
		int counter = 1;
		
		for (Item item : itemsList) {
			counter++;
			
			if (item.getType() == null) {
				errorList.add("Pos." + counter + ": Item type cannot be null");
	
			} else {
			
				switch(item.getType()) {
				
				case EXPENSE:
					
					if (item.getBenefInitials() == null) {
						errorList.add("Pos." + counter + ": Beneficiary initials cannot be null");
					}
	
					if (item.getPayerInitials() == null) {
						errorList.add("Pos." + counter + ": Payer initials cannot be null");
					}
					
					if (item.getCategoryAbbr() == null) {
						errorList.add("Pos." + counter + ": Category abbreviation cannot be null");
					}
					
					if (item.getLocation() == null) {
						errorList.add("Pos." + counter + ": Location cannot be null");
					}
	
					if (item.getSrcAccountNo() == null) {
						errorList.add("Pos." + counter + ": Src account number cannot be null");
					}
					break;
	
				case INCOME:
					
					if (item.getDestAccountNo() == null) {
						errorList.add("Pos." + counter + ": Dest account number cannot be null");
					}
					
					if (item.getBenefInitials() == null) {
						errorList.add("Pos." + counter + ": Beneficiary initials cannot be null");
					}
	
					if (item.getSource() == null) {
						errorList.add("Pos." + counter + ": Source cannot be null");
					}
					break;
					
				case TRANSFER:
					
					if (item.getDestAccountNo() == null) {
						errorList.add("Pos." + counter + ": Dest account number cannot be null");
					}
					
					if (item.getSrcAccountNo() == null) {
						errorList.add("Pos." + counter + ": Src account number cannot be null");
					}
					break;
					
				default:
					
					if (item.getAmount() == null) {
						errorList.add("Pos." + counter + ": Amount cannot be null");
					}
					
					if (item.getDate() == null) {
						errorList.add("Pos." + counter + ": Date cannot be null");
					}
					
					if (item.getDescription() == null) {
						errorList.add("Pos." + counter + ": Date cannot be null");
					}
					
				}
			}
		}
			
		return errorList;
	}

}
