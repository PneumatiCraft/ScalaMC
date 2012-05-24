package com.pneumaticraft.scalamc.commands {
    
    import java.util.List

    import org.bukkit.ChatColor
    import org.bukkit.command.CommandSender
    import org.bukkit.permissions.PermissionDefault
    import org.bukkit.plugin.java.JavaPlugin
    
    class SMHelloCommand(plugin: JavaPlugin) extends SMCommand(plugin) {
    
        this.setName("Hello")
        this.setArgRange(0, 0)
        this.setCommandUsage("/hello")
        this.addCommandExample("/hello")
        this.setPermission("scalamc.hello.use", "Use the /hello command", PermissionDefault.TRUE)
        this.addKey("hello")
    
        override def runCommand(sender:CommandSender, args:List[String]) = sender.sendMessage("Hello!")
        
    }

}
