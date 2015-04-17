package tk.coolv1994.plugins.ops;

import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.plugin.Plugin;

/**
 * Created by Vinnie on 2/2/2015.
 */

/**
 * A list of server operators and their level
 * This uses Mojang's system...
 * You have all permissions, or none :)
 */
public class OP implements Plugin {
    private static PermManager manager;

    public static PermManager getManager() {
        return manager;
    }

    @Override
    public void startup() {
        manager = (PermManager) Permissions.getManager();
        manager.loadPerms();
    }

    @Override
    public void shutdown() {
    }
}
