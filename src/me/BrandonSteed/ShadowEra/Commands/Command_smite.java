package me.BrandonSteed.ShadowEra.Commands;

import me.BrandonSteed.ShadowEra.Modules.AdminChat;
import me.BrandonSteed.ShadowEra.SE_Messages;
import me.BrandonSteed.ShadowEra.SE_Utils;
import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.command.CommandPermissions;
import net.pravian.bukkitlib.command.SourceType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_smite extends BukkitCommand 
{
  @Override
  public boolean run(final CommandSender sender, Command cmd, String label, String[] args)
  {
    if (! (sender.hasPermission("shadoweracore.command.smite")))
    {
      sender.sendMessage("§9[ShadowEraCore] §cYou don't have enough permissions.");
      return true;
    }
    
    int length = args.length;
    
    if (length == 0)
    {
      sender.sendMessage("/smite <player>");
      return true;
    }
    
    if (length == 1)
    {
      boolean playerFound = false;
      
      for (Player player : Bukkit.getServer().getOnlinePlayers())
      {
        if (player.getName().equalsIgnoreCase(args[0]))
        {
          Bukkit.broadcastMessage(ChatColor.AQUA + sender.getName() + " - Smiting " + player.getName());
          Bukkit.broadcastMessage(ChatColor.RED + player.getName() + "has been a naughty, naughty boy/girl.");
          
          for (int i = 0; i <= 200; i++)
          {
            player.getWorld().strikeLightning(player.getLocation());
          }
          
          player.setHealth(0.0);
          player.setFireTicks(10000);
          sender.sendMessage(ChatColor.GRAY + "Smitten " + player.getName() + ".");
          player.sendMessage(ChatColor.DARK_RED + "You were smitten by " + sender.getName() + ".");
          playerFound = true;
          break;
        }
      }
      
      if (playerFound == false)
      {
        sender.sendMessage(ChatColor.GRAY + args[0] + " not found!");
      }
      
      return true;
    }
    
    
    return true;
  }
}
