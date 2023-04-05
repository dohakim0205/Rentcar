package controller;

import controller.action.Action;
import controller.action.LoginAction;
import controller.action.RegistAction;
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
		return action;
	}
}
