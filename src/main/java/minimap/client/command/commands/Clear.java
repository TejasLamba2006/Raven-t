package minimap.client.command.commands;

import minimap.client.clickgui.raven.Terminal;
import minimap.client.command.Command;

public class Clear extends Command {
    public Clear() {
        super("clear", "Clears the terminal", 0, 0, new String[] {}, new String[] { "l", "clr" });
    }

    @Override
    public void onCall(String[] args) {
        Terminal.clearTerminal();
    }
}
