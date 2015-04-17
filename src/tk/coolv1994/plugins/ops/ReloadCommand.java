package tk.coolv1994.plugins.ops;

import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.utils.Chat;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class ReloadCommand implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (!OP.getManager().hasPermission(player, "ops.reload")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        OP.getManager().loadPerms();
        Chat.sendMessage(player, "Operators reloaded.");
    }
}
