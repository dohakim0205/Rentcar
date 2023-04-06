package controller;

import controller.action.Action;
import controller.action.BoardAction;
import controller.action.BookingAction;
import controller.action.LoginAction;
import controller.action.ModifyBoardAction;
import controller.action.RegistAction;
import controller.action.SearchAddressAction;
import controller.action.UpdateAction;

public class ActionFactory {

	// Singleton Pattern
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("regist")) {
			action = new RegistAction();
		}

		else if (command.equals("update")) {
			action = new UpdateAction();
		}

		else if (command.equals("login")) {
			action = new LoginAction();
		}

		else if (command.equals("booking")) {
			action = new BookingAction();
		}

		else if (command.equals("board")) {
			action = new BoardAction();
		}
		
		else if (command.equals("modifyBoard")) {
			action = new ModifyBoardAction();
			
		}
		
		else if (command.equals("address")) {
			action = new SearchAddressAction();
			
		}
		return action;
	}
}
