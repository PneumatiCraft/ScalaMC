package com.pneumaticraft.scalamc {

    import java.util.logging.Logger

    import scala.collection.JavaConversions._

    import org.bukkit.command.{Command, CommandSender}
    import org.bukkit.plugin.java.JavaPlugin
    
    import com.pneumaticraft.scalamc.commands._
    import com.pneumaticraft.commandhandler.CommandHandler

    object ScalaMC {
        val LOG_PREFIX = "[ScalaMC] "
        val LOG = Logger.getLogger("Minecraft")

        def Info(s:String) = LOG.info(LOG_PREFIX + s)
    }
    
    class ScalaMC extends JavaPlugin {
        private var permissionsHandler:SMPermissionsHandler = _
        private var commandHandler:CommandHandler = _
    
        override def onEnable() = {
            ScalaMC.Info("Enabled!")
    
            this.initializePermissions()
            this.loadCommands()
        }
    
        private def initializePermissions() = {
            this.permissionsHandler = new SMPermissionsHandler(this)
        }
    
        private def loadCommands() = {
            this.commandHandler = new CommandHandler(this, this.permissionsHandler)
            
            this.commandHandler.registerCommand(new SMHelloCommand(this))
        }
    
        override def onDisable() = ScalaMC.Info("Disabled!")
        
        override def onCommand(sender:CommandSender, command:Command, commandLabel:String, args:Array[String]):Boolean = {
            var keyPath = List(command.getLabel().toLowerCase()) ++ args
            this.commandHandler.locateAndRunCommand(sender, keyPath)
        }
    
        def getPermissionsHandler() = this.permissionsHandler
    }
    
}
