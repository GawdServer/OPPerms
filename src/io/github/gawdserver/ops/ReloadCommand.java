package io.github.gawdserver.ops;

import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class ReloadCommand implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!OP.getManager().hasPermission(player, "ops.reload")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        OP.getManager().loadPerms();
        Chat.sendMessage(player, "Operators reloaded.");
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        if (sender != Sender.CONSOLE) {
            return;
        }
        OP.getManager().loadPerms();
        Chat.sendMessage(sender.name(), "Operators reloaded.");
    }
}
