/*
 * This file is part of KeyAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 Epic Planet Minecraft Server <http://epicpla.net>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.epicpla.keyapi.listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import net.epicpla.keyapi.Key;
import net.epicpla.keyapi.event.PlayerPressKeyEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.Plugin;

public class KeyListener extends PacketAdapter implements Listener {

    public KeyListener(Plugin plugin, PacketType... types) {
        super(plugin, types);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        PlayerPressKeyEvent myEvent = new PlayerPressKeyEvent(event.getPlayer(), Key.DROP);
        Bukkit.getServer().getPluginManager().callEvent(myEvent);

        if (myEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.CLIENT_COMMAND) {
            PacketContainer packet = event.getPacket();
            EnumWrappers.ClientCommand action = packet.getClientCommands().read(0);

            if (action == EnumWrappers.ClientCommand.OPEN_INVENTORY_ACHIEVEMENT) {
                PlayerPressKeyEvent myEvent = new PlayerPressKeyEvent(event.getPlayer(), Key.INVENTORY);
                Bukkit.getServer().getPluginManager().callEvent(myEvent);

                if (myEvent.isCancelled()) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        PlayerPressKeyEvent myEvent = new PlayerPressKeyEvent(event.getPlayer(), Key.SWAPHANDS);
        Bukkit.getServer().getPluginManager().callEvent(myEvent);

        if (myEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }

}
