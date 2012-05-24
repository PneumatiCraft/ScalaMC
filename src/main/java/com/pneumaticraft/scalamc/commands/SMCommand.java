package com.pneumaticraft.scalamc.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.pneumaticraft.scalamc.ScalaMC;
import com.pneumaticraft.commandhandler.Command;

/**
 * Abstract parent class for all executable commands in ScalaMC. Every command
 * handled by ScalaMC is a concrete subclass of SMCommand, which itself subclasses
 * CommandHandler's Command class.
 */
public abstract class SMCommand extends Command {

    /**
     * Instantiate a command backed by the given plugin. The plugin is used
     * in subclasses for various queries back into Bukkit.
     *
     * @param plugin The plugin used for Bukkit calls in concrete command
     * subclasses.
     */
    public SMCommand(JavaPlugin plugin) {
        super(plugin);
    }

    /**
     * Get this SMCommand's plugin. Casts the plugin passed in the constructor
     * to an instance of ScalaMC.
     *
     * @see #SMCommand(JavaPlugin)
     *
     * @return The ScalaMC plugin instance handling this SMCommand.
     */
    public ScalaMC getPlugin() {
        return (ScalaMC) this.plugin;
    }

    /**
     * Check if the sender of this SMCommand is a Player. If the sender is not a
     * Player, send an error message back.
     *
     * @param sender The CommandSender to check.
     * @return true if the sender is a Player; false otherwise.
     */
    public boolean checkPlayerSender(CommandSender sender) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.RED + "Command must be run in-game!");
            return false;
        } else if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Cannot verify command's sender!");
            return false;
        }
        return true;
    }

    @Override
    public void addKey(String key) {
        super.addKey(key);
    }

    @Override
    public void addKey(String key, int minArgs, int maxArgs) {
        super.addKey(key, minArgs, maxArgs);
    }
}
