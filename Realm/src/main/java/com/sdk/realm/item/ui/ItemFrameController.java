package com.sdk.realm.item.ui;

import com.sdk.realm.character.domain.CharacterWarehouse;
import com.sdk.realm.item.domain.Item;
import com.sdk.realm.item.domain.ItemWarehouse;
import com.sdk.realm.player.domain.Player;
import com.sdk.realm.player.domain.PlayerWarehouse;
import com.sdk.realm.ui.Controller;

public class ItemFrameController extends Controller {

	private int itemID;
	private Item currentItem;
	private ItemListFrameController itemListFrameController;
	private ItemJFrame itemFrame;
	
	public ItemFrameController(ItemListFrameController anItemListFrameController) {
		super();
		itemListFrameController = anItemListFrameController;
	}
	@Override
	public void makeFrameVisable() {
		refreshFromDomain();
		itemFrame.pack();
		itemFrame.setVisible(true);
	}

	void cancelJButtonClicked() {
		refreshFromDomain();
	}
	
	void saveJButtonClicked() {
		currentItem.setName(itemFrame.getNameJTextField().getText());
		currentItem.setWill(((Number) itemFrame.getWillFormattedTextField().getValue()).intValue());
		currentItem.setWillModifier(((Number) itemFrame.getWillModifierFormattedTextField().getValue()).intValue());
		// this particular Item instance is already known to the warehouse.  Just tell the warehouse to
		// persist everything.
		ItemWarehouse.getCurrent().persistAll();
		itemListFrameController.itemDomainWasModified();
		itemFrame.setVisible(false);
		
	}

	private void refreshFromDomain() {
		Item myItem = ItemWarehouse.getCurrent().getItem(itemID);
		if (myItem != null) {
			currentItem = myItem;
			itemFrame.getIdFormattedTextField().setValue(myItem.getId());
			itemFrame.getNameJTextField().setText(myItem.getName());
			itemFrame.getWillFormattedTextField().setValue(myItem.getWill());
			itemFrame.getWillModifierFormattedTextField().setValue(myItem.getWillModifier());
		}
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	ItemJFrame getFrame() {
		return itemFrame;
	}
	
	void setFrame(ItemJFrame aFrame) {
		itemFrame = aFrame;
		aFrame.setLocation(280,180);
	}


}
