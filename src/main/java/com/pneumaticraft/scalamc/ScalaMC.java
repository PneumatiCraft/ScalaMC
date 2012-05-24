package com.pneumaticraft.scalamc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.pneumaticraft.scalamc.commands.*;
import com.pneumaticraft.commandhandler.CommandHandler;

public class ScalaMC extends JavaPlugin {
    public static final String LOG_PREFIX = "[ScalaMC] ";
    public static final Logger LOG = Logger.getLogger("Minecraft");

    private SMPermissionsHandler permissionsHandler;
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        LOG.info(LOG_PREFIX + "Enabled!");

        this.initializePermissions();
        this.loadCommands();
    }

    private void initializePermissions() {
        this.permissionsHandler = new SMPermissionsHandler(this);
    }

    private void loadCommands() {
        this.commandHandler = new CommandHandler(this, this.permissionsHandler);
        
        this.commandHandler.registerCommand(new SMHelloCommand(this));
    }

    @Override
    public void onDisable() {
        LOG.info(LOG_PREFIX + "Disabled!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        List<String> keyPath = new ArrayList<String>();
        keyPath.add(command.getLabel().toLowerCase());
        for(int i = 0; i < args.length; i++) {
            keyPath.add(args[i]);
        }
        return this.commandHandler.locateAndRunCommand(sender, keyPath);
    }

    public SMPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }
}
