package minimap.client.command.commands;

import minimap.client.clickgui.raven.Terminal;
import minimap.client.command.Command;
import minimap.client.main.Raven;
import minimap.client.utils.Utils;
import minimap.client.utils.version.Version;

import java.net.MalformedURLException;
import java.net.URL;

public class Update extends Command {
    public Update() {
        super("update", "Assists you in updating the client", 0, 0, new String[] {}, new String[] { "upgrade" });
    }

    @Override
    public void onCall(String[] args) {
        Version clientVersion = Raven.versionManager.getClientVersion();
        Version latestVersion = Raven.versionManager.getLatestVersion();

        if (latestVersion.isNewerThan(clientVersion)) {
            Terminal.print("Opening page...");
            URL url = null;
            try {
                url = new URL(Raven.sourceLocation);
                Utils.Client.openWebpage(url);
                Utils.Client.openWebpage(new URL(Raven.downloadLocation));
                Terminal.print("Opened page successfully!");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Terminal.print("Failed to open page! Please report this bug in Raven b++'s discord!");

            }
        } else {
            Terminal.print("No need to upgrade, You are on the latest build");
        }
    }
}
