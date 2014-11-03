package com.sdk.realm.player.ui;

import java.util.Comparator;

import com.sdk.realm.player.domain.Player;

public class PlayerComparator implements Comparator<Player> {

	// compare them by ids
	public int compare(Player arg0, Player arg1) {

		if (arg0 != null && arg1 != null) {
			return new Integer(arg0.getId()).compareTo(new Integer(arg1.getId()));
		} else {
			return 0;
		}
	}
}
