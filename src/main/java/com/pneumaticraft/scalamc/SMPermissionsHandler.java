package com.pneumaticraft.scalamc;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.pneumaticraft.commandhandler.PermissionsInterface;

/**
 * Utility class to handle permissions checks for ScalaMC. Implements basic
 * functionality required by CommandHandler for permissions checking and
 * command dispatch. Interfaces with both SuperPerms-based systems and old
 * Permissions plugins.
 */
public class SMPermissionsHandler implements PermissionsInterface {

    /**
     * ScalaMC instance backing this permissions handler.
     */
    private ScalaMC plugin;

    /**
     * Create a new permissions handler for the given ScalaMC instance.
     *
     * @param sm The ScalaMC instance for which to handle permissions.
     */
    public SMPermissionsHandler(ScalaMC sm) {
        this.plugin = sm;
    }

    @Override
    public boolean hasPermission(CommandSender sender, String node, boolean isOpRequired) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player) sender;
            if (player.hasPermission(node)) {
                return true;
            } else if (isOpRequired) {
                return player.isOp();
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean hasAnyPermission(CommandSender sender, List<String> allPermissionStrings, boolean opRequired) {
        for (String node : allPermissionStrings) {
            if (this.hasPermission(sender, node, opRequired)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasAllPermission(CommandSender sender, List<String> allPermissionStrings, boolean opRequired) {
        for (String node : allPermissionStrings) {
            if (!this.hasPermission(sender, node, opRequired)) {
                return false;
            }
        }
        return true;
    }

}
