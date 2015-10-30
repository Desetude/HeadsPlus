/*
 *     Copyright (c) 2015. Desetude (devdesetude@gmail.com)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.desetude.headsplus;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
public class Head {

    private HeadCategory category;
    private ItemStack skull;

    public Head(Plugin plugin, String name, HeadCategory category, String playerName) {
        this.category = category;
        skull = new ItemStack(Material.SKULL_ITEM);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(name);
        //Async as it may need to lookup skin
        new BukkitRunnable() {
            @Override
            public void run() {
                skullMeta.setOwner(playerName);
            }
        }.runTaskAsynchronously(plugin);
    }

}
