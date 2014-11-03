package com.sdk.realm.herblore.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.sdk.realm.herblore.domain.Herb;
import com.sdk.realm.herblore.domain.HerbLibrary;
import com.sdk.realm.ui.Controller;

public class HerbLoreFrameController extends Controller implements ListSelectionListener {

	private HerbLoreJFrame _herbLoreFrame = null;
	private SearchResultsTableModel _searchResultsTableModel = null;
	private SearchResultsTableHerbComparator _resultsComparator = new SearchResultsTableHerbComparator();
	private ListSelectionModel _resultsTableListSelectionModel = null;
	
	public HerbLoreFrameController() {
		super();
		
		ListSelectionModel temp = new DefaultListSelectionModel();
		temp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		temp.addListSelectionListener(this);
		_resultsTableListSelectionModel = temp;
		
	}

	ListSelectionModel getResultsTableListSelectionModel() {
		return _resultsTableListSelectionModel;
	}
	
	@Override
	public void makeFrameVisable() {
		_herbLoreFrame.pack();
		_herbLoreFrame.setVisible(true);

	}
	
	TableModel getSearchResultsTableModel() {
		if (_searchResultsTableModel == null) {
			initializeSearchResultsTableModel();
		}
		return _searchResultsTableModel;
	}
	
	public void setFrame(HerbLoreJFrame aFrame) {
		_herbLoreFrame = aFrame;
		aFrame.setLocation(80,80);
	}
	
	private void initializeSearchResultsTableModel() {
		_searchResultsTableModel = new SearchResultsTableModel();
	}

	private void updateSearchResultsTableModelWithSearchResults(List<Herb> searchResults) {
		Collections.sort(searchResults, _resultsComparator);
		_searchResultsTableModel.setSearchResults(searchResults);
		if (searchResults.size() == 1) {
			_resultsTableListSelectionModel.setSelectionInterval(0, 0);
		} else {
			updateSelectedResultFields(new Herb());
		}
	}
	
	private String getSearchCriteria() {
		return _herbLoreFrame.getSearchCriteriaJTextField().getText();
	}
	
	void surpriseSearchButtonClicked() {
		Herb randomHerb = HerbLibrary.getCurrent().getRandomHerb();
		List<Herb> listOHerbs = new ArrayList<Herb>();
		listOHerbs.add(randomHerb);
		updateSearchResultsTableModelWithSearchResults(listOHerbs);
	}
	
	void searchbyNameButtonClicked() {
		List<Herb> selectedHerbs = HerbLibrary.getCurrent().getHerbsContainingName(getSearchCriteria());
		updateSearchResultsTableModelWithSearchResults(selectedHerbs);
	}
	
	void searchByClassificationButtonClicked() {
		List<Herb> selectedHerbs = HerbLibrary.getCurrent().getHerbsContainingClassification(getSearchCriteria());
		updateSearchResultsTableModelWithSearchResults(selectedHerbs);
	}

	// listen for events from the _resultsTableListSelectionModel
	public void valueChanged(ListSelectionEvent e) {
		// ignore extra messages
		if (e.getValueIsAdjusting()) {
			return;
		}
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (! lsm.isSelectionEmpty()) {
			int selectedRow = lsm.getMinSelectionIndex();
			updateSelectedResultFields(_searchResultsTableModel.getResultAtRow(selectedRow));
		}
	}
	
	// update the text fields with data from the selected herb
	private void updateSelectedResultFields(Herb aHerb) {
		_herbLoreFrame.getResultNameJTextField().setText(aHerb.getName());
		_herbLoreFrame.getResultClassificationJTextField().setText(aHerb.getClassification());
		String attackLevel = null;
		if (aHerb.getName()!= null && aHerb.getName().length() > 0) {
			attackLevel = (new Integer(aHerb.getAttackLevel()).toString());
		}
		_herbLoreFrame.getAttackLevelJTextField().setText(attackLevel);
		_herbLoreFrame.getFormAndPreperationJTextField().setText(aHerb.getFormAndPreperation());
		_herbLoreFrame.getCostAndRarityJTextField().setText(aHerb.getCostRarity());
		_herbLoreFrame.getEffectJTextArea().setText(aHerb.getEffect());		
	}
}
