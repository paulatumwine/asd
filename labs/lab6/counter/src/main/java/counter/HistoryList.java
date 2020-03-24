package counter;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {
	private Collection<ICommand> commandlist = new ArrayList<ICommand>();
	private Collection<ICommand> undolist = new ArrayList<ICommand>();

	public void undo() {
		if (commandlist.size() > 0) {
			ICommand ICommandObject = (ICommand) ((ArrayList<ICommand>) commandlist).get(commandlist.size() - 1);
			((ArrayList<ICommand>) commandlist).remove(ICommandObject);
			ICommandObject.unExecute();
			undolist.add(ICommandObject);
		}
	}

	public void redo() {
		if (undolist.size() > 0) {
			ICommand ICommandObject = (ICommand) ((ArrayList<ICommand>) undolist).get(undolist.size() - 1);
			ICommandObject.execute();
			((ArrayList<ICommand>) undolist).remove(ICommandObject);
			commandlist.add(ICommandObject);
		}
	}

	public void addCommand(ICommand ICommandObject) {
		commandlist.add(ICommandObject);
	}

}
