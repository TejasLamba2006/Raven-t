package minimap.client.command.commands;

import minimap.client.command.Command;
import minimap.client.main.Raven;
import minimap.client.utils.version.Version;

import static minimap.client.clickgui.raven.Terminal.print;

public class VersionCommand extends Command {
    public VersionCommand() {
        super("version", "tells you what build of B++ you are using", 0, 0, new String[] {},
                new String[] { "v", "ver", "which", "build", "b" });
    }

    @Override
    public void onCall(String[] args) {
        Version clientVersion = Raven.versionManager.getClientVersion();
        Version latestVersion = Raven.versionManager.getLatestVersion();

        print("Your build: " + clientVersion);
        print("Latest version: " + latestVersion);

    }
}
