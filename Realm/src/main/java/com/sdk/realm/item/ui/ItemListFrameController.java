package com.sdk.realm.item.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.sdk.realm.item.domain.Item;
import com.sdk.realm.item.domain.ItemWarehouse;
import com.sdk.realm.ui.Controller;

public class ItemListFrameController extends Controller {

	private ItemListJFrame itemListFrame = null;
	
	private ItemFrameController itemFrameController = null;
	
	public ItemListFrameController(ItemListJFrame aFrame) {
		super();
		itemListFrame = aFrame;
		aFrame.setLocation(120,120);
		itemListFrame.getItemListJTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		initializeTableColumnSizes(aFrame.getItemListJTable());
	}
	
	private void initializeTableColumnSizes(JTable characterListTable) {
		
		Enumeration<TableColumn> columnsEnumeration = characterListTable.getColumnModel().getColumns();
		while (columnsEnumeration.hasMoreElements()) {
			TableColumn aColumn = columnsEnumeration.nextElement();
			if (aColumn.getModelIndex() == ItemListTableDataModel.ITEM_NAME_INDEX) {
				aColumn.setPreferredWidth(150);
			} else {
				aColumn.setPreferredWidth(20);
			}
		}
	}

	@Override
	public void makeFrameVisable() {
		refreshTableFromDomain();
		itemListFrame.pack();
		itemListFrame.setVisible(true);
	}

	void refreshTableFromDomain() {
		
		List<Item> items = new ArrayList<Item>();
		items.addAll((ItemWarehouse.getCurrent().getAllItems()));
		itemListFrame.getTableDataModel().setItems(items);
		itemListFrame.getItemListJTable().repaint();
	}

	void addItemJButtonClicked() {
		
		Item newItem = ItemWarehouse.getCurrent().createAndAddNewItem();
		getItemFrameController().setItemID(newItem.getId());
		getItemFrameController().makeFrameVisable();
		
	}
	
	void itemDomainWasModified() {
		refreshTableFromDomain();
	}
	
	void viewAndEditItemDetailsJButtonClicked() {
		
		if (itemListFrame.getItemListJTable().getSelectedRowCount() != 1) {
			JOptionPane.showMessageDialog(itemListFrame, "Must select one item to view/edit");
		} else {
			int selectedItemRow = itemListFrame.getItemListJTable().getSelectedRow();
			Item selectedItem = itemListFrame.getTableDataModel().getItems().get(selectedItemRow); 
			getItemFrameController().setItemID(selectedItem.getId());
			getItemFrameController().makeFrameVisable();
		}
	}
	
	void deleteItemJButtonClicked() {
		
		if (itemListFrame.getItemListJTable().getSelectedRowCount() < 1) {
			JOptionPane.showMessageDialog(itemListFrame, "Must select at least one item to delete");
		} else {
			int[] selectedItemRows = itemListFrame.getItemListJTable().getSelectedRows();
			for (int index = 0; index < selectedItemRows.length; index++) {
				Item selectedItem = itemListFrame.getTableDataModel().getItems().get(selectedItemRows[index]);
				ItemWarehouse.getCurrent().deleteItem(selectedItem);
			}
			ItemWarehouse.getCurrent().persistAll();
			refreshTableFromDomain();
		}
	}

	void deleteAllItemsJButtonClicked() {
		
		ItemWarehouse.getCurrent().deleteAllItems();
		ItemWarehouse.getCurrent().persistAll();
		refreshTableFromDomain();
	}
	
	private ItemFrameController getItemFrameController() {
		
		if (itemFrameController == null) {
			ItemFrameController aController = new ItemFrameController(this);
			ItemJFrame aFrame = new ItemJFrame(aController);
			aFrame.setTitle("Realm - Item");
			aController.setFrame(aFrame);
			itemFrameController = aController;
		}
		
		return itemFrameController;
	}

}
