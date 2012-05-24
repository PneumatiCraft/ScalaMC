package com.pneumaticraft.scalamc {

    import java.util.List
    
    import scala.collection.JavaConversions._
    
    import org.bukkit.command.CommandSender
    import org.bukkit.entity.Player
    import org.bukkit.plugin.Plugin
    
    import com.pneumaticraft.commandhandler.PermissionsInterface
    
    /**
     * Utility class to handle permissions checks for ScalaMC. Implements basic
     * functionality required by CommandHandler for permissions checking and
     * command dispatch. Interfaces with both SuperPerms-based systems and old
     * Permissions plugins.
     */
    class SMPermissionsHandler(plugin:ScalaMC) extends PermissionsInterface {
    
        override def hasPermission(sender:CommandSender, node:String, isOpRequired:Boolean) = sender match {
            case sender: Player => sender.hasPermission(node) || (isOpRequired && sender.isOp())
            case _ => true
        }
    
        override def hasAnyPermission(sender:CommandSender, allPermissionStrings:List[String], opRequired:Boolean) =
            allPermissionStrings.map(this.hasPermission(sender, _, opRequired)).reduceLeft((x,y) => x || y)
    
        override def hasAllPermission(sender:CommandSender, allPermissionStrings:List[String], opRequired:Boolean) =
            allPermissionStrings.map(this.hasPermission(sender, _, opRequired)).reduceLeft((x,y) => x && y)
    
    }
    
}
