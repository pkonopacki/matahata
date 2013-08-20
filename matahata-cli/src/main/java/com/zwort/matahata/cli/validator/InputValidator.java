package com.zwort.matahata.cli.validator;

import java.util.ArrayList;
import java.util.List;

import com.zwort.matahata.cli.model.Item;

public class InputValidator extends AbstractValidator {
	
	public static List<String> validate(List<Item> itemsList) {
		List<String> errorList = new ArrayList<String>();
		int counter = 0;
		
		for (Item item : itemsList) {
			counter++;

            if (item.getType() == null) {
				errorList.add("Pos." + counter + ": Item type cannot be null");
	
			} else {
				
				if (!isNull(item.getAmount())) {
					errorList.add("Pos." + counter + ": Amount cannot be null");
				}
				
				if (!isNull(item.getDate())) {
					errorList.add("Pos." + counter + ": Date cannot be null");
				}
				
				if (!isNull(item.getDescription())) {
					errorList.add("Pos." + counter + ": Description cannot be null");
				}

				switch(item.getType()) {
				
				case EXPENSE:

                    if (!isValidString(item.getBenefInitials())) {
						errorList.add("Pos." + counter + ": Beneficiary initials must have a valid value");
					}
	
					if (!isValidString(item.getCategoryAbbr())) {
						errorList.add("Pos." + counter + ": Category abbreviation must have a valid value");
					}
					
					if (!isValidString(item.getLocation())) {
						errorList.add("Pos." + counter + ": Location cannot must have a valid value");
					}
	
					if (!isValidString(item.getSrcAccountNo())) {
						errorList.add("Pos." + counter + ": Src account number must have a valid value");
					}
					break;
	
				case INCOME:

                    if (!isValidString(item.getDestAccountNo())) {
						errorList.add("Pos." + counter + ": Dest account number must have a valid value");
					}
					
					if (!isValidString(item.getBenefInitials())) {
						errorList.add("Pos." + counter + ": Beneficiary initials must have a valid value");
					}
	
					if (!isValidString(item.getSource())) {
						errorList.add("Pos." + counter + ": Source must have a valid value");
					}

					if (!isValidString(item.getCategoryAbbr())) {
						errorList.add("Pos." + counter + ": Category abbreviation must have a valid value");
					}
					break;
					
				case TRANSFER:

                    if (!isValidString(item.getDestAccountNo())) {
						errorList.add("Pos." + counter + ": Dest account number must have a valid value");
					}
					
					if (!isValidString(item.getSrcAccountNo())) {
						errorList.add("Pos." + counter + ": Src account number must have a valid value");
					}
					break;
					
				default:
					
				}
			}
		}
			
		return errorList;
	}

}
