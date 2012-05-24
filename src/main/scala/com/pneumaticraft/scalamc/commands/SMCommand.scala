package com.pneumaticraft.scalamc.commands {

    import org.bukkit.ChatColor
    import org.bukkit.command.{CommandSender, ConsoleCommandSender}
    import org.bukkit.entity.Player
    import org.bukkit.plugin.java.JavaPlugin
    
    import com.pneumaticraft.scalamc.ScalaMC
    import com.pneumaticraft.commandhandler.Command
    
    /**
     * Abstract parent class for all executable commands in ScalaMC. Every command
     * handled by ScalaMC is a concrete subclass of SMCommand, which itself subclasses
     * CommandHandler's Command class.
     */
    abstract class SMCommand(plugin:JavaPlugin) extends Command(plugin) {
       
        /**
         * Get this SMCommand's plugin. Casts the plugin passed in the constructor
         * to an instance of ScalaMC.
         *
         * @see #SMCommand(JavaPlugin)
         *
         * @return The ScalaMC plugin instance handling this SMCommand.
         */
        override def getPlugin():ScalaMC = plugin match {
            case plugin: ScalaMC => plugin
            case _ => throw new ClassCastException
        }
    
        /**
         * Check if the sender of this SMCommand is a Player. If the sender is not a
         * Player, send an error message back.
         *
         * @param sender The CommandSender to check.
         * @return true if the sender is a Player; false otherwise.
         */
        def checkPlayerSender(sender:CommandSender):Boolean = sender match {
            case sender: ConsoleCommandSender => {
                sender.sendMessage(ChatColor.RED + "Command must be run in-game!")
                false
            }
            case sender: Player => true
            case _ => {
                sender.sendMessage(ChatColor.RED + "Cannot verify command's sender!")
                false
            }
        }
    
        override def addKey(key:String) = super.addKey(key)
        override def addKey(key:String, minArgs:Int, maxArgs:Int) = super.addKey(key, minArgs, maxArgs)
    }
    
}
