package io.github.gawdserver.ops;

import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.plugin.Plugin;

import java.util.logging.Logger;

/**
 * Created by Vinnie on 2/2/2015.
 */

/**
 * A list of server operators and their level
 * This uses Mojang's system...
 * You have all permissions, or none :)
 */
public class OP implements Plugin {
    public static final Logger logger = Logger.getLogger("OPPerms");
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
