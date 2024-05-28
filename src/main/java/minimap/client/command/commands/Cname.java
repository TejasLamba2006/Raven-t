package minimap.client.command.commands;

import minimap.client.clickgui.raven.Terminal;
import minimap.client.command.Command;
import minimap.client.module.modules.other.NameHider;

public class Cname extends Command {
    public Cname() {
        super("cname", "Hides your name client-side", 1, 1, new String[] { "New name" },
                new String[] { "cn", "changename" });
    }

    @Override
    public void onCall(String[] args) {
        if (args.length == 0) {
            this.incorrectArgs();
            return;
        }

        NameHider.n = args[0];
        Terminal.print("Nick has been set to: " + NameHider.n);
    }
}
