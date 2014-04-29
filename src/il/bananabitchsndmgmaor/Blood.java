package il.bananabitchsndmgmaor;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Blood {

	public static void setValue(Object instance, String fieldName, Object value) throws Exception {
		  Field field = instance.getClass().getDeclaredField(fieldName);
		  field.setAccessible(true);
		  field.set(instance, value);
		 }
		 
		 public static void sendToPlayer(String effect, Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
		  PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles();
		  setValue(packet, "a", effect);
		  setValue(packet, "b", (float) location.getX());
		  setValue(packet, "c", (float) location.getY());
		  setValue(packet, "d", (float) location.getZ());
		  setValue(packet, "e", offsetX);
		  setValue(packet, "f", offsetY);
		  setValue(packet, "g", offsetZ);
		  setValue(packet, "h", speed);
		  setValue(packet, "i", count);
		  ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		 }
		
		 
		 public static void sendBloodEffect(Player victim) {
		  try {
		   for (Player players : Bukkit.getOnlinePlayers()) {
		    sendToPlayer("blockcrack_152_0", players, victim.getLocation(), 0, 1, 0, 50, 300);
		   }
		  }
		  catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
	
}
